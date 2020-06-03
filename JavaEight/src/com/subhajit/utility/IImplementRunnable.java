package com.subhajit.utility;

public class IImplementRunnable implements Runnable {

	private String threadName;
	
	public IImplementRunnable(String threadName) {
		super();
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		
		try {
			for(int i =1; i<=100;i++) {
				System.out.println("From "+ threadName + " - " + i);
				Thread.sleep(500);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
