package com.subhajit.singleton.model;

public class SingletonTwo {
	private static SingletonTwo singletonTwo;
	static {
		singletonTwo = new SingletonTwo();
	}
	private SingletonTwo() {}
	
	public static SingletonTwo getInstance() {
		return singletonTwo;
	}
}

//Pros :
//1. Eager initializing
//2. Exception handling
//3. Thread safe

//Cons :
//1. Resource wastage might happen.
// 2. Booting of the project might get delayed if SingletonTwo initialization is complex
