package com.subhajit.jvm.model;

public class InstanceTestModelOne {
	//private String NAME1 = "Subhajit";
	private static Integer NUMBER1 = 1000;
	{
		//System.out.println("InstanceTestModelOne NAME1 : " + System.identityHashCode(NAME1));
		System.out.println("InstanceTestModelOne NUMBER1 : " + System.identityHashCode(NUMBER1));
	}
	
	public void method() {
		/*
		 * String NAME2 = "Subhajit";
		 * System.out.println("InstanceTestModelOne method NAME2 : " +
		 * System.identityHashCode(NAME2)); String NAME3 = new String("Subhajit");
		 * System.out.println("InstanceTestModelOne method NAME3 : " +
		 * System.identityHashCode(NAME3)); String NAME4 = NAME3.intern();
		 * System.out.println("InstanceTestModelOne method NAME4 : " +
		 * System.identityHashCode(NAME4));
		 */
		Integer NUMBER2 = 1000;
		System.out.println("InstanceTestModelOne method NUMBER2 : " + System.identityHashCode(NUMBER2));	
		Integer NUMBER3 = new Integer(1000);
		System.out.println("InstanceTestModelOne method NAME3 : " + System.identityHashCode(NUMBER3));
	}

}
