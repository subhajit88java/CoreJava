package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;

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
		synchronized(SharedBean.class) {
			System.out.println("[synchronized] Received sharedBean in ThreadThree : " + sharedBean);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sharedBean.setMessage(sharedBean.getMessage() + " - " + "ThreadThree");
			System.out.println("Modifying value of sharedBean in ThreadThree : " + sharedBean);
		}
		System.out.println("ThreadThree Ends..................");	
	}

}
