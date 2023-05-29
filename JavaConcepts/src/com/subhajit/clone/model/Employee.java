package com.subhajit.clone.model;

import java.util.ArrayList;
import java.util.List;

public class Employee implements Cloneable{

	private int id;
	private Long salary;
	private String name;
	private List<String> skills;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", skills=" + skills + "]";
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		// for shallow cloning
		//return super.clone();
		
		// for deep cloning
		Employee emp = (Employee) super.clone();
		emp.setId(Integer.valueOf(this.id));
		emp.setSalary(Long.valueOf(this.salary));
		emp.setName(new String(this.name));
		emp.setSkills(new ArrayList<String>(this.skills));
		return emp;
		
	}
}
