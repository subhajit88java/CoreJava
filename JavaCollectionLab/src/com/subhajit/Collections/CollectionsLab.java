package com.subhajit.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.subhajit.models.MiniModel;
import com.subhajit.threads.ThreadOne;
import com.subhajit.threads.ThreadTwo;

public class CollectionsLab {

	public static void main(String[] args) {
		synchronizedList(); // return SynchronizedList where all add/update/delete methods are synchronized using a monitor object, thus thread-safe
		//singletonList(); // returns an immutable list with a single element where insert/edit/delete are prohibited
		//unmodifiableList(); // returns an immutable list with multiple elements where insert/edit/delete are prohibited
		//arraysAsList(); // returns an immutable list with multiple elements where insert/delete are prohibited, edit is allowed
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
		List<String> arrayAsList = Arrays.asList("a","b","c","d");
		//list.add("e"); // Will throw UnsupportedOperationException
		//list.remove(0); // Will throw UnsupportedOperationException
		//list.set(0, "edit"); // Will work without exception
		System.out.println("list element : " + arrayAsList.get(0));
		System.out.println("list : " + arrayAsList);
		System.out.println("list address : " + System.identityHashCode(arrayAsList));
		arrayAsList.forEach(elem -> {
			System.out.println("element : " + elem);
		});
		for(String elem : arrayAsList) {
			System.out.println("element : " + elem);
		}
		
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		System.out.println("list address : " + System.identityHashCode(list));
		
		List<List<String>> arrayAsList2 = Arrays.asList(list);
		list.add("Add");
		System.out.println("arrayAsList2 : " + arrayAsList2);
	}

	private static void unmodifiableList() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		System.out.println("list address : " + System.identityHashCode(list));
		List<String> unmodifiableList = Collections.unmodifiableList(list);
		
		System.out.println("unmodifiableList before : " + unmodifiableList);
		System.out.println("unmodifiableList address : " + System.identityHashCode(unmodifiableList));
		System.out.println("unmodifiableList element : " + unmodifiableList.get(1));
		
		//unmodifiableList.add("Add"); // Will throw UnsupportedOperationException
		//unmodifiableList.remove(0); // Will throw UnsupportedOperationException
		//unmodifiableList.set(0, "Edit"); // Will throw UnsupportedOperationException
		
		// Though list and unmodifiableList have different references and they are different objects, still if we add/remove/edit an element on list, unmodifiableList will get effected
		//list.add("Add"); // 
		//list.remove(0); 
		//list.set(0, "Edit"); 
			
		System.out.println("unmodifiableList after : " + unmodifiableList);
		
		/*
		 * MiniModel miniModel1 = new MiniModel(1,"Value 1"); MiniModel miniModel2 = new
		 * MiniModel(2,"Value 2"); List<MiniModel> testList2 = new
		 * ArrayList<MiniModel>(); testList2.add(miniModel1); testList2.add(miniModel2);
		 * 
		 * List<MiniModel> unmodifiableList2 = Collections.unmodifiableList(testList2);
		 * System.out.println("unmodifiableList2 : " + unmodifiableList2);
		 * System.out.println("unmodifiableList2 address : " +
		 * System.identityHashCode(unmodifiableList2));
		 * 
		 * miniModel1.setName("Value 3"); System.out.println("unmodifiableList2 : " +
		 * unmodifiableList2);
		 */
		
	}

	private static void singletonList() {
		
		List<String> testList1 = Collections.singletonList("A");
		//testList1.add("B"); // Will throw UnsupportedOperationException
		//testList1.remove(0); // Will throw UnsupportedOperationException
		//testList1.set(0, "B"); // Will throw UnsupportedOperationException
		System.out.println("testList1 : " + testList1);
		System.out.println("testList1 element : " + testList1.get(0));
		System.out.println("testList1 address : " + System.identityHashCode(testList1));

		/*
		 * MiniModel miniModel = new MiniModel(1, "Value 1"); List<MiniModel> testList2
		 * = Collections.singletonList(miniModel); System.out.println("testList2 : " +
		 * testList2); System.out.println("testList2 address : " +
		 * System.identityHashCode(testList2));
		 * 
		 * miniModel.setName("Value 2"); System.out.println("testList2 : " + testList2);
		 * System.out.println("testList2 address : " +
		 * System.identityHashCode(testList2));
		 */
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		
		List<List<String>> testList3 = Collections.singletonList(list);
		list.add("Add");
		System.out.println("testList3 : " + testList3); // The added value will be reflected

	}

	private static void synchronizedList() {
		
		List<String> list = new ArrayList<>();
		//list.add("A");
		//list.add("B");
		//list.add("C");
		//list.add("D");
		//list.add("E");
		List<String> list1 = Collections.synchronizedList(list);
		Runnable r1 = new ThreadOne(list1);
		Runnable r2 = new ThreadTwo(list1);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		/*
		 * for(String s : list) { System.out.println("S before edit --> " + s);
		 * list.add("F"); }
		 */
		
	}
}
