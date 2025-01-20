package com.subhajit.main;

import com.subhajit.threads.runnable.ThreadOne;
import com.subhajit.threads.runnable.ThreadTwo;

public class TestJoinMain {
	
	public static void main(String[] args) {
		//withoutJoining();
		withJoining();
	}

	private static void withJoining() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();

		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException ie) {ie.printStackTrace();}

		System.out.println("Main Thread Ends..................");
	}

	private static void withoutJoining() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();

		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);

		t1.start();
		t2.start();

		System.out.println("Main Thread Ends..................");
	}

}
