package com.subhajit.threads;

public class ThreadOne implements Runnable{

	@Override
	public void run() {
		
		for(int i=0;i<50;i++) {
			System.out.println("From ThreadOne : " + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
