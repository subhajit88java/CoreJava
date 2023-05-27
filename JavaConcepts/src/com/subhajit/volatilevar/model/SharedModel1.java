package com.subhajit.volatilevar.model;

public class SharedModel1 {
	
	public volatile int i = 0;

	@Override
	public String toString() {
		return "SharedModel1 [i=" + i + "]";
	}

	
}
