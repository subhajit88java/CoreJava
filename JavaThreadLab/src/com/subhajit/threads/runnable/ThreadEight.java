package com.subhajit.threads.runnable;

public class ThreadEight implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadEight Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		for(int i=0;i<5;i++) {
			System.out.println("From ThreadEight : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ThreadEight Ends..................");	
	}

}
