package com.subhajit.inheritance.package1.model;

public class ChildFinalMethod extends ParentFinalMethod{
	
	// Cannot override final parent method, compilation issue
	public void method() {
		System.out.println("Parent version");
	}
}
