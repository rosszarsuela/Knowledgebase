package com.oris.mis.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oris.base.BaseServiceImpl;
import com.oris.mis.dao.MISDao;
import com.oris.mis.model.Brand;
import com.oris.mis.model.Client;
import com.oris.mis.model.Consultants;
import com.oris.mis.model.Customer;
import com.oris.mis.model.Doctor;
import com.oris.mis.model.Event;
import com.oris.mis.model.Participants;
import com.oris.mis.model.Product;
import com.oris.mis.model.ProductImages;
import com.oris.mis.model.Solution;
import com.oris.mis.model.SolutionsCategory;
import com.oris.mis.model.Speaker;
import com.oris.mis.model.Specifications;
import com.oris.mis.model.Users;
import com.oris.mis.model.Videos;
import com.oris.mis.model.dto.ProductsAndServicesMenu;
import com.oris.util.InventoryUtility;
import com.oris.util.Page;
import com.oris.util.PaginationUtility;

/**
 * 
 * @author Ross Zarsuela
 *
 */

@Service
public class MISServiceImpl extends BaseServiceImpl implements MISService{
	
	@Autowired private MISDao misDao;
	@Autowired private Md5PasswordEncoder md5PasswordEncoder; 
	
	@Override
	public void registration(Users users) {
		users.setPassword(md5PasswordEncoder.encodePassword(users.getPassword(), null));
		if(!InventoryUtility.isEmpty(InventoryUtility.getLoginUsername())) {
			users.setCreatedBy(new Users(InventoryUtility.getLoginUsername()));
		}
		if(InventoryUtility.isNull(users.getCreatedDate())) {
			users.setCreatedDate(new Date());
		}
		save(users);
	}

