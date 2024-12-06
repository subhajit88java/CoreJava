package com.subhajit.inheritance.package1.model;

public class ChildThreeStaticMethods extends ParentStaticMethods{
	public static void method() {
		ParentStaticMethods.method1();
		ParentStaticMethods.method3();
		ParentStaticMethods.method4();
		System.out.println("CHILDTHREE || public static void method");
	}
}
