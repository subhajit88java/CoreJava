package com.subhajit.inheritance.package1.model;

public class ParentInstanceFinalMethod {
	
	private final void privateMethod() {
		System.out.println("Parent private final method");	
	}
	
	protected final void protectedMethod() {
		System.out.println("Parent protected final method");	
	}
	
	final void defaultMethod() {
		System.out.println("Parent default final method");	
	}
	
	public final void publicMethod() {
		System.out.println("Parent public final method");	
	}

}
