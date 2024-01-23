package com.subhajit.immutable.main;

import java.util.ArrayList;
import java.util.List;

import com.subhajit.immutable.model.BreakImmutableOne;
import com.subhajit.immutable.model.BreakImmutableThree;
import com.subhajit.immutable.model.BreakImmutableThreeChild;
import com.subhajit.immutable.model.BreakImmutableTwo;

public class TestImmutable {

	public static void main(String[] args) {
		breakImmutableOne();
		//breakImmutableTwo();
		//breakImmutableThree();
		breakImmutableFour();
	}

	private static void breakImmutableOne() {
		
		Integer integerValue = 10;
		String stringValue = "ABCDE";
		
		// injecting listOfString from outside
		List<String> listOfString = new ArrayList<>();
		listOfString.add("A");
		listOfString.add("B");
		listOfString.add("C");
		System.out.println("listOfString address at main class : " + System.identityHashCode(listOfString));

		
		BreakImmutableOne breakImmutableOne = new BreakImmutableOne(integerValue, stringValue, listOfString);
		System.out.println("breakImmutableOne : " + breakImmutableOne);
		System.out.println("breakImmutableOne address : " + System.identityHashCode(breakImmutableOne));
		System.out.println("listOfString address within BreakImmutableOne : " + System.identityHashCode(breakImmutableOne.getListOfString()));

		// modifying listOfString from outside
		listOfString.add("D");
		System.out.println("breakImmutableOne : " + breakImmutableOne);
		System.out.println("listOfString address after modification : " + System.identityHashCode(breakImmutableOne.getListOfString()));

		// To resolve this let us design BreakImmutableTwo
	}
	
	private static void breakImmutableTwo() {
		
		Integer integerValue = 10;
		String stringValue = "ABCDE";
		
		// injecting listOfString from outside
		List<String> listOfString = new ArrayList<>();
		listOfString.add("A");
		listOfString.add("B");
		listOfString.add("C");
		System.out.println("listOfString address at main class : " + System.identityHashCode(listOfString));
		
		BreakImmutableTwo breakImmutableTwo = new BreakImmutableTwo(integerValue, stringValue, listOfString);
		System.out.println("breakImmutableTwo : " + breakImmutableTwo);
		System.out.println("breakImmutableTwo address : " + System.identityHashCode(breakImmutableTwo));
		System.out.println("listOfString address within BreakImmutableTwo : " + System.identityHashCode(breakImmutableTwo.getListOfString()));

		// modifying listOfString from outside, but the listOfString within breakImmutableTwo will not be changed
		listOfString.add("D");
		System.out.println("breakImmutableTwo : " + breakImmutableTwo);
		System.out.println("listOfString address after 1st modification : " + System.identityHashCode(breakImmutableTwo.getListOfString()));

		// now lets break this wall
		breakImmutableTwo.getListOfString().add("E");
		System.out.println("breakImmutableTwo : " + breakImmutableTwo);
		System.out.println("listOfString address after 2nd modification : " + System.identityHashCode(breakImmutableTwo.getListOfString()));

		// To resolve this let us design BreakImmutableThree
	}

	private static void breakImmutableThree() {
		
		Integer integerValue = 10;
		String stringValue = "ABCDE";
		
		// injecting listOfString from outside
		List<String> listOfString = new ArrayList<>();
		listOfString.add("A");
		listOfString.add("B");
		listOfString.add("C");
		System.out.println("listOfString address at main class : " + System.identityHashCode(listOfString));
		
		BreakImmutableThree breakImmutableThree = new BreakImmutableThree(integerValue, stringValue, listOfString);
		System.out.println("breakImmutableThree : " + breakImmutableThree);
		System.out.println("breakImmutableThree address : " + System.identityHashCode(breakImmutableThree));
		System.out.println("listOfString address within BreakImmutableThree : " + System.identityHashCode(breakImmutableThree.getListOfString()));

		// modifying listOfString from outside, but the listOfString within breakImmutableThree will not be changed
		listOfString.add("D");
		System.out.println("breakImmutableThree : " + breakImmutableThree);
		System.out.println("listOfString address after 1st modification : " + System.identityHashCode(breakImmutableThree.getListOfString()));

		// now lets try break this wall
		// but this wall can't be broken as getter will return new list this time
		breakImmutableThree.getListOfString().add("E");
		System.out.println("breakImmutableThree : " + breakImmutableThree);
		System.out.println("listOfString address after 2nd modification : " + System.identityHashCode(breakImmutableThree.getListOfString()));

		// now lets again try break this wall through BreakImmutableThree child class
	}
	
	private static void breakImmutableFour() {
		
		Integer integerValue = 10;
		String stringValue = "ABCDE";
		
		// injecting listOfString from outside
		List<String> listOfString = new ArrayList<>();
		listOfString.add("A");
		listOfString.add("B");
		listOfString.add("C");
		System.out.println("listOfString address at main class : " + System.identityHashCode(listOfString));
		
		BreakImmutableThree breakImmutableThree = new BreakImmutableThreeChild(integerValue, stringValue, listOfString);
		System.out.println("breakImmutableThree(child) : " + breakImmutableThree);
		System.out.println("breakImmutableThree(child) address : " + System.identityHashCode(breakImmutableThree));
		System.out.println("listOfString address within BreakImmutableThree(child) : " + System.identityHashCode(breakImmutableThree.getListOfString()));

		// modifying listOfString from outside
		listOfString.add("D");
		System.out.println("breakImmutableThree(child) : " + breakImmutableThree);
		System.out.println("listOfString address after 1st modification : " + System.identityHashCode(breakImmutableThree.getListOfString()));

		// again modifying the listOfString from outside
		breakImmutableThree.getListOfString().add("E");
		System.out.println("breakImmutableThree(child) : " + breakImmutableThree);
		System.out.println("listOfString address after 2nd modification : " + System.identityHashCode(breakImmutableThree.getListOfString()));

		// This is "SEEMINGLY" breaking of immutability of BreakImmutableThree. Not real.
		// One can sabotage the code by passing the BreakImmutableThreeChild and letting the BreakImmutableThreeChild's version of listOfString to be modified
		
		// To resolve this, BreakImmutableThreeChild should be made as final to avoid inheritance
	}
	
}

