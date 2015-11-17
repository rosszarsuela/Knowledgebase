package com.oris.mis.controller;

import java.io.IOException;
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
import com.oris.mis.model.Solution;
import com.oris.mis.model.SolutionsCategory;
import com.oris.mis.service.MISService;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/solution/category")
public class SolutionsCategoryController extends BaseController {
	protected static Logger logger = Logger.getLogger(SolutionsCategoryController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_SOLUTION = "/web/secured/admin/solution/category/view";
	private static final String ADD_EDIT_SOLUTION = "solutionsCategory";
	private static final String VIEW_SOLUTION = "viewSolutionsCategory";

	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("solutionCommand") final SolutionsCategory category,
							BindingResult result) throws IOException {		
		misService.createSolutionCategory(category);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_SOLUTION);
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		SolutionsCategory category = misService.get(SolutionsCategory.class, id);
		model.addAttribute("solutionCommand", category);
		model.addAttribute("solutionsList", getSolutions());
		return ADD_EDIT_SOLUTION;
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("solutionCommand") final SolutionsCategory category) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "sc.name" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		category.setBegin(begin);
		category.setOrderBy(orderBy);
		category.setSortBy(sortBy);
		
		Page page = misService.viewSolutionsCategory(category);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_SOLUTION;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("solutionCommand") final SolutionsCategory category, ModelMap model) {
		model.addAttribute("solutionsList", getSolutions());
		return ADD_EDIT_SOLUTION;
	}
	
	@SuppressWarnings("unchecked")
	private List<Solution> getSolutions() {
		return (List<Solution>) misService.getAll(Solution.class, "name");
	}
}