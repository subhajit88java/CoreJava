package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;
import com.subhajit.models.WrapperBean;

public class ThreadFourThreadLocalImpl implements Runnable{
	
	private WrapperBean wrapperBean;
	
	public ThreadFourThreadLocalImpl(WrapperBean wrapperBean) {
		super();
		this.wrapperBean = wrapperBean;
	}


	@Override
	public void run() {
		System.out.println("ThreadFourThreadLocalImpl Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		System.out.println("SharedBean received in ThreadFourThreadLocalImpl : " + wrapperBean.getSharedBean());
		wrapperBean.setSharedBean(new SharedBean("ThreadFourThreadLocalImpl"));
		System.out.println("SharedBean value has been set in ThreadFourThreadLocalImpl");
		System.out.println("Getting SharedBean value in ThreadFourThreadLocalImpl : " + wrapperBean.getSharedBean());
		
		System.out.println("WrapperBean obj  in ThreadFourThreadLocalImpl : " + wrapperBean.toString());
		System.out.println("ThreadFourThreadLocalImpl ends.......");
		
	}

}
