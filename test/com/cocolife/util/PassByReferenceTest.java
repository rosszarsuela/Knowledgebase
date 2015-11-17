package com.cocolife.util;

import static org.junit.Assert.*;

import org.junit.Test;


public class PassByReferenceTest {
	@Test
	public void testInteger() {
		Double a = new Double(0);
		System.out.println(a);
		
		setDouble(a);
		
		assertEquals(Double.valueOf(7), a);
		
	}
	
	private void setDouble(Double a) {
		a = new Double(7);
		System.out.println(7);
	}
}
