package com.subhajit.main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.subhajit.threads.callable.ThreadOne;
import com.subhajit.threads.callable.ThreadThree;
import com.subhajit.threads.callable.ThreadTwo;

public class CallableThreadLabMain {

	public static void main(String[] args) {
		
		//threadExperimentWithoutPooling();
		//threadExperimentWithPooling();		
		
	}
	
	

	private static void threadExperimentWithoutPooling() {

		try {
		 runThreeThreads();
		// runTwoThreadsWithObjectSharing();
		// runTwoThreadsWithBankAccountObject();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void runThreeThreads() throws InterruptedException, ExecutionException{

		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());
		
		Callable threadOne = new ThreadOne();
		Callable threadTwo = new ThreadTwo();
		Callable threadThree = new ThreadThree();
		
		FutureTask futureTaskOne = new FutureTask(threadOne);
		FutureTask futureTaskTwo = new FutureTask(threadTwo);
		FutureTask futureTaskThree = new FutureTask(threadThree);
		
		Thread t1 = new Thread(futureTaskOne);
		Thread t2 = new Thread(futureTaskTwo);
		Thread t3 = new Thread(futureTaskThree);
		
		t1.start();
		t2.start();
		t3.start();
		
		System.out.println("Retrieving the results --->");
		Integer result1 = (Integer) futureTaskOne.get();
		System.out.println("result1 retrieved............");
		Integer result2 = (Integer) futureTaskTwo.get();
		Integer result3 = (Integer) futureTaskThree.get();
		
		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);
		System.out.println("Sum from ThreadThree : " + result3);

		System.out.println("Main Thread Ends..................");

	}
}
