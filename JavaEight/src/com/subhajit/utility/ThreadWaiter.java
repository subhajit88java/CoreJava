package com.subhajit.utility;

import com.subhajit.model.ThreadTestBean;

public class ThreadWaiter implements Runnable{
	
	private ThreadTestBean threadTestBean;
	private String threadName;
	
	public ThreadWaiter(String threadName, ThreadTestBean threadTestBean) {
		this.threadName = threadName;
		this.threadTestBean = threadTestBean;
	}

	@Override
	public void run() {
		synchronized (threadTestBean) {
			try {
				System.out.println("Lock aquired by "+ threadName + " at " + System.currentTimeMillis());
				threadTestBean.wait();
				System.out.println("Freed "+ threadName + " at " + System.currentTimeMillis());
				System.out.println("Value : " + threadTestBean.getMessage());
				threadTestBean.setMessage(threadName);
				System.out.println("End of "+ threadName + " at " + System.currentTimeMillis());
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
