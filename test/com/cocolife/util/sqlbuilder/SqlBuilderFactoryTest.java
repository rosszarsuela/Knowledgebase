package com.cocolife.util.sqlbuilder;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oris.util.sqlbuilder.SqlBuilderAbstractVO;
import com.oris.util.sqlbuilder.SqlBuilderFactory;

/**
 * 
 * @author Ross Zarsuela
 *
 */

public class SqlBuilderFactoryTest {
	private SqlBuilderFactory factory;
	
	@Before
	public void setup() {
		factory = new SqlBuilderFactory();
	}
	
	@Test
	public void shouldTestNullability() {
		assertNotNull(factory);
	}
	
	
	@Test
	public void shouldTestThreadSafety() throws InterruptedException {
		//TODO
	}
	
	@Test
	public void shouldGenerateCorrectToDateFcn() {
		String expected = "to_date('"+new SimpleDateFormat("MM-dd-yyyy").format(new Date())+"','MM-DD-YYYY')";
		assertEquals(expected, SqlBuilderFactory.toDate(new Date()));
	}
	
	@Test
	public void shouldTestTransformation() {
		String name = "name";
		String age = "age";
		String gender = "gender";
		
		List<Map<String, Object>> mapListFromHibernate = new ArrayList<Map<String,Object>>();
		
		for(int i = 0; i<10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(name, "Ross Zarsuela"+i);
			map.put(age, i);
			map.put(gender, "F"+i);
			
			mapListFromHibernate.add(map);
		}
		
		
		List<SqlBuilderAbstractVO> abstractVOList = SqlBuilderFactory.transformToSqlBuilderAbstractVO(mapListFromHibernate);
		
		assertEquals(mapListFromHibernate.size(), abstractVOList.size());
		
		for(int i = 0; i< abstractVOList.size(); i++) {
			Map<String, Object> mapVO = mapListFromHibernate.get(i);
			SqlBuilderAbstractVO absVO = abstractVOList.get(i);
			
			assertSame(mapVO.get(name), absVO.getField(name));
		}
	}
	
	@After
	public void teardown() {
		factory = null;
	}
}
