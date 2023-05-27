package com.subhajit.threads.runnable;

import java.util.Map;

public class ThreadOneHashMap implements Runnable {

	Map<String, String> sharedMap;
	
	
	public ThreadOneHashMap(Map<String, String> sharedMap) {
		super();
		this.sharedMap = sharedMap;
	}


	@Override
	public void run() {
		System.out.println("ThreadOneHashMap Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		System.out.println("Map in ThreadOneHashMap : " + sharedMap);
		if(sharedMap.containsKey("A")) {
			try{
				Thread.sleep(20000);
			}catch(Exception e) {}
			System.out.println("Key found in ThreadOneHashMap : " + sharedMap.get("A"));		
		}else
			System.out.println("Key not found in ThreadOneHashMap");
		
	}

}
