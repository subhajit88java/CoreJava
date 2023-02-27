package com.subhajit.singleton.main;

import com.subhajit.singleton.model.SingletonFive;
import com.subhajit.singleton.model.SingletonFour;
import com.subhajit.singleton.model.SingletonOne;
import com.subhajit.singleton.model.SingletonSix;
import com.subhajit.singleton.model.SingletonThree;
import com.subhajit.singleton.model.SingletonTwo;

public class TestSingleton {
	
	public static void main(String[] args) {
		//singletonOne();
		//singletonTwo();
		//singletonThree();
		//singletonFour();
		//singletonFive();
		singletonSix();
	}

	private static void singletonOne() {
		SingletonOne object1 = SingletonOne.getInstance();
		System.out.println("object1 address : " + System.identityHashCode(object1));
		SingletonOne object2 = SingletonOne.getInstance();
		System.out.println("object2 address : " + System.identityHashCode(object2));		
	}
	
	private static void singletonTwo() {
		SingletonTwo object1 = SingletonTwo.getInstance();
		System.out.println("object1 address : " + System.identityHashCode(object1));
		SingletonTwo object2 = SingletonTwo.getInstance();
		System.out.println("object2 address : " + System.identityHashCode(object2));		
	}
	
	private static void singletonThree() {
		SingletonThree object1 = SingletonThree.getInstance();
		System.out.println("object1 address : " + System.identityHashCode(object1));
		SingletonThree object2 = SingletonThree.getInstance();
		System.out.println("object2 address : " + System.identityHashCode(object2));		
	}
	
	private static void singletonFour() {
		SingletonFour object1 = SingletonFour.getInstance();
		System.out.println("object1 address : " + System.identityHashCode(object1));
		SingletonFour object2 = SingletonFour.getInstance();
		System.out.println("object2 address : " + System.identityHashCode(object2));		
	}
	
	private static void singletonFive() {
		SingletonFive object1 = SingletonFive.getInstance();
		System.out.println("object1 address : " + System.identityHashCode(object1));
		SingletonFive object2 = SingletonFive.getInstance();
		System.out.println("object2 address : " + System.identityHashCode(object2));		
	}
	
	private static void singletonSix() {
		SingletonSix object1 = SingletonSix.getInstance();
		System.out.println("object1 address : " + System.identityHashCode(object1));
		SingletonSix object2 = SingletonSix.getInstance();
		System.out.println("object2 address : " + System.identityHashCode(object2));		
	}


}
