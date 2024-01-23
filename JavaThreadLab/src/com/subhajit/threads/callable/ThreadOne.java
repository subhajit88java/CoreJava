package com.subhajit.threads.callable;

import java.util.concurrent.Callable;

public class ThreadOne implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("ThreadOne Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		int sum = 0;
		for(int i=0;i<5;i++) {
			System.out.println("From ThreadOne : " + i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum = sum + i;
			// activate the below code to generate exception
			String s = null;
			s.length();
		}
		System.out.println("ThreadOne Ends with sum : " + sum);	
		return sum;
	}

	
}
