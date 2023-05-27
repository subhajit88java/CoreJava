package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;

public class ThreadOneThreadLocalImpl implements Runnable{
	
	private ThreadLocal<SharedBean> threadLocalObj;
	
	public ThreadOneThreadLocalImpl(ThreadLocal<SharedBean> threadLocalObj) {
		super();
		this.threadLocalObj = threadLocalObj;
	}


	@Override
	public void run() {
		System.out.println("ThreadOneThreadLocalImpl Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		System.out.println("Setting threadlocal 1 value");
		threadLocalObj.set(new SharedBean("ThreadOneThreadLocalImpl"));
		try {
			Thread.sleep(20000);
		}catch(Exception e) {}
		System.out.println("Getting threadlocal 1 value : " + threadLocalObj.get());
		
		System.out.println("Thread local 1 obj : " + threadLocalObj.toString());
		System.out.println("ThreadOneThreadLocalImpl ends.......");
		
	}

}
