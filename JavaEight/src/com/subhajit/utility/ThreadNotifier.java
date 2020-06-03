package com.subhajit.utility;

import com.subhajit.model.ThreadTestBean;

public class ThreadNotifier implements Runnable{
	
	private ThreadTestBean threadTestBean;
	private String threadName;
	
	public ThreadNotifier(String threadName, ThreadTestBean threadTestBean) {
		this.threadName = threadName;
		this.threadTestBean = threadTestBean;
	}

	@Override
	public void run() {
		
		try {	
		Thread.sleep(2000);
		synchronized (threadTestBean) {
						
				System.out.println("Lock aquired by "+ threadName + " at " + System.currentTimeMillis());
				threadTestBean.setMessage(threadName);
				threadTestBean.notifyAll();
				System.out.println("End of  "+ threadName + " at " + System.currentTimeMillis());
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
			
	
		
	}

}

