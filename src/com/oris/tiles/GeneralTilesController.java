package com.oris.tiles;

import java.sql.Date;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oris.base.BaseController;
import com.oris.enums.StatusEnum;
import com.oris.mis.dao.MISDao;
import com.oris.mis.model.Users;
import com.oris.mis.model.UsersForgotPassword;
import com.oris.mis.service.MISService;
import com.oris.util.Config;
import com.oris.util.EncryptionUtil;
import com.oris.util.InventoryUtility;
import com.oris.util.email.template.MessageTemplate;
import com.oris.util.email.template.UserForgotPasswordTemplate;
import com.oris.util.email.template.UserPasswordChangeConfirmTemplate;

/**
 * Tile Controller for General Pages
 * @author Ross Zarsuela
 *
 */
@Controller
public class GeneralTilesController extends BaseController {
	
	protected static Logger logger = Logger.getLogger(GeneralTilesController.class);
	private MISDao misDao;	
	private EncryptionUtil fp = EncryptionUtil.getInstance();
		
	@Autowired private MISService misService;
	
//	@ExceptionHandler
//	@ResponseStatus(value=HttpStatus.NOT_FOUND)
//	public String notFoundEceptionHandler(ModelMap map) {
//		return getHomePage(map);
//	}
	
	@RequestMapping(value = "/cms/login", method = RequestMethod.GET)
	public String getLoginPage() {
		logger.debug("Received request to show login page");
		return "loginPage";
	}
	
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String getHomePage(ModelMap model) {
//		logger.debug("Received request to show home page");
//		model.addAttribute("activeMenu", LinksEnum.HOME.getId());
//		return "homePage";
//	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String getForgotPasswordPage(ModelMap model) {
		logger.debug("Received request to show forgot password page");
		model.addAttribute("errorMessage","");
		return "forgotPasswordPage";
	}
	
	@RequestMapping(value = "/forgotValidate", method = RequestMethod.GET)
	public String validateForgotPassword(HttpServletRequest request,@RequestParam(value = "userinput") String input, ModelMap model) {
		logger.debug("validating forgot password");
		String errorStr = "Invalid username/email or the account may be inactive. Please try again.";
		
		model.addAttribute("errorMessage",errorStr);
		
		if(InventoryUtility.isEmpty(input)){
			return "forgotPasswordPage";
		}
		
		//generate encrpted link
		Users user = null;
		try {
			user = misDao.validateUserForgotPassword(input);
		} catch (Exception e) {
			return "forgotPasswordPage";
		}
		
		if(InventoryUtility.isEmpty(user)) {
			return "forgotPasswordPage";
		} else {
			if(user.getStatus() != StatusEnum.ACTIVE.getId()){
				return "forgotPasswordPage";
			}
		}
		
		UsersForgotPassword ufp = misDao.createNewForgotPass(user);

		Integer count = ufp.getId().intValue();
		String encrypted = fp.encrypt(user, count);
		
		String encryptedLink = "<a href=\""+request.getRequestURL().toString().replaceAll("forgotValidate", "") + "forgotChange"+"?i="+encrypted+"\" target=\"_blank\">click here</a> ";
		
		//email user about random link
		try{
			MessageTemplate template = UserForgotPasswordTemplate.newTemplate(user, encryptedLink);
			misService.getMailService().sendMessage(template);
		}catch (Exception e) {
			e.printStackTrace();
			errorStr = "Failed to send message.";
			logger.info(errorStr);
			
			//set created status to inactive
			ufp.setStatus(StatusEnum.INACTIVE.getId());
			misDao.save(ufp);
			return "forgotPasswordPage";
		}
		
	
		model.addAttribute("forgotPasswordSuccess",1);
		return "homePage";
	}
	
