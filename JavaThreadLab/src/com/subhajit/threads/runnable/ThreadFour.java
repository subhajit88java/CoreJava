package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;
import com.subhajit.models.SynchronizeMonitorOne;
import com.subhajit.models.SynchronizeMonitorTwo;

public class ThreadFour implements Runnable{
	
	private SharedBean sharedBean;
	
	public ThreadFour(SharedBean sharedBean) {
		this.sharedBean = sharedBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadFour Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		// Class level synchronization means : keeping the same class as MONITOR in multiple locations/classes, 
		// until and unless the block of a particular location is completed
		// no other blocks will get executed by other threads
		synchronized(SynchronizeMonitorTwo.class) {
			System.out.println("[synchronized] Received sharedBean in ThreadFour : " + sharedBean);
			try {
				for(int i = 1; i<=10; i ++) {
					System.out.println("ThreadFour => " + i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sharedBean.setMessage(sharedBean.getMessage() + " - " + "ThreadFour");
			System.out.println("Modifying value of sharedBean in ThreadFour : " + sharedBean);
		}
		System.out.println("ThreadFour Ends..................");
	}

}

