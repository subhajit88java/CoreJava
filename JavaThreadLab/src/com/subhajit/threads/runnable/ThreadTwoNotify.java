package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;

public class ThreadTwoNotify implements Runnable {

	private SharedBean sharedBean;

	public ThreadTwoNotify(SharedBean sharedBean) {
		super();
		this.sharedBean = sharedBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadTwoNotify Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		synchronized (sharedBean) {
			System.out.println("ThreadTwoNotify going to wait.....");
			try {
				sharedBean.wait();
			} catch (InterruptedException e) {
			}
			System.out.println("ThreadTwoNotify wait is over.....");
			// sharedBean.notify();
		}
		System.out.println("ThreadTwoNotify Ends..................");
	}

}
