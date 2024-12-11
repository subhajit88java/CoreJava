package com.subhajit.inheritance.package1.model;

public class ChildInstanceVarTwo extends ParentInstanceVarOne{
	private Integer var = 300;
	
	@Override
	public void method() {
		var = 500;
		this.var = 600;
		super.var = 700;
		System.out.println("ChildInstanceVarTwo var : " + var);
		System.out.println("ChildInstanceVarTwo super.var : " + super.var);
		System.out.println("ChildInstanceVarTwo this.var : " + this.var);
	}

}
