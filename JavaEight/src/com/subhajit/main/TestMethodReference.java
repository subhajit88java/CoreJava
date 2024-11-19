package com.subhajit.main;

import java.util.Comparator;
import java.util.function.Function;

import com.subhajit.funtional.interfaces.ConstructerFunctionalInterface;
import com.subhajit.funtional.interfaces.MethodRefInterfaceFour;
import com.subhajit.funtional.interfaces.MethodRefInterfaceOne;
import com.subhajit.funtional.interfaces.MethodRefInterfaceThree;
import com.subhajit.funtional.interfaces.MethodRefInterfaceTwo;
import com.subhajit.utility.UseMyMethodOne;
import com.subhajit.utility.UseMyMethodThree;
import com.subhajit.utility.UseMyMethodTwo;

public class TestMethodReference {

	public static void main(String[] args) {
		
		// static reference of specified object
		MethodRefInterfaceOne methodRefInterfaceOne =  UseMyMethodOne::method1;
		methodRefInterfaceOne.m1("Subhajit");
				
		MethodRefInterfaceTwo methodRefInterfaceTwo = UseMyMethodOne::method1;
		methodRefInterfaceTwo.m2("Pallobi");

		// non-static reference of specified object
		MethodRefInterfaceThree methodRefInterfaceThree = new UseMyMethodOne()::addM;
		System.out.println(methodRefInterfaceThree.addM(100, 20));

		//MethodRefInterfaceFour methodRefInterfaceFour = new UseMyMethodOne()::testMethodSignature;
		//methodRefInterfaceFour.testMethodSignature("ARG");
		
		// Constructor reference of specified object
		ConstructerFunctionalInterface constructerFunctionalInterface = UseMyMethodOne::new;
		System.out.println(constructerFunctionalInterface.getObj());
		
		// non-static reference of arbitrary object
		MethodRefInterfaceFive<UseMyMethodTwo, String> methodRefInterfaceFive1 = UseMyMethodTwo :: method;
		System.out.println(methodRefInterfaceFive1.m(new UseMyMethodTwo()));
		
		MethodRefInterfaceFive<UseMyMethodThree, String> methodRefInterfaceFive2 = UseMyMethodThree :: method;
		System.out.println(methodRefInterfaceFive2.m(new UseMyMethodThree()));


	}

}
