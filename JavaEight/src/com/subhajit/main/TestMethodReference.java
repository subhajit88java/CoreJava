package com.subhajit.main;

import com.subhajit.funtional.interfaces.ConstructerFunctionalInterface;
import com.subhajit.funtional.interfaces.MethodRefInterfaceOne;
import com.subhajit.funtional.interfaces.MethodRefInterfaceThree;
import com.subhajit.funtional.interfaces.MethodRefInterfaceTwo;
import com.subhajit.utility.UseMyMethodOne;

public class TestMethodReference {

	public static void main(String[] args) {
		MethodRefInterfaceOne methodRefInterfaceOne =  UseMyMethodOne::method1;
		methodRefInterfaceOne.m1("Subhajit");

		MethodRefInterfaceTwo methodRefInterfaceTwo = UseMyMethodOne::method1;
		methodRefInterfaceTwo.m2("Pallobi");

		MethodRefInterfaceThree methodRefInterfaceThree = new UseMyMethodOne()::addM;
		System.out.println(methodRefInterfaceThree.addM(100, 20));

		ConstructerFunctionalInterface constructerFunctionalInterface = UseMyMethodOne::new;
		System.out.println(constructerFunctionalInterface.getObj());

	}

}
