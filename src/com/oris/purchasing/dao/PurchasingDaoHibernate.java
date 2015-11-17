package com.oris.purchasing.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oris.base.BaseDaoHibernate;
import com.oris.mis.model.Users;
import com.oris.purchasing.model.PurchaseOrder;
import com.oris.util.InventoryUtility;

/**
 * 
 * @author Ross Zarsuela
 *
 */

@Repository("puchasingDao")
public class PurchasingDaoHibernate extends BaseDaoHibernate implements PurchasingDao {

	@Autowired
	public PurchasingDaoHibernate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewOrders(PurchaseOrder order) {
				
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Users u ");
		StringBuffer hqlQuery = new StringBuffer("from Users u ");
		
		if(StringUtils.isNotEmpty(order.getName())) {
			dynamicSql.append("where lower(u.username) like lower(:search) or lower(u.firstName) like lower(:search) or lower(u.lastName) like lower(:search) ");
		}
		
		if(StringUtils.isNotEmpty(order.getOrderBy())) {
			dynamicSql.append("order by ").append(order.getOrderBy());			
			if(StringUtils.isNotEmpty(order.getSortBy())) {
				dynamicSql.append(" ").append(order.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(order.getName())) {
			query.setParameter("search", order.getName()+"%");
			queryCount.setParameter("search", order.getName()+"%");
		}

		if(!InventoryUtility.isNull(order.getBegin())) {
			query.setFirstResult((order.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Users> usersList = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, usersList);
		return map;
	}
}