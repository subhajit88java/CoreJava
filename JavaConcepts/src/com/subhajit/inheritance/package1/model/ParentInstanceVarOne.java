package com.subhajit.inheritance.package1.model;

public class ParentInstanceVarOne {
	
	public Integer var = 100;
	
	public void method() {
		System.out.println("ParentInstanceVarOne var : " + var);
		System.out.println("ParentInstanceVarOne this.var : " + this.var);
	}

}
