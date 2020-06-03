package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;

public class TestVisibilityOfvariableMain {

	static int a = 10;
	static List<Integer> intList = new ArrayList<>();
	
	public static void main(String[] args) {  
		
		intList.add(100);
		intList.add(200);
		intList.add(300);
		
		System.out.println("In main a = " + a + " - " + System.identityHashCode(a)+" - "+intList +" - "+System.identityHashCode(intList));
		func1(a, intList);
		System.out.println("In main(after return func1) a = " + a + " - " + System.identityHashCode(a)+" - "+intList +" - "+System.identityHashCode(intList));
		func2();
		System.out.println("In main(after return func2) a = " + a + " - " + System.identityHashCode(a)+" - "+intList +" - "+System.identityHashCode(intList));

	}

	

	private static void func1(int a, List<Integer> intList) {
		System.out.println("In func1 a = " + a + " - " + System.identityHashCode(a)+" - "+intList +" - "+System.identityHashCode(intList));
		a++;
		intList.set(1, 500);
		System.out.println("In func1(after upadte) a = " + a + " - " + System.identityHashCode(a)+" - "+intList +" - "+System.identityHashCode(intList));

	}
	
	private static void func2() {
		System.out.println("In func2 a = " + a + " - " + System.identityHashCode(a)+" - "+intList +" - "+System.identityHashCode(intList));
		a = 30;
		intList.set(1, 700);
		System.out.println("In func2(after upadte) a = " + a + " - " + System.identityHashCode(a)+" - "+intList +" - "+System.identityHashCode(intList));

	}
}
