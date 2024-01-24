package com.subhajit.volatilevar.model;

public class Thread1 implements Runnable {

	private SharedModel1 sharedModel1;

	public Thread1(SharedModel1 sharedModel1) {
		this.sharedModel1 = sharedModel1;
	}

	@Override
	public void run() {
		System.out.println("Thread1 Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		int i = sharedModel1.i;
		System.out.println("sharedModel1 i received in Thread1 : " + i);
		while(i < 20) {
			sharedModel1.i  = ++i;
			System.out.println("sharedModel1 i incremented in Thread1 : " + sharedModel1.i);
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}
