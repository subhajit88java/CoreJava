package com.subhajit.ArrayListLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Comparator;

public class ArrayListLabMain {

	public static void main(String[] args) {
		//testCreate();
		//testUpdate();
		//testDelete();
		testRead();
		// testOtherMethods();
		// testStream();
		// testThread();
	}

	private static void testCreate() {

		// [1] - Checking order of elements, duplicate and null values
		ArrayListCLab.create1();

		// [2] - Checking adding of elements in specific index 1(no element in index 0)
		ArrayListCLab.create2();

		// [3] - Checking adding of elements in specific index 1 then in index 0
		ArrayListCLab.create3();

		// [4] - Checking adding of elements in specific index 0 and then 2(skipping 1) and then 1
		ArrayListCLab.create4();

		// [5] - Adding all elements in specific index 0 and checking shifting of previously added elements
		ArrayListCLab.create5();

		// [6] - Adding element in a specific intermediate index and checking shifting of previously added elements
		ArrayListCLab.create6();

		// [7] - Adding 2 different lists in a single list
		ArrayListCLab.create7();

		// [8] - Adding 1st List and then 2nd List in index 0 to check shifting of previously added elements
		ArrayListCLab.create8();

	}

	private static void testUpdate() {

		// [1] - Updating element at specific index
		ArrayListULab.update1();

	}

	private static void testDelete() {

		// [1] - Removing element at specific index
		ArrayListDLab.delete1();

		// [2] - Removing null and not-null elements
		ArrayListDLab.delete2();

		// [3] - Removing elements (contained in a different list) from the main list
		ArrayListDLab.delete3();

		// [4] - Removing elements based on certain condition
		ArrayListDLab.delete4();

	}

	private static void testRead() {

		// [1] - Using ForEach cum implicit iterator loop, adding/updating/removing elements during iteration
		ArrayListRLab.read1();

		// [2] - Using simple for loop, adding/updating/removing elements during iteration
		ArrayListRLab.read2();

		// [3] - Using iterator, adding/updating/removing elements during iteration
		ArrayListRLab.read3();

		// [4] - Using iterator's forEachRemaining, adding/updating/removing elements during iteration
		ArrayListRLab.read4();

		// [5] - Using listIterator, adding/updating/removing elements during iteration
		ArrayListRLab.read5();

		// [6] - Using ForEach loop, adding/updating/removing elements during iteration
		ArrayListRLab.read6();

	}

	private static void testOtherMethods() {
		List<String> stringList = new ArrayList<>();

		stringList.add("Z");
		stringList.add("A");
		stringList.add(null);
		stringList.add("Y");
		stringList.add("A");
		stringList.add("B");
		stringList.add("X");
		stringList.add("A");
		stringList.add(null);

		System.out.println("Size : " + stringList.size());
		System.out.println("stringList : " + stringList);
		System.out.println("stringList.IsEmpty() : " + stringList.isEmpty());

		stringList.clear();

		System.out.println("Size : " + stringList.size());
		System.out.println("stringList : " + stringList);

		// System.out.println("stringList.contains() : " + stringList.contains("M"));

		/*
		 * List<String> subStringList = new ArrayList<>(); subStringList.add(null);
		 * subStringList.add("M"); System.out.println("stringList.containsAll() : " +
		 * stringList.containsAll(subStringList));
		 */
		/*
		 * List<String> subStringList = new LinkedList<>(); subStringList.add("Z");
		 * subStringList.add("A"); subStringList.add(null); subStringList.add("Y");
		 * subStringList.add("A"); subStringList.add("B"); subStringList.add("A");
		 * subStringList.add("X"); subStringList.add(null);
		 * 
		 * System.out.println("stringList.equals() : " +
		 * stringList.equals(subStringList));
		 */

		/*
		 * List<String> subStringList = new ArrayList<>(); subStringList.add(null);
		 * subStringList.add("A"); stringList.retainAll(subStringList);
		 * System.out.println("stringList " + stringList);
		 */

		/*
		 * stringList.sort((val1, val2) -> { return (val2 ==
		 * null?"":val2).compareTo(val1 == null?"":val1); });
		 * System.out.println("Desc Sorted stringList " + stringList);
		 */

		List<String> newList = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			newList.add(String.valueOf(i));
		System.out.println("Size : " + newList.size());
		System.out.println("1 : " + newList);

		Spliterator<String> sitr = newList.spliterator();
		int current = 0;
		while (sitr.tryAdvance(a -> {
			a = a + "_Ok";
		})) {
			current++;
		}
		System.out.println("3 : " + newList);

	}

	private static void testStream() {

		List<String> stringList = new ArrayList<>();

		stringList.add("Z");
		stringList.add("A");
		stringList.add(null);
		stringList.add("Y");
		stringList.add("A");
		stringList.add("B");
		stringList.add("X");
		stringList.add("A");
		stringList.add(null);

		System.out.println("Size : " + stringList.size());
		System.out.println("stringList : " + stringList);

		boolean flag = stringList.stream().allMatch(val -> {
			return val != null;
		});

		System.out.println("allMatch : " + flag);

		flag = stringList.stream().anyMatch(val -> {
			return val == null;
		});

		System.out.println("anyMatch : " + flag);

		System.out.println("Count : " + stringList.stream().count());

		List<String> collectedList = stringList.stream().distinct().collect(Collectors.toList());
		System.out.println("collectedList : " + collectedList);

		List<String> filteredList = stringList.stream().filter(val -> {
			return val != null;
		}).collect(Collectors.toList());
		System.out.println("filteredList : " + filteredList);

		System.out.println("findAny : " + stringList.stream().findAny().get());

		stringList.stream().forEach(val -> {
			System.out.println("forEach data : " + val);
		});

		stringList.stream().forEachOrdered(val -> { // Disput
			System.out.println("forEachOrdered data : " + val);
		});

		List<String> sortedList = stringList.stream().sorted(Comparator.nullsLast((val1, val2) -> {
			return val1.compareTo(val2);
		})).collect(Collectors.toList());
		System.out.println("sortedList : " + sortedList);

		List<String> limitedList = stringList.stream().limit(5).collect(Collectors.toList());
		System.out.println("limitedList : " + limitedList);

		System.out.println("Max : " + stringList.stream().max((val1, val2) -> {

			return (val1 == null ? "" : val1).compareTo(val2 == null ? "" : val2);

		}).get());

		List<String> upperCaseList = stringList.stream().map(val -> {
			return (val == null ? "" : val).toUpperCase();
		}).collect(Collectors.toList());

		System.out.println("upperCaseList : " + upperCaseList);

		stringList.stream().mapToInt((val) -> {
			return (val == null ? "" : val).length();
		}).forEach(System.out::println);

	}

	private static void testThread() {
		List<String> stringList = new CopyOnWriteArrayList<>();

		for (int i = 1; i < 10; i++)
			stringList.add(String.valueOf(i));

		System.out.println("Size : " + stringList.size());
		System.out.println("stringList : " + stringList);

		ThreadClassOne threadClassOne = new ThreadClassOne(stringList);
		ThreadClassTwo threadClassTwo = new ThreadClassTwo(stringList);

		Thread one = new Thread(threadClassOne);
		Thread two = new Thread(threadClassTwo);

		one.start();
		two.start();

		System.out.println("End of main thread");

	}

}
