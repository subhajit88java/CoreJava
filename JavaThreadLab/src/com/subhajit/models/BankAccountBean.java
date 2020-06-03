package com.subhajit.models;

public class BankAccountBean {

	private Integer amount;

	public BankAccountBean(Integer amount) {
		this.amount = amount;
	}

	public Integer getAmount() {
		System.out.println("In getAmount : " + amount +" - "+System.currentTimeMillis());
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
		System.out.println("In setAmount : " + amount +" - "+System.currentTimeMillis());
	}

	@Override
	public String toString() {
		return "BankAccountBean [amount=" + amount + "]";
	}

}
