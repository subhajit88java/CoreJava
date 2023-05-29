package com.subhajit.clone.main;

import java.util.Arrays;

import com.subhajit.clone.model.Employee;

public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		//shallowClone();
		deepClone();
	}

	private static void deepClone() throws CloneNotSupportedException {
		Employee original = new Employee();
		original.setId(1);
		original.setSalary(10000L);
		original.setName("Subhajit");
		original.setSkills(Arrays.asList("Java", "Database", "Openshift"));
		
		System.out.println("original employee : " + original);
		System.out.println("original employee address : " + System.identityHashCode(original));
		System.out.println("original employee id address : " + System.identityHashCode(original.getId()));
		System.out.println("original employee salary address : " + System.identityHashCode(original.getSalary()));
		System.out.println("original employee name address : " + System.identityHashCode(original.getName()));
		System.out.println("original employee skills address : " + System.identityHashCode(original.getSkills()));
		System.out.println("-----------------------------------------------------");
		Employee clone = (Employee) original.clone();
		System.out.println("clone employee : " + clone);
		System.out.println("clone employee address : " + System.identityHashCode(clone));
		System.out.println("clone employee id address : " + System.identityHashCode(clone.getId()));
		System.out.println("clone employee salary address : " + System.identityHashCode(clone.getSalary()));
		System.out.println("clone employee name address : " + System.identityHashCode(clone.getName()));
		System.out.println("clone employee skills address : " + System.identityHashCode(clone.getSkills()));

	}

	private static void shallowClone() throws CloneNotSupportedException {
		Employee original = new Employee();
		original.setId(1);
		original.setSalary(10000L);
		original.setName("SUbhajit");
		original.setSkills(Arrays.asList("Java", "Database", "Openshift"));
		
		System.out.println("original employee : " + original);
		System.out.println("original employee address : " + System.identityHashCode(original));
		System.out.println("original employee id address : " + System.identityHashCode(original.getId()));
		System.out.println("original employee salary address : " + System.identityHashCode(original.getSalary()));
		System.out.println("original employee name address : " + System.identityHashCode(original.getName()));
		System.out.println("original employee skills address : " + System.identityHashCode(original.getSkills()));
		System.out.println("-----------------------------------------------------");
		Employee clone = (Employee) original.clone();
		System.out.println("clone employee : " + clone);
		System.out.println("clone employee address : " + System.identityHashCode(clone));
		System.out.println("clone employee id address : " + System.identityHashCode(clone.getId()));
		System.out.println("clone employee salary address : " + System.identityHashCode(clone.getSalary()));
		System.out.println("clone employee name address : " + System.identityHashCode(clone.getName()));
		System.out.println("clone employee skills address : " + System.identityHashCode(clone.getSkills()));

	}
}
