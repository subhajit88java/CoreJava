package com.subhajit.main;

import com.subhajit.model.ThreadTestBean;
import com.subhajit.utility.IImplementRunnable;
import com.subhajit.utility.ThreadNotifier;
import com.subhajit.utility.ThreadWaiter;

public class TestMultiThread {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * IImplementRunnable iImplementRunnable1 = new IImplementRunnable("Thread-1");
		 * IImplementRunnable iImplementRunnable2 = new IImplementRunnable("Thread-2");
		 * IImplementRunnable iImplementRunnable3 = new IImplementRunnable("Thread-3");
		 * 
		 * Thread t1 = new Thread(iImplementRunnable1); Thread t2 = new
		 * Thread(iImplementRunnable2); Thread t3 = new Thread(iImplementRunnable3);
		 * 
		 * t1.start(); t2.start(); t2.join(); t3.start();
		 */

		
		ThreadTestBean threadTestBean = new ThreadTestBean("Main");
		System.out.println(threadTestBean.getMessage());

		ThreadWaiter threadWaiter = new ThreadWaiter("ThreadWaiter", threadTestBean);
		ThreadWaiter threadWaiter1 = new ThreadWaiter("ThreadWaiter1", threadTestBean);
		ThreadNotifier threadNotifier = new ThreadNotifier("ThreadNotifier", threadTestBean);

		Thread t1 = new Thread(threadWaiter);
		Thread t2 = new Thread(threadNotifier);
		Thread t3 = new Thread(threadWaiter1);

		t1.start();
		t3.start();
		t2.start();
		System.out.println("ThreadWaiter has been released at " + System.currentTimeMillis());
	}
}
