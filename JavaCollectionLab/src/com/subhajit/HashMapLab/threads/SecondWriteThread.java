 package com.subhajit.HashMapLab.threads;

import java.util.Map;

import com.subhajit.models.HashModel;

public class SecondWriteThread implements Runnable{
	
	private Map<Integer,String> testMap;
	
	public SecondWriteThread(Map<Integer,String> testMap) {
		this.testMap = testMap;
	}

	// process 1

	@Override
	public void run() {
		System.out.println("SecondWriteThread Starts.................." + " Thread Id : "
				+ Thread.currentThread().getId() + " Thread Name : " + Thread.currentThread().getName());
		for (int i = 16; i <= 30; i++) {
			System.out.println("From SecondWriteThread : " + i);
			testMap.put(i, "SecondWriteThread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("SecondWriteThread Ends..................");
	}
	
	// process 2
	/*
	 * @Override public void run() {
	 * System.out.println("SecondWriteThread Starts.................." +
	 * " Thread Id : " + Thread.currentThread().getId() + " Thread Name : " +
	 * Thread.currentThread().getName()); for (int i = 16; i <= 30; i++) { HashModel
	 * hm = new HashModel(String.valueOf(i));
	 * System.out.println("From SecondWriteThread : " + i); testMap.compute(hm,
	 * (key, value) -> { try { Thread.sleep(1000); } catch (InterruptedException e)
	 * { e.printStackTrace(); } return value + " - " + "SecondWriteThread"; });
	 * 
	 * } System.out.println("SecondWriteThread Ends.................."); }
	 */
}
