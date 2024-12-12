package com.subhajit.inheritance.package1.model;

public class ChildInstanceVarOne extends ParentInstanceVarOne{
	public Integer var = 200;
	
	@Override
	public void method() {
		System.out.println("ChildInstanceVarOne var : " + var);
		System.out.println("ChildInstanceVarOne super.var : " + super.var);
		System.out.println("ChildInstanceVarOne this.var : " + this.var);
	}

}
