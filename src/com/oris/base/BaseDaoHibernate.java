package com.oris.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.oris.mis.model.Users;
import com.oris.util.Config;
import com.oris.util.DateUtility;
import com.oris.util.InventoryUtility;
import com.oris.util.sqlbuilder.SqlBuilderAbstractVO;
import com.oris.util.sqlbuilder.SqlBuilderFactory;

/**
 * Base Dao Implementation
 * 
 * @author Ross Zarsuela
 * 
 */

@SuppressWarnings("deprecation")
@Repository("baseDao")
public class BaseDaoHibernate extends HibernateDaoSupport implements BaseDao {

	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;
	
	public Integer getDoctorSize() {
		return Integer.parseInt(Config.getProperties("mis.doctor.view.size"));
	}
	
	public Integer getSize() {
		return Integer.parseInt(Config.getProperties("views.mis.view.size"));
	}

	@Autowired
	public BaseDaoHibernate(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@Override
	public Object save(Object entityClass) {
		return getHibernateTemplate().merge(entityClass);
	}

	@Override
	public Object createNew(Object entityClass) {
		Long id = (Long) getHibernateTemplate().save(entityClass);
		return get(entityClass.getClass(), id);
	}

	@Override
	public <L> L get(Class<L> entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}
	
	@Override
	public <L> L load(Class<L> entityClass, Serializable id) {
		return getHibernateTemplate().load(entityClass, id);
	}

	@Override
	public void delete(Class<?> entityClass, Serializable id) {
		Object entityObject = get(entityClass, id);
		delete(entityObject);
	}

	@Override
	public List<?> getAll(Class<?> entityClass) {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public void delete(Object entityObject) {
		getHibernateTemplate().delete(entityObject);
	}

	@Override
	public List<?> getAll(Class<?> entityClass, Integer status) {
		return getHibernateTemplate().find("from " + entityClass.getSimpleName() + " where status = ? order by id", status);
	}
	
	@Override
	public List<?> getAll(Class<?> entityClass, List<Integer> status) {
		List<?> results = (List<?>) getSession().createQuery("from " + entityClass.getSimpleName() + " where status in (:status) order by id").setParameterList("status", status).list();
		return results;
	}

	@Override
	public List<?> getAll(Class<?> entityClass, String orderBy) {
		return (List<?>) getSession().createQuery("from " + entityClass.getSimpleName() + " order by " + orderBy +" asc").list();
	}

	@Override
	public List<?> getAll(Class<?> entityClass, Long id) {
		return getHibernateTemplate().find("from " + entityClass.getSimpleName() + " where status = ? order by id", id);
	}

	// Use a more specific column like alias_name.column_nam
	@Override
	public List<?> getListAllByColumnName(Class<?> entityClass, String columnNam, Object columnValue) {
		return getHibernateTemplate().find("from " + entityClass.getSimpleName() + " where " + columnNam + " = ?", columnValue);
	}

	@Override
	public List<?> getListAllByColumnName(Class<?> entityClass, String columnNam, Object columnValue, String orderBy, String sortBy) {
		return getHibernateTemplate().find("from " + entityClass.getSimpleName() + " where " + columnNam + " = ?  order by ? " + sortBy, columnValue, orderBy);
	}

	@Override
	public Calendar getSysdate() {
		Session session = getSessionFactory().openSession();
		Query qry = session.createSQLQuery("select NOW()");

		Timestamp sysDate = (Timestamp) qry.list().get(0);
		String dateStr = DateUtility.convertDateToStr(sysDate, "yyyy-MM-dd");
		String timeStr = DateUtility.convertDateToStr(sysDate, "hh:mm:ss");
		
		String[] dateArray = dateStr.split("-");
		Calendar date = Calendar.getInstance();
		date.set(Calendar.YEAR, Integer.parseInt(dateArray[0]));
		date.set(Calendar.MONTH, Integer.parseInt(dateArray[1])-1);
		date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateArray[2]));
		
		String[] timeArray = timeStr.split(":");
		date.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeArray[0]));
		date.set(Calendar.MINUTE, Integer.parseInt(timeArray[1]));
		date.set(Calendar.SECOND, Integer.parseInt(timeArray[2]));
		date.set(Calendar.MILLISECOND, 0);

		session.flush();
		session.close();

		return date;
	}

	@Override
	public List<?> getAllByHashMap(Class<?> entityClass,
			HashMap<String, Object> map) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);

		Set<String> keys = map.keySet();
		Iterator<String> iter = keys.iterator();

		Object date_from = null;
		Object date_to = null;
		String date_param = "";

		if (map.size() > 0) {
			while (iter.hasNext()) {
				String key = iter.next();

				if (map.get(key) instanceof Object[]) {
					criteria.add(Expression.in(key, (Object[]) map.get(key)));
				} else if (key.contains("dateFrom%")) {// For Date BETWEEN
														// Parameters :p
					date_from = map.get(key);
				} else if (key.contains("orderBy")) {
					criteria.addOrder(Order.asc(map.get(key).toString()));
				} else if (key.contains("dateTo%")) {
					date_to = map.get(key);
					int index = key.indexOf("%");
					date_param = key.substring(index + 1);
				} else if(key.contains("description")){
					logger.info("has description.");
					criteria.add(Expression.isNotNull("description"));
				} else {
					criteria.add(Expression.eq(key, map.get(key)));
				}
			}

			if (date_from != null && date_to != null) {
				criteria.add(Expression.between(date_param, date_from, date_to));
			}
			
		}
		
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<?> getListAllByColumnName(Class<?> entityClass, String operator, List<String> columnNam, List<Object> columnValue) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Users> getUsersByRoleId(Integer roleId) {
		Criteria criteria = getSession().createCriteria(Users.class);
		criteria.add(Restrictions.eq("role.id", roleId));
		criteria.addOrder(Order.asc("username"));
		return criteria.list();
	}

	

	@Override
	public boolean validateUser(String username, String password) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Users.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", md5PasswordEncoder.encodePassword(password, null)));

		@SuppressWarnings("unchecked")
		List<Users> users = getHibernateTemplate().findByCriteria(criteria);
		if (!users.isEmpty())
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<?> getListAllByHashMapLike(Class<?> entityClass,
			HashMap<String, Object> map) {

		Criteria criteria = null;

		// Create Session and create Criteria Fetch modes
		HashMap<String, Object> mapCriteriaAliases = (HashMap<String, Object>) map
				.get(CRITERIA_ALIAS);
		criteria = createFetchModeJoins(entityClass, mapCriteriaAliases);

		// Create disjuctions for map of Criterion(disjunstions)
		HashMap<String, Object> mapCriterions_disjunctions = (HashMap<String, Object>) map
				.get(CRITERION_PARAMS_OR);
		if (mapCriterions_disjunctions.size() > 0) {
			criteria.add(createDisjunction(mapCriterions_disjunctions));
		}

		// Create conjunctions for map of Criterion(conjuctions)
		HashMap<String, Object> mapCriterions_conjunctions = (HashMap<String, Object>) map
				.get(CRITERION_PARAMS_AND);
		if (mapCriterions_conjunctions.size() > 0) {
			criteria.add(createConjunction(mapCriterions_conjunctions));
		}

		return (List<?>) criteria.list();
	}

	/**
	 * This HashMap refers to the collection of Criterias for creating aliases
	 * 
	 * @key : refers to the join name, e.g accounts.policy, member.memberPolicy
	 * @value: refers to the desired alias name, e.g acctPol, memComp
	 */
	private Criteria createFetchModeJoins(Class<?> entityClass,
			HashMap<String, Object> map) {
		Criteria criteria = getSession().createCriteria(entityClass);

		Set<String> alias_keys = map.keySet();
		Iterator<String> alias_iters = alias_keys.iterator();

		if (map.size() > 0) {
			while (alias_iters.hasNext()) {
				String key = alias_iters.next();

				criteria.setFetchMode(key, FetchMode.JOIN);
				criteria.createAlias(key, (String) map.get(key));
			}
		}

		return criteria;
	}

	/**
	 * This HashMap refers to the collection of Criterion for creating
	 * Disjunctions (OR)
	 * 
	 * @key : refers to the attribute, representing the column_name
	 * @value : refers to the value to be compared
	 * 
	 * @example : or (upper(key1) like upper('%value1%')) or (upper(key2) like
	 *          upper('%value2%')) or ...
	 * 
	 * @return Disjunction
	 */
	private Disjunction createDisjunction(HashMap<String, Object> map) {
		Set<String> criterionD_keys = map.keySet();
		Iterator<String> criterionD_iters = criterionD_keys.iterator();
		Disjunction disjunction = Restrictions.disjunction();
		if (map.size() > 0) {
			while (criterionD_iters.hasNext()) {
				String key = criterionD_iters.next();
				Criterion criterionName = Restrictions.ilike(key, (String) map
						.get(key).toString(), MatchMode.ANYWHERE);
				disjunction.add(criterionName);
			}
		}

		return disjunction;
	}

	/**
	 * This HashMap refers to the collection of Criterion for creating
	 * Conjunction (AND)
	 * 
	 * @key : refers to the attribute, representing the column_name
	 * @value : refers to the value to be compared
	 * 
	 * @example : and (upper(key1) like upper('%value1%')) and (upper(key2) like
	 *          upper('%value2%')) and ...
	 * 
	 * @return Conjunction
	 */
	private Conjunction createConjunction(HashMap<String, Object> map) {
		Set<String> criterionD_keys = map.keySet();
		Iterator<String> criterionD_iters = criterionD_keys.iterator();
		Conjunction conjunction = Restrictions.conjunction();
		if (map.size() > 0) {
			while (criterionD_iters.hasNext()) {
				String key = criterionD_iters.next();
				Criterion criterionName = Restrictions.ilike(key, (String) map
						.get(key).toString(), MatchMode.ANYWHERE);
				conjunction.add(criterionName);
			}
		}

		return conjunction;
	}

	public void bulkUpdate(Class<?> entityClass, Map<String, Object> map,
			Map<String, Object> conditionClause) {
		String sql = "update " + entityClass.getSimpleName() + " set ";
		int i = 0;
		for (String key : map.keySet()) {
			sql += key + " = " + map.get(key);

			if (i < (map.size() - 1))
				sql += ", ";

			i++;
		}

		if (null != conditionClause) {
			sql += " where ";
			for (String key : conditionClause.keySet()) {
				sql += key + " = " + conditionClause.get(key);

				if (i < (conditionClause.size() - 1))
					sql += ", ";

				i++;
			}
		}

		getHibernateTemplate().bulkUpdate(sql);
	}

	@Override
	public List<?> getListByHibernateCallBack(Class<?> entityClass,
			Map<String, Object> map, final Integer begin, String orderBy,
			String sortBy) {
		StringBuffer sb = new StringBuffer();
		sb.append("from ").append(entityClass.getSimpleName()).append(" ");

		if (map != null && !map.isEmpty()) {
			sb.append("where ");
			Iterator<String> it = map.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				Object value = map.get(key);

				if (value instanceof String)
					sb.append("upper(").append(key).append(") like '%")
							.append(((String) value).toUpperCase())
							.append("%' ");
				else if (value instanceof List)
					sb.append(key)
							.append(" in ")
							.append(" (")
							.append(InventoryUtility
									.getStringOfArray((List<?>) value))
							.append(") ");
				else
					sb.append(key).append("=").append(value).append(" ");

				if (it.hasNext())
					sb.append(" and ");
			}
		}

		if (StringUtils.isNotEmpty(orderBy)) {
			sb.append("order by ").append(orderBy);

			if (StringUtils.isNotEmpty(sortBy)) {
				sb.append(" ").append(sortBy);
			}
		}

		final String dynamicSql = sb.toString();

		List<?> list = getHibernateTemplate().executeFind(
				new HibernateCallback<List<?>>() {
					@Override
					public List<?> doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(dynamicSql);
						query.setFirstResult((begin - 1) * getSize());
						query.setMaxResults(getSize());

						return query.list();
					}
				});
		return list;
	}

	/**
	 * This method assumes that the passed in String sql is a native sql
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<SqlBuilderAbstractVO> executeSqlQuery(String sql) {
		SQLQuery sqlQuery = getSession().createSQLQuery(sql);
		logger.debug(sql);
		List<Map<String, Object>> list = sqlQuery.setResultTransformer(
				AliasToEntityMapResultTransformer.INSTANCE).list();
		List<SqlBuilderAbstractVO> abstractVOs = SqlBuilderFactory
				.transformToSqlBuilderAbstractVO(list);
		return abstractVOs;
	}
	
	public String removeApos(String obj) {
		if(StringUtils.isNotEmpty(obj))
			return obj.replaceAll("'", "");
		else
			return "";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <L> L getNative(Class<L> clazz, Object id) {
		Field field1 = null;
		Field field2 = null;
		SQLQuery query = null;
		try {
			field1 = clazz.getDeclaredField("className");
			field2 = clazz.getDeclaredField("classId");
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			query = (SQLQuery) getSession().createSQLQuery("SELECT " +
				"	{CLAZZ.*} " +
				"	FROM " + field1.get(0) + " CLAZZ " +
				"	WHERE CLAZZ." + field2.get(0) + " = :ID").addEntity("CLAZZ", clazz).setParameter("ID", id);
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return (L) query.list().get(0);
	}

	@Override
	public void deleteObjIn(Class<?> clazz, Long id, String condition, Long param) {
		StringBuffer hql = new StringBuffer("delete from " + clazz.getSimpleName() + " obj where 1=1 ");
		
		if(!InventoryUtility.isNull(id)) {
			hql.append("and obj.id = :id ");
		}
		
		if(StringUtils.isNotEmpty(condition) && !InventoryUtility.isNull(param)) {
			hql.append("and ").append(condition).append(" = :param");
		}
		
		Query query = getSession().createQuery(hql.toString());
		
		if(!InventoryUtility.isNull(id)) {
			query.setParameter("id", id);
		}
		
		if(StringUtils.isNotEmpty(condition) && !InventoryUtility.isNull(param)) {
			query.setParameter("param", param);
		}
		query.executeUpdate();
	}
}