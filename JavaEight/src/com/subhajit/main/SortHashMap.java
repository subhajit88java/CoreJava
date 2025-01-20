package com.subhajit.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import com.subhajit.model.Student;

public class SortHashMap {
	
	public static void main(String[] args) {
		//sortMapBasedOnPrimalKey();
		sortMapBasedOnCustomisedKey();
		//sortMapBasedOnPrimalValue();
	}

	private static void sortMapBasedOnPrimalValue() {
		Map<String, String> map = new HashMap();
		map.put("A", "ZZ");
		map.put("B", "AA");
		map.put("C", "YY");
		map.put("D", "BB");
		map.put("E", "XX");
		
		// Aesc order by converting into entrySet
		Map<String,String>	sortedMap = map
				.entrySet()
				.stream()
				.sorted((s1,s2) -> {
					return s1.getValue().compareTo(s2.getValue());
				})
				.collect(Collectors
						.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a,() -> new LinkedHashMap<>()));
				
		System.out.println("Aesc order based on value : " + sortedMap);
		
		// Desc order by converting into entrySet
		sortedMap = map
				.entrySet()
				.stream()
				.sorted((s1,s2) -> {
					return s1.getValue().compareTo(s2.getValue());
				})
				.collect(Collectors
						.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a,() -> new LinkedHashMap<>()));
				
		System.out.println("Aesc order based on value : " + sortedMap);
				
	}

	private static void sortMapBasedOnCustomisedKey() {
		Map<Student, String> map = new HashMap();
		map.put(new Student(1, "Subhajit", 75), "val1");
		map.put(new Student(2, "Asim", 90), "val2");
		map.put(new Student(3, "Suman", 65), "val3");
		map.put(new Student(4, "Ram", 80), "val4");
		map.put(new Student(5, "Sourav", 100), "val5");
		
		// Aesc order by converting into entrySet		
		Map<Student, String> sortedMap =  map
		.entrySet()
		.stream()
		.sorted(Comparator.comparing(Entry :: getKey, Comparator.comparing(Student :: getMarks)))
		.collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a, LinkedHashMap :: new));
	
		System.out.println("Asc order based on student marks :: " + sortedMap);
		
		// Aesc order by converting into entrySet		
		sortedMap =  map
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(Entry :: getKey, Comparator.comparing(Student :: getMarks).reversed()))
				.collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a, LinkedHashMap :: new));
			
				System.out.println("Desc order based on student marks :: " + sortedMap);
	
		//map.put(null, "val5");
		// Aesc order by converting into entrySet		
		sortedMap =  map
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(Entry :: getKey, Comparator.nullsFirst(Comparator.comparing(Student :: getMarks))))
				.collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a, LinkedHashMap :: new));
			
		System.out.println("Asc order based on student marks(null key) :: " + sortedMap);
		
		// Desc order by converting into entrySet		
		sortedMap =  map
						.entrySet()
						.stream()
						.sorted(Comparator.comparing(Entry :: getKey, Comparator.nullsFirst(Comparator.comparing(Student :: getMarks).reversed())))
						.collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a, LinkedHashMap :: new));
					
				System.out.println("Asc order based on student marks(null key) :: " + sortedMap);
		
		map.put(new Student(5, "NULL-NAME", null), "val5");
		// Aesc order by converting into entrySet		
		sortedMap =  map
						.entrySet()
						.stream()
						.sorted(Comparator.comparing(Entry :: getKey, Comparator.comparing(Student :: getMarks, Comparator.nullsFirst(Comparator.naturalOrder()))))
						.collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a, LinkedHashMap :: new));
					
		System.out.println("Asc order based on student marks(null) :: " + sortedMap);
		
		// Dsc order by converting into entrySet		
		sortedMap =  map
								.entrySet()
								.stream()
								.sorted(Comparator.comparing(Entry :: getKey, Comparator.comparing(Student :: getMarks, Comparator.nullsFirst(Comparator.reverseOrder()))))
								.collect(Collectors.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a, LinkedHashMap :: new));
							
		System.out.println("Asc order based on student marks(null) :: " + sortedMap);
		
	
	}

	private static void sortMapBasedOnPrimalKey() {
		Map<String, String> map = new HashMap();
		map.put("AA", "AA-name");
		map.put("B", "B-name");
		map.put("AAA", "AAA-name");
		map.put("C", "C-name");
		map.put("AAAA", "AAAA-name");
		
		System.out.println("Original map : " + map);
		System.out.println("---------------------------------------------");
		
		// Aesc order with the help of treemap
		// If any null key is present this process will give nullpointer exception
		Map<String, String> sortedMap = new TreeMap(map);
		System.out.println("Aesc order based on key, using treemap approach : " + sortedMap);
		System.out.println("---------------------------------------------");
		
		// Aesc order by converting into entrySet
		sortedMap = map
		.entrySet()
		.stream()
		.sorted((s1,s2) -> {
			return s1.getKey().compareTo(s2.getKey());
		})
		.collect(Collectors
				.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a,() -> new LinkedHashMap<>()));
		
		System.out.println("Aesc order based on key, using entry-set approach : " + sortedMap);
		System.out.println("---------------------------------------------");
		
		// Desc order by converting into entry-set
		sortedMap = map
				.entrySet()
				.stream()
				.sorted((s1,s2) -> {
					return s2.getKey().compareTo(s1.getKey());
				})
				.collect(Collectors
						.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a,() -> new LinkedHashMap<>()));
				
		System.out.println("Desc order based on key, using entry-set approach : " + sortedMap);
		System.out.println("---------------------------------------------");
		
		// Aesc order though key-set
		List<String> keyList = map
								.keySet()
								.stream()
								.sorted(Comparator.naturalOrder())
								.collect(Collectors.toList());
		
		Map<String, String> sortedMap2 = new LinkedHashMap();
		
		keyList.forEach(s -> {
			sortedMap2.put(s, map.get(s));
		});
		System.out.println("Aesc order based on key, using key-set approach : " + sortedMap2);
		System.out.println("---------------------------------------------");
		
		// Desc order though key-set
		keyList = map
					.keySet()
					.stream()
					.sorted(Comparator.reverseOrder())
					.collect(Collectors.toList());
				
		Map<String, String> sortedMap3 = new LinkedHashMap();
				
		keyList.forEach(s -> {
			sortedMap3.put(s, map.get(s));
		});
		System.out.println("Desc order based on key, using key-set approach : " + sortedMap3);
		System.out.println("---------------------------------------------");
		
		map.put(null, "ZZZZZ");
		
		// Aesc order, will one key as null
		sortedMap = map
				.entrySet()
				.stream()
				.sorted(Comparator
						.comparing(Entry :: getKey, 
								Comparator.nullsFirst(Comparator.naturalOrder())))
				.collect(Collectors
						.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a,() -> new LinkedHashMap<>()));
				
		System.out.println("Aesc order based on key(null), using entry-set approach : " + sortedMap);
		System.out.println("---------------------------------------------");
		
		// Desc order, will one key as null
		sortedMap = map
						.entrySet()
						.stream()
						.sorted(Comparator
								.comparing(Entry :: getKey, 
										Comparator.nullsFirst(Comparator.reverseOrder())))
						.collect(Collectors
								.toMap(Entry :: getKey, Entry :: getValue, (a,b) -> a,() -> new LinkedHashMap<>()));
						
		System.out.println("Desc order based on key(null), using entry-set approach : " + sortedMap);
		System.out.println("---------------------------------------------");
		
		map.put("BB", null);
		
		// Aesc order, will one key as null
		sortedMap = map
					.entrySet()
					.stream()
					.sorted(Comparator
							.comparing(Entry :: getValue, 
										Comparator.nullsFirst(Comparator.naturalOrder())))
					.collect(Collectors
							.toMap(Entry :: getKey, Entry :: getValue, 
									(a,b) -> "", // This will cause NPE if value is null, so cant followthis entry-set approach
									() -> new LinkedHashMap<>()));
						
		System.out.println("Aesc order based on value(null), using entry-set approach : " + sortedMap);
		System.out.println("---------------------------------------------");		
		
	}

}
