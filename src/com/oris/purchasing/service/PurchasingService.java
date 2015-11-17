package com.oris.purchasing.service;

import com.oris.base.BaseService;
import com.oris.purchasing.model.PurchaseOrder;
import com.oris.util.Page;

public interface PurchasingService extends BaseService {
	
	void createOrder(PurchaseOrder order);
	Page viewOrders(PurchaseOrder order);
}
