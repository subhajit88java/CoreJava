package com.subhajit.plain.interfaces;

public interface DefaultMethodInterface {
	
	default void getName() {
		System.out.println("Subhajit");
	}
	
	default void getMethod1() {
		System.out.println("getMethod1");
	}
	
	default void getMethod2() {
		System.out.println("getMethod2");
	}

}
