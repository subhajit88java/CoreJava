package com.subhajit.main;

import com.subhajit.threads.runnable.ThreadOne;
import com.subhajit.threads.runnable.ThreadTwo;

public class TestDaemonThreadMain {
	public static void main(String[] args) {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();

		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);
		
		t1.setDaemon(true);
		t2.setDaemon(true);

		t1.start();
		t2.start();
		
		// If main thread doesn't sleep then the daemon threads will be immediately terminated once the main threads terminates
		try {
			Thread.sleep(20000); // Daemon threads will get time to get themselves executed
		}catch(Exception e) {}

		System.out.println("Main Thread Ends..................");
	
	}
}
