package com.oris.base;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oris.mis.model.Users;
import com.oris.util.Config;
import com.oris.util.email.MessageService;

@Service
public class BaseServiceImpl implements BaseService{
	private BaseDao baseDao;
	private MessageService mailService;
	
	public Integer getSize() {
		return Integer.parseInt(Config.getProperties("views.mis.view.size"));
	}
	
	//Setters and Getters
	@Autowired
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
	@Autowired
	public void setMailService(MessageService mailService) {
		this.mailService = mailService;
	}
	
	public MessageService getMailService() {
		return mailService;
	}
	
	public BaseDao getBaseDao() {
		return baseDao;
	}
	
	@Override
	public Object save(Object entityObject) {
		return baseDao.save(entityObject);
	}
	
	@Override
	public Object createNew(Object entityObject){
		return baseDao.createNew(entityObject);
	}

	@Override
	public <L> L get(Class<L> entityClass, Serializable id) {
		return baseDao.get(entityClass, id);
	}
	
	@Override
	public <L> L load(Class<L> entityClass, Serializable id) {
		return baseDao.load(entityClass, id);
	}

	@Override
	public void delete(Class<?> entityClass, Serializable id) {
		baseDao.delete(entityClass, id);
	}

	@Override
	public void delete(Object entityObject) {
		baseDao.delete(entityObject);
	}

	@Override
	public List<?> getAll(Class<?> entityClass) {
		return baseDao.getAll(entityClass);
	}
	
	@Override
	public List<?> getAll(Class<?> entityClass, String orderBy) {
		return baseDao.getAll(entityClass, orderBy);
	}

	@Override
	public List<?> getAll(Class<?> clazz, Integer status) {
		return baseDao.getAll(clazz, status);
	}
	
	@Override
	public List<?> getAll(Class<?> clazz, List<Integer> status) {
		return baseDao.getAll(clazz, status);
	}

	@Override
	public List<?> getListAllByColumnName(Class<?> entityClass,
			String columnNam, Object columnValue) {
		return baseDao.getListAllByColumnName(entityClass, columnNam, columnValue);
	}
	
	@Override
	public Calendar getSysdate(){
		return baseDao.getSysdate();
	}

	@Override
	public List<?> getAllByHashMap(Class<?> entityClass, HashMap<String, Object> map) {
		return baseDao.getAllByHashMap(entityClass, map);
	}
	
	
	
	@Override
	public List<Users> getUsersByRoleId(Integer roleId) {
		return baseDao.getUsersByRoleId(roleId);
	}

	@Override
	public boolean validateUser(String username, String password) {
		return baseDao.validateUser(username, password);
	}
	
	public String removeApos(String obj) {
		if(StringUtils.isNotEmpty(obj))
			return obj.replaceAll("'", "");
		else
			return "";
	}
	
	@Override
	public <L> L getNative(Class<L> clazz, Object id) {
		return baseDao.getNative(clazz, id);
	}

	@Override
	public Map<Integer, String> getReferenceObjByGroupName(String groupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReferenceValueByGroupNameKey(String groupName, Integer key) {
		// TODO Auto-generated method stub
		return null;
	}
}