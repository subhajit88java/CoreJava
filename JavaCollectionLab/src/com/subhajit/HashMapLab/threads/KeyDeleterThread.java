package com.subhajit.HashMapLab.threads;

import java.util.Map;

public class KeyDeleterThread implements Runnable{
	
	private Map<Integer,String> testMap;
	
	public KeyDeleterThread(Map<Integer,String> testMap) {
		this.testMap = testMap;
	}

	// process 1

	@Override
	public void run() {
		System.out.println("KeyDeleterThread Starts.................." + " Thread Id : "
				+ Thread.currentThread().getId() + " Thread Name : " + Thread.currentThread().getName());
		System.out.println("testMap in KeyDeleterThread : " + testMap);
		testMap.remove(1);
		System.out.println("key 1 removed");
		System.out.println("SecondWriteThread Ends..................");
	}
}
