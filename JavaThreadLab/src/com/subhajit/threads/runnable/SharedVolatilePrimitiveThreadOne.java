package com.subhajit.threads.runnable;

import java.util.List;

public class SharedVolatilePrimitiveThreadOne implements Runnable {

	private int value = 30;
	private StringBuilder stringValueMain;
	private  List<Integer> intList;

	public SharedVolatilePrimitiveThreadOne(int value, StringBuilder stringValueMain, List<Integer> intList) {
		System.out.println("ThreadOne constructor -- " + "Supplied int address -> " + System.identityHashCode(value) + ", Local int address -> "
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
				.println("ThreadOne : " + "int value : " + value + " Int address : " + System.identityHashCode(value) + " StringBuilder value : " + stringValueMain + " StringBuilder address : " + System.identityHashCode(stringValueMain) + " List value : " + intList + " List address : " + System.identityHashCode(intList));
		
		  try { Thread.sleep(2000); } catch (InterruptedException e) { }
		 
		value = 20;
		stringValueMain.append("-Pallobi");
		intList.set(1, 700);
		for (int i = 0; i < 10; i++) {
			/*
			 * try { Thread.sleep(1000); } catch (InterruptedException e) { }
			 */
			System.out
			.println("ThreadOne Loop : " + "int value : " + value + " Int address : " + System.identityHashCode(value) + " StringBuilder value : " + stringValueMain + " StringBuilder address : " + System.identityHashCode(stringValueMain) + " List value : " + intList + " List address : " + System.identityHashCode(intList));

		}

	}

}
