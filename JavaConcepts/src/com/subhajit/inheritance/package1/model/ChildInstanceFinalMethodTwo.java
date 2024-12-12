package com.subhajit.inheritance.package1.model;

public class ChildInstanceFinalMethodTwo extends ParentInstanceFinalMethod{
	
	// final method cant be overriden with or without @Override
	// If we change return type then we will get compilation issue, as return type doesnt play part in overriding
	// However method overloading will work
	@Override
	public void publicMethod() {
		System.out.println("Parent public final method");
	}

}
