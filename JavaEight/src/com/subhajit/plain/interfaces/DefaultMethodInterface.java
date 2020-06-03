package com.subhajit.plain.interfaces;

public interface DefaultMethodInterface {
	
	default void getName() {
		System.out.println("Subhajit");
	}		

}
