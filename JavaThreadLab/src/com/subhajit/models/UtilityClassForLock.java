package com.subhajit.models;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UtilityClassForLock {
	
	private final Lock methodOneLock = new ReentrantLock();

	public void methodOne(String threadName) {	
		System.out.println("[locked] Received threadName in UtilityClassForLock-methodOne : " + threadName);
		methodOneLock.lock();
		System.out.println("[locked] lock aquired on UtilityClassForLock-methodOne by : " + threadName);
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println(threadName + " => " + i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			methodOneLock.unlock();
			System.out.println("[locked] lock released on UtilityClassForLock-methodOne by : " + threadName);
		}
		System.out.println(threadName + " ends!");
	}

}
