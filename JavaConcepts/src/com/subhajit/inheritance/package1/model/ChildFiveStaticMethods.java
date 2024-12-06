package com.subhajit.inheritance.package1.model;

public class ChildFiveStaticMethods extends ParentStaticMethods {
	
	// cannot reduce visibility 
	private static void method1() {
		System.out.println("CHILDFIVE || public static void method1");
	}
	
	// can widen visibility
	public static void method2() {
		System.out.println("CHILDFIVE || public static void method2");
	}
	
	// can widen visibility
	public static void method3() {
		System.out.println("CHILDFIVE || public static void method3");
	}
	
	// can widen visibility
	public static void method4() {
		System.out.println("CHILDFIVE || public static void method4");
	}

}
