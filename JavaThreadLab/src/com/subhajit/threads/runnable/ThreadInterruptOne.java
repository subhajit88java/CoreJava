package com.subhajit.threads.runnable;

public class ThreadInterruptOne implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadInterruptOne Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());
		try {
			System.out.println("ThreadInterruptOne going to sleep");
			Thread.sleep(20000);
			System.out.println("ThreadInterruptOne sleep over");
		}catch(Exception e) {
			System.out.println("Interrupt exception ThreadInterruptOne...");
		}
		System.out.println("ThreadInterruptOne ends.....");
	}

}
