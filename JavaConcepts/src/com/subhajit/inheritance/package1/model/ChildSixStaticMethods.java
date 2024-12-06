package com.subhajit.inheritance.package1.model;

public class ChildSixStaticMethods extends ParentStaticMethods{
	
	// instance methos cannot override parent static method
	public void method1() {
		System.out.println("CHILDSIX || public static void method1");
	}

}
