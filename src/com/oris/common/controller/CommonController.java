package com.oris.common.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oris.base.BaseController;
import com.oris.enums.LinksEnum;
import com.oris.enums.StatusEnum;
import com.oris.mis.model.Brand;
import com.oris.mis.model.Client;
import com.oris.mis.model.Consultants;
import com.oris.mis.model.Doctor;
import com.oris.mis.model.Event;
import com.oris.mis.model.Participants;
import com.oris.mis.model.Product;
import com.oris.mis.model.ProductImages;
import com.oris.mis.model.Solution;
import com.oris.mis.model.SolutionsCategory;
import com.oris.mis.model.Specifications;
import com.oris.mis.model.dto.ProductsAndServicesMenu;
import com.oris.mis.service.MISService;
import com.oris.util.Config;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;
import com.oris.util.email.MessageService;
import com.oris.util.email.SimpleClientSmtpMessageService;
import com.oris.util.email.SimpleClientSmtpServiceConfig;
import com.oris.util.email.SimpleSmtpMessageService;
import com.oris.util.email.SimpleSmtpServiceConfig;
import com.oris.util.email.template.ContactEmailTemplate;
import com.oris.util.email.template.EventMailTemplate;
import com.oris.util.email.template.MessageTemplate;


@Controller
public class CommonController extends BaseController {
	protected static Logger logger = Logger.getLogger(CommonController.class);
	
	//Services
	@Autowired private MISService misService;
	
	//Variables
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	//Constant variables
	private static final String VIEW_DOCTORS = "viewCommonDoctors";
	/*private static final String VIEW_DOCTORS_INFO = "viewCommonDoctors";*/
	private static final String VIEW_CONSULTANTS = "viewCommonConsultants";
	private static final String VIEW_SOLUTIONS= "viewCommonSolutions";
	private static final String VIEW_EVENTS = "viewCommonEvents";
	private static final String VIEW_EVENTS_INFO = "viewCommonEventsInfo";
	private static final String VIEW_EVENT_REGISTRATION ="/web/view/event/info";
	private static final String VIEW_PORTFOLIO = "viewCommonPortfolio";
	private static final String VIEW_PORTFOLIO_INFO = "viewPortfolioInfo";
	private static final String CONTACT_US_RE = "/web/view/contact/form";


	@RequestMapping(value="/view/mentors")
	public String viewDoctors(HttpServletRequest request, ModelMap model, @ModelAttribute("doctorCommand") final Doctor doctor) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "d.createdDate" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		doctor.setBegin(begin);
		doctor.setOrderBy(orderBy);
		doctor.setSortBy(sortBy);
		doctor.setStatus(StatusEnum.ACTIVE.getId());
		
