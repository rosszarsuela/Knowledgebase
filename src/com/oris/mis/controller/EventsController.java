package com.oris.mis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

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
import com.oris.mis.model.Brand;
import com.oris.mis.model.Event;
import com.oris.mis.model.Speaker;
import com.oris.mis.service.MISService;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/event")
public class EventsController extends BaseController {
	protected static Logger logger = Logger.getLogger(EventsController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_EVENT = "/web/secured/admin/event/view";
	private static final String ADD_EDIT_EVENT = "event";
	private static final String VIEW_EVENT = "viewEvents";
	/*private static final String VIEW_EVENT_REGISTRATION ="/web/view/event/info";*/

	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("eventCommand") final Event event, BindingResult result) throws IOException {
		
		if(event.getImage().getSize() > 0) {
			byte[] bFile = new byte[(int) event.getImage().getBytes().length];			
			InputStream fis = event.getImage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			event.setPicture(bFile);
			event.setContentType(event.getImage().getContentType());
		}
		
		if(event.getPdf().getSize() > 0) {
			byte[] bFile = new byte[(int) event.getPdf().getBytes().length];
			InputStream fis = event.getPdf().getInputStream();
			fis.read(bFile);
			fis.close();
			
			event.setContentType(event.getPdf().getContentType());
			event.setBrochure(bFile);
		}
		
		misService.createEvent(event);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_EVENT);
	}
	
	/*@RequestMapping(value="/payment", method=RequestMethod.GET)
	public void paymentForm(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Participants p = misService.get(Participants.class, id);
		model.addAttribute("registerCommand", p);
		
		response.sendRedirect(request.getContextPath() + VIEW_EVENT_REGISTRATION + "?id="+p.getEvent().getImageContent()+"&participantId="+p.getId());
	}*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Event event = misService.get(Event.class, id);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("event.id", event.getId());
		map.put("orderBy", "id");
		
		event.setSpeakers((List<Speaker>)misService.getAllByHashMap(Speaker.class, map));
		
		model.addAttribute("brandList", getBrands());
		model.addAttribute("status", initStatus());
		model.addAttribute("eventCommand", event);
		return ADD_EDIT_EVENT;
	}
	
	@SuppressWarnings("unchecked")
	private List<Brand> getBrands() {
		return (List<Brand>) misService.getAll(Brand.class, "name");
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("eventCommand") final Event event) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "e.name" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		event.setBegin(begin);
		event.setOrderBy(orderBy);
		event.setSortBy(sortBy);
		
		Page page = misService.viewEvents(event);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_EVENT;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("eventCommand") final Event event, ModelMap model) {
		model.addAttribute("brandsList", getBrands());
		model.addAttribute("status", initStatus());
		return ADD_EDIT_EVENT;
	}
}