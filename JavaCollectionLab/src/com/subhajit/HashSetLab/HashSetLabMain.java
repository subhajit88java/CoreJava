package com.subhajit.HashSetLab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashSetLabMain {
	public static void main(String[] args) {
		// testCreate();
		// testUpdate();
		 testDelete();
		//testRead();
	}

	private static void testCreate() {
		Set<String> stringSet = new HashSet<>();

		/*
		 * stringSet.add("Z"); stringSet.add("A"); stringSet.add("B");
		 * stringSet.add(null); stringSet.add("Y"); stringSet.add(null);
		 * stringSet.add("C"); stringSet.add("Y");
		 */
		/*
		 * System.out.println("stringSet size : " + stringSet.size());
		 * System.out.println("stringSet : " + stringSet);
		 */

		List<String> stringList = new ArrayList<>();
		stringList.add("Z");
		stringList.add("A");
		stringList.add("B");
		stringList.add(null);
		stringList.add("Y");
		stringList.add(null);
		stringList.add("C");
		stringList.add("Y");
		stringSet.addAll(stringList);
		System.out.println("stringSet : " + stringSet);

	}

	private static void testUpdate() {
		// No method provided

	}

	private static void testDelete() {
		Set<String> stringSet = new HashSet<>();

		stringSet.add("Z");
		stringSet.add("A");
		stringSet.add("B");
		stringSet.add(null);
		stringSet.add("Y");
		stringSet.add(null);
		stringSet.add("C");
		stringSet.add("Y");

		System.out.println("stringSet : " + stringSet);

		// stringSet.remove(null);

		List<String> stringList = new ArrayList<>();
		stringList.add("Z");
		stringList.add("A");
		stringList.add("B");
		
		//stringSet.removeAll(stringList);

		/*
		 * stringSet.removeIf(value -> { return value == null; });
		 * System.out.println("stringSet : " + stringSet);
		 */
		stringSet.retainAll(stringList);
		System.out.println("stringSet : " + stringSet);

	}

	private static void testRead() {

		Set<String> stringSet = new HashSet<>();

		stringSet.add("Z");
		stringSet.add("A");
		stringSet.add("B");
		stringSet.add(null);
		stringSet.add("Y");
		stringSet.add(null);
		stringSet.add("C");
		stringSet.add("Y");

		System.out.println("stringSet : " + stringSet);

		/*
		 * stringSet.forEach(value -> { System.out.println("Set Data : " + value);
		 * //stringSet.add("New Value"); //stringSet.remove(null); });
		 */

		Iterator<String> itr = stringSet.iterator();
		/*
		 * while(itr.hasNext()) { System.out.println("Set Data : " + itr.next());
		 * //itr.remove(); //stringSet.add("New Value"); //stringSet.remove(null); }
		 * System.out.println("stringSet : " + stringSet);
		 */

		itr.forEachRemaining(value -> {
			System.out.println("Set Value : " + value);
			// itr.remove();
			// stringSet.add("New Value");
			// stringSet.remove(null);
		});
		System.out.println("stringSet : " + stringSet);

	}
}
