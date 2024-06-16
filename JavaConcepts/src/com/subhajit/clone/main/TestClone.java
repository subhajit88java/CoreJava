package com.subhajit.clone.main;

import java.util.Arrays;

import com.subhajit.clone.model.Employee;
import com.subhajit.clone.model.EmployeeAddress;

public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		shallowClone();
		//deepClone();
	}

	private static void deepClone() throws CloneNotSupportedException {
		Employee original = new Employee();
		original.setId(150);
		original.setSalary(10000L);
		original.setName("Subhajit");
		original.setSkills(Arrays.asList("Java", "Database", "Openshift"));
		EmployeeAddress employeeAddressOriginal = new EmployeeAddress();
		employeeAddressOriginal.setAddress("Durgapur");
		
		original.setEmployeeAddress(employeeAddressOriginal);
		
		System.out.println("original employee : " + original);
		System.out.println("original employee address : " + System.identityHashCode(original));
		System.out.println("original employee id address : " + System.identityHashCode(original.getId()));
		System.out.println("original employee salary address : " + System.identityHashCode(original.getSalary()));
		System.out.println("original employee name address : " + System.identityHashCode(original.getName()));
		System.out.println("original employee skills address : " + System.identityHashCode(original.getSkills()));
		System.out.println("original employee employeeAddress address : " + System.identityHashCode(original.getEmployeeAddress()));
		System.out.println("original employee employeeAddress(address) address : " + System.identityHashCode(original.getEmployeeAddress().getAddress()));
		System.out.println("-----------------------------------------------------");
		Employee clone = (Employee) original.clone();
		System.out.println("clone employee : " + clone);
		System.out.println("clone employee address : " + System.identityHashCode(clone));
		System.out.println("clone employee id address : " + System.identityHashCode(clone.getId()));
		System.out.println("clone employee salary address : " + System.identityHashCode(clone.getSalary()));
		System.out.println("clone employee name address : " + System.identityHashCode(clone.getName()));
		System.out.println("clone employee skills address : " + System.identityHashCode(clone.getSkills()));
		System.out.println("clone employee employeeAddress address : " + System.identityHashCode(clone.getEmployeeAddress()));
		System.out.println("clone employee employeeAddress(address) address : " + System.identityHashCode(clone.getEmployeeAddress().getAddress()));
	}

	private static void shallowClone() throws CloneNotSupportedException {
		Employee original = new Employee();
		original.setId(1000);
		original.setSerialNo(128); // int datatype if having > 127 no is getting deep cloned
		original.setSalary(10000L);
		original.setName("Subhajit");
		original.setSkills(Arrays.asList("Java", "Database", "Openshift"));
		
		EmployeeAddress employeeAddressOriginal = new EmployeeAddress();
		employeeAddressOriginal.setAddress("Durgapur");
		
		original.setEmployeeAddress(employeeAddressOriginal);
		
		System.out.println("original employee : " + original);
		System.out.println("original employee address : " + System.identityHashCode(original));
		System.out.println("original employee id address : " + System.identityHashCode(original.getId()));
		System.out.println("original employee serial-no address : " + System.identityHashCode(original.getSerialNo()));
		System.out.println("original employee salary address : " + System.identityHashCode(original.getSalary()));
		System.out.println("original employee name address : " + System.identityHashCode(original.getName()));
		System.out.println("original employee skills address : " + System.identityHashCode(original.getSkills()));
		System.out.println("original employee employeeAddress address : " + System.identityHashCode(original.getEmployeeAddress()));
		System.out.println("original employee employeeAddress(address) address : " + System.identityHashCode(original.getEmployeeAddress().getAddress()));
		System.out.println("-----------------------------------------------------");
		Employee clone = (Employee) original.clone();
		System.out.println("clone employee : " + clone);
		System.out.println("clone employee address : " + System.identityHashCode(clone));
		System.out.println("clone employee id address : " + System.identityHashCode(clone.getId()));
		System.out.println("clone employee serial-no address : " + System.identityHashCode(original.getSerialNo()));
		System.out.println("clone employee salary address : " + System.identityHashCode(clone.getSalary()));
		System.out.println("clone employee name address : " + System.identityHashCode(clone.getName()));
		System.out.println("clone employee skills address : " + System.identityHashCode(clone.getSkills()));
		System.out.println("clone employee employeeAddress address : " + System.identityHashCode(clone.getEmployeeAddress()));
		System.out.println("clone employee employeeAddress(address) address : " + System.identityHashCode(clone.getEmployeeAddress().getAddress()));
	}
}
