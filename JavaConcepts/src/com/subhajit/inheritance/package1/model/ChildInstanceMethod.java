package com.subhajit.inheritance.package1.model;

public class ChildInstanceMethod extends ParentInstanceMethod {

	// as parent's version of private method is not inherited, so this will be not considered as method overriding
	// if we use @Override then it will give compilation issue saying that this must override parent's method (which is not visible)
	//@Override
	private void privateMethod() {
		System.out.println("Child private method");	
	}
	
	// true method overriding
	// cant reduce visibility, or it will give compilation issue
	// Even if we dont mention @Override , then also this method will be overriden
	// If we change return type then we will get compilation issue, as return type doesnt play part in overriding
	@Override
	protected void protectedMethod() {
		System.out.println("Child protected method");
	}
	
	// true method overriding
	// cant reduce visibility, or it will give compilation issue
	// Even if we dont mention @Override , then also this method will be overriden	
	// If we change return type then we will get compilation issue, as return type doesnt play part in overriding
	@Override
	void defaultMethod() {
		System.out.println("Child default method");	
	}
	
	// true method overriding
	// cant reduce visibility, or it will give compilation issue
	// Even if we dont mention @Override , then also this method will be overriden
	// If we change return type then we will get compilation issue, as return type doesnt play part in overriding
	@Override
	public void publicMethod() {
		System.out.println("Child public method");	
	}
	
	
}
