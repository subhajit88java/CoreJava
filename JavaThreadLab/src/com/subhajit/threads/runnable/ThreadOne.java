package com.subhajit.threads.runnable;

public class ThreadOne implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadOne Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		for(int i=0;i<50;i++) {
			System.out.println("From ThreadOne : " + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadOne Ends..................");	
	}

}
