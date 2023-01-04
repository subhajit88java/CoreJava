package com.subhajit.threads.runnable;

public class ThreadTwo implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadTwo Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		for(int i=0;i<5;i++) {
			System.out.println("From ThreadTwo : " + i);
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadTwo Ends..................");
	}

}

