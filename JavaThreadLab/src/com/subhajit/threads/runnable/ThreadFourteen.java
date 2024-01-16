package com.subhajit.threads.runnable;

import com.subhajit.models.SynchronizeMonitorTwo;
import com.subhajit.models.UtilityClassOne;

public class ThreadFourteen implements Runnable{
	
	private SynchronizeMonitorTwo synchronizeMonitorTwo;
	
	public ThreadFourteen(SynchronizeMonitorTwo synchronizeMonitorTwo) {
		this.synchronizeMonitorTwo = synchronizeMonitorTwo;
	}
	
	@Override
	public void run() {
		System.out.println("ThreadFourteen Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		new UtilityClassOne().objectLevelSynchMethod("ThreadFourteen", synchronizeMonitorTwo);
	}

}
