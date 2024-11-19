package com.subhajit.utility;

public class UseMyMethodOne {
	
	public UseMyMethodOne(){
		System.out.println("Constructer.....");
	}
	
	public static void method1(String name) {
		System.out.println("Hello : " + name);
	}
	
	public String method2() {
		System.out.println("method2 : ");
		return null;
	}
	
	public int addM(int a, int b) {
		return a+b;
	}
	
	public void testMethodSignature(String arg) {
		System.out.println("testMethodSignature");
	}

}
