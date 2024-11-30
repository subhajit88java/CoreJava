package com.subhajit.jvm.main;

import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.subhajit.jvm.model.ChildTwo;
import com.subhajit.jvm.model.NoClassDefFoundModel;
import com.subhajit.jvm.model.Subhajit;


public class TestClassLoading {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//classLoaderTypes();
		//generateClassNotFoundException();
		//generateClassDefNotFoundError();
		testSameClassFromDiffJars();
		
		System.exit(1);
		//ClassLoader cl = ClassLoader.getPlatformClassLoader();
		//Class c = cl.loadClass("java.lang.String");
		//System.out.println("See : " + c.getClassLoader());
 }

	private static void testSameClassFromDiffJars() {
		//Test test = new Test();
		//System.out.println("Test class loader : " + Test.class.getClassLoader());
		//test.method();
		
		try {
			Class c = Class.forName("com.subhajit.test.Test");
			Method m = c.getDeclaredMethod("method", null);
			m.invoke(c.newInstance(),null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void classLoaderTypes() {
		System.out.println("Subhajit class loader : " + Subhajit.class.getClassLoader());
		System.out.println("String class loader : " + java.lang.String.class.getClassLoader());
		System.out.println("DriverManager class loader : " + DriverManager.class.getClassLoader());
	}

	private static void generateClassDefNotFoundError() {
		// During compile time the class is present and it is successfully linked, but during runtime somehow the class is deleted
		// Steps to replicate : After compilation and generation of the .class file, go back and delete the .class file and rerun the project
		// Steps to remediate : Bring back the class at teh correct location and re-run 
		try {
			NoClassDefFoundModel model = new NoClassDefFoundModel();
			model.m();
		}catch(Throwable t) {
			t.printStackTrace();
		}
	}

	private static void generateClassNotFoundException() {
		// During runtime if the given class is missing then ClassNotFoundException happens
		// This exception also occurs when you have two class loaders and if a ClassLoader tries to access a class that is loaded by another classloader in Java
		// Steps to replicate : Load a class with wrong package name or with a random name
		// Steps to remediate : Rectify the package name or place a class with same class name in the classpath 
		try {
			Class.forName("com.subhajit.jvm.model.Subhajit");
			System.out.println("Class has been loaded");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
