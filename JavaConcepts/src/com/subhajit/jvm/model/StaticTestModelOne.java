package com.subhajit.jvm.model;

public class StaticTestModelOne {
	private static String NAME = "Subhajit";
	static{
		System.out.println("StaticTestModelOne NAME : " + System.identityHashCode(NAME));
	}

}
