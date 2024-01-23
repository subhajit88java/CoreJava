package com.subhajit.main;

import com.subhajit.models.SharedBean;
import com.subhajit.models.WrapperBean;
import com.subhajit.threads.runnable.ThreadFourThreadLocalImpl;
import com.subhajit.threads.runnable.ThreadOneThreadLocalImpl;
import com.subhajit.threads.runnable.ThreadThreeThreadLocalImpl;
import com.subhajit.threads.runnable.ThreadTwoThreadLocalImpl;

public class ThreadLocalTestingLabMain {

	public static void main(String[] args) {

		//scenarioWithoutThreadLocal();
		scenarioWithThreadLocal();

	}

	private static void scenarioWithThreadLocal() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		ThreadLocal<SharedBean> threadLocalObj = new ThreadLocal<>();

		Runnable threadOne = new ThreadOneThreadLocalImpl(threadLocalObj);
		Runnable threadTwo = new ThreadTwoThreadLocalImpl(threadLocalObj);

		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);
		t1.start();
		try {
			Thread.sleep(5000);
		}catch(Exception e) {}
		t2.start();

		System.out.println("Main ends................");

	}

	private static void scenarioWithoutThreadLocal() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		WrapperBean wrapperBean = new WrapperBean();

		Runnable threadthree = new ThreadThreeThreadLocalImpl(wrapperBean);
		Runnable threadFour = new ThreadFourThreadLocalImpl(wrapperBean);

		Thread t1 = new Thread(threadthree);
		Thread t2 = new Thread(threadFour);
		t1.start();
		try {
			Thread.sleep(5000);
		}catch(Exception e) {}
		t2.start();

		System.out.println("Main ends................");

	}
}
