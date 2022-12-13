package com.subhajit.threads;

import com.subhajit.models.SharedBean;

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
		synchronized(SharedBean.class) {
			System.out.println("[synchronized] Received sharedBean in ThreadFour : " + sharedBean);
			sharedBean.setMessage(sharedBean.getMessage() + " - " + "ThreadFour");
			System.out.println("Modifying value of sharedBean in ThreadFour : " + sharedBean);
		}
		System.out.println("ThreadFour Ends..................");
	}

}

