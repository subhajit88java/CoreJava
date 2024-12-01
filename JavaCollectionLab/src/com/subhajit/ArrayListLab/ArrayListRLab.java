package com.subhajit.ArrayListLab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListRLab {

	public static void read1() {

		try {
			
			System.out.println("[1] - Using ForEach cum implicit iterator loop, adding/updating/removing elements during iteration");

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

			for (String s : stringList) {
				System.out.println("Data : " + s);
				// stringList.add("Concurrent add"); // Concurrent mod exception
				// stringList.set(3, "Concurrent edit"); // no exception
				//stringList.remove(3); // Concurrent mod exception
			}

			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
	}

	public static void read2() {

		try {
			
			System.out.println("[2] - Using simple for loop, adding/updating/removing elements during iteration");

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

			for (int count = 0; count < stringList.size(); count++) {
				System.out.println("Data : " + stringList.get(count));
				// stringList.add("Concurrent add"); // no exception
				// stringList.add(9, "Concurrent add"); // no exception
				// stringList.set(3, "Concurrent edit"); // no exception
				// stringList.remove(3); // no exception
			}

			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
	}

	public static void read3() {

		try {
			
			System.out.println("[3] - Using iterator, adding/updating/removing elements during iteration");

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

			Iterator<String> itr = stringList.iterator();

			while (itr.hasNext()) {

				String data = itr.next();
				System.out.println("Data : " + data);
				// itr.remove(); // no exception
				// stringList.add("Concurrent add"); // Concurrent mod exception
				// stringList.set(3, "Concurrent edit");  // no exception
				// stringList.remove(3); // Concurrent mod exception
			}

			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
	}

	public static void read4() {

		try {
			
			System.out.println("[4] - Using iterator's forEachRemaining, adding/updating/removing elements during iteration");

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

			Iterator<String> itr = stringList.iterator();

			itr.forEachRemaining(val -> {
				System.out.println("Data : " + val);
				// stringList.add("Concurrent add");
				// stringList.set(3, "Concurrent edit");
				// stringList.remove(3);
				// itr.remove();
			});

			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
	}

	public static void read5() {

		try {
			
			System.out.println("[5] - Using listIterator, adding/updating/removing elements during iteration");

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

			Iterator<String> litr = stringList.listIterator();

			while (litr.hasNext()) {
				System.out.println("Data : " + litr.next());
				 stringList.add("Concurrent add");
				// stringList.set(3, "Concurrent edit");
				// stringList.remove(3);
				// litr.remove();
			}

			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}

	}

	public static void read6() {

		try {
			
			System.out.println("[6] - Using ForEach loop, adding/updating/removing elements during iteration");

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

			stringList.forEach(val -> {
				System.out.println("Data : " + val);
				// stringList.add("Concurrent add");
				// stringList.set(3, "Concurrent edit");
				 stringList.remove(3);
			});

			System.out.println("stringList : " + stringList);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception :: " + e.getMessage());
		} finally {
			System.out.println("----------------------------------------------------------------");
		}
	}

}
