package com.subhajit.inheritance.package1.model;

public class ChildInstanceVarThree extends ParentInstanceVarOne{	
	@Override
	public void method() {
		var = 500;
		System.out.println("ChildInstanceVarTwo var : " + var);
		System.out.println("ChildInstanceVarTwo super.var : " + super.var);
		System.out.println("ChildInstanceVarTwo this.var : " + this.var);
	}

}
