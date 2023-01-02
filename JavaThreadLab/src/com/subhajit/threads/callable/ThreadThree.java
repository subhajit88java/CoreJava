package com.subhajit.threads.callable;

import java.util.concurrent.Callable;

public class ThreadThree implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("ThreadThree Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		int sum = 0;
		for(int i=0;i<16;i=i+3) {
			System.out.println("From ThreadThree : " + i);
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum = sum + i;
		}
		System.out.println("ThreadThree Ends with sum : " + sum);	
		return sum;
	}

}
