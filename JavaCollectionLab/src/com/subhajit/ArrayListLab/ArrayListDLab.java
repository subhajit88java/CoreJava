package com.subhajit.ArrayListLab;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDLab {

	public static void delete1() {

		try {
			System.out.println("[1] - Removing element at specific index");

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

			stringList.remove(3);

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
	}

	public static void delete2() {

		try {
			System.out.println("[2] - Removing null and not-null elements");

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

			stringList.remove(null);

			stringList.remove("A");

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}

	}

	public static void delete3() {

		try {
			System.out.println("[3] - Removing elements (contained in a different list) from the main list");

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

			List<String> subStringList1 = new ArrayList<>();
			subStringList1.add(null);
			subStringList1.add("A");
			subStringList1.add("X");
			subStringList1.add("A");

			stringList.removeAll(subStringList1);

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}

	}

	public static void delete4() {

		try {
			System.out.println("[4] - Removing elements based on certain condition");

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

			stringList.removeIf(val -> {
				boolean flag = false;
				if (val != null)
					if (val.equals("A"))
						flag = true;
				return flag;

			});

			System.out.println("Size : " + stringList.size());
			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}

	}

}
