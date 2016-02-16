package com.oris.mis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.oris.enums.StatusEnum;
import com.oris.mis.model.Doctor;
import com.oris.mis.service.MISService;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/doctor")
public class DoctorProfileController extends BaseController {
	protected static Logger logger = Logger.getLogger(DoctorProfileController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Map<Integer, String> customerStatus;
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_DOCTOR = "/web/secured/admin/doctor/view";
	private static final String ADD_EDIT_DOCTOR = "doctorProfile";
	private static final String VIEW_DOCTOR = "viewDoctors";

	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("doctorCommand") final Doctor doctor,
							BindingResult result) throws IOException {
		
		if(doctor.getImage().getSize() > 0) {
			byte[] bFile = new byte[(int) doctor.getImage().getBytes().length];			
			InputStream fis = doctor.getImage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			doctor.setPicture(bFile);
			doctor.setContentType(doctor.getImage().getContentType());
		}
		
		misService.doctorRegistration(doctor);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_DOCTOR);
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Doctor doctor = misService.get(Doctor.class, id);
		model.addAttribute("doctorCommand", doctor);
		return ADD_EDIT_DOCTOR;
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("doctorCommand") final Doctor doctor) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "d.lastName" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		doctor.setBegin(begin);
		doctor.setOrderBy(orderBy);
		doctor.setSortBy(sortBy);
		
		Page page = misService.viewDoctors(doctor);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_DOCTOR;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("doctorCommand") final Doctor doctor) {
		return ADD_EDIT_DOCTOR;
	}
	
	@ModelAttribute("status")
	public Map<Integer, String> userStatus(ModelMap map) {
		if (InventoryUtility.isNull(customerStatus)) {
			customerStatus = new HashMap<Integer, String>();
			for(StatusEnum value : StatusEnum.values()) {
				customerStatus.put(value.getId(), value.getDescription());
			}
		}
		return customerStatus;		
	}
}