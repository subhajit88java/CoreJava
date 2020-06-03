package com.subhajit.CopyOnWriteArrayListLab;

public class CopyOnWriteArrayListLabMain {

	public static void main(String[] args) {
		//testCreate();
		//testUpdate();
		//testDelete();
		testRead();
	}

	private static void testCreate() {

		// [1] - Checking order of elements, duplicate and null values
		CopyOnWriteArrayListCLab.create1();

		// [2] - Checking adding of elements in specific index 1(no element in index 0)
		CopyOnWriteArrayListCLab.create2();

		// [3] - Checking adding of elements in specific index 1 then in index 0
		CopyOnWriteArrayListCLab.create3();

		// [4] - Checking adding of elements in specific index 0 and then 2(skipping 1),
		// and then 1
		CopyOnWriteArrayListCLab.create4();

		// [5] - Adding all elements in specific index 0 and checking shifting of
		// previously added elements
		CopyOnWriteArrayListCLab.create5();

		// [6] - Adding element in a specific intermediate index and checking shifting
		// of previously added elements
		CopyOnWriteArrayListCLab.create6();

		// [7] - Adding 2 different lists in a single list
		CopyOnWriteArrayListCLab.create7();

		// [8] - Adding 1st List and then 2nd List in index 0 to check shifting of
		// previously added elements
		CopyOnWriteArrayListCLab.create8();

	}

	private static void testUpdate() {

		// [1] - Updating element at specific index
		CopyOnWriteArrayListULab.update1();

	}

	private static void testDelete() {

		// [1] - Removing element at specific index
		CopyOnWriteArrayListDLab.delete1();

		// [2] - Removing null and not-null elements
		CopyOnWriteArrayListDLab.delete2();

		// [3] - Removing elements (contained in a different list) from the main list
		CopyOnWriteArrayListDLab.delete3();
		
		// [4] - Removing elements based on certain condition
		CopyOnWriteArrayListDLab.delete4();

	}

	private static void testRead() {
		
		// [1] - Using ForEach loop, adding/updating/removing elements during iteration
		CopyOnWriteArrayListRLab.read1();

		// [2] - Using simple for loop, adding/updating/removing elements during iteration
		CopyOnWriteArrayListRLab.read2();

		// [3] - Using iterator, adding/updating/removing elements during iteration
		CopyOnWriteArrayListRLab.read3();

		// [4] - Using iterator's forEachRemaining, adding/updating/removing elements during iteration
		CopyOnWriteArrayListRLab.read4();

		// [5] - Using iforEach loop, adding/updating/removing elements
		CopyOnWriteArrayListRLab.read5();		

	}
}