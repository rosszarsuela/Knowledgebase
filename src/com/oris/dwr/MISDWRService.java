package com.oris.dwr;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.oris.mis.model.Product;
import com.oris.mis.service.MISService;

@RemoteProxy(name="misDWRService")
public class MISDWRService {
	
	@Autowired private MISService misService;
		
	public boolean isUserExists(String username) {
		return misService.isUserExists(username);
	}
	
	public boolean isUserEmailExists(String email) {
		return misService.isUserEmailExists(email);
	}
	
	public boolean isDoctorExists(String param) {
		return misService.isDoctorExists(param);
	}
	
	public Product getProductById(Long id) {
		Product product = misService.get(Product.class, id);
		return product;
	}
}