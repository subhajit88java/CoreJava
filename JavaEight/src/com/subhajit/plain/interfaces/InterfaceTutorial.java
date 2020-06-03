package com.subhajit.plain.interfaces;

public interface InterfaceTutorial {

	String getName(String name); //public and abstract
	
	static String getStaticName(String name) { // public and static
		return "I love my India";
	}
	
	default String getDefaultName() { // public and default
		return "Suvo";
	}
	
}
