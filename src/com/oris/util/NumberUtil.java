package com.oris.util;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;

public class NumberUtil {
	public static DecimalFormat amountFormat =  new DecimalFormat("Php #, ##0.00;-Php #, ##0.00");
	
	static Logger logger = Logger.getLogger(NumberUtil.class);
	
	public static String formatAmountStr(Double amount) {
		if(amount == null) return amountFormat.format(0);
		else return amountFormat.format(amount);
	}
	
	public static Integer toInteger(Object o){
		Integer answer = null;
		
		if(o instanceof Long){
			answer = (Integer) o;
		} else if (o instanceof String){
			try{ answer = Integer.parseInt((String) o);}
			catch(Exception e){ logger.error(e);}
		}
		
		return answer;
	}
	
	public static Long toLong(Object o){
		Long answer = null;
		
		if(o instanceof Long){
			answer = (Long) o;
		} else if (o instanceof String){
			try{ answer = Long.parseLong((String) o);}
			catch(Exception e){ logger.error(e);}
		}
		
		return answer;
	}
	
	public static Double toDouble(Object o){
		return toDouble(o, false);
	}
	
	public static String toPercent(Double value) {
		if(value == null) return "0%";
		else return value*100+"%";
	}
	
	public static String toPercentNoDec(Double value) {
		if(value == null){
			return "0%";
		}else{
			Integer val = 0;
			Double val2 = value*100;
			String amt = val2.toString();
			val = Integer.parseInt(amt.replace(".", ""))/10;
			return val+"%";
		}
	}
	
	public static String toPercentNoDec2(Double value) {
		if(value == null){
			return "0";
		}else{
			Integer val = 0;
			String amt = value.toString();
			val = Integer.parseInt(amt.replace(".", ""))/10;
			return val.toString();
		}
	}
	
	/*
	 * Never use anything but DigDecimal to manipulate money in java, else, use these methods
	 */
	public static Double toDouble(Object o, boolean allowNull){
		Double answer = null;
		if(allowNull && null == o) return null;
		
		if(o instanceof Double){
			answer = (Double) o;
		} else if(o instanceof String){
			answer = Double.parseDouble((String) o);
		}
		
		return (null == answer)? 0d: answer;
	}
	
	// TODO: convert all Doubles to BigDecimals.  Sigh.
	public static Double round(Double value, String format){
		DecimalFormat decimalFormat = new DecimalFormat(format);
        return Double.valueOf(decimalFormat.format(value));
	}
	
	public static Float round(Float value, String format){
		DecimalFormat decimalFormat = new DecimalFormat(format);
        return Float.valueOf(decimalFormat.format(value));
	}
	
	public static Double round(Double value){
		return round(value, "#.00");
	}
	
	public static Float round(Float value){
		return round(value, "#.00");
	}
	
	public static boolean isZeroOrNull(Double value){
		return (null == value || value == 0)? true: false;
	}
	
	public static Double zeroIfNull(Double value){
		return (null == value)? 0d: value;
	}
	
	public static String format2Decimal(Double amount) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		if(InventoryUtility.isNull(amount)) {
			amount = new Double(0);
		}
		return df.format(amount);
	}
	
	public static String format2Decimal(Float amount) {
		DecimalFormat df = new DecimalFormat("#,##0.00");
		return df.format(amount);
	}
	
	public static Double removeComma(String amount) {
		String amt = amount.replace(",", "");
		return new Double(amt);
	}
}














