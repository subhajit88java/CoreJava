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
		
		System.out.println("SharedBean received in ThreadTwoThreadLocalImpl : " + threadLocalObj.get());
		threadLocalObj.set(new SharedBean("ThreadTwoThreadLocalImpl"));
		System.out.println("SharedBean value has been set in ThreadTwoThreadLocalImpl");
		
		System.out.println("Getting SharedBean value in ThreadTwoThreadLocalImpl : " + threadLocalObj.get());
		
		System.out.println("threadLocalObj in ThreadTwoThreadLocalImpl : " + threadLocalObj.toString());
		System.out.println("ThreadTwoThreadLocalImpl ends.......");
		
	}

}
