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
import com.oris.mis.model.Brand;
import com.oris.mis.service.MISService;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/brand")
public class BrandsController extends BaseController {
	protected static Logger logger = Logger.getLogger(BrandsController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_BRAND = "/web/secured/admin/brand/view";
	private static final String ADD_EDIT_BRAND = "brand";
	private static final String VIEW_BRAND = "viewBrands";

	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("brandCommand") final Brand brand,
							BindingResult result) throws IOException {	
		
		if(brand.getImage().getSize() > 0) {
			byte[] bFile = new byte[(int) brand.getImage().getBytes().length];			
			InputStream fis = brand.getImage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			brand.setPicture(bFile);
			brand.setContentType(brand.getImage().getContentType());
		}
		
		if(brand.getBimage().getSize() > 0) {
			byte[] bFile = new byte[(int) brand.getBimage().getBytes().length];			
			InputStream fis = brand.getBimage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			brand.setBpicture(bFile);
			brand.setContentType(brand.getBimage().getContentType());
		}
		
		if(brand.getPdf().getSize() > 0) {
			byte[] bFile = new byte[(int) brand.getPdf().getBytes().length];
			InputStream fis = brand.getPdf().getInputStream();
			fis.read(bFile);
			fis.close();
			
			brand.setContentType(brand.getPdf().getContentType());
			brand.setManual(bFile);
		}
		
		if(brand.getPdfimage().getSize() > 0) {
			byte[] bFile = new byte[(int) brand.getPdfimage().getBytes().length];			
			InputStream fis = brand.getPdfimage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			brand.setPimage(bFile);
			brand.setContentType(brand.getPdfimage().getContentType());
		}
		
		misService.createBrand(brand);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_BRAND);
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Brand brand = misService.get(Brand.class, id);
		model.addAttribute("brandCommand", brand);
		return ADD_EDIT_BRAND;
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("brandCommand") final Brand brand) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "b.name" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		brand.setBegin(begin);
		brand.setOrderBy(orderBy);
		brand.setSortBy(sortBy);
		
		Page page = misService.viewBrands(brand);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_BRAND;
	}

	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("brandCommand") final Brand brand) {
		return ADD_EDIT_BRAND;
	}
}