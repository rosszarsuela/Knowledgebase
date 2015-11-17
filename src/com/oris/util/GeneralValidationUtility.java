package com.oris.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.joda.time.Years;

public class GeneralValidationUtility {

	private static DecimalFormat amountFormat =  new DecimalFormat(" #, ##0.00; -#, ##0.00");
	
	public static boolean checkAlpha(String pattern) {
		if(StringUtils.isBlank(pattern))
			return false;
		return pattern.matches("^[a-zA-ZÒ—'\\s]*$");
	}
	
	public static int computeAge(Date date){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String bDate = sdf.format(date);
		String[] temp = bDate.split("/");
		
		DateMidnight birthdate = new DateMidnight(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
		DateTime now = new DateTime();
		Years age = Years.yearsBetween(birthdate, now);

		return age.getYears();
	}
	
	public static int computeMonthsToSysdate(Date param){
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = sdf.format(param);
		String[] temp = strDate.split("/");
		
		DateMidnight dateDM = new DateMidnight(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
		DateTime now = new DateTime();
		Months age = Months.monthsBetween(dateDM, now);
		
		return age.getMonths();
	}
	
	public static String formatNegativeNumber(Double amount) {
		if(amount < 0) {
			return "(" + amountFormat.format(Math.abs(amount)) + ")";
		}
		
		return ""+amount;
	}

}
