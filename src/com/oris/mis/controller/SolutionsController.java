package com.oris.mis.controller;

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
import com.oris.mis.model.Solution;
import com.oris.mis.service.MISService;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/solution")
public class SolutionsController extends BaseController {
	protected static Logger logger = Logger.getLogger(SolutionsController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_SOLUTION = "/web/secured/admin/solution/view";
	private static final String ADD_EDIT_SOLUTION = "solution";
	private static final String VIEW_SOLUTION = "viewSolutions";

	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, 
			@ModelAttribute("solutionCommand") final Solution solution, BindingResult result) throws IOException {		
		
		if(solution.getImage().getSize() > 0) {			
			byte[] bFile = new byte[(int) solution.getImage().getBytes().length];			
			InputStream fis = solution.getImage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			solution.setContentType(solution.getImage().getContentType());
			solution.setPicture(bFile);
		}
		
		misService.createSolution(solution);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_SOLUTION);
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Solution solution = misService.get(Solution.class, id);
		
		model.addAttribute("solutionCommand", solution);
		return ADD_EDIT_SOLUTION;
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("solutionCommand") final Solution solution) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "s.name" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		solution.setBegin(begin);
		solution.setOrderBy(orderBy);
		solution.setSortBy(sortBy);
		
		Page page = misService.viewSolutions(solution);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_SOLUTION;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("solutionCommand") final Solution solution) {
		return ADD_EDIT_SOLUTION;
	}
}