package com.subhajit.main;

import com.subhajit.models.BankAccountBean;
import com.subhajit.models.SharedBean;
import com.subhajit.threads.runnable.ThreadFive;
import com.subhajit.threads.runnable.ThreadFour;
import com.subhajit.threads.runnable.ThreadOne;
import com.subhajit.threads.runnable.ThreadSeven;
import com.subhajit.threads.runnable.ThreadSix;
import com.subhajit.threads.runnable.ThreadThree;
import com.subhajit.threads.runnable.ThreadTwo;

public class RunnableThreadLabMain {

	public static void main(String[] args) {

		threadExperimentWithoutPooling();
		// threadExperimentWithPooling();

	}

	private static void threadExperimentWithPooling() {

	}

	private static void threadExperimentWithoutPooling() {

		// runTwoThreads();
		runTwoThreadsWithObjectSharing();
		// runTwoThreadsWithBankAccountObject();

	}

	private static void runTwoThreads() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		ThreadOne threadOne = new ThreadOne();
		ThreadTwo threadTwo = new ThreadTwo();

		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);

		t1.start();
		t2.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main Thread Ends..................");

	}

	private static void runTwoThreadsWithObjectSharing() {

		// objectLevelSynchronizationTest();
		classLevelSynchronizationTest();
		// methodLevelSynchronizationTest();

	}

	private static void classLevelSynchronizationTest() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		SharedBean sharedBean = new SharedBean("Main");

		ThreadThree threadThree = new ThreadThree(sharedBean);
		ThreadFour threadFour = new ThreadFour(sharedBean);

		Thread t3 = new Thread(threadThree);
		Thread t4 = new Thread(threadFour);

		t3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t4.start();

		System.out.println("sharedBean in Main : " + sharedBean);

		System.out.println("Main Thread Ends..................");

	}

	private static void methodLevelSynchronizationTest() {
		// TODO Auto-generated method stub

	}

	private static void objectLevelSynchronizationTest() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		SharedBean sharedBean = new SharedBean("Main");

		ThreadThree threadThree = new ThreadThree(sharedBean);
		ThreadFour threadFour = new ThreadFour(sharedBean);

		Thread t3 = new Thread(threadThree);
		Thread t4 = new Thread(threadFour);

		t3.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t4.start();

		System.out.println("sharedBean in Main : " + sharedBean);

		System.out.println("Main Thread Ends..................");

	}

	private static void runTwoThreadsWithBankAccountObject() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		BankAccountBean bankAccountBean = new BankAccountBean(1000);

		ThreadFive threadFive = new ThreadFive(bankAccountBean);
		ThreadSix threadSix = new ThreadSix(bankAccountBean);
		ThreadSeven threadSeven = new ThreadSeven(bankAccountBean);

		Thread t5 = new Thread(threadFive);
		Thread t6 = new Thread(threadSix);
		Thread t7 = new Thread(threadSeven);

		t5.start();
		t6.start();
		t7.start();

//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		System.out.println("Amount remaining in Main : " + bankAccountBean);
		System.out.println("Main Thread Ends..................");

	}
}
