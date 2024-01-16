package com.subhajit.models;

public class UtilityClassOne {

	public void classLevelSynchMethod(String threadName) {
		// Class level synchronization means : keeping the same class as MONITOR only 1
		// thread can execute statements within the synchronized block at a time
		synchronized (SynchronizeMonitorOne.class) {
			System.out.println("[synchronized] Received threadName in classLevelSynchMethod : " + threadName);
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.println(threadName + " => " + i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " ends!");
		}
	}

	public void objectLevelSynchMethod(String threadName, SynchronizeMonitorTwo synchronizeMonitorTwo) {
		synchronized (synchronizeMonitorTwo) {
			System.out.println("[synchronized] Received threadName in objectLevelSynchMethod : " + threadName);
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.println(threadName + " => " + i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " ends!");
		}
	}

	public synchronized void methodLevelSynchMethod(String threadName) {
		System.out.println("[synchronized] Received threadName in methodLevelSynchMethod : " + threadName);
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println(threadName + " => " + i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(threadName + " ends!");
	}

}
