package com.subhajit.main;

import com.subhajit.models.SharedBean;
import com.subhajit.threads.runnable.ThreadOneThreadLocalImpl;
import com.subhajit.threads.runnable.ThreadTwoThreadLocalImpl;

public class ThreadLocalTestingLabMain {

	public static void main(String[] args) {
		
		ThreadLocal<SharedBean> threadLocalObj = new ThreadLocal<>();
		
		Runnable threadOne = new ThreadOneThreadLocalImpl(threadLocalObj);
		Runnable threadTwo = new ThreadTwoThreadLocalImpl(threadLocalObj);
		
		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);
		t1.start();
		t2.start(); 

		System.out.println("Main ends................");

	}
}
