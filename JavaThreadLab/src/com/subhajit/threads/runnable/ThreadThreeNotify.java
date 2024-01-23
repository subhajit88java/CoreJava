package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;

public class ThreadThreeNotify implements Runnable {

	private SharedBean sharedBean;

	public ThreadThreeNotify(SharedBean sharedBean) {
		super();
		this.sharedBean = sharedBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadThreeNotify Starts.................." + " Thread Id : "
				+ Thread.currentThread().getId() + " Thread Name : " + Thread.currentThread().getName());

		synchronized (sharedBean) {
			System.out.println("ThreadThreeNotify going to notify all .....");
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			}
			//sharedBean.notifyAll(); // will activate all waiting threads
			sharedBean.notify(); // will invoke only one waiting thread in adhoc manner
			System.out.println("ThreadThreeNotify notified all.....");

		}
		System.out.println("ThreadThreeNotify Ends..................");
	}

}
