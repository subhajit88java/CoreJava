package com.subhajit.threads;

import java.util.List;

public class ThreadTwo implements Runnable{
	
	private List<String> sharedList;
	
	public ThreadTwo(List<String> sharedList) {
		this.sharedList = sharedList;
	}

	@Override
	public void run() {
		System.out.println("ThreadTwo Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		while(true) {
		for(int i = 0; i< sharedList.size(); i++){
			System.out.println(sharedList.get(i));
		}
		}
		//System.out.println("ThreadTwo Ends..................");	
	}

}
