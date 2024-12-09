 package com.subhajit.HashMapLab.threads;

import java.util.Map;

import com.subhajit.models.HashModel;

public class WriteThread implements Runnable{
	
	private Map<Integer,String> testMap;
	
	public WriteThread(Map<Integer,String> testMap) {
		this.testMap = testMap;
	}

	// process 1 

	@Override
	public void run() {
		System.out.println("WriteThread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());
		for (int i = 1; i <= 15; i++) {
			System.out.println("From WriteThread : " + i);
			testMap.put(i, "WriteThread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("WriteThread Ends..................");
	}
	
	// process 2

	/*
	 * @Override public void run() {
	 * System.out.println("WriteThread Starts.................." + " Thread Id : " +
	 * Thread.currentThread().getId() + " Thread Name : " +
	 * Thread.currentThread().getName()); for (int i = 1; i <= 15; i++) {
	 * testMap.compute(i, (key, value) -> { try { Thread.sleep(1000); } catch
	 * (InterruptedException e) { e.printStackTrace(); } return value + " - " +
	 * "WriteThread"; });
	 * 
	 * } System.out.println("WriteThread Ends.................."); }
	 */

}
