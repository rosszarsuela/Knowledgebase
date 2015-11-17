package com.cocolife.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.oris.util.NumberUtil;

public class NumberUtilTest {

	@Before
	public void setup(){}
	
	@Test
	public void shouldTestToDouble(){
		Double d = null;
		assertNotNull(NumberUtil.toDouble(d, false));
		assertEquals(new Double(0), NumberUtil.toDouble(d, false));
		assertEquals(new Double(5), NumberUtil.toDouble(5d, false));
	}
}
