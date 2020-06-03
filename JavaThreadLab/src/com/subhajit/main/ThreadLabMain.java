package com.subhajit.main;

import com.subhajit.models.BankAccountBean;
import com.subhajit.models.ThreadTestBean;
import com.subhajit.threads.ThreadFive;
import com.subhajit.threads.ThreadFour;
import com.subhajit.threads.ThreadOne;
import com.subhajit.threads.ThreadSeven;
import com.subhajit.threads.ThreadSix;
import com.subhajit.threads.ThreadThree;
import com.subhajit.threads.ThreadTwo;

public class ThreadLabMain {

	public static void main(String[] args) {
		//runTwoThreads();
		//runTwoThreadsWithObjectSharing();
		runTwoThreadsWithBankAccountObject();
	}

	private static void runTwoThreads() {
		
		System.out.println("Main Thread Starts..................");
		
		ThreadOne threadOne = new ThreadOne();
		ThreadTwo threadTwo = new ThreadTwo();
		
		Thread t1 = new Thread(threadOne);
		Thread t2 = new Thread(threadTwo);
		
		t1.start();
		t2.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main Thread Ends..................");

	}
	

	private static void runTwoThreadsWithObjectSharing() {
		
		System.out.println("Main Thread Starts..................");
		
		ThreadTestBean threadTestBean = new ThreadTestBean("Main");
		
		ThreadThree threadThree = new ThreadThree(threadTestBean);
		ThreadFour threadFour = new ThreadFour(threadTestBean);
		
		Thread t3 = new Thread(threadThree);
		Thread t4 = new Thread(threadFour);
		
		t3.start();
		t4.start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("threadTestBean in Main : " + threadTestBean);
		System.out.println("Main Thread Ends..................");

	}
	

	private static void runTwoThreadsWithBankAccountObject() {
		
		System.out.println("Main Thread Starts..................");
		
		BankAccountBean bankAccountBean = new BankAccountBean(1000);
		
		ThreadFive threadFive= new ThreadFive(bankAccountBean);
		ThreadSix threadSix = new ThreadSix(bankAccountBean);
		ThreadSeven threadSeven = new ThreadSeven(bankAccountBean);
		
		Thread t5 = new Thread(threadFive);
		Thread t6 = new Thread(threadSix);
		Thread t7 = new Thread(threadSeven);
		
		t5.start();
		t6.start();
		t7.start();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Amount remaining in Main : " + bankAccountBean);
		System.out.println("Main Thread Ends..................");
		
	}
}
