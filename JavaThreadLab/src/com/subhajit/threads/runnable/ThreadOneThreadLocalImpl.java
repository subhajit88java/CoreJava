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
		
		System.out.println("SharedBean received in ThreadOneThreadLocalImpl : " + threadLocalObj.get());
		threadLocalObj.set(new SharedBean("ThreadOneThreadLocalImpl"));
		System.out.println("SharedBean value has been set in ThreadOneThreadLocalImpl");
		try {
			Thread.sleep(20000);
		}catch(Exception e) {}
		System.out.println("Getting SharedBean value in ThreadOneThreadLocalImpl : " + threadLocalObj.get());
		
		System.out.println("threadLocalObj in ThreadOneThreadLocalImpl : " + threadLocalObj.toString());
		System.out.println("ThreadOneThreadLocalImpl ends.......");
		
	}

}
