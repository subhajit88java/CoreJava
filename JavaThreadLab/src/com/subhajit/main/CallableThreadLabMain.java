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

		// threadExperimentWithoutPooling();
		threadExperimentWithPooling();

	}

	private static void threadExperimentWithPooling() {
		// multiThreadPool();
		// multiThreadCachedPool();
		 multiThreadPoolWithExecutorCompletionService();
	}

	// With Executer Completion service the result will be available to the main thread in the order of thread completion 
	private static void multiThreadPoolWithExecutorCompletionService() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		List<Callable> callableTasks = new ArrayList<>();
		callableTasks.add(new ThreadOne()); // 1st task submission, completion will be after task 2nd and 3rd
		callableTasks.add(new ThreadTwo()); // 2nd task submission, completion will be after task3rd
		callableTasks.add(new ThreadThree()); // 3rd task submission, completion will be ahead of task 1st and 2nd

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

		} catch (Exception e) {
			System.out.println("Exception caught!!");
		}

		System.out.println("Main Thread Ends..................");

	}

	// With Executer service the result will be available to the main thread in the order of task submission
	private static void multiThreadCachedPool() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Callable threadOne = new ThreadOne(); 
		Callable threadTwo = new ThreadTwo();  
		Callable threadThree = new ThreadThree();

		ExecutorService executor = Executors.newCachedThreadPool(); // If no thread is available in pool then new thread will be created, otherwise any freed thread will be assigned
		Future futureOne = executor.submit(threadOne); // 1st task submission, completion will be after task 2nd and 3rd
		Future futureTwo = executor.submit(threadTwo); // 2nd task submission, completion will be after task3rd
		Future futureThree = executor.submit(threadThree); // 3rd task submission, completion will be ahead of task 1st and 2nd
		System.out.println("Retrieving the results --->");
		Integer result1 = 0;
		Integer result2 = 0;
		Integer result3 = 0;
		try {
			result1 = (Integer) futureOne.get();
			System.out.println("result1 retrieved............ " + result1); // Even if it takes long time for completion , the result will be printed first
			result2 = (Integer) futureTwo.get();
			System.out.println("result2 retrieved............ " + result2); // This statement will not get executed until task 1 result is fetched and printed
			result3 = (Integer) futureThree.get();
			System.out.println("result3 retrieved............ " + result3); // This statement will not get executed until task 1 and 2 result is fetched and printed
		} catch (Exception e) {
		}

		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);
		System.out.println("Sum from ThreadThree : " + result3);

		executor.shutdown(); // Need to shut down after all tasks completion, otherwise main thread will
								// never end

		System.out.println("Main Thread Ends..................");
	}

	private static void multiThreadPool() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		Callable threadOne = new ThreadOne();
		Callable threadTwo = new ThreadTwo();
		Callable threadThree = new ThreadThree();

		ExecutorService executor = Executors.newFixedThreadPool(2); // fixed thread pool will create and contain given no of threads. Until and unless 1 thread gets freed, the 3rd task cant be picked up
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
			System.out.println("result2 retrieved............ " + result2);
			result3 = (Integer) futureThree.get();
			System.out.println("result3 retrieved............ " + result3);
		} catch (Exception e) {
			System.out.println("Exception caught!!");
		}

		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);
		System.out.println("Sum from ThreadThree : " + result3);

		executor.shutdown(); // Need to shut down after all tasks completion, otherwise main thread will
								// never end

		System.out.println("Main Thread Ends..................");

	}

	private static void threadExperimentWithoutPooling() {

		try {
			runThreeThreads();
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}

	}

	private static void runThreeThreads() throws InterruptedException, ExecutionException {

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

		Integer result1 = -1;
		Integer result2 = -1;
		Integer result3 = -1;

		// The main thread will not get terminated until and unless all the threads finished their executions, if we call .get() on the threads
		// If an exception is thrown from any one of the threads, it is only when get()
		// will be called on future task instance that same exception will be delegated
		// in
		// the main thread.
		// If we dont handle the exception then the following lines post the get() call
		// on the future task(throwing exception) will not be executed
		// If we handle exception, then the other get() calls will execute atleast, but the main thread will end before completion of the other threads
		try {
			System.out.println("Retrieving the results --->");
			//result1 = (Integer) futureTaskOne.get();
			System.out.println("result1 retrieved............ " + result1);
			result2 = (Integer) futureTaskTwo.get();
			System.out.println("result2 retrieved............ " + result2);
			result3 = (Integer) futureTaskThree.get();
			System.out.println("result3 retrieved............ " + result3);
		} catch (Exception e) {
			System.out.println("Exception caught!!!");
		}

		System.out.println("Sum from ThreadOne : " + result1);
		System.out.println("Sum from ThreadTwo : " + result2);
		System.out.println("Sum from ThreadThree : " + result3);

		System.out.println("Main Thread Ends..................");

	}
}
