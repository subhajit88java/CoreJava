package com.subhajit.singleton.model;

public class SingletonOne {
	
	private static SingletonOne singletonOne;
	
	private SingletonOne() {}
	
	public static SingletonOne getInstance() {
		if(singletonOne == null){
			singletonOne  = new SingletonOne();
		}
		return singletonOne;
	}

}

//Pros :
// 1. Lazy initializing
// 2. Exception handling

//Cons :
// 1. Non-thread safe

