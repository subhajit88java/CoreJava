package com.subhajit.jvm.model;

public class StaticTestModelOne {
	//private static String NAME = "Subhajit";
	private static Integer NUMBER = 1000;
	static{
		//System.out.println("StaticTestModelOne NAME : " + System.identityHashCode(NAME));
		System.out.println("StaticTestModelOne NUMBER : " + System.identityHashCode(NUMBER));
	}

}
