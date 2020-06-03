package com.subhajit.threads;

import com.subhajit.models.ThreadTestBean;

public class ThreadThree implements Runnable{
	
	private ThreadTestBean threadTestBean;
	
	public ThreadThree(ThreadTestBean threadTestBean) {
		this.threadTestBean = threadTestBean;
	}

	@Override
	public void run() {
		synchronized(threadTestBean) {
			System.out.println("Received threadTestBean in ThreadThree : " + threadTestBean);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadTestBean.setMessage("ThreadThree");
			System.out.println("Modifying value of threadTestBean in ThreadThree : " + threadTestBean);
		}
	}

}
