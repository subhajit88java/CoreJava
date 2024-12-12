package com.subhajit.main;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortHashMap {
	
	public static void main(String[] args) {
		sortMapBasedOnKey();
	}

	private static void sortMapBasedOnKey() {
		Map<String, String> map = new HashMap();
		map.put("AA", "AA-name");
		map.put("B", "B-name");
		map.put("AAA", "AAA-name");
		map.put("C", "C-name");
		map.put("AAAA", "AAAA-name");
		
		// Aesc order
		Map<String, String> sortedMap1 = new TreeMap(map);
		System.out.println("Aesc order based on key : " + sortedMap1);
		
		List<String> keyList = map
											.keySet()
											.stream()
											.sorted(Comparator.reverseOrder())
											.collect(Collectors.toList());
		
		Map<String, String> sortedMap2 = new LinkedHashMap();
		
		keyList.forEach(s -> {
			sortedMap2.put(s, map.get(s));
		});
		System.out.println("Desc order based on key : " + sortedMap2);
	}

}
