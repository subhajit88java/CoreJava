package com.subhajit.main;

import com.subhajit.models.SharedBean;
import com.subhajit.threads.runnable.ThreadEight;
import com.subhajit.threads.runnable.ThreadOne;
import com.subhajit.threads.runnable.ThreadOneNotify;
import com.subhajit.threads.runnable.ThreadThreeNotify;
import com.subhajit.threads.runnable.ThreadTwo;
import com.subhajit.threads.runnable.ThreadTwoNotify;

public class TestNotifyMain {

	public static void main(String[] args) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		SharedBean sharedBean = new SharedBean("Notify Test");

		Runnable threadOne = new ThreadOneNotify(sharedBean);
		Runnable threadTwo = new ThreadTwoNotify(sharedBean);
		Runnable threadThree = new ThreadThreeNotify(sharedBean);

		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);
		Thread t3 = new Thread(threadThree);

		t1.start();
		t2.start();

		System.out.println("Main thread going to sleep");
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
		}
		System.out.println("Main thread sleep over");

		t3.start();

		System.out.println("Main thread ends.....");
	}
}
