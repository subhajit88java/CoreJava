package com.subhajit.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMapFlatmap {
	
	public static void main(String[] args) {
		List<String> listString = Arrays.asList("1","2","3","4","5");
		System.out.println(listString);
		
		List<Integer> listInteger = listString.stream().map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(listInteger);
		
		List<String> listString1 = Arrays.asList("1","2","3");
		List<String> listString2 = Arrays.asList("4","5","6");
		List<String> listString3 = Arrays.asList("7","8");
		
		Stream<List<String>> streamString = Stream.of(listString1, listString2, listString3);
		
		List<Integer> combinedList = streamString.flatMap(stream -> stream.stream()).map(Integer::valueOf).collect(Collectors.toList());
		System.out.println(combinedList);
 	}

}
