  package com.subhajit.CopyOnWriteArrayListLab;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListULab {
	
	public static void update1() {
		
		try {
			
			System.out.println("[1] - Updating element at specific index");

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
