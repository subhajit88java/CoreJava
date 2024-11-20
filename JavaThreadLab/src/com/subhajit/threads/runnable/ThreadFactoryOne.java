package com.subhajit.threads.runnable;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryOne implements ThreadFactory {
	
	private int count = 0;

	@Override
	public Thread newThread(Runnable r) {
		count++;
		return new Thread(r);
	}
	
	public int getCount() {
		return count;
	}

}
