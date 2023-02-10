package com.subhajit.generics.model;

public class GenericModel1<A,B,C> {
	
	private A field1;
	private B field2;
	private C field3;
	
	public GenericModel1(A field1, B field2, C field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public A getField1() {
		return field1;
	}

	public void setField1(A field1) {
		this.field1 = field1;
	}

	public B getField2() {
		return field2;
	}

	public void setField2(B field2) {
		this.field2 = field2;
	}

	public C getField3() {
		return field3;
	}

	public void setField3(C field3) {
		this.field3 = field3;
	}

	@Override
	public String toString() {
		return "GenericModel1 [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	public void showSomething() {
		System.out.println("field1 : " + field1.getClass());
		System.out.println("field2 : " + field2.getClass());
		System.out.println("field3 : " + field3.getClass());
	}

}
