package com.subhajit.main;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.subhajit.models.BankAccountBean;
import com.subhajit.models.SharedBean;
import com.subhajit.models.SynchronizeMonitorOne;
import com.subhajit.models.SynchronizeMonitorTwo;
import com.subhajit.models.UtilityClassOne;
import com.subhajit.threads.runnable.ThreadEight;
import com.subhajit.threads.runnable.ThreadEleven;
import com.subhajit.threads.runnable.ThreadFifteen;
import com.subhajit.threads.runnable.ThreadFive;
import com.subhajit.threads.runnable.ThreadFour;
import com.subhajit.threads.runnable.ThreadFourteen;
import com.subhajit.threads.runnable.ThreadNine;
import com.subhajit.threads.runnable.ThreadOne;
import com.subhajit.threads.runnable.ThreadSeven;
import com.subhajit.threads.runnable.ThreadSix;
import com.subhajit.threads.runnable.ThreadSixteen;
import com.subhajit.threads.runnable.ThreadTen;
import com.subhajit.threads.runnable.ThreadThirteen;
import com.subhajit.threads.runnable.ThreadThree;
import com.subhajit.threads.runnable.ThreadTwelve;
import com.subhajit.threads.runnable.ThreadTwo;

public class RunnableThreadLabMain {

	public static void main(String[] args) {

		threadExperimentWithoutPooling();
		threadExperimentWithPooling();

	}

	private static void threadExperimentWithPooling() {
		// singleThreadPool();	
		// multiThreadPool();	
		// singleThreadPoolWithException();
		 multiThreadPoolWithExecutorCompletionService();
	}

	private static void singleThreadPool() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();
		Runnable threadEight = new ThreadEight();
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(threadOne);
		executor.submit(threadTwo);
		executor.submit(threadEight);
		
//		try {
//			System.out.println("futureOne : " + futureOne.get());
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			e.printStackTrace();
//		}
		
		//executor.execute(threadOne);
		//executor.execute(threadTwo);
		//executor.execute(threadEight);
		
		System.out.println("Main Thread Ends..................");

	}
	
	private static void multiThreadPoolWithExecutorCompletionService() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();
		Runnable threadEight = new ThreadEight();
		
		String a = "threadOne";
		String b = "threadTwo";
		String c = "threadEight";
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		CompletionService completionService = new ExecutorCompletionService<>(executor);
		completionService.submit(threadOne, a);
		completionService.submit(threadTwo, b);
		completionService.submit(threadEight, c);
		
		try {	
			System.out.println("Rank 1 : " + completionService.take().get());
			System.out.println("Rank 2 : " + completionService.take().get());
			System.out.println("Rank 3 : " + completionService.take().get());	
		} catch (Exception e) {e.printStackTrace();} 
		
		
//		executor.execute(threadOne);
//		executor.execute(threadTwo);
//		executor.execute(threadEight);
		
		System.out.println("Main Thread Ends..................");

	}
	
	private static void singleThreadPoolWithException() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();
		Runnable threadEight = new ThreadEight();
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future futureOne = executor.submit(threadOne);
		Future futureTwo = executor.submit(threadTwo);
		Future futureEight = executor.submit(threadEight);
		
		
		try {
			System.out.println("futureOne : " + futureOne.get());
			System.out.println("futureTwo : " + futureTwo.get());
			System.out.println("futureEight : " + futureEight.get());
			
		} catch (Exception e) {e.printStackTrace();} 
		
		
//		executor.execute(threadOne);
//		executor.execute(threadTwo);
//		executor.execute(threadEight);
		
		System.out.println("Main Thread Ends..................");

	}
	
	private static void multiThreadPool() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();
		Runnable threadEight = new ThreadEight();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);		
		Future futureOne = executor.submit(threadOne);
		Future futureTwo = executor.submit(threadTwo);
		Future futureEight = executor.submit(threadEight);
				
