package com.subhajit.jvm.main;

import java.util.ArrayList;

import com.subhajit.jvm.model.ChildTwo;


public class TestClassLoading {

	public static void main(String[] args) throws ClassNotFoundException {
		
		ClassLoader cl = ClassLoader.getPlatformClassLoader();
		Class c = cl.loadClass("java.lang.String");
		System.out.println("See : " + c.getClassLoader());
 }
}
