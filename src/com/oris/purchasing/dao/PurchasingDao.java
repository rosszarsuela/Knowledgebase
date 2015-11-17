package com.oris.purchasing.dao;

import java.util.Map;

import com.oris.base.BaseDao;
import com.oris.purchasing.model.PurchaseOrder;

public interface PurchasingDao extends BaseDao {
	
	Map<String, Object> viewOrders(PurchaseOrder order);
}
