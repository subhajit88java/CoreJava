package com.subhajit.inheritance.package1.model;

public class Parent1Class {

	private String var1;
	protected String var2;
	String var3;
	public String var4;
	
	public Parent1Class() {
		System.out.println("Parent1Class default constructor");
	}

	public Parent1Class(String var1, String var2, String var3, String var4) {
		super();
		this.var1 = var1;
		this.var2 = var2;
		this.var3 = var3;
		this.var4 = var4;
		System.out.println("Parent1Class parameterised constructor");
	}
	
	public String getValues() {
		System.out.println("Parent1Class getValues");
		return var1+"-"+var2+"-"+var3+"-"+var4;
	}
	
}
