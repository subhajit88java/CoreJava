package com.subhajit.main;

import com.subhajit.utility.ImplementPlainInterface;

/*
 * This main method is to test ImplementPlainInterface
 * 
 */
public class TestPlainInterface {

	public static void main(String[] args) {
		
		ImplementPlainInterface implementPlainInterface = new ImplementPlainInterface();
		
		implementPlainInterface.getName(); // Test case 1 defined in ImplementPlainInterface
		implementPlainInterface.testMethodSignature1(); // Test case 2 defined in ImplementPlainInterface
		implementPlainInterface.testMethodSignature2(); // Test case 3 defined in ImplementPlainInterface
		implementPlainInterface.testMethodSignature2("Subhajit"); // Test case 3 defined in ImplementPlainInterface
		
	}
}
