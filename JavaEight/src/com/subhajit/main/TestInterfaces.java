package com.subhajit.main;

import com.subhajit.funtional.interfaces.FunctionalInterfaceFour;
import com.subhajit.utility.ImplementInterface;

public class TestInterfaces {

	public static void main(String[] args) {
		FunctionalInterfaceFour obj1 = new ImplementInterface();
		System.out.println("Result : " + obj1.addTwoNumbers(10, 20));
		
		
		FunctionalInterfaceFour obj2 = new FunctionalInterfaceFour() {

			@Override
			public int addTwoNumbers(int a, int b) {
				return a + b;
			}
			
		};
				
		System.out.println("Result : " + obj2.addTwoNumbers(10, 20));
		
		  FunctionalInterfaceFour obj3 = (a, b) -> { return a + b; };
		  System.out.println("Result : " + obj3.addTwoNumbers(10, 20));
		 

	}
}



