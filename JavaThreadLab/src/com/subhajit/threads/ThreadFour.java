package com.subhajit.threads;

import com.subhajit.models.ThreadTestBean;

public class ThreadFour implements Runnable{
	
	private ThreadTestBean threadTestBean;
	
	public ThreadFour(ThreadTestBean threadTestBean) {
		this.threadTestBean = threadTestBean;
	}

	@Override
	public void run() {
		synchronized(threadTestBean) {
			System.out.println("Received threadTestBean in ThreadFour : " + threadTestBean);
			threadTestBean.setMessage("ThreadFour");
			System.out.println("Modifying value of threadTestBean in ThreadFour : " + threadTestBean);
		}
	}

}

