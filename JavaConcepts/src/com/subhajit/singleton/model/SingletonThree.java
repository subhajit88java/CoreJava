package com.subhajit.singleton.model;

public class SingletonThree {
	
	private static SingletonThree singletonThree = new SingletonThree();
	
	private SingletonThree() {}
	
	public static SingletonThree getInstance() {
		return singletonThree;
	}
}

//Pros :
//1. Eager initializing
//2. Thread safe

//Cons :
//1. Resource wastage might happen.
//2. Booting of the project might get delayed if SingletonTwo initialization is complex
//3. Exception handling not possible


