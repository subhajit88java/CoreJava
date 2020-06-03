package com.subhajit.HashMapLab;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HashMapLabMain {
	public static void main(String[] args) {
		// testCreate();
		// testUpdate();
		// testDelete();
		testRead();
	}

	private static void testCreate() {

		Map<Integer, String> testMap = new HashMap<>();
		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		testMap.putIfAbsent(4, "ZZ");

		System.out.println("testMap : " + testMap);

	}

	private static void testUpdate() {

		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);

		/*
		 * testMap.replace(1, "Edited Value"); System.out.println("Edited testMap : " +
		 * testMap);
		 */

		testMap.replace(2, "Xx", "Edited Value");

		testMap.replaceAll((key, value) -> {
			String replaceValue = value;
			if (value == null)
				replaceValue = "Null Replaced";
			return replaceValue;
		});
		System.out.println("Edited testMap : " + testMap);
	}

	private static void testDelete() {
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);

		// testMap.remove(null);
		testMap.remove(2, "Xx");
		System.out.println("Deleted testMap : " + testMap);

	}

	private static void testRead() {
		
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);
		
		Collection<String> mapValues = testMap.values();
		System.out.println("mapValues : " + mapValues);

		Set<Integer> keySet = testMap.keySet();
		System.out.println("keySet : " + keySet);
		
		/*
		 * for(Integer key : keySet) { System.out.println("Map data : " +
		 * testMap.get(key)); testMap.put(5, "New Value"); testMap.put(4,
		 * "Edited value"); testMap.replace(4, "Edited value"); testMap.remove(4); }
		 * System.out.println("testMap : " + testMap);
		 */

		Set<Map.Entry<Integer, String>> keyValuePair = testMap.entrySet();
		System.out.println("keyValuePair : " + keyValuePair);

		/*
		 * for (Map.Entry<Integer, String> keyValue : testMap.entrySet()) {
		 * System.out.println("Map Data : " + keyValue.getKey() + " - " +
		 * keyValue.getValue()); }
		 */

		testMap.forEach((key, value) -> {
			System.out.println("Map Data1 : " + key + " - " + value);
			testMap.put(5, "New Value");
		});

		System.out.println("Default value : " + testMap.getOrDefault(10, "defaultValue"));
		
	}

}
