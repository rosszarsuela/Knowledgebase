package com.cocolife.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.oris.util.SqlEngineUtil;

public class SqlEngineUtilTest {
	SqlEngineUtil util;
	
	@Before
	public void setup(){
		util = SqlEngineUtil.getInstance();
	}
	
	@Test
	public void shouldTestCreateInClause(){
		String sql = util.createInClause("test", new String[]{"1"});
		assertNotNull(sql);
		assertEquals(" test in (1)", sql);
		
		sql = util.createInClause("test", true, new String[]{"1"});
		assertNotNull(sql);
		assertEquals(" test in (?)", sql);
		
		sql = util.createInClause("test", new String[]{"1", "2"});
		assertEquals(" test in (1, 2)", sql);
		
		sql = util.createInClause("test", true, new String[]{"1" , "2"});
		assertEquals(" test in (?, ?)", sql);
		
	}
	
	@Test
	public void shouldTestInstantiation(){
		assertNotNull(util);
	}
	
	
	
}




