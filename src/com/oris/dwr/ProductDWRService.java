package com.oris.dwr;

import java.util.HashMap;
import java.util.List;

import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import com.oris.enums.StatusEnum;
import com.oris.mis.model.Product;
import com.oris.mis.model.ProductImages;
import com.oris.mis.service.MISService;

@RemoteProxy(name="productDWRService")
public class ProductDWRService {
	
	@Autowired private MISService misService;
		
	@SuppressWarnings("unchecked")
	public List<Product> getProductsByCategoryId(Long id) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("category.id", id);
		map.put("status", StatusEnum.ACTIVE.getId());
		map.put("orderBy", "id");
		List<Product> products = (List<Product>) misService.getAllByHashMap(Product.class, map);		
		return products;
	}
	
	public Product getProductById(Long id) {
		Product product = misService.get(Product.class, id);
		return product;
	}
	
	public ProductImages getImageById(Long id) {
		ProductImages pi = misService.get(ProductImages.class, id);
		return pi;
	}
}