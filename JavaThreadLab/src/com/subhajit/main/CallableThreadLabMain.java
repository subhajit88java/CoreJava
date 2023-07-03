package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.subhajit.threads.callable.ThreadOne;
import com.subhajit.threads.callable.ThreadThree;
import com.subhajit.threads.callable.ThreadTwo;
import com.subhajit.threads.runnable.ThreadEight;

public class CallableThreadLabMain {

	public static void main(String[] args) {
		
		//threadExperimentWithoutPooling();
		threadExperimentWithPooling();		
		
	}
	
	

	private static void threadExperimentWithPooling() {
			//multiThreadPool();	
			//multiThreadCachedPool();
			multiThreadPoolWithExecutorCompletionService();
	}
	
	// Completion service returns the result from any of the the threads whenever available
	// Executor service returns the result when manually asked for 
	private static void multiThreadPoolWithExecutorCompletionService() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		List<Callable> callableTasks = new ArrayList<>();
		callableTasks.add(new ThreadOne());
		callableTasks.add(new ThreadTwo());
		callableTasks.add(new ThreadThree());
		
		ExecutorService executor = Executors.newCachedThreadPool();
		CompletionService completionService = new ExecutorCompletionService<>(executor);
		callableTasks.stream().forEach(callableTask -> completionService.submit(callableTask));
				
		System.out.println("Retrieving the results --->");
		
		try {	
			callableTasks.stream().forEach(dummy -> {
				try {
					System.out.println("Result received :: " + completionService.take().get());
				} catch (InterruptedException | ExecutionException e) {
				}
			});
			
		} catch (Exception e) {} 
		
		System.out.println("Main Thread Ends..................");

	}
	
	private static void multiThreadCachedPool() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Callable threadOne = new ThreadOne();
		Callable threadTwo = new ThreadTwo();
		Callable threadThree = new ThreadThree();
		
		ExecutorService executor = Executors.newCachedThreadPool();
		Future futureOne = executor.submit(threadOne);
		Future futureTwo = executor.submit(threadTwo);
		Future futureThree = executor.submit(threadThree);
		
		System.out.println("Retrieving the results --->");
		Integer result1 = 0;
		Integer result2 = 0;
		Integer result3 = 0;
		try {			
			result1 = (Integer) futureOne.get();
			System.out.println("result1 retrieved............ " + result1);
			result2 = (Integer) futureTwo.get();
			result3 = (Integer) futureThree.get();				
		} catch (Exception e) {} 
			
		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);
		System.out.println("Sum from ThreadThree : " + result3);
		
		executor.shutdown(); // Need to shut down after all tasks completion, otherwise main thread will never end
		
		System.out.println("Main Thread Ends..................");
	}



	private static void multiThreadPool() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Callable threadOne = new ThreadOne();
		Callable threadTwo = new ThreadTwo();
		Callable threadThree = new ThreadThree();
		
		ExecutorService executor = Executors.newFixedThreadPool(2);		
		Future futureOne = executor.submit(threadOne);
		Future futureTwo = executor.submit(threadTwo);
		Future futureThree = executor.submit(threadThree);
		
		System.out.println("Retrieving the results --->");
		Integer result1 = 0;
		Integer result2 = 0;
		Integer result3 = 0;
		try {			
			result1 = (Integer) futureOne.get();
			System.out.println("result1 retrieved............ " + result1);
			result2 = (Integer) futureTwo.get();
			result3 = (Integer) futureThree.get();				
		} catch (Exception e) {} 
			
		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);
		System.out.println("Sum from ThreadThree : " + result3);
		
		executor.shutdown(); // Need to shut down after all tasks completion, otherwise main thread will never end
		
		System.out.println("Main Thread Ends..................");

	}



	private static void threadExperimentWithoutPooling() {

		try {
		 runThreeThreads();
		}catch(Exception e) {
			System.out.println("Exception : " + e.getMessage());
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
		System.out.println("result1 retrieved............ " + result1);
		Integer result2 = (Integer) futureTaskTwo.get();
		Integer result3 = (Integer) futureTaskThree.get();
		
		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);
		System.out.println("Sum from ThreadThree : " + result3);

		System.out.println("Main Thread Ends..................");

	}
}
