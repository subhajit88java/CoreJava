package com.subhajit.jvm.model;

public class StaticTestModelTwo {
	private static String NAME = "Subhajit";
	static{
		System.out.println("StaticTestModelTwo NAME : " + System.identityHashCode(NAME));
	}

}
