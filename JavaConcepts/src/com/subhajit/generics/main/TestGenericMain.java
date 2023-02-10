package com.subhajit.generics.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.subhajit.generics.inter.TestInterface;
import com.subhajit.generics.model.GenericModel1;
import com.subhajit.generics.model.GenericModel2;
import com.subhajit.generics.model.GenericModel3;
import com.subhajit.generics.model.Student;

public class TestGenericMain {

	public static void main(String[] args) {
		//testGenericClass();
		//testGenericMethod();
		//sortingGenericList();
		testGenericMethodWithInterface();
	}

	private static void testGenericMethodWithInterface() {
		
		testGenericMethodWithInterface(new GenericModel2());
		testGenericMethodWithInterface(new GenericModel3());
		
	}
	
	private static <T extends TestInterface>void testGenericMethodWithInterface(T object) {		
		object.printSomething();
	}

	private static void sortingGenericList() {
		List<String> listString = new ArrayList<>();
		listString.add("B");
		listString.add("A");
		listString.add("C");	
		sortingGenericList(listString);
		
		List<Student> listStudent = new ArrayList<>();
		listStudent.add(new Student(2, "Subhajit"));
		listStudent.add(new Student(1, "Asim"));
		listStudent.add(new Student(3, "Ram"));	
		
		sortingGenericList(listStudent);
	}

	private static void testGenericMethod() {
		Student s = new Student(1, "Subhajit");
		testGenericMethod(s);
	}

	private static void testGenericClass() {
		Student s = new Student(1, "Subhajit");
		GenericModel1<Integer, String, Student> genericModel1 = new GenericModel1<>(10, "ABCD", s);
		System.out.println(genericModel1);
		System.out.println(genericModel1.getField1() + " - " + genericModel1.getField2() + " -"
				+ genericModel1.getField3().getStudentName());
		genericModel1.showSomething();
	}

	public static <T> void testGenericMethod(T object) {
		System.out.println(object + " - " + object.getClass());

	}
	
	public static <T extends Comparable<T>> void sortingGenericList(List<T> list) {
		Collections.sort(list);
		System.out.println("Sorted list : " + list);

	}
	
	
}
