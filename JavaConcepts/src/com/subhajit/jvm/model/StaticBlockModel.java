package com.subhajit.jvm.model;

public class StaticBlockModel {
	
	static Integer val = 10;
	
	static {
		val = 20;
		System.out.println("static block 1");
	}
	
	static {
		val = 30;
		System.out.println("static block 2");
	}
	
	public static void m() {
		System.out.println("val : " + val);
	}

}
