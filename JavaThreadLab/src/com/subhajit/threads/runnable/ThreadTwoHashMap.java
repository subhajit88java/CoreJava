package com.subhajit.threads.runnable;

import java.util.Map;

public class ThreadTwoHashMap implements Runnable {

	Map<String, String> sharedMap;
	
	
	public ThreadTwoHashMap(Map<String, String> sharedMap) {
		super();
		this.sharedMap = sharedMap;
	}


	@Override
	public void run() {
		System.out.println("ThreadTwoHashMap Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		System.out.println("Map in ThreadTwoHashMap : " + sharedMap);
		sharedMap.remove("A");
		System.out.println("Map in ThreadTwoHashMap after deletion : " + sharedMap);
		
	}

}