		Page page = misService.viewMentors(doctor);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("activeMenu", LinksEnum.TRAINING.getId());
		return VIEW_DOCTORS;
	}
		
	@RequestMapping(value="/view/consultants")
	public String viewConsultant(HttpServletRequest request, ModelMap model, @ModelAttribute("consultantCommand") final Consultants consultant) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "con.createdDate" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		consultant.setBegin(begin);
		consultant.setOrderBy(orderBy);
		consultant.setSortBy(sortBy);
		consultant.setStatus(StatusEnum.ACTIVE.getId());
		
		Page page = misService.viewConsultant(consultant);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("activeMenu", LinksEnum.TRAINING.getId());
		return VIEW_CONSULTANTS;
	}
	
	
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/view/solutions")
	public String viewSolutions(HttpServletRequest request, ModelMap model, @ModelAttribute("solutionsCommand") final Solution solution) {
		Solution s = misService.get(Solution.class, solution.getId());
		Long id = Long.parseLong(request.getParameter("id"));
		Product product = misService.get(Product.class, id);		
		
		//get solutions category by solution
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("solution.id", s.getId());
		map.put("orderBy", "id");
		s.setSolutions((List<SolutionsCategory>)misService.getAllByHashMap(SolutionsCategory.class, map));		
		
		//get all products by solutions category
		List<Product> products = null;
		if(!InventoryUtility.isNull(s.getSolutions())) {
			Long categoryId = s.getSolutions().get(0).getId();
			
			map = new HashMap<String, Object>();
			map.put("category.id", categoryId);
			map.put("status", StatusEnum.ACTIVE.getId());
			map.put("orderBy", "id");
			products = (List<Product>) misService.getAllByHashMap(Product.class, map);
		}
		
		model.addAttribute("productCommand",product);
		model.addAttribute("solution", s);
		model.addAttribute("products", products);
		model.addAttribute("activeMenu", LinksEnum.PRODUCT.getId());
		return VIEW_SOLUTIONS;
	}
	
	
	
	@RequestMapping(value="/view/events")
	public String viewEvents(HttpServletRequest request, ModelMap model, @ModelAttribute("eventCommand") final Event event) {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "e.name" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
		
		event.setBegin(begin);
		event.setOrderBy(orderBy);
		event.setSortBy(sortBy);
		event.setStatus(StatusEnum.ACTIVE.getId());
				
		Page page = misService.viewEvents(event);

		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("activeMenu", LinksEnum.EVENTS.getId());
		return VIEW_EVENTS;
	}
	
	@RequestMapping(value="/view/event/info", method=RequestMethod.GET)
	public String eventInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("registerCommand") final Participants participant, 
			ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Event event = misService.get(Event.class, id);
		Long participantId = StringUtils.isNotEmpty(request.getParameter("participantId")) ? Long.parseLong(request.getParameter("participantId")) : null;
		
		Participants p = null;
		if(!InventoryUtility.isNull(participantId)) {
			p = misService.get(Participants.class, participantId);
			model.addAttribute("participantId", participantId);
			model.addAttribute("registerCommand", p);
			model.addAttribute("paymentMessage", Config.getProperties("payment.message"));
			model.addAttribute("accountName", Config.getProperties("bank.account.name"));
			model.addAttribute("accountNo", Config.getProperties("bank.account.no"));
		}
		
		else if (InventoryUtility.isNull(participantId)){
			model.addAttribute("paymentMessage", Config.getProperties("payment.message"));
			model.addAttribute("accountName", Config.getProperties("bank.account.name"));
			model.addAttribute("accountNo", Config.getProperties("bank.account.no"));
		}
		
		model.addAttribute("eventCommand", event);
		model.addAttribute("activeMenu", LinksEnum.EVENTS.getId());
		return VIEW_EVENTS_INFO;
	}
	
	//Process
	@RequestMapping(value="/view/event/info/registration", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("registerCommand") final Participants participant,
							BindingResult result) throws IOException {
		
		//convert image
		if(!InventoryUtility.isNull(participant.getImage()) && participant.getImage().getSize() > 0) {
			byte[] bFile = new byte[(int) participant.getImage().getBytes().length];			
			InputStream fis = participant.getImage().getInputStream();
			fis.read(bFile);
			fis.close();
			
			participant.setContentType(participant.getImage().getContentType());
			participant.setPicture(bFile);
		}
		
		Participants obj = misService.createParticipant(participant);
		
		SimpleSmtpServiceConfig smtpConfig = new SimpleSmtpServiceConfig("smtp", "smtp.gmail.com", 587, "devism41l@gmail.com","devisyakshas01", false, true, true);
		MessageService mailService = new SimpleSmtpMessageService();
		mailService.setConfig(smtpConfig);
		
		MessageTemplate template = null;
		
		String email = Config.getProperties("email.from");
			
		template = EventMailTemplate.newTemplate(email, obj);
		mailService.sendMessage(template);
		
		response.sendRedirect(request.getContextPath() + VIEW_EVENT_REGISTRATION + "?id=" + participant.getEvent().getId());
	}
	
	@RequestMapping(value="/payment", method=RequestMethod.GET)
	public void paymentForm(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Participants p = misService.get(Participants.class, id);
		model.addAttribute("registerCommand", p);
		
		response.sendRedirect(request.getContextPath() + VIEW_EVENT_REGISTRATION + "?id="+p.getEvent().getImageContent()+"&participantId="+p.getId());
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/view/portfolio")
	public String viewProducts(HttpServletRequest request, ModelMap model, @ModelAttribute("productCommand") final Product product) throws IOException {
		begin = request.getParameter("begin") == null ? 
				Integer.parseInt(getMessageValue("views.mis.view.begin")) 
				: Integer.parseInt(request.getParameter("begin"));
														
		orderBy = request.getParameter("orderBy")  == null ? "p.id" : request.getParameter("orderBy");
		sortBy = request.getParameter("sortBy") == null ? "ASC" : request.getParameter("sortBy");
				
		List<ProductsAndServicesMenu> solutionBrandList = misService.getSolutionsBrand();
		Set<String> solutionIdSet = new TreeSet<String>();
		for(ProductsAndServicesMenu pam : solutionBrandList) {
			solutionIdSet.add(pam.getSolutionName());
		}
		
		product.setBegin(begin);
		product.setOrderBy(orderBy);
		product.setSortBy(sortBy);
		product.setStatus(StatusEnum.ACTIVE.getId());
		
		Page page = null;
		if(InventoryUtility.isNull(product.getId()) && InventoryUtility.isNull(product.getBrand()) &&
				!InventoryUtility.isNull(product.getCategory())) {
			//from home
			page = misService.viewProducts(product);
			model.addAttribute("product", product);
		} else if(InventoryUtility.isNull(product.getId()) && InventoryUtility.isNull(product.getBrand())) {
			//on click product and services
			page = misService.viewBrands(new Brand());
			model.addAttribute("product", product);
		} else if(InventoryUtility.isNull(product.getId()) && !InventoryUtility.isNull(product.getBrand().getId())){
			Brand b = misService.get(Brand.class, product.getBrand().getId());
			model.addAttribute("brand", b.getCode());
			
			model.addAttribute("product", product);
			page = misService.viewProducts(product);
			
		} else if(!InventoryUtility.isNull(product.getId()) && !InventoryUtility.isNull(product.getBrand().getId())){
			Brand b = misService.get(Brand.class, product.getBrand().getId());
			model.addAttribute("brand", b.getCode());
			
			
			Product p = misService.get(Product.class, product.getId());
			model.addAttribute("brandEvent", p.getName());
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("product.id", p.getId());
			map.put("orderBy", "id");
			
			p.setSpecs((List<Specifications>) misService.getAllByHashMap(Specifications.class, map));
			map.put("isDeleted", false);
			
			p.setProductImages((List<ProductImages>)misService.getAllByHashMap(ProductImages.class, map));
			model.addAttribute("product", p);
		} 
				
		model.addAttribute("page", page);
		model.addAttribute("begin", begin);
		model.addAttribute("orderBy", orderBy);
		model.addAttribute("sortBy", sortBy);
		model.addAttribute("brandList", solutionBrandList);
		model.addAttribute("solutionList", solutionIdSet);
		model.addAttribute("activeMenu", LinksEnum.PRODUCT.getId());
		return VIEW_PORTFOLIO;
	}
	
	/*@RequestMapping(value="/view/portfolio/product", method=RequestMethod.GET)
	public void productDetail(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Product p = misService.get(Product.class, id);
		model.addAttribute("pCommand", p);
		
		response.sendRedirect(request.getContextPath() + VIEW_PORTFOLIO + "?brand.id="+ p.getId() + "&id="+id);
	}*/
	
	@RequestMapping(value="/view/product/info", method=RequestMethod.GET)
	public String editSupplier(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Long id = Long.parseLong(request.getParameter("id"));
		Product product = misService.get(Product.class, id);
		model.addAttribute("productCommand", product);
		model.addAttribute("activeMenu", LinksEnum.PRODUCT.getId());
		return VIEW_PORTFOLIO_INFO;
	}
	
	@RequestMapping(value="/view/downloadPdf", method=RequestMethod.GET)
	protected String previewSection1(HttpServletResponse response, HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Event event = misService.get(Event.class, id);
	    try {
	        byte[] documentInBytes = event.getBrochure();
	        response.setHeader("Content-Disposition", "filename="+event.getName()+"_Brochure.pdf");
	        response.setDateHeader("Expires", -1);
	        response.setContentType("application/pdf");
	        response.setContentLength(documentInBytes.length);
	        response.getOutputStream().write(documentInBytes);
	    } catch (Exception ioe) {
	    } finally {
	    }
	    return null;
	}
	
	@RequestMapping(value="/view/manualPdf", method=RequestMethod.GET)
	protected String previewSection(HttpServletResponse response, HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		Product product = misService.get(Product.class, id);
	    try {
	        byte[] documentInBytes = product.getBrand().getManual();
	        response.setHeader("Content-Disposition", "filename="+product.getBrand().getManualName()+"_Manual.pdf");
	        response.setDateHeader("Expires", -1);
	        response.setContentType("application/pdf");
	        response.setContentLength(documentInBytes.length);
	        response.getOutputStream().write(documentInBytes);
	    } catch (Exception ioe) {
	    } finally {
	    }
	    return null;
	}
	
	@RequestMapping(value="/view/contact/form", method=RequestMethod.GET)
	public String eventInfo(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("sendCommand") final Client client, 
			ModelMap model) {
		
		return "contactForm";
	}
	
	@RequestMapping(value="/view/contact/form/send", method=RequestMethod.POST)
	public void register(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("sendCommand") final Client client,
							BindingResult result) throws IOException {
		
	
		Client obj = misService.createClient(client);
		
		SimpleClientSmtpServiceConfig smtpConfig = new SimpleClientSmtpServiceConfig("smtp", "smtp.gmail.com", 587, "devism41l@gmail.com","devisyakshas01", false, true, true);
		MessageService mailService = new SimpleClientSmtpMessageService();
		mailService.setConfig(smtpConfig);
		
		MessageTemplate template = null;
		
		String email = Config.getProperties("email.from");
			
		template = ContactEmailTemplate.newTemplate(email, obj);
		mailService.sendMessage(template);
		
		response.sendRedirect(request.getContextPath() + CONTACT_US_RE);
	}
	
	/*@RequestMapping(value="/view/downloadPdf", method=RequestMethod.GET)
	public void downloadPdf(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Product product = misService.get(Product.class, id);
		
		String fileName =  product.getName()+ "manual.pdf";
	    response.setContentType("application/pdf");
	    response.setHeader("Content-disposition", "attachment; filename="+ fileName+".pdf");
	    response.getOutputStream().write(product.getManual());
	}*/
	
}