	@RequestMapping(value = "/forgotChangeSubmit", method = RequestMethod.POST)
	public String forgotChangeSubmit(HttpServletRequest request,
			HttpServletResponse response,
		ModelMap model,
		@RequestParam(value = "uname", defaultValue="") String uname,
		@RequestParam(value = "pword", defaultValue="") String pword,
		@RequestParam(value = "confPword", defaultValue="") String confPword,
		@RequestParam(value = "i", defaultValue="") String encrypted
		
			) {
		
		Pattern passwordRegEx = Pattern.compile(Config.getProperties("regex.alphanumeric.password"));
		logger.debug("validating password change");
		model.addAttribute("uname", uname);
		
		Boolean valid = true;
		
		try {
			
		//all fields must not be empty
		if(InventoryUtility.isEmpty(uname)){
			model.addAttribute("errorMsg1", Config.getProperties("mis.user.error.username.required"));
			valid = false;
		}
		
		if(InventoryUtility.isEmpty(pword)){
			model.addAttribute("errorMsg2", Config.getProperties("mis.user.error.password.required"));
			valid = false;
		}else if(!passwordRegEx.matcher(pword).matches()){
			model.addAttribute("errorMsg2", Config.getProperties("mis.user.error.password"));
			valid = false;
		}
		
		if(InventoryUtility.isEmpty(confPword)){
			model.addAttribute("errorMsg3", "Confirm " + Config.getProperties("mis.user.error.password.required"));
			valid = false;
		}else if(!passwordRegEx.matcher(confPword).matches()){
			model.addAttribute("errorMsg3", Config.getProperties("mis.user.error.password"));
			valid = false;
		}
				
		if(InventoryUtility.isEmpty(encrypted)){
			model.addAttribute("errorMsg4", "There is an error in your request.");
			valid = false;
		}
		
		//the new password and the old password must be the same
		if(!pword.equals(confPword)){
			model.addAttribute("errorMsg3", Config.getProperties("mis.user.error.confirmPassword"));
			valid = false;
		}
		
		String decrypted = fp.decrypt(encrypted);
		Users user = misDao.get(Users.class, uname);
		UsersForgotPassword ufp = misDao.getLastForgotPass(user);
		
		//user and ufp must not be null
		if(!InventoryUtility.isEmpty(uname) && InventoryUtility.isEmpty(user)){
			valid = false;
		}
		
		if(InventoryUtility.isEmpty(ufp)){
			model.addAttribute("errorMsg4", "Error fetching request change password");
			valid = false;
		}
		
		//the username submitted + the pk of password change and the encrypted link should be the same
		if(!uname.equals(decrypted) ){
			model.addAttribute("errorMsg4", "Username submitted and the username that requested did not matched");
			valid = false;
		}
		
		//the username submitted should still be active
		if(!InventoryUtility.isEmpty(user)){
			if(user.getStatus() == StatusEnum.INACTIVE.getId()) {
				model.addAttribute("errorMsg4", "Cannot change password for inactive users.");
				valid = false;
			}
		}
		
		if(!InventoryUtility.isEmpty(ufp)){
			//the password change request must still be active
			if(ufp.getStatus() == StatusEnum.INACTIVE.getId()){
				model.addAttribute("errorMsg4", Config.getProperties("mis.user.error.request.required"));
				valid = false;
			}
		}
		
		//the password change request and the current date must only have less than 24hours difference
		Date currentDate = new Date(misService.getSysdate().getTimeInMillis());		
		long diff = Math.abs(currentDate.getTime() - ufp.getDateRequested().getTime());
		long diffHours = diff / (60 * 60 * 1000);
		 
		if(diffHours > 24){
			model.addAttribute("errorMsg4", "Sorry but this request has already expired");
			valid = false;
		}

		if(	!valid	){
			model.addAttribute("i",encrypted);
			model.addAttribute("mode","changePassword");
			return "forgotPasswordPage";
		}
		
		
		//send confirmation message
		MessageTemplate template = UserPasswordChangeConfirmTemplate.newTemplate(user);
		misService.getMailService().sendMessage(template);
		
		//if valid change password
		user.setPassword(pword);
		misService.registration(user);
		
		//set request to inactive
		ufp.setStatus(StatusEnum.INACTIVE.getId());
		misDao.save(ufp);
		
		//if all is success redirect to login page
		model.addAttribute("forgotPasswordSuccess",2);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("forgotPasswordSuccess",0);
			return "homePage";
		}
		
		return "homePage";
	}
	
	@RequestMapping(value = "/forgotChange", method = RequestMethod.GET)
	public String getChangePasswordPage(ModelMap model) {
		logger.debug("Received request to show change password page");
		model.addAttribute("errorMessage","");
		model.addAttribute("mode","changePassword");
		return "forgotPasswordPage";
	}
	

	@RequestMapping(value="/secured/dashboard", method = RequestMethod.GET)
	public String getDashboardPage() {
		logger.debug("Received request to show home page");
		username = InventoryUtility.getLoginUsername();
		return "dashboardPage";
	}
	
	@Autowired
	public void setMisDao(MISDao misDao) {
		this.misDao = misDao;
	}
	
	@ModelAttribute("principalUser")
	public String getPrincipalUser() {
		if(InventoryUtility.getAuthentication() != null) {
			return InventoryUtility.getLoginUsername() != null ?
				InventoryUtility.getLoginUsername() : "";
		}
		
		return "";
	}
}
