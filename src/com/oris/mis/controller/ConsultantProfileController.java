package com.oris.mis.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
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
import com.oris.mis.model.Consultants;
import com.oris.mis.service.MISService;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/consultant")
public class ConsultantProfileController extends BaseController {
	protected static Logger logger = Logger.getLogger(ConsultantProfileController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Map<Integer, String> consultantStatus;
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_CONSULTANT = "/web/secured/admin/consultant/view";
	private static final String ADD_EDIT_CONSULTANT  = "consultantProfile";
	private static final String VIEW_CONSULTANT = "viewConsultant";

	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("consultantCommand") final Consultants consultant,
							BindingResult result) throws IOException {
		
		if(consultant.getImage().getSize() > 0) {
			byte[] bFile = new byte[(int) consultant.getImage().getBytes().length];			
			InputStream fis = consultant.getImage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			consultant.setPicture(bFile);
			consultant.setContentType(consultant.getImage().getContentType());
		}
		
		misService.consultantRegistration(consultant);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_CONSULTANT);
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Consultants consultant = misService.get(Consultants.class, id);
		model.addAttribute("consultantCommand", consultant);
		return ADD_EDIT_CONSULTANT;
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("consultantCommand") final Consultants consultant) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "con.lastName" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		consultant.setBegin(begin);
		consultant.setOrderBy(orderBy);
		consultant.setSortBy(sortBy);
		
		Page page = misService.viewConsultant(consultant);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_CONSULTANT;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("consultantCommand") final Consultants consultant) {
		return ADD_EDIT_CONSULTANT;
	}
	
	@ModelAttribute("status")
	public Map<Integer, String> userStatus(ModelMap map) {
		if (InventoryUtility.isNull(consultantStatus)) {
			consultantStatus = new HashMap<Integer, String>();
			for(StatusEnum value : StatusEnum.values()) {
				consultantStatus.put(value.getId(), value.getDescription());
			}
		}
		return consultantStatus;		
	}
}