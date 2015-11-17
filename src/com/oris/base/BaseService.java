package com.oris.base;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oris.mis.model.Users;
import com.oris.util.email.MessageService;

public interface BaseService {
	static final String KEY_COUNT = "count";
	static final String KEY_LIST = "list";
	
	Object save(Object object);
	Object createNew(Object entityObject);
	<L> L get(Class<L> clazz, Serializable id);
	<L> L load(Class<L> clazz, Serializable id);
	void delete(Class<?> clazz, Serializable id);
	void delete(Object entityClass);
	List<?> getAll(Class<?> clazz);
	List<?> getAll(Class<?> entityClass, String orderBy);
	List<?> getAll(Class<?> clazz, Integer status);
	List<?> getAll(Class<?> clazz, List<Integer> status);
	
	List<?> getListAllByColumnName(Class<?> entityClass, String columnNam, Object columnValue);
	Calendar getSysdate();
	
	List<?> getAllByHashMap(Class<?> entityClass, HashMap<String, Object> map);
	Map<Integer, String> getReferenceObjByGroupName(String groupName);
	String getReferenceValueByGroupNameKey(String groupName, Integer key);
	List<Users> getUsersByRoleId(Integer roleId);
	boolean validateUser(String username, String password);
	MessageService getMailService();
	<L> L getNative(Class<L> clazz, Object id);
}
