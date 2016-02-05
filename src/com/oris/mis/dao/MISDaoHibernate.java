package com.oris.mis.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oris.base.BaseDaoHibernate;
import com.oris.enums.StatusEnum;
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
import com.oris.util.InventoryUtility;

/**
 * 
 * @author Ross Zarsuela
 *
 */

@Repository("misDao")
public class MISDaoHibernate extends BaseDaoHibernate implements MISDao {

	@Autowired
	public MISDaoHibernate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewUsers(String username, final Integer begin, String orderBy, String sortBy) {
				
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Users u where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Users u where 1=1 ");
		
		if(StringUtils.isNotEmpty(username)) {
			dynamicSql.append("and lower(u.username) like lower(:search) or lower(u.firstName) like lower(:search) or lower(u.lastName) like lower(:search) ");
		}
		
		if(StringUtils.isNotEmpty(orderBy)) {
			dynamicSql.append("order by ").append(orderBy);			
			if(StringUtils.isNotEmpty(sortBy)) {
				dynamicSql.append(" ").append(sortBy);
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(username)) {
			query.setParameter("search", username+"%");
			queryCount.setParameter("search", username+"%");
		}

		if(!InventoryUtility.isNull(begin)) {
			query.setFirstResult((begin - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Users> usersList = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, usersList);
		return map;
	}

	@Override
	public UsersForgotPassword createNewForgotPass(Users user) {
		UsersForgotPassword ufp = new UsersForgotPassword();
		ufp.setDateRequested(new Date());
		ufp.setStatus(StatusEnum.ACTIVE.getId());
		ufp.setUser(user);
		return (UsersForgotPassword) save(ufp);
		
	}
	
	@Override
	public UsersForgotPassword getLastForgotPass(Users user){
		DetachedCriteria maxId = DetachedCriteria.forClass(UsersForgotPassword.class).setProjection( Projections.max("id") );
		Criteria criteria = getSession().createCriteria(UsersForgotPassword.class).add( Property.forName("id").eq(maxId) )  ;
		
		return (UsersForgotPassword) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer getForgotPasswordCountByUser(Users user) {		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user.username", user.getUsername());
		List<UsersForgotPassword> list = (List<UsersForgotPassword>) getAllByHashMap(UsersForgotPassword.class, map);		
		return list.size();
	}

	@Override
	public Users getUserByEmailAddress(String input) {
		Criteria criteria = getSession().createCriteria(Users.class);
		criteria.add(Restrictions.eq("email", input).ignoreCase());
		return (Users) criteria.uniqueResult();
	}

	@Override
	public boolean isUserExists(String username) {
		Criteria criteria = getSession().createCriteria(Users.class);
		criteria.add(Restrictions.like("username", username).ignoreCase());		
		return criteria.list().size() > 0 ? true : false;
	}

	@Override
	public boolean isUserEmailExists(String email) {
		Criteria criteria = getSession().createCriteria(Users.class);
		criteria.add(Restrictions.eq("email", email).ignoreCase());
		return criteria.list().size() > 0 ? true : false;
	}

	@Override
	public boolean isSamePassword(String md5Password) {
		Long count = (Long) getSession().createQuery("select count(*) from Users where password = :password").setParameter("password", md5Password).uniqueResult();
		return count>0?true: false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewDoctors(Doctor doctor) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Doctor d where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Doctor d where 1=1 ");
		
		if(StringUtils.isNotEmpty(doctor.getSearch())) {
			dynamicSql.append("and ( lower(d.lastName) like lower(:search) or lower(d.middleName) like lower(:search) " +
							  "or lower(d.lastName) like lower(:search) or lower(d.address) like lower(:search) ) ");
		}
		
		if(!InventoryUtility.isNull(doctor.getStatus())) {
			dynamicSql.append("and d.status = :status ");
		}
		
		if(StringUtils.isNotEmpty(doctor.getOrderBy())) {
			dynamicSql.append("order by ").append(doctor.getOrderBy());			
			if(StringUtils.isNotEmpty(doctor.getSortBy())) {
				dynamicSql.append(" ").append(doctor.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(doctor.getSearch())) {
			query.setParameter("search", "%"+doctor.getSearch()+"%");
			queryCount.setParameter("search", "%"+doctor.getSearch()+"%");
		}
		
		if(!InventoryUtility.isNull(doctor.getStatus())) {
			query.setParameter("status", doctor.getStatus());
			queryCount.setParameter("status", doctor.getStatus());
		}

		if(!InventoryUtility.isNull(doctor.getBegin())) {
			query.setFirstResult((doctor.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Doctor> customerList = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, customerList);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewMentors(Doctor doctor) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Doctor d where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Doctor d where 1=1 ");
		
		if(!InventoryUtility.isNull(doctor.getStatus())) {
			dynamicSql.append("and d.status = :status ");
		}
		
		if(StringUtils.isNotEmpty(doctor.getOrderBy())) {
			dynamicSql.append("order by ").append(doctor.getOrderBy());			
			if(StringUtils.isNotEmpty(doctor.getSortBy())) {
				dynamicSql.append(" ").append(doctor.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		
		if(!InventoryUtility.isNull(doctor.getStatus())) {
			query.setParameter("status", doctor.getStatus());
			queryCount.setParameter("status", doctor.getStatus());
		}

		if(!InventoryUtility.isNull(doctor.getBegin())) {
			query.setFirstResult((doctor.getBegin() - 1) * getDoctorSize());
			query.setMaxResults(getDoctorSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Doctor> customerList = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, customerList);
		return map;
	}

	@Override
	public boolean isCustomerExists(String param) {
		StringBuffer hqlQuery = new StringBuffer("select count(*) from CustomerProfile c where lower(c.name) = lower(:param) or lower(c.email) = lower(:param)");
		Query query = getSession().createQuery(hqlQuery.toString());
		query.setParameter("param", param);
		
		Integer count = Integer.parseInt(query.list().get(0).toString());
		if(count > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Users validateUserForgotPassword(String param) {
		StringBuffer hqlQuery = new StringBuffer("from Users u where lower(u.username) = lower(:search) or lower(u.email) = lower(:search) ");
		Query query = getSession().createQuery(hqlQuery.toString());
		query.setParameter("search", param);
		query.setParameter("search", param);
		
		List<Users> user = query.list();
		return user.size()> 0 ? (Users) user.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewProduct(Product product) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Product p " + "inner join p.brand b " +
													  "inner join p.category sc inner join sc.solution s " + "inner join p.specs " + "where 1=1 ");
		
		StringBuffer hqlQuery = new StringBuffer("from Product p " + "inner join fetch p.brand b " + "inner join fetch p.category sc inner join fetch sc.solution s " + "where 1=1 ");
		
		if(!InventoryUtility.isNull(product.getCategory()) && !InventoryUtility.isNull(product.getCategory().getSolution().getId())) {
			dynamicSql.append("and s.id = :solutionId ");
		}
		
		if(!InventoryUtility.isNull(product.getCategory()) && !InventoryUtility.isNull(product.getCategory().getId())) {
			dynamicSql.append("and sc.id = :categoryId ");
		}
				
		if(!InventoryUtility.isNull(product.getBrand()) && !InventoryUtility.isNull(product.getBrand().getId())) {
			dynamicSql.append("and b.id = :brandId ");
		}
		
		if(StringUtils.isNotEmpty(product.getName())) {
			dynamicSql.append("and lower(p.name) like lower(:search) ");
		}
		
		if(StringUtils.isNotEmpty(product.getOrderBy())) {
			dynamicSql.append("order by ").append(product.getOrderBy());			
			if(StringUtils.isNotEmpty(product.getSortBy())) {
				dynamicSql.append(" ").append(product.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		
		if(!InventoryUtility.isNull(product.getCategory()) && !InventoryUtility.isNull(product.getCategory().getSolution().getId())) {
			query.setParameter("solutionId", product.getCategory().getSolution().getId());
			queryCount.setParameter("solutionId", product.getCategory().getSolution().getId());
		}
		
		if(!InventoryUtility.isNull(product.getCategory()) && !InventoryUtility.isNull(product.getCategory().getId())) {
			query.setParameter("categoryId", product.getCategory().getId());
			queryCount.setParameter("categoryId", product.getCategory().getId());
		}
		
		if(!InventoryUtility.isNull(product.getBrand()) && !InventoryUtility.isNull(product.getBrand().getId())) {
			query.setParameter("brandId", product.getBrand().getId());
			queryCount.setParameter("brandId", product.getBrand().getId());
		}
		
		if(StringUtils.isNotEmpty(product.getName())) {
			query.setParameter("search", "%"+product.getName()+"%");
			queryCount.setParameter("search", "%"+product.getName()+"%");
		}

		if(!InventoryUtility.isNull(product.getBegin())) {
			query.setFirstResult((product.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		} else {
			if(!InventoryUtility.isNull(product.getStartLimit()) && !InventoryUtility.isNull(product.getEndLimit())) {
				query.setFirstResult(product.getStartLimit());
				query.setMaxResults(product.getEndLimit());
			}
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Product> results = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, results);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewCustomers(Customer customer) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Customer c where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Customer c where 1=1 ");
		
		if(StringUtils.isNotEmpty(customer.getName())) {
			dynamicSql.append("and lower(c.name) like lower(:search) ");
		}
		
		if(StringUtils.isNotEmpty(customer.getOrderBy())) {
			dynamicSql.append("order by ").append(customer.getOrderBy());			
			if(StringUtils.isNotEmpty(customer.getSortBy())) {
				dynamicSql.append(" ").append(customer.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(customer.getName())) {
			query.setParameter("search", "%"+customer.getName()+"%");
			queryCount.setParameter("search", "%"+customer.getName()+"%");
		}

		if(!InventoryUtility.isNull(customer.getBegin())) {
			query.setFirstResult((customer.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Customer> results = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, results);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewEvents(Event event) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Event e left join e.speakers where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Event e left join fetch e.speakers where 1=1 ");
		
		if(StringUtils.isNotEmpty(event.getName())) {
			dynamicSql.append("and lower(e.name) like lower(:search) ");
		}
		
		if(!InventoryUtility.isNull(event.getStatus())) {
			dynamicSql.append("and e.status =:status ");
		}
		
		if(StringUtils.isNotEmpty(event.getOrderBy())) {
			dynamicSql.append("order by ").append(event.getOrderBy());			
			if(StringUtils.isNotEmpty(event.getSortBy())) {
				dynamicSql.append(" ").append(event.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(event.getName())) {
			query.setParameter("search", "%"+event.getName()+"%");
			queryCount.setParameter("search", "%"+event.getName()+"%");
		}
		
		if(!InventoryUtility.isNull(event.getStatus())) {
			query.setParameter("status", event.getStatus());
			queryCount.setParameter("status", event.getStatus());
		}

		if(!InventoryUtility.isNull(event.getBegin())) {
			query.setFirstResult((event.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		} else {
			if(!InventoryUtility.isNull(event.getStartLimit()) && !InventoryUtility.isNull(event.getEndLimit())) {
				query.setFirstResult(event.getStartLimit());
				query.setMaxResults(event.getEndLimit());
			}
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Event> results = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, results);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewBrands(Brand brand) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Brand b where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Brand b where 1=1 ");
		
		if(StringUtils.isNotEmpty(brand.getName())) {
			dynamicSql.append("and ( lower(b.code) like lower(:search) or lower(b.name) like lower(:search) )");
		}
		
		if(StringUtils.isNotEmpty(brand.getOrderBy())) {
			dynamicSql.append("order by ").append(brand.getOrderBy());			
			if(StringUtils.isNotEmpty(brand.getSortBy())) {
				dynamicSql.append(" ").append(brand.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(brand.getName())) {
			query.setParameter("search", "%"+brand.getName()+"%");
			queryCount.setParameter("search", "%"+brand.getName()+"%");
		}

		if(!InventoryUtility.isNull(brand.getBegin())) {
			query.setFirstResult((brand.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Brand> results = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, results);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewSolutions(Solution solution) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Solution s where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Solution s where 1=1 ");
		
		if(StringUtils.isNotEmpty(solution.getName())) {
			dynamicSql.append("and ( lower(s.code) like lower(:search) or lower(s.name) like lower(:search) or lower(s.description) like lower(:search))");
		}
		
		if(StringUtils.isNotEmpty(solution.getOrderBy())) {
			dynamicSql.append("order by ").append(solution.getOrderBy());			
			if(StringUtils.isNotEmpty(solution.getSortBy())) {
				dynamicSql.append(" ").append(solution.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(solution.getName())) {
			query.setParameter("search", "%"+solution.getName()+"%");
			queryCount.setParameter("search", "%"+solution.getName()+"%");
		}

		if(!InventoryUtility.isNull(solution.getBegin())) {
			query.setFirstResult((solution.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Solution> results = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, results);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewSolutionsCategory(SolutionsCategory category) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from SolutionsCategory sc where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from SolutionsCategory sc where 1=1 ");
		
		if(StringUtils.isNotEmpty(category.getName())) {
			dynamicSql.append("and ( lower(sc.name) like lower(:search) or lower(sc.description) like lower(:search) )");
		}
		
		if(StringUtils.isNotEmpty(category.getOrderBy())) {
			dynamicSql.append("order by ").append(category.getOrderBy());			
			if(StringUtils.isNotEmpty(category.getSortBy())) {
				dynamicSql.append(" ").append(category.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(category.getName())) {
			query.setParameter("search", "%"+category.getName()+"%");
			queryCount.setParameter("search", "%"+category.getName()+"%");
		}

		if(!InventoryUtility.isNull(category.getBegin())) {
			query.setFirstResult((category.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<SolutionsCategory> results = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, results);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductsAndServicesMenu> getSolutionsBrand() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT b.brand_id_pk AS brandId, s.solution_id_pk AS solutionId, s.name AS solutionName, b.name AS brandName FROM product p ");
		sql.append("INNER JOIN brand b ON b.brand_id_pk = p.brand_id_fk ");
		sql.append("INNER JOIN solution_category sc ON sc.sol_cat_id_pk = p.sol_cat_id_fk ");
		sql.append("INNER JOIN solution s ON s.solution_id_pk = sc.solution_id_fk ");
		sql.append("GROUP BY b.name ");
		sql.append("ORDER BY s.name ASC ");
		
		List<ProductsAndServicesMenu> results = getSession().createSQLQuery(sql.toString())
		.addScalar("brandId",StandardBasicTypes.LONG)
		.addScalar("solutionId",StandardBasicTypes.LONG)
		.addScalar("brandName", StandardBasicTypes.STRING)
		.addScalar("solutionName", StandardBasicTypes.STRING)
		.setResultTransformer(Transformers.aliasToBean(ProductsAndServicesMenu.class))
		.list();
		
		return results;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Videos getVideos() {		
		Query query = getSession().createQuery("from Videos");		
		List<Videos> results = query.list();
		
		if(results.size() > 0)
			return results.get(0);
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> viewConsultant(Consultants consultant) {
		Map<String, Object> map = new HashMap<String, Object>();		
		StringBuffer dynamicSql = new StringBuffer();
		
		//Generate sqlCount query
		StringBuffer hqlQueryCount = new StringBuffer("select count(*) from Consultants con where 1=1 ");
		StringBuffer hqlQuery = new StringBuffer("from Consultants con where 1=1 ");
		
		if(StringUtils.isNotEmpty(consultant.getSearch())) {
			dynamicSql.append("and ( lower(con.firstName) like lower(:search) or lower(con.middleName) like lower(:search) " +
							  "or lower(con.lastName) like lower(:search) or lower(con.address) like lower(:search) ) ");
		}
		
		if(!InventoryUtility.isNull(consultant.getStatus())) {
			dynamicSql.append("and con.status = :status ");
		}
		
		if(StringUtils.isNotEmpty(consultant.getOrderBy())) {
			dynamicSql.append("order by ").append(consultant.getOrderBy());			
			if(StringUtils.isNotEmpty(consultant.getSortBy())) {
				dynamicSql.append(" ").append(consultant.getSortBy());
			}
		}
		
		final String sql =  hqlQuery.append(dynamicSql).toString();
		final String sqlCount =  hqlQueryCount.append(dynamicSql).toString();
		
		Query query = getSession().createQuery(sql);
		Query queryCount = getSession().createQuery(sqlCount);
		if(StringUtils.isNotEmpty(consultant.getSearch())) {
			query.setParameter("search", "%"+consultant.getSearch()+"%");
			queryCount.setParameter("search", "%"+consultant.getSearch()+"%");
		}
		
		if(!InventoryUtility.isNull(consultant.getStatus())) {
			query.setParameter("status", consultant.getStatus());
			queryCount.setParameter("status", consultant.getStatus());
		}

		if(!InventoryUtility.isNull(consultant.getBegin())) {
			query.setFirstResult((consultant.getBegin() - 1) * getSize());
			query.setMaxResults(getSize());
		}
		
		Integer count = Integer.parseInt(queryCount.list().get(0).toString());
		List<Consultants> customerList = query.list();
		
		map.put(KEY_COUNT, count);
		map.put(KEY_LIST, customerList);
		return map;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorList() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT d.doctor_id_pk AS id, d.last_name AS lastName FROM doctor d ");
		sql.append("GROUP BY d.last_name ");
		sql.append("ORDER BY d.last_name ASC ");
		
		List<Doctor> results = getSession().createSQLQuery(sql.toString())
		.addScalar("doctorId",StandardBasicTypes.LONG)
		.addScalar("doctorName", StandardBasicTypes.STRING)
		.setResultTransformer(Transformers.aliasToBean(Doctor.class))
		.list();
		
		return results;
	}
}