package com.subhajit.threads.runnable;

import com.subhajit.models.UtilityClassOne;

public class ThreadTen implements Runnable{
	
	@Override
	public void run() {
		System.out.println("ThreadTen Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		new UtilityClassOne().classLevelSynchMethod("ThreadTen");
	}

}
