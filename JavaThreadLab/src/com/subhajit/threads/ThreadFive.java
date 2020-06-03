package com.subhajit.threads;

import com.subhajit.models.BankAccountBean;

public class ThreadFive implements Runnable {

	private BankAccountBean bankAccountBean;

	public ThreadFive(BankAccountBean bankAccountBean) {
		this.bankAccountBean = bankAccountBean;
	}

	@Override
	public void run() {

		synchronized (bankAccountBean) {
			Integer localAmount = bankAccountBean.getAmount();
			System.out.println("Received amt in ThreadFive : " + localAmount);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Integer remainingAmount = localAmount - 100;
			System.out.println("remainingAmount in ThreadFive : " + remainingAmount);

			try {
				bankAccountBean.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			bankAccountBean.setAmount(remainingAmount);
			System.out.println("Withdrawing 100 in ThreadFive : " + bankAccountBean);
		}

	}
}
