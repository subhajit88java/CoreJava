package com.subhajit.jvm.model;

public class InstanceTestModelOne {
	private String NAME1 = "Subhajit";
	{
		System.out.println("InstanceTestModelOne NAME1 : " + System.identityHashCode(NAME1));
	}
	
	public void method() {
		String NAME2 = "Subhajit";
		System.out.println("InstanceTestModelOne method NAME2 : " + System.identityHashCode(NAME2));	
		String NAME3 = new String("Subhajit");
		System.out.println("InstanceTestModelOne method NAME3 : " + System.identityHashCode(NAME3));
		String NAME4 = NAME3.intern();
		System.out.println("InstanceTestModelOne method NAME4 : " + System.identityHashCode(NAME4));
		String CITY = new String("Durgapur");
		System.out.println("InstanceTestModelOne method CITY : " + System.identityHashCode(CITY));
	}

}
