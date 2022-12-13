package com.subhajit.threads;

import com.subhajit.models.BankAccountBean;

public class ThreadFive implements Runnable {

	private BankAccountBean bankAccountBean;

	public ThreadFive(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	@Override
	public void run() {
		System.out.println("ThreadFive Starts.................." + 
				" Thread Id : " + Thread.currentThread().getId() + 
				" Thread Name : " + Thread.currentThread().getName()
				);
		synchronized (bankAccountBean) {
			Integer localAmount = bankAccountBean.getAmount();
			System.out.println("Received amt in ThreadFive : " + localAmount);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Integer remainingAmount = localAmount - 100;
			System.out.println("remainingAmount in ThreadFive : " + remainingAmount);

//			try {
//				System.out.println("ThreadFive going to wait..");
//				bankAccountBean.wait();
//				System.out.println("ThreadFive wait ends..");
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}

			bankAccountBean.setAmount(remainingAmount);
			System.out.println("Withdrawing 100 in ThreadFive : " + bankAccountBean);
			System.out.println("ThreadFive Ends..................");
		}

	}
}
