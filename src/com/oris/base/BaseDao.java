package com.oris.base;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oris.mis.model.Users;
import com.oris.util.sqlbuilder.SqlBuilderAbstractVO;

public interface BaseDao {
	static final String KEY_COUNT = "count";
	static final String KEY_LIST = "list";
	
	static final String CRITERIA_ALIAS = "criteria_alias";
	static final String CRITERION_PARAMS_OR = "criterion_params_DISJUNTION";
	static final String CRITERION_PARAMS_AND = "criterion_params_CONJUNCTION";
	
	Object save(Object entityClass);
	Object createNew(Object entityClass);
	<L> L get(Class<L> entityClass, Serializable id);
	<L> L load(Class<L> entityClass, Serializable id);
	void delete(Class<?> entityClass, Serializable id);
	void delete(Object entityClass);
	void deleteObjIn(Class<?> clazz, Long id, String condition, Long param);
	List<?> getAll(Class<?> entityClass);
	List<?> getAll(Class<?> entityClass, String orderBy);
	List<?> getAll(Class<?> entityClass, Integer status);
	List<?> getAll(Class<?> entityClass, List<Integer> status);
	List<?> getAll(Class<?> entityClass, Long id);
	
	List<?> getListAllByColumnName(Class<?> entityClass, String columnNam, Object columnValue);

	List<?> getListAllByColumnName(Class<?> entityClass, String operator, List<String> columnNam, List<Object> columnValue);
	Calendar getSysdate();
	List<?> getAllByHashMap(Class<?> entityClass, HashMap<String, Object> map);
	List<Users> getUsersByRoleId(Integer roleId);
	
	boolean validateUser(String username, String password);
	
	List<?> getListAllByHashMapLike(Class<?> entityClass, HashMap<String, Object> map);
	void bulkUpdate(Class<?> entityClass, Map<String, Object> map, Map<String, Object> conditionClause);
	List<?>  getListByHibernateCallBack(Class<?> entityClass, Map<String, Object> conditionClause, Integer begin, String orderBy, String sortBy);
	List <SqlBuilderAbstractVO> executeSqlQuery(String sql);
	List<?> getListAllByColumnName(Class<?> entityClass, String columnNam,
			Object columnValue, String orderBy, String sortBy);
	<L> L getNative(Class<L> clazz, Object id);
}
