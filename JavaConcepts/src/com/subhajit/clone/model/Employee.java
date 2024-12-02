package com.subhajit.clone.model;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable {

	private Integer id;
	private int serialNo;
	private Long salary;
	private String name;
	private List<String> skills;
	private EmployeeAddress employeeAddress;

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public EmployeeAddress getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(EmployeeAddress employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", serialNo=" + serialNo + ", salary=" + salary + ", name=" + name + ", skills="
				+ skills + ", employeeAddress=" + employeeAddress + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		// for shallow cloning
		return super.clone();
		
		// for deep cloning
		
		  //Employee emp = (Employee) super.clone(); 
		  //emp.setId(Integer.valueOf(this.id));
		  // if integer value ranges between -128 and 127 then Integer.valueOf() will
		  //not create any new Integer object, it will return the existing integer
		  //address 
		  //emp.setSalary(Long.valueOf(this.salary)); 
		  //emp.setName(new String(this.name)); 
		  //emp.setSkills(new ArrayList<String>(this.skills));
		  //EmployeeAddress employeeAddress = new EmployeeAddress();
		  //employeeAddress.setAddress(new String(this.employeeAddress.getAddress()));
		  //emp.setEmployeeAddress(employeeAddress); 
		  //return emp;	 
		
	}
}
