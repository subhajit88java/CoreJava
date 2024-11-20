package com.subhajit.threads.callable;

import java.util.concurrent.Callable;

public class ThreadTwo implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("ThreadTwo Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		int sum = 200;
		for(int i=0;i<10;i++) {
			System.out.println("From ThreadTwo : " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum = sum + i;
		}
		System.out.println("ThreadTwo Ends with sum : " + sum);	
		return sum;
	}

	

}

