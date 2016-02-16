package com.oris.mis.dao;

import java.util.List;
import java.util.Map;

import com.oris.base.BaseDao;
import com.oris.mis.model.Brand;
import com.oris.mis.model.Consultants;
import com.oris.mis.model.Customer;
import com.oris.mis.model.Doctor;
import com.oris.mis.model.Event;
import com.oris.mis.model.Product;
import com.oris.mis.model.Solution;
import com.oris.mis.model.SolutionsCategory;
import com.oris.mis.model.Users;
import com.oris.mis.model.UsersForgotPassword;
import com.oris.mis.model.Videos;
import com.oris.mis.model.dto.ProductsAndServicesMenu;

public interface MISDao extends BaseDao {
	
	//Users
	Map<String, Object> viewUsers(String username, Integer begin, String orderBy, String sortBy);
	boolean isUserExists(String username);
	boolean isUserEmailExists(String email);
	boolean isSamePassword(String md5Password);
	Users validateUserForgotPassword(String param);
	
	//Doctor
	Map<String, Object> viewDoctors(Doctor doctor);
	Map<String, Object> viewMentors(Doctor doctor);
	
	//Customer
	Map<String, Object> viewCustomers(Customer customer);
	boolean isCustomerExists(String param);
	
	//Product
	Map<String, Object> viewProduct(Product product);
	
	//Brand
	Map<String, Object> viewBrands(Brand brand);
	
	//Solution
	Map<String, Object> viewSolutions(Solution solution);
	
	//Solution Category
	Map<String, Object> viewSolutionsCategory(SolutionsCategory category);
	
	//Events
	Map<String, Object> viewEvents(Event event);
	
	//for forgot password
	UsersForgotPassword createNewForgotPass(Users user);
	Integer getForgotPasswordCountByUser(Users user);
	UsersForgotPassword getLastForgotPass(Users user);
	Users getUserByEmailAddress(String input);
	
	//Solutions Brand
	List<ProductsAndServicesMenu> getSolutionsBrand();
	
	//Video Links
	Videos getVideos();
	
	//Consultant
	Map<String, Object> viewConsultant(Consultants consultant);
	
	//Doctors for Educators
	List<Doctor> getDoctorList();
	
}
