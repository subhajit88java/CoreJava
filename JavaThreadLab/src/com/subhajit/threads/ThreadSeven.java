package com.subhajit.threads;

import com.subhajit.models.BankAccountBean;

public class ThreadSeven implements Runnable {

	private BankAccountBean bankAccountBean;

	public ThreadSeven(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	@Override
	public void run() {

		synchronized (bankAccountBean) {
			Integer localAmount = bankAccountBean.getAmount();
			System.out.println("Received amt in ThreadSeven : " + localAmount);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Integer remainingAmount = localAmount - 300;
			System.out.println("remainingAmount in ThreadSeven : " + remainingAmount);
			bankAccountBean.setAmount(remainingAmount);
			System.out.println("Withdrawing 300 in ThreadSeven : " + bankAccountBean);
			bankAccountBean.notifyAll();
		}

	}
}
