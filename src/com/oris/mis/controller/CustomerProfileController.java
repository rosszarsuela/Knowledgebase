package com.oris.mis.controller;

import java.io.IOException;
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
import com.oris.mis.model.Customer;
import com.oris.mis.service.MISService;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/customer")
public class CustomerProfileController extends BaseController {
	protected static Logger logger = Logger.getLogger(CustomerProfileController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Map<Integer, String> customerStatus;
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_CUSTOMER = "/web/secured/admin/customer/view";
	private static final String ADD_EDIT_CUSTOMER = "customerProfile";
	private static final String VIEW_CUSTOMER = "viewCustomers";

	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("customerCommand") final Customer customer,
							BindingResult result) throws IOException {		
		misService.customerRegistration(customer);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_CUSTOMER);
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Customer customer = misService.get(Customer.class, id);
		model.addAttribute("customerCommand", customer);
		return ADD_EDIT_CUSTOMER;
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("customerCommand") final Customer customer) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "c.name" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		customer.setBegin(begin);
		customer.setOrderBy(orderBy);
		customer.setSortBy(sortBy);
		
		Page page = misService.viewCustomers(customer);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_CUSTOMER;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("customerCommand") final Customer customer) {
		return ADD_EDIT_CUSTOMER;
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