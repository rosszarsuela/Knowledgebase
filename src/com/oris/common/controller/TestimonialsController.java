package com.oris.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oris.base.BaseController;
import com.oris.enums.LinksEnum;


@Controller
public class TestimonialsController extends BaseController {
	protected static Logger logger = Logger.getLogger(TestimonialsController.class);
		
	@RequestMapping(value = "testimonials", method = RequestMethod.GET)
	public String getTestimonialPage(ModelMap model) {
		logger.debug("Received request to show testimonials");
		model.addAttribute("activeMenu", LinksEnum.TESTIMONIALS.getId());
		return "testimonialPage";
	}	
}