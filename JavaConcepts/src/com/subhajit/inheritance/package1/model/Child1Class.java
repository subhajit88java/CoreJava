package com.subhajit.inheritance.package1.model;

public class Child1Class extends Parent1Class{
	
	public Child1Class() {
		System.out.println("Child1Class default constructor");
	}
	
	public Child1Class(String var1, String var2, String var3, String var4) {
		super(var1, var2, var3, var4);
		System.out.println("Parent1Class parameterised constructor");
	}
	
	@Override
	public String getValues() {
		super.getValues();
		System.out.println("Child1Class getValues");
		System.out.println("super values : " + super.var2 + " - " + super.var3 + " - " + super.var4);
		System.out.println("this values : " + this.var2 + " - " + this.var3 + " - " + this.var4);

		return var2+"-"+var3+"-"+var4;
	}

}
