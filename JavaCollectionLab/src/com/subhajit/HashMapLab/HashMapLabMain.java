package com.subhajit.HashMapLab;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.subhajit.HashMapLab.threads.KeyDeleterThread;
import com.subhajit.HashMapLab.threads.ReadThread;
import com.subhajit.HashMapLab.threads.SecondReadThread;
import com.subhajit.HashMapLab.threads.SecondWriteThread;
import com.subhajit.HashMapLab.threads.WriteThread;
import com.subhajit.models.HashModel;

public class HashMapLabMain {
	public static void main(String[] args) {
		// testCreate();
		// testUpdate();
		// testDelete();
		//testRead();
		//testReadWriteSingleThread();
		//testReadWriteMultiThread();
		//testReadReadMultiThread();
		//testWriteWriteMultiThread();
		nullKeyAndValue();
	}

	private static void nullKeyAndValue() {
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);
		
		System.out.println("Key 1 and value : " + testMap.containsKey(1) + " - " + testMap.get(1));
		System.out.println("Key 5 : " + testMap.containsKey(5));
		System.out.println("Key null : " + testMap.containsKey(null));
		
		Runnable keyDeleter = new KeyDeleterThread(testMap);

		Thread delete = new Thread(keyDeleter);
		
		if(testMap.containsKey(1)) { // main thread checking presence of key 1
			System.out.println("key 1 found");
			delete.start();
			try {
				Thread.sleep(5000);
			}catch(Exception e) {}
			System.out.println("testMap in main thread " + testMap);
			System.out.println("Value against key 1 : " + testMap.get(1)); // output null, ambiguity is we shall assume that value is null against key 1 as containsKey cond. passed. Reality is the key itself is removed by another thread
		}

		
	}

	private static void testCreate() {

		// In HashMap we can put null key and null values
		Map<Integer, String> testMap = new HashMap<>();
		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		
		// If we put a value against an existing key, then the old-value gets returned
		//String oldValue = testMap.put(2, "Z");
		//System.out.println("oldValue : " + oldValue);

		testMap.putIfAbsent(4, "ZZ");
		System.out.println("testMap before : " + testMap);
		
		// key not present - key will be injected with the value returned from function functional interface. If null is returned, key will not be injected
		// key present but contains null - same as key not present
		// key present but contains not-null  - function functional interface will not be executed and the existing value against that key will be returned
		/*String value = testMap.computeIfAbsent(2, key -> {
			System.out.println("key : " + key);
			return testMap.get(4);
		});*/
		
		// key not present - key will be injected with the value returned from function functional interface. If null is returned, key will not be injected
		// key present but contains null - function functional interface will not be executed and the existing value(null) against that key will be returned
		// key present but contains not-null  - Value of existing key will be replace with the value returned from function functional interface. If null is returned no replacement will take place				
		/*String value = testMap.computeIfPresent(2, (key,val) -> {
			System.out.println("key - value : " + key + " - " + val);
			return testMap.get(4);
		});*/
		
		// key not present - function functional interface will not be executed and null will be returned
		// key present but contains null - Value of existing key will be replace with the value returned from function functional interface. If null is returned no replacement will take place
		// key present but contains not-null  - Value of existing key will be replace with the value returned from function functional interface. If null is returned no replacement will take place								
		String value = testMap.compute(5, (key,val) -> {
			System.out.println("key - value : " + key + " - " + val);
			return testMap.get(4);
		});
		
		System.out.println("value : " + value);
		
		System.out.println("testMap after : " + testMap);

	}

	private static void testUpdate() {

		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);

		/*
		 * testMap.replace(1, "Edited Value"); System.out.println("Edited testMap : " +
		 * testMap);
		 */

		testMap.replace(2, "Xx", "Edited Value");

		testMap.replaceAll((key, value) -> {
			String replaceValue = value;
			if (value == null)
				replaceValue = "Null Replaced";
			return replaceValue;
		});
		System.out.println("Edited testMap : " + testMap);
	}

	private static void testDelete() {
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);

		// testMap.remove(null);
		testMap.remove(2, "Xx");
		System.out.println("Deleted testMap : " + testMap);

	}

	private static void testRead() {
		
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);
		
		Collection<String> mapValues = testMap.values();
		System.out.println("mapValues : " + mapValues);

		Set<Integer> keySet = testMap.keySet();
		System.out.println("keySet : " + keySet);
		
		for (Integer key : keySet) {
			System.out.println("Map data : " + testMap.get(key));
			//testMap.put(5, "New Value"); // Concurrent mod exception, new key addition
			//testMap.put(4, "Edited value"); // no exception, existing key overriding
			//testMap.replace(4, "Edited value"); // no exception
			//testMap.remove(4); // Concurrent mod exception
		}
		System.out.println("testMap : " + testMap);
		
		Set<Map.Entry<Integer, String>> keyValuePair = testMap.entrySet();
		System.out.println("keyValuePair : " + keyValuePair);

		for (Map.Entry<Integer, String> keyValue : testMap.entrySet()) {
			System.out.println("Map Data : " + keyValue.getKey() + " - " + keyValue.getValue());
		}

		testMap.forEach((key, value) -> {
			System.out.println("Map Data1 : " + key + " - " + value);
			//testMap.put(5, "New Value");
		});

		System.out.println("Default value : " + testMap.getOrDefault(10, "defaultValue"));
		
	}
	
	private static void testReadWriteSingleThread() {
		
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);
		
		Set<Integer> keySet = testMap.keySet();
		System.out.println("keySet : " + keySet);
		
		// this type of for uses HashIterator internally
		for (Integer key : keySet) {
			System.out.println("Map data : " + testMap.get(key));
			testMap.put(5, "New Value"); //  java.util.ConcurrentModificationException
			//testMap.put(4, "Edited value"); // Edit successful
			//testMap.replace(4, "Edited value");  // Edit successful
			//testMap.remove(4); //  java.util.ConcurrentModificationException
		}
		
		Set<Map.Entry<Integer, String>> keyValuePair = testMap.entrySet();
		System.out.println("keyValuePair : " + keyValuePair);

		// this type of for uses HashIterator internally
		for (Map.Entry<Integer, String> keyValue : testMap.entrySet()) {
			System.out.println("Map Data : " + keyValue.getKey() + " - " + keyValue.getValue());
			//testMap.put(5, "New Value"); //  java.util.ConcurrentModificationException
			//testMap.put(4, "Edited value"); // Edit successful
			//testMap.replace(4, "Edited value");  // Edit successful
			//testMap.remove(4); //  java.util.ConcurrentModificationException
		}
		
		testMap.forEach((key, value) -> {
			System.out.println("Map Data : " + key + " - " + value);
			//testMap.put(5, "New Value"); //  java.util.ConcurrentModificationException
			//testMap.put(4, "Edited value"); // Edit successful
			//testMap.replace(4, "Edited value");  // Edit successful
			//testMap.remove(4); //  java.util.ConcurrentModificationException
		});
		
	}
	
	private static void testReadWriteMultiThread() {
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap in Main thread : " + testMap);
		
		Runnable writeThread = null;// new WriteThread(testMap);
		Runnable readThread = new ReadThread(testMap);

		Thread write = new Thread(writeThread);
		Thread read = new Thread(readThread);

		read.start();
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		write.start();
		
		System.out.println("Main thread ends : " + testMap);
		
		// Outcome : May encounter Concurrent-modification exception if the hashmap iteration is in progress in read-thread(process 1) and the map is modified by write-thread
		// [process 1] Need to run this program by adjusting the thread-sleep time, sometimes concurrent exception might be encountered, sometimes not
		// For process 1 and 2, Concurrent-modification exception will be thrown for sure
				
	}
	
	private static void testReadReadMultiThread() {
		Map<Integer, String> testMap = new HashMap<>();

		testMap.put(null, null);
		testMap.put(1, null);
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap in Main thread : " + testMap);
		
		Runnable readThread = new ReadThread(testMap);
		Runnable secondReadThread = new SecondReadThread(testMap);

		Thread read1 = new Thread(readThread);
		Thread read2 = new Thread(secondReadThread);

		read1.start();
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		read2.start();
		
		System.out.println("Main thread ends : " + testMap);
	}
	
	private static void testWriteWriteMultiThread() {
		Map<Integer, String> testMap = new HashMap<>();

		System.out.println("testMap in Main thread : " + testMap);
		
		Runnable writeThread = new WriteThread(testMap);
		Runnable secondWriteThread = new SecondWriteThread(testMap);

		Thread write1 = new Thread(writeThread);
		Thread write2 = new Thread(secondWriteThread);

		write1.start();
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 */
		write2.start();
		
		try {
			write1.join();
			write2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Main thread ends : " + testMap);
		
		// process 1 will not throw any concurrent exception
		// process 2 will throw concurrent exception
	}

}
