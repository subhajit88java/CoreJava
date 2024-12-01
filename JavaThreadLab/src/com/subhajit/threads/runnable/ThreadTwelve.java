package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;
import com.subhajit.models.SynchronizeMonitorOne;

public class ThreadTwelve implements Runnable{
	
	private SynchronizeMonitorOne synchronizeMonitorOne;
	private SharedBean sharedBean;
	
	public ThreadTwelve(SynchronizeMonitorOne synchronizeMonitorOne, SharedBean sharedBean) {
		this.synchronizeMonitorOne = synchronizeMonitorOne;
		this.sharedBean = sharedBean;
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
			System.out.println("sharedBean in ThreadTwelve : " + sharedBean);
			sharedBean.setMessage("ThreadTwelve");
			System.out.println("[synchronized] block ends in ThreadTwelve!");
		}
		System.out.println("ThreadTwelve Ends!");
	}

}

