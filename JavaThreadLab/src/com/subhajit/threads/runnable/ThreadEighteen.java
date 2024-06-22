package com.subhajit.threads.runnable;

import com.subhajit.models.UtilityClassForLock;

public class ThreadEighteen implements Runnable{
	
	private UtilityClassForLock utilityClassForLock;
	
	public ThreadEighteen(UtilityClassForLock utilityClassForLock) {
		this.utilityClassForLock = utilityClassForLock;
	}

	@Override
	public void run() {
		System.out.println("ThreadEighteen Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		utilityClassForLock.methodOne("ThreadEighteen");
		System.out.println("ThreadEighteen Ends..................");	
	}

}
