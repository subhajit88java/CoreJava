package com.subhajit.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.subhajit.models.MiniModel;

public class CollectionsLab {

	public static void main(String[] args) {
		//synchronizedList(); // need research in depth
		//singletonList();
		//unmodifiableList();
		arraysAsList();
		//frequency();
	}


	private static void frequency() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("B");
		list.add("C");

		int times = Collections.frequency(list, "A");
		System.out.println("Times : " + times);
		
	}

	private static void arraysAsList() {
		List<String> list = Arrays.asList("a","b","c","d");
		System.out.println("list : " + list);
		list.add("e");
		System.out.println("list : " + list);

	}

	private static void unmodifiableList() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		
		System.out.println("unmodifiableList : " + unmodifiableList);
		System.out.println("unmodifiableList address : " + System.identityHashCode(unmodifiableList));
		
		//unmodifiableList.add("F"); // Will throw UnsupportedOperationException
		//System.out.println("unmodifiableList : " + unmodifiableList);
		//System.out.println("unmodifiableList address : " + System.identityHashCode(unmodifiableList));
		
		MiniModel miniModel1 = new MiniModel(1,"Value 1");
		MiniModel miniModel2 = new MiniModel(2,"Value 2");
		List<MiniModel> testList2 = new ArrayList<MiniModel>();
		testList2.add(miniModel1);
		testList2.add(miniModel2);
		
		List<MiniModel> unmodifiableList2 = Collections.unmodifiableList(testList2);
		System.out.println("unmodifiableList2 : " + unmodifiableList2);
		System.out.println("unmodifiableList2 address : " + System.identityHashCode(unmodifiableList2));
		
		miniModel1.setName("Value 3");
		System.out.println("unmodifiableList2 : " + unmodifiableList2);
		
	}

	private static void singletonList() {
		
		List<String> testList1 = Collections.singletonList("A");
		testList1.add("B"); // Will throw UnsupportedOperationException
		System.out.println("testList1 : " + testList1);
		System.out.println("testList1 address : " + System.identityHashCode(testList1));
		
		MiniModel miniModel = new MiniModel(1,"Value 1");
		List<MiniModel> testList2 = Collections.singletonList(miniModel);
		System.out.println("testList2 : " + testList2);
		System.out.println("testList2 address : " + System.identityHashCode(testList2));
		
		miniModel.setName("Value 2");
		System.out.println("testList2 : " + testList2);
		System.out.println("testList2 address : " + System.identityHashCode(testList2));
		
	}

	private static void synchronizedList() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		Collections.synchronizedList(list);
		
		for(String s : list) {
			System.out.println("S before edit --> " + s);
			list.add("F");
		}
		
	}
}
