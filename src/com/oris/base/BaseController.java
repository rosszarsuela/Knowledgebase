package com.oris.base;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.oris.enums.StatusEnum;
import com.oris.mis.model.Doctor;
import com.oris.mis.model.Users;
import com.oris.mis.service.MISService;
import com.oris.util.Config;
import com.oris.util.DateUtility;
import com.oris.util.InventoryUtility;

@Controller
public class BaseController extends BasePDFGenUtil {
	
	@Autowired MISService misService;
	Logger logger = Logger.getLogger(BaseController.class);
	
	protected SimpleDateFormat excelFmtMMddyyyy = new SimpleDateFormat("MM/dd/yyyy");
	protected SimpleDateFormat excelFmtTimestamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	protected DecimalFormat fmtCurrency = new DecimalFormat("#,##0.00");
	
	protected static BaseFont courier;
	protected final static Font courierFontNormal = new Font(courier, 7, Font.NORMAL);
	protected final Font courierFont14Normal = new Font(courier, 11, Font.NORMAL);
	protected final Font courierFont11BOLD = new Font(courier, 11, Font.BOLD);
	protected final Font courierFont10Normal = new Font(courier, 10, Font.NORMAL);
	protected final Font courierFont11 = new Font(courier, 11, Font.NORMAL);
	protected final static Font courierFontBold = new Font(courier, 10, Font.BOLD);
	protected final static Font courierFontBoldTitle = new Font(courier, 14, Font.BOLD);
	protected final Font courierFontItalic = new Font(courier, 7, Font.ITALIC);
	protected final Font courierFontNormalUnderlined = new Font(courier, 7, Font.UNDERLINE);
	protected final Font courierFontBold10Underlined = new Font(courier, 10, Font.BOLD | Font.UNDERLINE);
	protected final Font courierH1SizeUnderlined = new Font(courier, 16, Font.UNDERLINE);
	
	protected static final String HEADER_IMG_SRC = "images/oris_logo.jpg";
	
	private String message;
	private String exceptionMessage;
	private String EXCEPTION_PAGE = "exceptionPage";
	protected final String DOWNLOAD_PAGE = "downloadPage";
	
	public String username;
	private Map<Integer, String> status;
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		e.printStackTrace();
		setExceptionMessage(e.toString());
		
		return EXCEPTION_PAGE;
	}
	
	public Users getUser() {
//		return InventoryUtility.getLoginUser();
		if(InventoryUtility.getAuthentication() != null) {
			return misService.get(Users.class, InventoryUtility.getLoginUsername());
		}
		return null;
	}

	@ModelAttribute("message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String  getMessageValue(String key) {
		return Config.getProperties(key);
	}
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
	    binder.registerCustomEditor(Date.class, editor);
	}
	
	public String setMessageRequired(String objectName){
		return objectName + " is required.";
	}

	@ModelAttribute("exceptionMessage")
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
	
	
	/*
	 * For debugging, only temporarily add but remove before SVN checkin
	 */
	
	private final static String BREAK = "\n\n\n";
	protected void printParametersDebugging(HttpServletRequest request){
		logger.info("FOR NAMES");
		Enumeration<String> names =  request.getParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			logger.info("name: " + name + " |  value: " + request.getParameter(name));
		}
		logger.info(BREAK);
	}
	
	protected void printAttributesDebugging(HttpServletRequest request){
		logger.info("FOR ATTRIBUTES");
		Enumeration<String> attrbs = request.getAttributeNames();
		while(attrbs.hasMoreElements()){
			String name = attrbs.nextElement();
			if (null != name)
				logger.info("name: " + name + " |  value: " + 
					((null ==  request.getParameter(name) || null == request.getParameter(name).toString())? "BLANK": request.getParameter(name).toString()));
		}
		logger.info(BREAK);
	}
	
	@ModelAttribute("principalUser")
	public String getPrincipalUser() {
		return InventoryUtility.getLoginUsername() != null ?
				InventoryUtility.getLoginUsername() : "";
	}
	
	@ModelAttribute("roleName")
	public String getRoleName() {
		if(InventoryUtility.getAuthentication() != null) {
			Object obj = CollectionUtils.get(InventoryUtility.getAuthorities(), 0);
			return obj.toString();
		}
		return "";
	}
	
	@ModelAttribute("loggedUser")
	public String getLoggedUser() {
		if(InventoryUtility.getAuthentication() != null) {
			Users user = misService.get(Users.class, InventoryUtility.getLoginUsername());
			return user.getFirstName() + " " + user.getLastName();
		}
		
		return "";
	}
	
	public String getTimestamp() {
		return DateUtility.convertDateToStr(new Date(), "MMddyyyyhhmmss");
	}
	
	public Map<Integer, String> initStatus() {
		if (InventoryUtility.isNull(status)) {
			status = new HashMap<Integer, String>();
			for(StatusEnum value : StatusEnum.values()) {
				status.put(value.getId(), value.getDescription());
			}
		}
		return status;		
	}
	
	protected void initModel(ModelMap model) {
		model.addAttribute("doctorsList", getDoctorsList());
		
	}
	
	public Doctor getDoctorList() {
		if(InventoryUtility.getAuthentication() != null) {
			return misService.get(Doctor.class, InventoryUtility.getString(getDoctorList()));
		}
		return null;
	}
		
	@SuppressWarnings("unchecked")
	@ModelAttribute("educatorList")
	protected List<Doctor> getDoctorsList() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("status", StatusEnum.ACTIVE.getId());
		map.put("orderBy", "createdDate");
		List<Doctor> doctors = (List<Doctor>)misService.getAllByHashMap(Doctor.class, map);
		return doctors;
	}
}