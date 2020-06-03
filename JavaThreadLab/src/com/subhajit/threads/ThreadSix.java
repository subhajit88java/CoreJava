package com.subhajit.threads;

import com.subhajit.models.BankAccountBean;

public class ThreadSix implements Runnable {

	private BankAccountBean bankAccountBean;

	public ThreadSix(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	@Override
	public void run() {

		synchronized (bankAccountBean) {
			Integer localAmount = bankAccountBean.getAmount();
			System.out.println("Received amt in ThreadSix : " + localAmount);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Integer remainingAmount = localAmount - 200;
			System.out.println("remainingAmount in ThreadSix : " + remainingAmount);
			try {
				bankAccountBean.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bankAccountBean.setAmount(remainingAmount);
			System.out.println("Withdrawing 200 in ThreadSix : " + bankAccountBean);
		}

	}
}
