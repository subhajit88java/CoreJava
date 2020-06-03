package com.subhajit.ArrayListLab;

import java.util.ArrayList;
import java.util.List;

public class ArrayListULab {

	public static void update1() {

		try {
			System.out.println("[1] - Updating element at specific index");

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

			String oldElement = stringList.set(3, "Edited Element");

			System.out.println("Size : " + stringList.size());
			System.out.println("oldElement : " + oldElement);
			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
	}
	
}
