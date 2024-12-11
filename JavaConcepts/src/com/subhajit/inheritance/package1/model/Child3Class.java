package com.subhajit.inheritance.package1.model;

public class Child3Class extends Parent3Class{
	public final int var1 = 200;
	
	 public void m() {
		 System.out.println("Child3Class! " + var1);
		 System.out.println("this.var1 " + this.var1);
		 System.out.println("super.var1 " + super.var1);
	 }
}