//		try {	
//			System.out.println("futureOne : " + futureOne.get());
//			System.out.println("futureTwo : " + futureTwo.get());
//			System.out.println("futureEight : " + futureEight.get());
//					
//		} catch (Exception e) {} 
		
		System.out.println("Main Thread Ends..................");

	}

	private static void threadExperimentWithoutPooling() {

		 runThreeThreads();
		// runTwoThreadsWithObjectSharing();
		// runTwoThreadsWithBankAccountObject();

	}

	private static void runThreeThreads() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Runnable threadOne = new ThreadOne();
		Runnable threadTwo = new ThreadTwo();
		Runnable threadEight = new ThreadEight();

		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);
		Thread t8 = new Thread(threadEight);

		t1.start();
		t2.start();
		t8.start();

//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		System.out.println("Main Thread Ends..................");

	}

	private static void runTwoThreadsWithObjectSharing() {

		// objectLevelSynchronizationTestOne();
		// objectLevelSynchronizationTestTwo();
		// classLevelSynchronizationTestOne();
		// classLevelSynchronizationTestTwo();
		 methodLevelSynchronizationTest();

	}

	private static void classLevelSynchronizationTestOne() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		// Shared bean is used to prove that data is getting updated in isolation
		SharedBean sharedBean = new SharedBean("Main");

		ThreadThree threadThree = new ThreadThree(sharedBean);
		ThreadFour threadFour = new ThreadFour(sharedBean);

		Thread t3 = new Thread(threadThree);
		Thread t4 = new Thread(threadFour);

		t3.start();
		t4.start();

		System.out.println("sharedBean in Main : " + sharedBean);

		System.out.println("Main Thread Ends..................");

	}
	
	private static void classLevelSynchronizationTestTwo() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		ThreadNine threadNine = new ThreadNine();
		ThreadTen threadTen = new ThreadTen();

		Thread t9 = new Thread(threadNine);
		Thread t10 = new Thread(threadTen);

		t9.start();
		t10.start();

		System.out.println("Main Thread Ends..................");

	}

	private static void methodLevelSynchronizationTest() {
		
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		UtilityClassOne utilityClassOne = new UtilityClassOne();
		UtilityClassOne utilityClassDuplicate = new UtilityClassOne();
	
		ThreadFifteen threadFifteen = new ThreadFifteen(utilityClassOne);
		ThreadSixteen threadSixteen = new ThreadSixteen(utilityClassDuplicate);

		Thread t15 = new Thread(threadFifteen);
		Thread t16 = new Thread(threadSixteen);

		t15.start();
		t16.start();

		System.out.println("Main Thread Ends..................");

	}

	private static void objectLevelSynchronizationTestOne() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		SynchronizeMonitorOne synchronizeMonitorOne = new SynchronizeMonitorOne();
		SynchronizeMonitorOne synchronizeMonitorTwo = new SynchronizeMonitorOne();

		ThreadEleven threadEleven = new ThreadEleven(synchronizeMonitorOne);
		ThreadTwelve threadTwelve = new ThreadTwelve(synchronizeMonitorTwo);

		Thread t11 = new Thread(threadEleven);
		Thread t12 = new Thread(threadTwelve);

		t11.start();
		t12.start();

		System.out.println("Main Thread Ends..................");

	}
	
	private static void objectLevelSynchronizationTestTwo() {

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());
		
		SynchronizeMonitorTwo synchronizeMonitorTwo = new SynchronizeMonitorTwo();
		SynchronizeMonitorTwo synchronizeMonitorDuplicate = new SynchronizeMonitorTwo();


		ThreadThirteen threadThirteen = new ThreadThirteen(synchronizeMonitorTwo);
		ThreadFourteen threadFourteen = new ThreadFourteen(synchronizeMonitorDuplicate);

		Thread t13 = new Thread(threadThirteen);
		Thread t14 = new Thread(threadFourteen);

		t13.start();
		t14.start();

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
