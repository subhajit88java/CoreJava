package com.subhajit.threads;

import com.subhajit.models.BankAccountBean;

public class ThreadSeven implements Runnable {

	private BankAccountBean bankAccountBean;

	public ThreadSeven(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadSeven Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		synchronized (bankAccountBean) {
			Integer localAmount = bankAccountBean.getAmount();
			System.out.println("Received amt in ThreadSeven : " + localAmount);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Integer remainingAmount = localAmount - 300;
			System.out.println("remainingAmount in ThreadSeven : " + remainingAmount);
			bankAccountBean.setAmount(remainingAmount);
			System.out.println("Withdrawing 300 in ThreadSeven : " + bankAccountBean);
//			System.out.println("ThreadSeven going to notify all..");
//			bankAccountBean.notifyAll();
//			System.out.println("ThreadSeven notified all..");
		}
		System.out.println("ThreadSeven Ends..................");
	}
}
