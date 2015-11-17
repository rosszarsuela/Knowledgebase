package com.oris.base.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public abstract class AbstrBaseModel implements Serializable{
	private static final long serialVersionUID = 3100330981366082365L;
	
	private HashMap<String, Object> modelValues = new HashMap<String, Object>();
	
	public Object getObject(String key){ return modelValues.get(key);}
	public void setValue(String name, Object value){ modelValues.put(name, value);}
	
	public String getString(String name){ return (String) modelValues.get(name);}
	public Integer getInteger(String name){ return (Integer) modelValues.get(name);}
	public BigDecimal getBigDecimal(String name){ return (BigDecimal) modelValues.get(name);}
	public Boolean getBoolean(String name){ return (Boolean) modelValues.get(name);}
	public Double getDouble(String name){ return (Double) modelValues.get(name);}
	public Date getDate(String name){ return (Date) modelValues.get(name);}
	public Long getLong(String name){ return (Long) modelValues.get(name);}
	@SuppressWarnings("unchecked")
	public List<String> getStringList(String name){ return (List<String>) modelValues.get(name);}
}




















