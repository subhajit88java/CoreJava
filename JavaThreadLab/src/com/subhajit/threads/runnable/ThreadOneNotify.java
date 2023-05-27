package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;

public class ThreadOneNotify implements Runnable {

	private SharedBean sharedBean;

	public ThreadOneNotify(SharedBean sharedBean) {
		super();
		this.sharedBean = sharedBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadOneNotify Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		synchronized (sharedBean) {
			System.out.println("ThreadOneNotify going to wait.....");
			try {
				sharedBean.wait();
			} catch (InterruptedException e) {
			}
			System.out.println("ThreadOneNotify wait is over.....");
			// sharedBean.notify();

		}
		System.out.println("ThreadOneNotify Ends..................");
	}

}
