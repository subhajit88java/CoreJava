package com.subhajit.inheritance.package1.model;

public class ParentStaticMethods {
	
	public static void method1() {
		System.out.println("PARENT || public static void method1");
	}
	
	private static void method2() {
		System.out.println("PARENT || private static void method2");
	}
	
	protected static void method3() {
		System.out.println("PARENT || protected static void method3");
	}
	
	static void method4() {
		System.out.println("PARENT || default static void method4");
	}
	
	public static void callByObject() {
		System.out.println("PARENT version");
	}

}
