package com.oris.test.pdf;

import java.util.Date;

import com.oris.util.DateUtility;

public class DateUtilTest {

	public static void main(String[] args) {
		Date date = new Date();
		
		System.out.println("Unformatted Date: " + date);
		System.out.println("Formatted Date: " + DateUtility.convertDateToStr(date, "MM-dd-yyyy"));
		
		String page = "Event";
		System.out.println(page);
		page = "Product";
		System.out.println(page);
		page = "Solution";
		System.out.println(page);
		
		String url = "https://youtu.be/aKRZn0uS6eA";
		System.out.println("lastIndex: " + url.substring(url.lastIndexOf("/") + 1));
	}
}
