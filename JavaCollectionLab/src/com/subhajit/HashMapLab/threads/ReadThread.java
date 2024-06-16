 package com.subhajit.HashMapLab.threads;

import java.util.Map;
import java.util.Set;

public class ReadThread implements Runnable{
	
	private Map<Integer,String> testMap;
	
	public ReadThread(Map<Integer,String> testMap) {
		this.testMap = testMap;
	}

	// read process 1
	/*
	 * @Override public void run() {
	 * System.out.println("ReadThread Starts.................." + " Thread Id : " +
	 * Thread.currentThread().getId() + " Thread Name : " +
	 * Thread.currentThread().getName()); for (int i = 1; i < 15; i++) {
	 * System.out.println("testMap in ReadThread : " + testMap); try {
	 * Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
	 * } System.out.println("ReadThread Ends.................."); }
	 */
	
	
	// read process 2
	/*
	 * @Override public void run() {
	 * System.out.println("ReadThread Starts.................." + " Thread Id : " +
	 * Thread.currentThread().getId() + " Thread Name : " +
	 * Thread.currentThread().getName());
	 * 
	 * // forEach method execution : When forEach starts executing, the existing //
	 * hashmap nodes are referenced by temporary variable and iterated // Upon //
	 * completion of the iteration if it is found that the hashmap structure has //
	 * been changed then concurrent-modification exception is thrown try {
	 * testMap.forEach((key, value) -> { System.out.println("Map Data : " + key +
	 * " - " + value); try { Thread.sleep(2000); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 * 
	 * }); } catch (Exception e) { System.out.println("ReadThread terminated!!"); }
	 * 
	 * System.out.println("ReadThread Ends.................."); }
	 */
	
	// read process 3

	@Override
	public void run() {
		System.out.println("ReadThread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Set<Map.Entry<Integer, String>> keyValuePair = testMap.entrySet();
		System.out.println("keyValuePair : " + keyValuePair);

		try {
			for (Map.Entry<Integer, String> keyValue : testMap.entrySet()) {
				System.out.println("Map Data : " + keyValue.getKey() + " - " + keyValue.getValue());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println("ReadThread terminated!!");
		}

		System.out.println("ReadThread Ends..................");
	}

}

// NB : if we simply print the map then also internally HashMap iterator is called which checks whether the HashMap structure is modified or not
