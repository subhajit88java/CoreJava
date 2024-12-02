package com.subhajit.inheritance.package2.model;

import com.subhajit.inheritance.package1.model.Parent1Class;

public class Child4Class extends Parent1Class{
	
	public Child4Class() {
		System.out.println("Child1Class default constructor");
	}
	
	public Child4Class(String var1, String var2, String var3, String var4) {
		super(var1, var2, var3, var4);
		System.out.println("Child1Class parameterised constructor");
	}
	
	@Override
	public String getValues() {
		System.out.println(super.getValues());
		System.out.println("Child1Class getValues");
		System.out.println("super values : " + super.var2 + " - " + super.var4);
		System.out.println("this values : " + this.var2 + " - " + this.var4);

		return var2+"-"+var4;
	}

}

