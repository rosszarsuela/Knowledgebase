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
import com.oris.mis.model.Brand;
import com.oris.mis.model.Product;
import com.oris.mis.model.ProductImages;
import com.oris.mis.model.SolutionsCategory;
import com.oris.mis.model.Specifications;
import com.oris.mis.service.MISService;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;


@Controller
@RequestMapping(value="/secured/admin/product")
public class ProductsController extends BaseController {
	protected static Logger logger = Logger.getLogger(ProductsController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Map<Integer, String> status;
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String REDIRECT_VIEW_PRODUCT = "/web/secured/admin/product/view";
	private static final String ADD_EDIT_PRODUCT = "product";
	private static final String VIEW_PRODUCT = "viewProduct";
	
	//Process
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("productCommand") final Product product,
							BindingResult result) throws IOException {
		
		if(product.getImage().getSize() > 0) {			
			byte[] bFile = new byte[(int) product.getImage().getBytes().length];			
			InputStream fis = product.getImage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			product.setContentType(product.getImage().getContentType());
			product.setPicture(bFile);
		}
		
		if(product.getPdf().getSize() > 0) {
			byte[] bFile = new byte[(int) product.getPdf().getBytes().length];
			InputStream fis = product.getPdf().getInputStream();
			fis.read(bFile);
			fis.close();
			
			product.setManualContentType(product.getPdf().getContentType());
			product.setManual(bFile);
		}
		
		misService.createProduct(product);
		response.sendRedirect(request.getContextPath() + REDIRECT_VIEW_PRODUCT);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Product product = misService.get(Product.class, id);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("product.id", product.getId());
		map.put("orderBy", "id");
		
		product.setSpecs((List<Specifications>)misService.getAllByHashMap(Specifications.class, map));
		map.put("isDeleted", false);
		product.setProductImages((List<ProductImages>)misService.getAllByHashMap(ProductImages.class, map));
		
		model.addAttribute("status", initStatus());
		model.addAttribute("categoryList", getSolutionsCategory());
		model.addAttribute("brandsList", getBrands());
		model.addAttribute("productCommand", product);
		return ADD_EDIT_PRODUCT;
	}
	
	@RequestMapping(value="/view")
	public String viewSuppliers(HttpServletRequest request, ModelMap model, @ModelAttribute("productCommand") final Product product) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "p.name" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		product.setBegin(begin);
		product.setOrderBy(orderBy);
		product.setSortBy(sortBy);
		
		Page page = misService.viewProducts(product);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		return VIEW_PRODUCT;
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String registrationForm(@ModelAttribute("productCommand") final Product product, ModelMap model) {
		model.addAttribute("categoryList", getSolutionsCategory());
		model.addAttribute("brandsList", getBrands());
		model.addAttribute("status", initStatus());
		return ADD_EDIT_PRODUCT;
	}
	
	@ModelAttribute("status")
	public Map<Integer, String> status() {
		if (InventoryUtility.isNull(status)) {
			status = new HashMap<Integer, String>();
			for(StatusEnum value : StatusEnum.values()) {
				status.put(value.getId(), value.getDescription());
			}
		}
		return status;		
	}
	
	@SuppressWarnings("unchecked")
	private List<SolutionsCategory> getSolutionsCategory() {
		List<SolutionsCategory> categories = (List<SolutionsCategory>) misService.getAll(SolutionsCategory.class, "name");
		categories.add(0, new SolutionsCategory(null, "Select"));
		return categories;
	}
	
	@SuppressWarnings("unchecked")
	private List<Brand> getBrands() {
		return (List<Brand>) misService.getAll(Brand.class, "name");
	}
}