package com.subhajit.inheritance.package1.model;

public class ChildStaticInstanceMethod extends ParentStaticInstanceMethod{
	
	// Instance method cannot override static method
	public void staticMethod() {
		System.out.println("Parent static staticMethod");
	}
	
	// Static method cannot hide instance method
	public static void instanceMethod() {
		System.out.println("Parent static instanceMethod");
	}
}
