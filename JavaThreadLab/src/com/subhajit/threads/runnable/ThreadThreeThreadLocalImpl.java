package com.subhajit.threads.runnable;

import com.subhajit.models.SharedBean;
import com.subhajit.models.WrapperBean;

public class ThreadThreeThreadLocalImpl implements Runnable{
	
	private WrapperBean wrapperBean;
	
	public ThreadThreeThreadLocalImpl(WrapperBean wrapperBean) {
		super();
		this.wrapperBean = wrapperBean;
	}


	@Override
	public void run() {
		System.out.println("ThreadThreeThreadLocalImpl Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		
		System.out.println("SharedBean received in ThreadThreeThreadLocalImpl : " + wrapperBean.getSharedBean());
		wrapperBean.setSharedBean(new SharedBean("ThreadThreeThreadLocalImpl"));
		System.out.println("SharedBean value has been set in ThreadThreeThreadLocalImpl");
		try {
			Thread.sleep(20000);
		}catch(Exception e) {}
		System.out.println("Getting SharedBean value in ThreadThreeThreadLocalImpl : " + wrapperBean.getSharedBean());
		
		System.out.println("WrapperBean obj  in ThreadThreeThreadLocalImpl : " + wrapperBean.toString());
		System.out.println("ThreadThreeThreadLocalImpl ends.......");
		
	}

}
