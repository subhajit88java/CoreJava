package com.subhajit.main;

import com.subhajit.threads.runnable.ThreadEight;
import com.subhajit.threads.runnable.ThreadInterruptOne;
import com.subhajit.threads.runnable.ThreadOne;
import com.subhajit.threads.runnable.ThreadTwo;

public class InterruptThreadMain {
	
	public static void main(String[] args) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadInterruptOne();

		Thread t1 = new Thread(threadOne);
		t1.start();
		try {
			System.out.println("Main Thread going to sleep");
			Thread.sleep(10000);
			System.out.println("Main Thread sleep over");
		}catch(Exception e) {}
		t1.interrupt();
		System.out.println("t1 interrupted");
		
		System.out.println("Main thread ends.....");
	}

}
