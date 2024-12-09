package com.subhajit.jvm.model;

public class StaticTestModelTwo {
	//private static String NAME = "Subhajit";
	private static Integer NUMBER = 1000;
	static{
		//System.out.println("StaticTestModelTwo NAME : " + System.identityHashCode(NAME));
		System.out.println("StaticTestModelTwo NUMBER : " + System.identityHashCode(NUMBER));
	}

}
