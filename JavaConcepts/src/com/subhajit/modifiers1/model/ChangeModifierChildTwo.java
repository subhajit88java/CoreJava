package com.subhajit.modifiers1.model;

public class ChangeModifierChildTwo extends ParentClass{
	
	// private cannot be overridden
	@Override
	public void method2() {
		System.out.println("CHILD || private void method2");
	}
}
