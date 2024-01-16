package com.subhajit.threads.runnable;

import com.subhajit.models.UtilityClassOne;

public class ThreadFifteen implements Runnable{
	
	private UtilityClassOne utilityClassOne;
	
	public ThreadFifteen(UtilityClassOne utilityClassOne) {
		this.utilityClassOne = utilityClassOne;
	}
	
	@Override
	public void run() {
		System.out.println("ThreadFifteen Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		utilityClassOne.methodLevelSynchMethod("ThreadFifteen");
	}

}
