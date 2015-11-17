package com.oris.util;

import java.util.Map;

import org.apache.log4j.Logger;

// TODO: please do not use until a dynamic sql generator is created
public class SqlEngineUtil {
	Logger logger = Logger.getLogger(SqlEngineUtil.class);
	public static final String COMMA = ",";
	public static final String SPACE = " ";
	public static final String QUESTION = "?";
	
	private static SqlEngineUtil util;
	private SqlEngineUtil(){}
	
	public static synchronized SqlEngineUtil getInstance(){
		if(null == util){
			util = new SqlEngineUtil();
		}
		return util;
	}
	
	public String createInClause(String columnName, String...values){
		return createInClause(columnName, false, values);
	}
	
	public String createInClause(String columnName, boolean forPreparedStatement, String...values){
		StringBuffer sb = new StringBuffer();
		String answer = null;
		
		sb.append(" " + columnName + " in (");
		for(String value: values){
			if(forPreparedStatement){
				sb.append(QUESTION + COMMA + SPACE);
			} else
				sb.append(value + COMMA + SPACE);
		}
		sb.append(")");
		
		answer = sb.toString().replace(", )", ")");
		return answer;
	}
	
	public String createTableSearchClause(Map<String, String> map){
		return null;
	}	
}