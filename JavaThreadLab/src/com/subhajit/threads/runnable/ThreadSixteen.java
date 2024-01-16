package com.subhajit.threads.runnable;

import com.subhajit.models.UtilityClassOne;

public class ThreadSixteen implements Runnable{
	
	private UtilityClassOne utilityClassOne;
	
	public ThreadSixteen(UtilityClassOne utilityClassOne) {
		this.utilityClassOne = utilityClassOne;
	}
	
	@Override
	public void run() {
		System.out.println("ThreadSixteen Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		utilityClassOne.methodLevelSynchMethod("ThreadSixteen");
	}

}
