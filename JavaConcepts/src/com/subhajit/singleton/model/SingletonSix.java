package com.subhajit.singleton.model;

// Bill Pugh
public class SingletonSix {
	
	private SingletonSix() {}
	
	private static class InnerSingletonSix{
		private static SingletonSix singletonSix = new SingletonSix();		
	}
	
	public static SingletonSix getInstance() {
		return InnerSingletonSix.singletonSix;
	}

}

//Pros :
//1. Though it is EAGER initializing but it will act as LAZY initializing as the inner class
// will not be loaded into memory when the outer class is loaded.
// It is when the getInstance is called, the inner class will be loaded into memory and
// the object will be created
//2. Exception handling
//3. Thread safe
//4.As no synchronization is present, performance is fast