package com.subhajit.main;

import com.subhajit.funtional.interfaces.FunctionalInterfaceSeven;
import com.subhajit.funtional.interfaces.FunctionalInterfaceSix;

//Testing of FunctionalInterfaceSix and FunctionalInterfaceSeven to learn how Lambda Expression will understand sequence of params of abstract method.
public class TestFunctionalInterfaceSixSeven {

	public static void main(String[] args) {
		
		FunctionalInterfaceSix functionalInterfaceSix = (a,b) -> {System.out.println(a.toUpperCase() + b);};
		functionalInterfaceSix.testMethod("Subhajit", 1);
		
		FunctionalInterfaceSeven functionalInterfaceSeven = (a,b) -> {System.out.println(a+ b.toUpperCase());};
		functionalInterfaceSeven.testMethod(2, "Pallobi");
	}
}
