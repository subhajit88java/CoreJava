package com.subhajit.threads.runnable;

import com.subhajit.models.SynchronizeMonitorTwo;
import com.subhajit.models.UtilityClassOne;

public class ThreadThirteen implements Runnable{
	
	private SynchronizeMonitorTwo synchronizeMonitorTwo;
	
	public ThreadThirteen(SynchronizeMonitorTwo synchronizeMonitorTwo) {
		this.synchronizeMonitorTwo = synchronizeMonitorTwo;
	}
	
	@Override
	public void run() {
		System.out.println("ThreadThirteen Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		new UtilityClassOne().objectLevelSynchMethodThree("ThreadThirteen", synchronizeMonitorTwo);
	}

}
