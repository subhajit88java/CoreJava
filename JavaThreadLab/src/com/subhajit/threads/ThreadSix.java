package com.subhajit.threads;

import com.subhajit.models.BankAccountBean;

public class ThreadSix implements Runnable {

	private BankAccountBean bankAccountBean;

	public ThreadSix(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadSix Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		synchronized (bankAccountBean) {
			Integer localAmount = bankAccountBean.getAmount();
			System.out.println("Received amt in ThreadSix : " + localAmount);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Integer remainingAmount = localAmount - 200;
			System.out.println("remainingAmount in ThreadSix : " + remainingAmount);
//			try {
//				System.out.println("ThreadSix going to wait..");
//				bankAccountBean.wait();
//				System.out.println("ThreadSix wait ends..");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			bankAccountBean.setAmount(remainingAmount);
			System.out.println("Withdrawing 200 in ThreadSix : " + bankAccountBean);
			System.out.println("ThreadSix Ends..................");
		}

	}
}
