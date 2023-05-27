package com.subhajit.volatilevar.model;

public class Thread2 implements Runnable {

	private SharedModel1 sharedModel1;

	public Thread2(SharedModel1 sharedModel1) {
		this.sharedModel1 = sharedModel1;
	}

	@Override
	public void run() {
		System.out.println("Thread2 Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		int i = sharedModel1.i;
		while (i < 20) {
			if (i != sharedModel1.i) {
				System.out.println("sharedModel1 change detected in Thread2 : " + sharedModel1.i);
				i = sharedModel1.i;
			}
		}
	}
}
