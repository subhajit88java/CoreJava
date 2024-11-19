package com.subhajit.models;

public class UtilityClassTwo {
	
	public void objectLevelSynchMethod(String threadName, SynchronizeMonitorTwo synchronizeMonitorTwo) {
		synchronized (synchronizeMonitorTwo) {
			System.out.println("[synchronized] Received threadName in [UtilityClassTwo]objectLevelSynchMethodThree : " + threadName);
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.println("[" + System.identityHashCode(this) + "] " + threadName + " => " + i);
					Thread.sleep(2000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + " ends!");
		}
	}

}
