package com.subhajit.modifiers1.model;

public class ChaneModifierChildOne extends ParentClass{
	
	// can't reduce visibility
	@Override
	private void method1() {
		System.out.println("PARENT || public void method1");
	}

}
