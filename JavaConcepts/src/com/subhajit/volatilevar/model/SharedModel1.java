package com.subhajit.volatilevar.model;

public class SharedModel1 {
	
	// Volatile keyword writes the variable value directly into main memory bypassing the thread-cache memory
	// It provides visibility but not atomicity
	public volatile int i = 0;

	@Override
	public String toString() {
		return "SharedModel1 [i=" + i + "]";
	}

	
}
