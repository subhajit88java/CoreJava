package com.subhajit.modifiers1.model;

public class ParentClass {
	
	// accessible from : same/different package, child class same/different package
	public void method1() {
		System.out.println("PARENT || public void method1");
	}
	
	// accessible from : only within the class
	private void method2() {
		System.out.println("PARENT || private void method2");
	}
	
	// accessible from : same package, child class same/different package
	protected void method3() {
		System.out.println("PARENT || protected void method3");
	}
	
	// accessible from : same package, child class same package
	void method4() {
		System.out.println("PARENT || default void method4");
	}
}
