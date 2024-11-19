package com.subhajit.threads.runnable;

import com.subhajit.models.SynchronizeMonitorTwo;
import com.subhajit.models.UtilityClassOne;
import com.subhajit.models.UtilityClassTwo;

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
		
		new UtilityClassTwo().objectLevelSynchMethod("ThreadFourteen", synchronizeMonitorTwo);
	}

}
