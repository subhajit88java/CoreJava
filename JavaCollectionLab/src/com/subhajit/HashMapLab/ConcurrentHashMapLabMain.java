package com.subhajit.HashMapLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.subhajit.HashMapLab.threads.ReadThread;
import com.subhajit.HashMapLab.threads.SecondReadThread;
import com.subhajit.HashMapLab.threads.SecondWriteThread;
import com.subhajit.HashMapLab.threads.WriteThread;

// ConcurrentHashMap doesnot allow null key and value unlike HashMap
public class ConcurrentHashMapLabMain {
	
	public static void main(String[] args) {
		//testReadWriteSingleThread();
		//testReadWriteMultiThread();
		//testReadReadMultiThread();
		testWriteWriteMultiThread();
	} 
	
private static void testReadWriteSingleThread() {
		
		Map<Integer, String> testMap = new ConcurrentHashMap<>();

		testMap.put(1, "M");
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap : " + testMap);
		
		Set<Integer> keySet = testMap.keySet();
		System.out.println("keySet : " + keySet);
		
		// this type of for uses HashIterator internally
		//for (Integer key : keySet) {
			//System.out.println("Map data : " + testMap.get(key));
			//testMap.put(5, "New Value"); // NO java.util.ConcurrentModificationException
			//testMap.put(4, "Edited value"); // Edit successful
			//testMap.replace(4, "Edited value");  // Edit successful
			//testMap.remove(4); // NO java.util.ConcurrentModificationException
		//}
		
		Set<Map.Entry<Integer, String>> keyValuePair = testMap.entrySet();
		System.out.println("keyValuePair : " + keyValuePair);

		// this type of for uses HashIterator internally
		//for (Map.Entry<Integer, String> keyValue : testMap.entrySet()) {
			//System.out.println("Map Data : " + keyValue.getKey() + " - " + keyValue.getValue());
			//testMap.put(5, "New Value"); //  java.util.ConcurrentModificationException
			//testMap.put(4, "Edited value"); // Edit successful
			//testMap.replace(4, "Edited value");  // Edit successful
			//testMap.remove(4); //  java.util.ConcurrentModificationException
		//}
		
		testMap.forEach((key, value) -> {
			System.out.println("Map Data : " + key + " - " + value);
			//testMap.put(5, "New Value"); //  java.util.ConcurrentModificationException
			//testMap.put(4, "Edited value"); // Edit successful
			//testMap.replace(4, "Edited value");  // Edit successful
			//testMap.remove(4); //  java.util.ConcurrentModificationException
		});
		
	}
	
	private static void testReadWriteMultiThread() {
		Map<Integer, String> testMap = new ConcurrentHashMap<>();

		testMap.put(1, "M");
		testMap.put(2, "X");
		testMap.put(3, "A");
		testMap.put(4, "Z");

		System.out.println("testMap in Main thread : " + testMap);
		
		Runnable writeThread = new WriteThread(testMap);
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
		
		// Outcome : No concurrent-exception
				
	}
	
	private static void testReadReadMultiThread() {
		Map<Integer, String> testMap = new ConcurrentHashMap<>();

		testMap.put(1, "M");
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
		Map<Integer, String> testMap = new ConcurrentHashMap<>();

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
		
		System.out.println("Main thread ends : " + testMap);
		
		// no concurrent-exception
	}

}
