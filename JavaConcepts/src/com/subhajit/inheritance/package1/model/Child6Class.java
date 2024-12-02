package com.subhajit.inheritance.package1.model;

public class Child6Class extends Parent4Class{
	
	@Override
	public void getValues() {
		super.getValues();
		System.out.println("Child5Class getValues");
		System.out.println("super values : " + super.var1 + " - " + super.var3 + " - " + super.var4);
		System.out.println("this values : "  + this.var1 + " - " + this.var3 + " - " + this.var4);

	}

}

