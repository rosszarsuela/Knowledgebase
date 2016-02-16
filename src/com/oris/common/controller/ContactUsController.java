package com.oris.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oris.base.BaseController;
import com.oris.enums.LinksEnum;


@Controller
public class ContactUsController extends BaseController {
	protected static Logger logger = Logger.getLogger(ContactUsController.class);
	
	private static final String VIEW_CALL_US = "callUs";
	private static final String VIEW_VISIT_US = "corporateOffice";
	
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String getContactPage(ModelMap model) {
		logger.debug("Received request to show contact page");
		model.addAttribute("activeMenu", LinksEnum.CONTACT.getId());
		return "contactPage";
	}	
	
	@RequestMapping(value="/view/contact/callUs",method = RequestMethod.GET)
	public String contact(HttpServletRequest request) {
		return VIEW_CALL_US;
	}
	
	@RequestMapping(value="/view/contact/corporateOffice",method = RequestMethod.GET)
	public String contactOffice(HttpServletRequest request) {
		return VIEW_VISIT_US;
	}
}