package com.subhajit.singleton.model;

// Double check locking
public class SingletonFive {
	
	private static SingletonFive singletonFive;
	
	private SingletonFive() {}
	
	public static SingletonFive getInstance() {
		if(singletonFive == null){
			synchronized (SingletonFive.class) {
				if(singletonFive == null)
					singletonFive  = new SingletonFive();
			}
			
		}
		return singletonFive;
	}
}

//Pros :
//1. Lazy initializing
//2. Exception handling
//3. Thread safe
//4. Due to the implementation of class level synchronization under conditional if, 
// after the object is created, threads need not to wait to get the object 

