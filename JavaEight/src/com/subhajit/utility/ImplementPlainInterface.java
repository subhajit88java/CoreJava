package com.subhajit.utility;

import com.subhajit.plain.interfaces.PlainInterface;
import com.subhajit.plain.interfaces.PlainInterfaceTwo;

/*
 * 
 *  This class implements 2 interfaces.
 *  Test cases :
 *  1. void getName() overriding in the implementation class.
 *  2. void testMethodSignature1() vs String testMethodSignature1(), 
 *     what will happen if return type differs?
 *  3. void testMethodSignature2() vs void testMethodSignature2(String name),
 *     what will happen if method arguments differs?
 *  
 */
public class ImplementPlainInterface{// implements PlainInterface, PlainInterfaceTwo{

	// Test case 1, if method signature and return types are same in both
	// the interfaces, just override the same signature, no issues
	//@Override
	public void getName() {
		System.out.println("Same method signature");		
	}

	// Test case 2, 2 methods of same signature but different return types in both the interfaces 
	// will cause compilation error if we inherit both the interfaces
	//@Override
	public void testMethodSignature1() {
		//return null;
	}
	

	// Test case 3, If method signature differs by method arguments + return type, then we have to
	// override both the methods of both the interfaces, example of method overloading
	// NB : return type doesn't play any role in method overriding
	//@Override
	public void testMethodSignature2() {
		System.out.println("Method overloading without argument");		
	}

	// Test case 3, If method signature differs by method arguments, then we have to
	// override both the methods of both the interfaces, example of method overloading
	//@Override
	public String testMethodSignature2(String name) {
		System.out.println("Method overloading with argument");		
		return name;
	}
	
	

}
