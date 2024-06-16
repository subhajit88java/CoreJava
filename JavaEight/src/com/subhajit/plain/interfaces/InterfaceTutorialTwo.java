package com.subhajit.plain.interfaces;

/*
 * 
 *  Plain/Normal Interface containing 
 *  1 abstract method
 *  1 static non-abstract method
 *  1 default non-abstract method
 *  Methods and fields of interface are by default public
 *  
 */
public interface InterfaceTutorialTwo {
	
	String getName(String name); //public and abstract
	Integer getId(Integer Id); //public and abstract
	
	// Will cause compilation issue once implemented by a class due to ambiguity of the return type in InterfaceTutorial
	//String getCity(); //public and abstract
	
	static String getStaticName(String name) { // public and static
		return "Static method InterfaceTutorialTwo";
	}
	
	default String getDefaultName() { // public and default
		return "Default method InterfaceTutorialTwo";
	}
}
