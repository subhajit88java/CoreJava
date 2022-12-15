package com.subhajit.main;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import com.subhajit.threads.callable.ThreadOne;
import com.subhajit.threads.callable.ThreadTwo;

public class CallableThreadLabMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());
		
		FutureTask[] randomNoTasks = new FutureTask[2];  
		Callable threadOne = new ThreadOne();
		Callable threadTwo = new ThreadTwo();
		randomNoTasks[0] = new FutureTask(threadOne);
		randomNoTasks[1] = new FutureTask(threadTwo);
		
		Thread t1 = new Thread(randomNoTasks[0]);
		Thread t2 = new Thread(randomNoTasks[1]);
		
		t1.start();
		t2.start();
		
		Integer result1 = (Integer) randomNoTasks[0].get();
		Integer result2 = (Integer) randomNoTasks[1].get();
		
		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);	

		System.out.println("Main Thread Ends..................");
		
	}
}
