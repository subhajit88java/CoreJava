package com.subhajit.singleton.model;

public class SingletonFour {
	
	private static SingletonFour singletonFour;
	
	private SingletonFour() {}
	
	public synchronized static SingletonFour getInstance() {
		if(singletonFour == null){
			singletonFour  = new SingletonFour();
		}
		return singletonFour;
	}

}

//Pros :
//1. Lazy initializing
//2. Exception handling
//3. Thread safe

//Cons :
//1. As method is synchronized, there will be unnecessarily performance issue, 
// because once the object is created there is no logically need for synchronization
// but threads have to wait
