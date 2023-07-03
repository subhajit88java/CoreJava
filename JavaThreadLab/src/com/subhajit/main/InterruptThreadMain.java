package com.subhajit.main;

import com.subhajit.threads.runnable.ThreadInterruptOne;

public class InterruptThreadMain {
	
	public static void main(String[] args) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadInterruptOne();

		Thread t1 = new Thread(threadOne);
		t1.start();
		try {
			System.out.println("Main Thread going to sleep");
			Thread.sleep(2000);
			System.out.println("Main Thread sleep over");
		}catch(Exception e) {}
		t1.interrupt(); // This method sets flag of the thread to true, which could be used later by the Thread code or the main thread code 
		System.out.println("t1 interrupted");
		
		System.out.println("Main thread ends.....");
	}

}
