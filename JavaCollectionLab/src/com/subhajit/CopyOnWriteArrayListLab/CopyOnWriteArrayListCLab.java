package com.subhajit.CopyOnWriteArrayListLab;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListCLab {

	public static void create1() {
		
		try {
			System.out.println("[1] - Checking order of elements, duplicate and null values");

			List<String> stringList = new CopyOnWriteArrayList<>();

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

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public static void create2() {

		try {
			System.out.println("[2] - Checking adding of elements in specific index 1(no element in index 0)");

			List<String> stringList = new CopyOnWriteArrayList<>();

			stringList.add(1, "Z");

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public static void create3() {

		try {
			System.out.println("[3] - Checking adding of elements in specific index 1 then in index 0");

			List<String> stringList = new CopyOnWriteArrayList<>();

			stringList.add(1, "Z");
			stringList.add(0, "A");
			stringList.add(2, "Y");
			stringList.add(3, "B");
			stringList.add(4, "X");

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public static void create4() {

		try {
			System.out.println("[4] - Checking adding of elements in specific index 0 and then 2(skipping 1) and then 1");

			List<String> stringList = new CopyOnWriteArrayList<>();

			stringList.add(0, "Z");
			stringList.add(2, "A");
			stringList.add(1, "Y");
			stringList.add(3, "B");
			stringList.add(4, "X");

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public static void create5() {

		try {
			System.out.println("[5] - Adding all elements in specific index 0 and checking shifting of previously added elements");

			List<String> stringList = new CopyOnWriteArrayList<>();

			stringList.add(0, "Z");
			stringList.add(0, "A");
			stringList.add(0, "Y");
			stringList.add(0, "B");
			stringList.add(0, "X");

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public static void create6() {

		try {
			System.out.println("[6] - Adding element in a specific intermediate index and checking shifting of previously added elements");

			List<String> stringList = new CopyOnWriteArrayList<>();

			stringList.add(0, "Z");
			stringList.add(1, "A");
			stringList.add(2, "Y");
			stringList.add(3, "B");
			stringList.add(4, "X");

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

			stringList.add(3, "M");

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public static void create7() {

		try {
			System.out.println("[7] - Adding 2 different lists in a single list");

			List<String> stringList = new CopyOnWriteArrayList<>();

			List<String> subStringList1 = new CopyOnWriteArrayList<>();
			subStringList1.add("subStringList1 Value1");
			subStringList1.add("subStringList1 Value2");
			subStringList1.add("Common Value");

			List<String> subStringList2 = new CopyOnWriteArrayList<>();
			subStringList2.add("subStringList2 Value1");
			subStringList2.add("Common Value");

			stringList.addAll(subStringList1);
			stringList.addAll(subStringList2);

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

	public static void create8() {

		try {
			System.out.println("[8] - Adding 1st List and then 2nd List in index 0 to check shifting of previously added elements");

			List<String> stringList = new CopyOnWriteArrayList<>();

			List<String> subStringList1 = new CopyOnWriteArrayList<>();
			subStringList1.add("subStringList1 Value1");
			subStringList1.add("subStringList1 Value2");
			subStringList1.add("Common Value");

			List<String> subStringList2 = new CopyOnWriteArrayList<>();
			subStringList2.add("subStringList2 Value1");
			subStringList2.add("Common Value");

			stringList.addAll(subStringList1);

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

			stringList.addAll(0, subStringList2);

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);

		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
		
	}

}
