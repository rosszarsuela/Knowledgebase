package com.oris.purchasing.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oris.base.BaseServiceImpl;
import com.oris.purchasing.dao.PurchasingDao;
import com.oris.purchasing.model.PurchaseOrder;
import com.oris.util.Page;
import com.oris.util.PaginationUtility;

/**
 * 
 * @author Ross Zarsuela
 *
 */

@Service
public class PurchasingServiceImpl extends BaseServiceImpl implements PurchasingService{
	
	@Autowired private PurchasingDao dao;
	
	@Override
	public void createOrder(PurchaseOrder order) {
		save(order);
	}

	@Override
	public Page viewOrders(PurchaseOrder order) {
		Map<String, Object> map = dao.viewOrders(order);
		
		Page page = PaginationUtility.getPage((Integer)map.get(KEY_COUNT), getSize(), order.getBegin());
		page.setContent((List<?>)map.get(KEY_LIST));
		
		return page;
	}
}