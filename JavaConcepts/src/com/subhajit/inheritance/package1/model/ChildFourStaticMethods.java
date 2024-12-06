package com.subhajit.inheritance.package1.model;

public class ChildFourStaticMethods extends ParentStaticMethods{
	
	// return type is incompitable with ParentStaticMethods' method1
	public static String method1() {
		System.out.println("CHILDFOUR || public static void method1");
		return "CHILDFOUR || public static void method1";
	}

}
