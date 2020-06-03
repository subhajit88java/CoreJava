package com.subhajit.LinkedListLab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListLabMain {

	public static void main(String[] args) {
		// testCreate();
		// testUpdate();
		// testDelete();
		testRead();
		// testOtherMethods();
		// testStream();
		// testThread();
	}

	private static void testCreate() {

		List<String> stringList = new LinkedList<>();

		// [1] - Checking order of elements, duplicate and null values

		/*
		 * stringList.add("Z"); stringList.add("A"); stringList.add(null);
		 * stringList.add("Y"); stringList.add("A"); stringList.add("B");
		 * stringList.add("X"); stringList.add("A"); stringList.add(null);
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [2] - Checking adding of elements in specific index 1(no element in index 0)

		/*
		 * stringList.add(1, "Z"); System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [3] - Checking adding of elements in specific index 1 then in index 0

		/*
		 * stringList.add(1, "Z"); stringList.add(0, "A"); stringList.add(2, "Y");
		 * stringList.add(3, "B"); stringList.add(4, "X");
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [4] - Checking adding of elements in specific index 0 and then 2(skipping 1),
		// and then 1

		/*
		 * stringList.add(0, "Z"); stringList.add(2, "A"); stringList.add(1, "Y");
		 * stringList.add(3, "B"); stringList.add(4, "X");
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [5] - Adding all elements in specific index 0 and checking shifting of
		// previously added elements

		/*
		 * stringList.add(0, "Z"); stringList.add(0, "A"); stringList.add(0, "Y");
		 * stringList.add(0, "B"); stringList.add(0, "X");
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [6] - Adding element in a specific intermediate index and checking shifting
		// of previously added elements

		/*
		 * stringList.add(0, "Z"); stringList.add(1, "A"); stringList.add(2, "Y");
		 * stringList.add(3, "B"); stringList.add(4, "X");
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 * 
		 * stringList.add(3, "M");
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [7] - Adding 2 different lists in a single list

		List<String> subStringList1 = new LinkedList<>();
		subStringList1.add("subStringList1 Value1");
		subStringList1.add("subStringList1 Value2");
		subStringList1.add("Common Value");

		List<String> subStringList2 = new LinkedList<>();
		subStringList2.add("subStringList2 Value1");
		subStringList2.add("Common Value");

		/*
		 * stringList.addAll(subStringList1); stringList.addAll(subStringList2);
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [8] - Adding 1st List and then 2nd List in index 0 to check shifting of
		// previously added elements

		stringList.addAll(subStringList1);

		System.out.println("Size : " + stringList.size());
		System.out.println("stringList : " + stringList);

		stringList.addAll(0, subStringList2);

		System.out.println("Size : " + stringList.size());
		System.out.println("stringList : " + stringList);

	}

	private static void testUpdate() {

		// [1] - Updating element at specific index
		List<String> stringList = new LinkedList<>();

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

		String oldElement = stringList.set(3, "Edited Element");

		System.out.println("Size : " + stringList.size());
		System.out.println("oldElement : " + oldElement);
		System.out.println("stringList : " + stringList);

	}

	private static void testDelete() {

		List<String> stringList = new LinkedList<>();

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

		// [1] - Removing element at specific index
		/*
		 * stringList.remove(3);
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [2] - Removing null and not-null elements

		/*
		 * stringList.remove(null);
		 * 
		 * stringList.remove("A");
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [3] - Removing elements (contained in a different list) from the main list

		/*
		 * List<String> subStringList1 = new ArrayList<>(); subStringList1.add(null);
		 * subStringList1.add("A"); subStringList1.add("X"); subStringList1.add("A");
		 * 
		 * stringList.removeAll(subStringList1);
		 * 
		 * System.out.println("Size : " + stringList.size());
		 * System.out.println("stringList : " + stringList);
		 */

		// [4] - Removing elements based on certain condition

		stringList.removeIf(val -> {
			boolean flag = false;
			if (val != null)
				if (val.equals("A"))
					flag = true;
			return flag;

		});

		System.out.println("Size : " + stringList.size());
		System.out.println("stringList : " + stringList);
	}

	private static void testRead() {

		List<String> stringList = new LinkedList<>();

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

		// [1] - Using ForEach loop, adding/updating/removing elements during iteration

		/*
		 * for (String s : stringList) { System.out.println("Data : " + s);
		 * //stringList.add("Concurrent add"); //stringList.set(3, "Concurrent edit");
		 * stringList.remove(3); } System.out.println("stringList : " + stringList);
		 */

		// [2] - Using simple for loop, adding/updating/removing elements during
		// iteration

		/*
		 * for (int count = 0; count < stringList.size(); count++) {
		 * System.out.println("Data : " + stringList.get(count));
		 * //stringList.add("Concurrent add"); //stringList.add(9, "Concurrent add");
		 * //stringList.set(3, "Concurrent edit"); stringList.remove(3); }
		 * System.out.println("stringList : " + stringList);
		 */

		// [3] - Using iterator, adding/updating/removing elements during iteration
		/*
		 * Iterator<String> itr = stringList.iterator(); while (itr.hasNext()) {
		 * 
		 * String data = itr.next(); System.out.println("Data : " + data);
		 * 
		 * //itr.remove(); //stringList.add("Concurrent add"); //stringList.set(3,
		 * "Concurrent edit"); //stringList.remove(3);
		 * 
		 * } System.out.println("stringList : " + stringList);
		 */

		// [4] - Using iterator's forEachRemaining, adding/updating/removing elements
		// during iteration

		/*
		 * itr.forEachRemaining(val -> { System.out.println("Data : " + val);
		 * //stringList.add("Concurrent add"); //stringList.set(3, "Concurrent edit");
		 * //stringList.remove(3); itr.remove(); });
		 * 
		 * System.out.println("stringList : " + stringList);
		 */

		Iterator<String> litr = stringList.listIterator();
		while (litr.hasNext()) {
			System.out.println("Data : " + litr.next());
			stringList.add("Concurrent add");
			stringList.set(3, "Concurrent edit");
			stringList.remove(3);
			litr.remove();
		}
		System.out.println("stringList : " + stringList);

		stringList.forEach(val -> {
			System.out.println("Data : " + val);
			// stringList.add("Concurrent add");
			// stringList.set(3, "Concurrent edit");
			stringList.remove(3);
		});
		System.out.println("stringList : " + stringList);

	}
}
