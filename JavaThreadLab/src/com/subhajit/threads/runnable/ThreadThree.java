package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;
import com.subhajit.models.SynchronizeMonitorOne;

public class ThreadThree implements Runnable{
	
	private SharedBean sharedBean;
	
	public ThreadThree(SharedBean sharedBean) {
		this.sharedBean = sharedBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadThree Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		// Class level synchronization means : keeping the same class as MONITOR in multiple locations/classes, 
		// until and unless the block of a particular location is completed
		// no other blocks will get executed by other threads 
		synchronized(SynchronizeMonitorOne.class) {
			System.out.println("[synchronized] Received sharedBean in ThreadThree : " + sharedBean);
			try {
				for(int i = 1; i<=10; i ++) {
					System.out.println("ThreadThree => " + i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sharedBean.setMessage(sharedBean.getMessage() + " - " + "ThreadThree");
			System.out.println("Modifying value of sharedBean in ThreadThree : " + sharedBean);
		}
		System.out.println("ThreadThree Ends..................");	
	}

}
