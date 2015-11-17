package com.cocolife.util;

import static org.junit.Assert.*;

import java.util.Date;

import org.joda.time.LocalDate;
import org.junit.Test;

import com.oris.util.DateUtility;

public class DateUtilityTest {
	
//	@Test
//	public void shouldTestGettingNextBusinessDay(){
//		LocalDate someDate = new LocalDate("2012-05-28");
//		LocalDate localDate = DateUtility.getNextBusinessDay(someDate, 1);
//		assertNotNull(localDate);
//		assertTrue(localDate.getDayOfWeek() == someDate.getDayOfWeek());
//		
//		// known Sunday
//		someDate = new LocalDate("2012-05-27");
//		localDate = DateUtility.getNextBusinessDay(someDate, 1);
//		assertNotNull(localDate);
//		assertTrue(localDate.getDayOfWeek() != someDate.getDayOfWeek());
//	
//		String str = "test";
//		String str2 = new String("test");
//		System.out.println(str2 == str);
//	}

	public static void main(String[] args) {
		System.out.println(DateUtility.convertDateToStr(new Date(), "MMddyyhhmmss"));
	}

}















