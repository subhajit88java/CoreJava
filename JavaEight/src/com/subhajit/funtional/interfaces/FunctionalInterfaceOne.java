package com.subhajit.funtional.interfaces;

@FunctionalInterface
public interface FunctionalInterfaceOne {
	public void testMethodOne();
	//public void testMethodTwo();
}

// NB : If we mention @FunctionalInterface over any interface 
// and declare multiple abstract methods, there will be compilation error
