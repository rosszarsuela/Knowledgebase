package com.knowledgebase.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	protected static Logger logger = Logger.getLogger(HomeController.class);


	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap model) {
		return "index";
	}
}