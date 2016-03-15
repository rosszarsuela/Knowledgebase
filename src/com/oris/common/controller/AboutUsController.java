package com.oris.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oris.base.BaseController;
import com.oris.enums.LinksEnum;


@Controller
public class AboutUsController extends BaseController {
	protected static Logger logger = Logger.getLogger(AboutUsController.class);
	
	@RequestMapping(value = "about", method = RequestMethod.GET)
	public String getAboutPage(ModelMap model) {
		logger.debug("Received request to show about page");
		model.addAttribute("activeMenu", LinksEnum.ABOUT.getId());
		return "aboutPage";
	}	
}