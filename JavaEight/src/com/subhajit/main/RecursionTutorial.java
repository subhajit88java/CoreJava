package com.subhajit.main;

public class RecursionTutorial {

	static int count = 0;
	public static void main(String[] args) {
		System.getProperties().forEach((k,v) ->{
			System.out.println(k + " : "+v);
		});
		String s ="India";
		//String output = func(s,++count); // cba
		//System.out.println("output : " + output);
	}
	
	static String func(String s, int count) {
		System.out.println("Input received for version : "+count + " is --> " + s);
		if(s.isEmpty()) //empty
			return s; // empty
		else {
			String temp = s.substring(1); // empty
			System.out.println("Going to call next version with : " + temp);
			 String returnValue = func(temp, ++count); // cb
			 System.out.println("Return value from previous call : " + returnValue);
			 return returnValue + s.charAt(0); // cb + a = cba
		}
	}
}
