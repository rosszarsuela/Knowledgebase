package com.oris.mis.controller;

import java.io.IOException;

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
import com.oris.mis.model.Videos;
import com.oris.mis.service.MISService;


@Controller
@RequestMapping(value="/secured/admin/videos")
public class VideosController extends BaseController {
	protected static Logger logger = Logger.getLogger(VideosController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Constant variables
	private static final String REDIRECT_CREATE_VIDEOS = "/web/secured/dashboard";
	private static final String ADD_EDIT_VIDEOS = "videos";
	
	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("videoCommand") final Videos video,
							BindingResult result) throws IOException {	
		
		misService.createVideo(video);
		response.sendRedirect(request.getContextPath() + REDIRECT_CREATE_VIDEOS);
	}
	
	/*@RequestMapping(value="/update", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Videos video = misService.get(Videos.class, id);
		model.addAttribute("videoCommand", video);
		return ADD_EDIT_VIDEOS;
	}*/
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(HttpServletRequest request, ModelMap model,@ModelAttribute("videoCommand") final Videos video) {
		
		Videos obj = misService.getVideo();
		model.addAttribute("videoCommand", obj);
		
		return ADD_EDIT_VIDEOS;
	}
}