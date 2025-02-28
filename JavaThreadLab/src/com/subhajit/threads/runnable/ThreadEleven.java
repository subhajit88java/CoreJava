package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;
import com.subhajit.models.SynchronizeMonitorOne;

public class ThreadEleven implements Runnable{
	
	private SynchronizeMonitorOne synchronizeMonitorOne;
	private SharedBean sharedBean;
	
	public ThreadEleven(SynchronizeMonitorOne synchronizeMonitorOne, SharedBean sharedBean) {
		this.synchronizeMonitorOne = synchronizeMonitorOne;
		this.sharedBean = sharedBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadEleven Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		synchronized(synchronizeMonitorOne) {
			System.out.println("[synchronized] block starts in ThreadEleven!");
			try {
				for(int i = 1; i<=10; i ++) {
					System.out.println("ThreadEleven => " + i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("sharedBean in : ThreadEleven " + sharedBean);
			sharedBean.setMessage("ThreadEleven");
			System.out.println("[synchronized] block ends in ThreadEleven!");
		}
		System.out.println("ThreadEleven Ends!");
	}

}

