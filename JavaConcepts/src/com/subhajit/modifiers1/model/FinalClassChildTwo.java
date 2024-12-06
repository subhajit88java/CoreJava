package com.subhajit.modifiers1.model;

public class FinalClassChildTwo extends FinalClassParent{

	// final override not allowed
	@Override
	public void method1() {
		System.out.println("CHILD || public final void method1");
	}
	
	// non-final method is allowed for overriding. In child class we can make it as final
	@Override
	public final void method2() {
		System.out.println("PARENT || public non-final void method1");
	}
}
