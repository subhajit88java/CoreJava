package com.subhajit.threads;

import java.util.List;

public class ThreadOne implements Runnable{
	
	private List<String> sharedList;
	
	public ThreadOne(List<String> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		System.out.println("ThreadOne Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		for(int i=0;i<9999999999999L;i++) {
			try {
				//Thread.sleep(2000);
			}catch(Exception e) {}
			sharedList.add("Thread1 : " + i);
			//System.out.println("ThraedOne");	
		}
		System.out.println("ThreadOne Ends..................");	
	}

}
