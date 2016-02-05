package com.oris.common.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oris.base.BaseController;
import com.oris.enums.LinksEnum;
import com.oris.mis.model.Client;
import com.oris.mis.model.Participants;
import com.oris.mis.service.MISService;
import com.oris.util.Config;
import com.oris.util.InventoryUtility;
import com.oris.util.email.MessageService;
import com.oris.util.email.SimpleSmtpMessageService;
import com.oris.util.email.SimpleSmtpServiceConfig;
import com.oris.util.email.template.ContactMailTemplate;
import com.oris.util.email.template.EventMailTemplate;
import com.oris.util.email.template.MessageTemplate;


@Controller
public class ContactUsController extends BaseController {
	protected static Logger logger = Logger.getLogger(ContactUsController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String getContactPage(ModelMap model) {
		logger.debug("Received request to show contact page");
		model.addAttribute("activeMenu", LinksEnum.CONTACT.getId());
		return "contactPage";
	}	
}