package com.subhajit.inheritance.package1.model;

public class ChildTwoStaticMethods extends ParentStaticMethods{
	
	// We cant use @Override for static method overriding, overriding is NA for static properties and @Override only refers to non-static methods
	//@Override
	public static void method1() {
		System.out.println("CHILDTWO || public static void method1");
	}
}
