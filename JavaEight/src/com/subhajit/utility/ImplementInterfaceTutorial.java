package com.subhajit.utility;

import com.subhajit.plain.interfaces.InterfaceTutorial;
import com.subhajit.plain.interfaces.InterfaceTutorialTwo;

/*
 * 
 *  This class implements 2 interfaces.
 *  Test cases :
 *  1. String getName(String name) overriding in the implementation class.
 *  2. default String getDefaultName() overriding in the implementation class. 
 *  3. A new version of static String getStaticName(String name) in the implementation class(static methods in interfaces cannot be overridden)
 *  
 */
public class ImplementInterfaceTutorial implements InterfaceTutorial, InterfaceTutorialTwo{

	@Override
	public String getName(String name) {
		return "method body has been defined in ImplementInterfaceTutorial";
	}

	@Override
	public String getDefaultName() {
		System.out.println(InterfaceTutorial.super.getDefaultName());
		System.out.println(InterfaceTutorialTwo.super.getDefaultName());
		return "Combined output of 2 default methods";
	}
	
	public static String getStaticName(String name) {
		return "getStaticName overriden in impl class";
	}

}
