package com.subhajit.casestudy.model;

public class ThisConstructorModel {
	
	private int a;
	private int b;
	private int c;
	
	public ThisConstructorModel(int a) {
		this.a = a;
	}
	
	public ThisConstructorModel(int a, int b) {
		this(a);
		this.b = b;
	}
	
	public ThisConstructorModel(int a, int b, int c) {
		this(a,b);
		this.c = c;
	}
	
	public void print() {
		System.out.println("Value => " + a + " - " + b + " - " + c);
	}

}
