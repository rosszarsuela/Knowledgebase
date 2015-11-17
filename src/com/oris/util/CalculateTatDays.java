package com.oris.util;

import java.util.Date;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class CalculateTatDays {
	
	public static final String PARAM_WORKING_DAYS = "workingDays";
	public static final String PARAM_CALENDAR_DAYS = "calendarDays";
	
	public static Date getTatDay(Date currentDate, Integer days, String type) {
		final LocalDate start = LocalDate.fromDateFields(currentDate);
		LocalDate weekday = start;
		final LocalDate end = weekday.plusDays(days);
		Date finalDate = null;
		
		while(weekday.isBefore(end)) {
			
			if(type.equals(PARAM_WORKING_DAYS)) {
				if (start.getDayOfWeek() == DateTimeConstants.SATURDAY || start.getDayOfWeek() == DateTimeConstants.SUNDAY) {
					weekday = weekday.plusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY);
				}

				if(weekday.getDayOfWeek() == DateTimeConstants.FRIDAY){
					weekday = weekday.plusDays(3);
				} else {
					weekday = weekday.plusDays(1);
				}
				finalDate = weekday.toDateMidnight().toDate();
			} else {
				weekday = weekday.plusDays(1);
				finalDate = weekday.minusDays(1).toDateMidnight().toDate();
			}
		}

		return finalDate;
	}
	
}
