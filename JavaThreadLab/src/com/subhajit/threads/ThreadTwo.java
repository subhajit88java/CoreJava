package com.subhajit.threads;

public class ThreadTwo implements Runnable{

	@Override
	public void run() {
		
		for(int i=0;i<50;i++) {
			System.out.println("From ThreadTwo : " + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}

