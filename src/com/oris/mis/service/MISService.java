package com.oris.mis.service;

import java.util.List;

import com.oris.base.BaseService;
import com.oris.mis.model.Brand;
import com.oris.mis.model.Customer;
import com.oris.mis.model.Doctor;
import com.oris.mis.model.Event;
import com.oris.mis.model.Participants;
import com.oris.mis.model.Product;
import com.oris.mis.model.Solution;
import com.oris.mis.model.SolutionsCategory;
import com.oris.mis.model.Users;
import com.oris.mis.model.Videos;
import com.oris.mis.model.dto.ProductsAndServicesMenu;
import com.oris.util.Page;

public interface MISService extends BaseService {
	
	//Users
	void registration(Users users);
	boolean isSamePassword(String md5Password);
	Page viewUsers(String username, Integer begin, String orderBy, String sortBy);
	boolean isUserExists(String username);
	boolean isUserEmailExists(String email);
	
	//Doctor
	void doctorRegistration(Doctor doctor);
	Page viewDoctors(Doctor doctor);
	boolean isDoctorExists(String param);
	
	//Customers
	void customerRegistration(Customer customer);
	Page viewCustomers(Customer customer);
	
	//Product
	void createProduct(Product product);
	Page viewProducts(Product product);
	boolean isProductExists(String param);
	
	//Brand
	void createBrand(Brand brand);
	Page viewBrands(Brand brand);
	
	//Solution
	void createSolution(Solution solution);
	Page viewSolutions(Solution solution);
	
	//Solution Category
	void createSolutionCategory(SolutionsCategory category);
	Page viewSolutionsCategory(SolutionsCategory category);
	
	//Event
	void createEvent(Event event);
	Page viewEvents(Event event);
		
	//Event Participant
	Participants createParticipant(Participants participant);
	Page viewParticipants(Participants participant);
	
	//Solution Brand
	List<ProductsAndServicesMenu> getSolutionsBrand();
	
	//Video Links
	void createVideo(Videos video);
	Videos getVideo();
	
}