	@Override
	public Page viewUsers(String username, Integer begin, String orderBy, String sortBy) {
		Map<String, Object> map = misDao.viewUsers(username, begin, orderBy, sortBy);
		
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), begin);
		page.setContent((List<?>)map.get(KEY_LIST));
		
		return page;
	}

	@Override
	public boolean isUserExists(String username) {
		return misDao.isUserExists(username);
	}

	@Override
	public boolean isUserEmailExists(String email) {
		return misDao.isUserEmailExists(email);
	}

	@Override
	public boolean isSamePassword(String md5Password) {
		return misDao.isSamePassword(md5Password);
	}

	@Override
	public void doctorRegistration(Doctor doctor) {
		if(InventoryUtility.isNull(doctor.getId())) {
			doctor.setCreatedBy(InventoryUtility.getLoginUser());
			doctor.setCreatedDate(new Date());
		} else {
			doctor.setUpdatedBy(InventoryUtility.getLoginUser());
			doctor.setUpdatedDate(new Date());
		}
		misDao.save(doctor);
	}

	@Override
	public Page viewDoctors(Doctor doctor) {
		Map<String, Object> map =  misDao.viewDoctors(doctor);
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), doctor.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}
	
	@Override
	public Page viewMentors(Doctor doctor) {
		Map<String, Object> map =  misDao.viewMentors(doctor);
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getDoctorSize(), doctor.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	@Override
	public boolean isDoctorExists(String param) {
		return misDao.isCustomerExists(param);
	}

	@Override
	public void createProduct(Product product) {
		List<Specifications> sp = product.getSpecs();
		List<ProductImages> productImages = product.getProductImages();
		product.setProductImages(null);
		product.setSpecs(null);
		
		if(InventoryUtility.isNull(product.getCategory().getId())) {
			product.setCategory(null);
		}
		
		if(InventoryUtility.isNull(product.getId())) {
			product.setCreatedBy(InventoryUtility.getLoginUser());
			product.setCreatedDate(new Date());
		} else {
			product.setUpdatedBy(InventoryUtility.getLoginUser());
			product.setUpdatedDate(new Date());
		}
		
		Product p = (Product) misDao.save(product);
		
		misDao.deleteObjIn(Specifications.class, null, "product.id", p.getId());
		
		for(Specifications specifications : sp) {
			specifications.setProduct(p);
			save(specifications);
		}
		
		HashMap<String, Object> update = new HashMap<String, Object>();
		update.put("isDeleted", true);
		
		HashMap<String, Object> condition = new HashMap<String, Object>();
		condition.put("product.id", p.getId());
		misDao.bulkUpdate(ProductImages.class, update, condition);
		
		if(!InventoryUtility.isNull(productImages) && productImages.size() > 0) {
			for(ProductImages pImg : productImages) {
				pImg.setProduct(p);
				pImg.setCreatedDate(new Date());
				pImg.setCreatedBy(InventoryUtility.getLoginUser());
				pImg.setIsDeleted(false);
				if(!InventoryUtility.isNull(pImg.getPImg()) && pImg.getPImg().getSize() > 0) {
					byte[] pImage = new byte[(int) pImg.getPImg().getBytes().length];
					try {
						InputStream fis = pImg.getPImg().getInputStream();
						fis.read(pImage);
						fis.close();
							pImg.setPImage(pImage);
							pImg.setContentType(pImg.getPImg().getContentType());
					} catch (IOException e) {
						
						e.printStackTrace();
					}
				} else {
					ProductImages pi = (ProductImages) get(ProductImages.class, pImg.getId());
					pImg.setPImage(pi.getPImage());
				}
				save(pImg);
			}
		}
	}
	
	@Override
	public Page viewProducts(Product product) {
		Map<String, Object> map =  misDao.viewProduct(product);		
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), product.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	@Override
	public void customerRegistration(Customer customer) {
		if(InventoryUtility.isNull(customer.getId())) {
			customer.setCreatedBy(InventoryUtility.getLoginUser());
			customer.setCreatedDate(new Date());
		} else {
			customer.setUpdatedBy(InventoryUtility.getLoginUser());
			customer.setUpdatedDate(new Date());
		}
		misDao.save(customer);
	}

	@Override
	public Page viewCustomers(Customer customer) {
		Map<String, Object> map =  misDao.viewCustomers(customer);		
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), customer.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	@Override
	public void createEvent(Event event) {
		List<Speaker> s = event.getSpeakers();
		event.setSpeakers(null);
		
		if(InventoryUtility.isNull(event.getId())) {
			event.setCreatedBy(InventoryUtility.getLoginUser());
			event.setCreatedDate(new Date());
		} else {
			event.setUpdatedBy(InventoryUtility.getLoginUser());
			event.setUpdatedDate(new Date());
		}
		
		Event e = (Event) misDao.save(event);
		misDao.deleteObjIn(Speaker.class, null, "event.id", e.getId());
		
		for(Speaker speaker : s) {
			speaker.setEvent(new Event(e.getId()));
			save(speaker);
		}
	}

	@Override
	public Page viewEvents(Event event) {
		Map<String, Object> map =  misDao.viewEvents(event);		
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), event.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	@Override
	public void createBrand(Brand brand) {
		if(InventoryUtility.isNull(brand.getId())) {
			brand.setCreatedBy(InventoryUtility.getLoginUser());
			brand.setCreatedDate(new Date());
		} else {
			brand.setUpdatedBy(InventoryUtility.getLoginUser());
			brand.setUpdatedDate(new Date());
		}
		misDao.save(brand);
	}

	@Override
	public Page viewBrands(Brand brand) {
		Map<String, Object> map =  misDao.viewBrands(brand);
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), brand.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	@Override
	public void createSolution(Solution solution) {
		
		if(InventoryUtility.isNull(solution.getId())) {
			solution.setCreatedBy(InventoryUtility.getLoginUser());
			solution.setCreatedDate(new Date());
		} else {
			solution.setUpdatedBy(InventoryUtility.getLoginUser());
			solution.setUpdatedDate(new Date());
		}
		misDao.save(solution);
	}

	@Override
	public Page viewSolutions(Solution solution) {
		Map<String, Object> map =  misDao.viewSolutions(solution);
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), solution.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	@Override
	public void createSolutionCategory(SolutionsCategory category) {
		if(InventoryUtility.isNull(category.getId())) {
			category.setCreatedBy(InventoryUtility.getLoginUser());
			category.setCreatedDate(new Date());
		} else {
			category.setUpdatedBy(InventoryUtility.getLoginUser());
			category.setUpdatedDate(new Date());
		}
		misDao.save(category);
	}

	@Override
	public Page viewSolutionsCategory(SolutionsCategory category) {
		Map<String, Object> map =  misDao.viewSolutionsCategory(category);
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), category.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	
	@Override
	public Page viewParticipants(Participants participant) {
		return null;
	}

	@Override
	public Participants createParticipant(Participants participant) {
		
		if (InventoryUtility.isNull(participant.getId())) {
			participant.setCreatedDate(new Date());
		}
		
		Participants obj = (Participants) misDao.save(participant);
		return obj;
	}

	@Override
	public boolean isProductExists(String param) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductsAndServicesMenu> getSolutionsBrand() {
		return misDao.getSolutionsBrand();
	}

	@Override
	public void createVideo(Videos video) {
		if(InventoryUtility.isNull(video.getId())){
			video.setCreatedBy(InventoryUtility.getLoginUser());
			video.setCreatedDate(new Date());
		} else{
			video.setUpdatedBy(InventoryUtility.getLoginUser());
			video.setUpdatedDate(new Date());
		}
		
		misDao.save(video);
	}

	@Override
	public Videos getVideo() {
		return misDao.getVideos();
	}

	
	@Override
	public void consultantRegistration(Consultants consultant) {
		if(InventoryUtility.isNull(consultant.getId())) {
			consultant.setCreatedBy(InventoryUtility.getLoginUser());
			consultant.setCreatedDate(new Date());
		} else {
			consultant.setUpdatedBy(InventoryUtility.getLoginUser());
			consultant.setUpdatedDate(new Date());
		}
		misDao.save(consultant);
	}

	@Override
	public Page viewConsultant(Consultants consultant) {
		Map<String, Object> map =  misDao.viewConsultant(consultant);		
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), consultant.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));		
		return page;
	}

	@Override
	public Client createClient(Client client) {
		if (InventoryUtility.isNull(client.getId())) {
			client.setCreatedDate(new Date());
		}
		
		Client obj = (Client) misDao.save(client);
		return obj;
	}

	@Override
	public List<Doctor> getDoctorList() {
		return misDao.getDoctorList();
	}
}