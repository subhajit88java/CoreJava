package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;

public class ThreadTwoThreadLocalImpl implements Runnable{
	
	private ThreadLocal<SharedBean> threadLocalObj;
	
	public ThreadTwoThreadLocalImpl(ThreadLocal<SharedBean> threadLocalObj) {
		super();
		this.threadLocalObj = threadLocalObj;
	}

	@Override
	public void run() {
		System.out.println("ThreadTwoThreadLocalImpl Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		System.out.println("Setting threadlocal 2 value");
		threadLocalObj.set(new SharedBean("ThreadTwoThreadLocalImpl"));
		System.out.println("Getting threadlocal 2 value : " + threadLocalObj.get());
		
		System.out.println("Thread local 2 obj : " + threadLocalObj.toString());
		System.out.println("ThreadTwoThreadLocalImpl ends.......");
		
	}

}
