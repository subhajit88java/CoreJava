package com.subhajit.threads.runnable;

import java.util.List;

public class SharedVolatilePrimitiveThreadTwo implements Runnable {

	private int value;
	private StringBuilder stringValueMain;
	private volatile List<Integer> intList;

	public SharedVolatilePrimitiveThreadTwo(int value, StringBuilder stringValueMain, List<Integer> intList) {
		System.out.println("ThreadTwo constructor -- " + "Supplied int address -> " + System.identityHashCode(value) + ", Local int address -> "
				+ System.identityHashCode(this.value) + ", Supplied StringBuilder address -> " + System.identityHashCode(stringValueMain) + ", Local StringBuilder address -> "
						+ System.identityHashCode(this.stringValueMain) + ", Supplied List address -> " + System.identityHashCode(intList) + ", Local List address -> "
								+ System.identityHashCode(this.intList));
		this.value = value;
		this.stringValueMain = stringValueMain;
		this.intList = intList;
	}

	@Override
	public void run() {
		System.out
				.println("ThreadTwo : " + "int value : " + value + " Int address : " + System.identityHashCode(value) + " StringBuilder value : " + stringValueMain + " StringBuilder address : " + System.identityHashCode(stringValueMain) + " List value : " + intList + " List address : " + System.identityHashCode(intList));
		/*
		 * try { Thread.sleep(2000); } catch (InterruptedException e) { }
		 */
		int i=0;
		while(intList.get(1)!=700) {
			i=2+5;
		}
		/*
		 * for (int i = 0; i < 50; i++) { try { Thread.sleep(1000); } catch
		 * (InterruptedException e) { } System.out .println("ThreadTwo Loop : " +
		 * "int value : " + value + " Int address : " + System.identityHashCode(value) +
		 * " StringBuilder value : " + stringValueMain + " StringBuilder address : " +
		 * System.identityHashCode(stringValueMain) + " List value : " + intList +
		 * " List address : " + System.identityHashCode(intList));
		 * 
		 * }
		 */
		System.out.println("Thread 2 ends : " + i);
	}

}
