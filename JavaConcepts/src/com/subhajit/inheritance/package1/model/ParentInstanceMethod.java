package com.subhajit.inheritance.package1.model;

public class ParentInstanceMethod {
	
	private void privateMethod() {
		System.out.println("Parent private method");	
	}
	
	protected void protectedMethod() {
		System.out.println("Parent protected method");	
	}
	
	void defaultMethod() {
		System.out.println("Parent default method");	
	}
	
	public void publicMethod() {
		System.out.println("Parent public method");	
	}

}
