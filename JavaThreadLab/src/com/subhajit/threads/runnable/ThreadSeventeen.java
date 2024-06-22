package com.subhajit.threads.runnable;

import com.subhajit.models.UtilityClassForLock;

public class ThreadSeventeen implements Runnable{
	
	private UtilityClassForLock utilityClassForLock;
	
	public ThreadSeventeen(UtilityClassForLock utilityClassForLock) {
		this.utilityClassForLock = utilityClassForLock;
	}

	@Override
	public void run() {
		System.out.println("ThreadSeventeen Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		utilityClassForLock.methodOne("ThreadSeventeen");
		System.out.println("ThreadSeventeen Ends..................");	
	}

}
