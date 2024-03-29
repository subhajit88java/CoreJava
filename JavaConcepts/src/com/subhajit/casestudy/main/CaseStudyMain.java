package com.subhajit.casestudy.main;

import java.io.ObjectStreamClass;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.subhajit.casestudy.model.Model1;
import com.subhajit.casestudy.model.ObjectSupplierClass;
import com.subhajit.casestudy.model.ThisConstructorModel;

public class CaseStudyMain {

	public static void main(String[] args) {
		// 1. A list with repeated values. Output should be a map with 
		// value as key and no. of occurrences as value
		//whatWillBeOutput1();
		
		// Sort a map based on key
		//whatWillBeOutput2();
		
		// Sort a map based on value
		//whatWillBeOutput3();
		
		// String quiz
		//whatWillBeOutput4();
		
		// Constructor quiz
		whatWillBeOutput5();
		
		
	}

	private static void whatWillBeOutput5() {
		ThisConstructorModel thisConstructorModel1 = new ThisConstructorModel(10);
		thisConstructorModel1.print();
		
		ThisConstructorModel thisConstructorModel2 = new ThisConstructorModel(10,20);
		thisConstructorModel2.print();
		
		ThisConstructorModel thisConstructorModel3 = new ThisConstructorModel(10, 20, 30);
		thisConstructorModel3.print();
	}

	private static void whatWillBeOutput4() {
		String a = "Hello";
		String b = new String("Hello");
		String c = "Hello";
		String d = new String("Hello");
		System.out.println((a==b) + " " + (a==c) + " " + (a==d)); // false true false
		//System.out.println(a==b + " " + a==c + " " + a==d); // compile error
	}

	private static void whatWillBeOutput3() {
		// TODO Auto-generated method stub
		
	}

	private static void whatWillBeOutput2() {
		// TODO Auto-generated method stub
		
	}

	private static void whatWillBeOutput1() {
		// Process 1 without null
		List<String> list1 = ObjectSupplierClass.getStringListRepeatedValues();
		Map<String, Long> map = list1.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println("Map : " + map);
		
		List<Model1> list3 = ObjectSupplierClass.getModel1ListRepeatedValues();
		Map<Model1, Long> map2 = list3.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println("Map Model1 : " + map2);
			
		// Process 1 with null, will give NPE
		List<String> list2 = ObjectSupplierClass.getStringListRepeatedValuesAndNull();
		map = list2.stream().collect(Collectors.groupingBy(s -> {
			if(s == null) // handling null
				s = "";
			return s;}, Collectors.counting()));
		System.out.println("Map : " + map);
		
		
		// Process 2 without null
		map = new HashMap<String, Long>();
		for(String s : list1) {
			if(!map.containsKey(s)) {
				map.put(s, Long.valueOf(Collections.frequency(list1, s)));
			}
		}
		System.out.println("Map : " + map);
		
		// Process 2 with null
		map = new HashMap<String, Long>();
		for(String s : list2) {
			if(!map.containsKey(s)) {
				map.put(s, Long.valueOf(Collections.frequency(list2, s)));
			}
		}
		System.out.println("Map : " + map);
	}
}
