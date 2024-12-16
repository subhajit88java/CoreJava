package com.subhajit.inheritance.package1.model;

public class Child7Class extends Parent3Class{
	public final int var1 = 200;
	private final int var2 = 210;
	protected final int var3 = 220;
	final int var4 = 230;
	
	@Override
	public void getValues() {
		super.getValues();
		System.out.println("Child7Class getValues");
		System.out.println("Child7Class values : "  + var1 + " - " + var2 + " - " + var3 + " - " + var4);
		System.out.println("super values : " + super.var1 + " - " + super.var3 + " - " + super.var4);
		System.out.println("this values : "  + this.var1 + " - " + this.var2 + " - " + this.var3 + " - " + this.var4);
	}

}
