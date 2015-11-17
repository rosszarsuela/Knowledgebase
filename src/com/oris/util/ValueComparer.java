package com.oris.util;

import java.util.Comparator;
import java.util.Map;

public class ValueComparer implements Comparator<Object> {
	private Map<Integer, String> map = null;

	public ValueComparer(Map<Integer, String> map) {
		super();
		this.map = map;
	}

	public int compare(Object o1, Object o2) {
		String e1 = (String) map.get(o1);
		String e2 = (String) map.get(o2);
		return e1.compareTo(e2);
	}
}