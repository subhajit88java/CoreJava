package com.subhajit.inheritance.package1.model;

public class ParentStaticFinalMethod {
	
	private static final void privateMethod() {
		System.out.println("Parent private static final method");	
	}
	
	protected static final void protectedMethod() {
		System.out.println("Parent protected static final method");	
	}
	
	static final void defaultMethod() {
		System.out.println("Parent default static final method");	
	}
	
	public static final void publicMethod() {
		System.out.println("Parent public static  final method");	
	}

}
