package com.subhajit.threads;

public class ThreadTwo implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadTwo Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		for(int i=0;i<50;i++) {
			System.out.println("From ThreadTwo : " + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadTwo Ends..................");
	}

}

