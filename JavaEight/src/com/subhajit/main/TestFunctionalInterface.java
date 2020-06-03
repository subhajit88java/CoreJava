package com.subhajit.main;

import com.subhajit.funtional.interfaces.FunctionalInterfaceFive;
import com.subhajit.funtional.interfaces.FunctionalInterfaceFour;
import com.subhajit.funtional.interfaces.FunctionalInterfaceOne;
import com.subhajit.funtional.interfaces.FunctionalInterfaceThree;
import com.subhajit.funtional.interfaces.FunctionalInterfaceTwo;

public class TestFunctionalInterface {

	public static void main(String[] args) {
		FunctionalInterfaceOne functionalInterfaceOne = () -> System.out.println("Hello World!!");
		functionalInterfaceOne.testMethodOne();

		
		FunctionalInterfaceTwo functionalInterfaceTwo = (name) -> System.out.println("Hello " + name);
		functionalInterfaceTwo.testMethodWithArgs("Subhajit");

		FunctionalInterfaceThree functionalInterfaceThree = (name, greetingMessage) -> System.out
				.println(greetingMessage + " - " + name);
		functionalInterfaceThree.testMethodWithMultiArgs("Subhajit", "Good Morning!!");

		FunctionalInterfaceFour functionalInterfaceFour = (a, b) -> a + b;
		System.out.println("Add 2 nos : " + functionalInterfaceFour.addTwoNumbers(4, 10));

		FunctionalInterfaceFive functionalInterfaceFive = (a, b) -> {
			int flag = a.compareTo(b);
			if (flag == 1)
				return a;
			else
				return b;
		};

		//FunctionalInterfaceFive functionalInterfaceFive = getBodyDefination();

		System.out.println("Comapre strings : " + functionalInterfaceFive.compareTwoStrings("Nibba", "Ziddi"));
		 

	}

	private static FunctionalInterfaceFive getBodyDefination() {
		return (a, b) -> {
			int flag = a.compareTo(b);
			if (flag == 1)
				return a;
			else
				return b;
		};
	}

}
