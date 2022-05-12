package com.subhajit.plain.interfaces;

/*
 * 
 *  Plain/Normal Interface containing 
 *  1 abstract method
 *  1 static non-abstract method
 *  1 default non-abstract method
 *  1 static abstract method
 *  1 default abstract method
 *  1 non-abstract method
 *  Methods and fields of interface are by default public
 *  
 */
public interface InterfaceTutorial {

	String getName(String name); //public and abstract
	
	static String getStaticName(String name) { // public and static
		return "Static method InterfaceTutorial";
	}
	
	default String getDefaultName() { // public and default
		return "Default method InterfaceTutorial";
	}
	
	// Compilation error, as static methods should contain body in an interface
	//static void abstractMethod1();
	
	// Compilation error, as default methods should contain body in an interface
	//default void abstractMethod2();
	
	// Compilation error, as non-static and non-default methods should be abstract in an interface
	/*
	 * String testNonAbstractMethod() { return "Non-Abstract"; }
	 */
	
}
