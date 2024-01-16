package com.subhajit.threads.runnable;

import com.subhajit.models.SynchronizeMonitorOne;

public class ThreadTwelve implements Runnable{
	
	private SynchronizeMonitorOne synchronizeMonitorOne;
	
	public ThreadTwelve(SynchronizeMonitorOne synchronizeMonitorOne) {
		this.synchronizeMonitorOne = synchronizeMonitorOne;
	}

	@Override
	public void run() {
		System.out.println("ThreadTwelve Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		synchronized(synchronizeMonitorOne) {
			System.out.println("[synchronized] block starts in ThreadTwelve!");
			try {
				for(int i = 1; i<=10; i ++) {
					System.out.println("ThreadTwelve => " + i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("[synchronized] block ends in ThreadTwelve!");
		}
		System.out.println("ThreadTwelve Ends!");
	}

}

