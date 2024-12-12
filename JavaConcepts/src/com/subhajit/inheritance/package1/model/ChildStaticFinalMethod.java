package com.subhajit.inheritance.package1.model;

public class ChildStaticFinalMethod extends ParentStaticFinalMethod{
	
	private static final void privateMethod() {
		System.out.println("Child private static final method");	
	}
	
	// Though overriding is NA for static props, still in this case it will give compilation issue citing "cannot override final parent method"
	protected static final void protectedMethod() {
		System.out.println("Parent protected static final method");	
	}
}
