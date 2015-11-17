package com.oris.util;

import java.text.DecimalFormat;
import java.util.List;

public class MathUtility {
	public static Double getSum(final Double... numbers) {
		Double total = new Double(0);
		
		for(Double num : numbers) {
			total += num;
		}
		
		return total;
	}
	
	public static Double getSum(final List<Double> numbers) {
		Double total = new Double(0);
		
		for(Double num : numbers) {
			total += num;
		}
		
		return total;
	}
	
	public static Double getProduct(final Double... numbers) {
		Double total = new Double(1);
		
		for(Double num : numbers) {
			total *= num;
		}
		
		return total;
	}
	
	public static Double getProduct(final List<Double> numbers) {
		Double total = new Double(1);
		
		for(Double num : numbers) {
			total *= num;
		}
		
		return total;
	}
	
	public static String formatNumber2Decimal(Double amount) {
		DecimalFormat currency = new DecimalFormat("#,##0.00");
		
		return currency.format(amount);
		
	}
}
