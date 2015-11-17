package com.oris.mis.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oris.base.BaseController;
import com.oris.email.template.UserRegistrationEmailTemplate;
import com.oris.enums.StatusEnum;
import com.oris.mis.model.Roles;
import com.oris.mis.model.Users;
import com.oris.mis.service.MISService;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;
import com.oris.util.email.template.MessageTemplate;


@Controller
@RequestMapping(value="/secured/admin/user")
public class UserAdminController extends BaseController {
	protected static Logger logger = Logger.getLogger(UserAdminController.class);
	
	//Services
	@Autowired private MISService userService;
	@Autowired private Md5PasswordEncoder md5PasswordEncoder;
	
	//Variables
	private List<Roles> rolesList;
	private Map<Integer, String> userStatus;
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_USERS = "/web/secured/admin/user/view";
	private static final String ADD_EDIT_USER = "userProfile";
	private static final String VIEW_USERS = "viewUsers";
	
	private String username;
	private Users oldUser;
	
	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("userCommand") final Users users,
							BindingResult result) throws IOException {
		
		logger.info("Registering: " + users.getUsername());
		System.out.println("Is same Password: " + userService.isSamePassword(md5PasswordEncoder.encodePassword(users.getConfirmPassword(), null)));
		
//		if(!userService.isSamePassword(md5PasswordEncoder.encodePassword(users.getConfirmPassword(), null))) {
//			sendEmail(users);
//		}
		
		userService.registration(users);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_USERS);
		
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editUser(HttpServletRequest request, ModelMap model) {
		username = request.getParameter("id");		
		oldUser = userService.get(Users.class, username);
		model.addAttribute("userCommand", oldUser);
		return ADD_EDIT_USER;
	}
	
	@RequestMapping(value="/view")
	public String viewUsers(HttpServletRequest request, ModelMap model) {
		username = request.getParameter("username") ;
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "u.username" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		Page page = userService.viewUsers(username, begin, orderBy, sortBy);
		
		model.addAttribute("page", page);
		model.addAttribute("username", username);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_USERS;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("userCommand") final Users users) {
		return ADD_EDIT_USER;
	}
	
	//Reference data
	@SuppressWarnings("unchecked")
	@ModelAttribute("rolesList")
	public List<Roles> userRoles(ModelMap map) {
		rolesList = (List<Roles>) userService.getAll(Roles.class);
		return rolesList;
	}
	
	@ModelAttribute("userStatus")
	public Map<Integer, String> userStatus(ModelMap map) {
		if (InventoryUtility.isNull(userStatus)) {
			userStatus = new HashMap<Integer, String>();
			for(StatusEnum value : StatusEnum.values()) {
				userStatus.put(value.getId(), value.getDescription());
			}
		}
		return userStatus;		
	}
	
	private void sendEmail(Users user) {

		MessageTemplate template = null;

		try {
			template = UserRegistrationEmailTemplate.newTemplate(user.getEmail(), user);
			userService.getMailService().sendMessage(template);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}