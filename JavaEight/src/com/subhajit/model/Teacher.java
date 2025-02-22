package com.subhajit.model;

public class Teacher implements Comparable<Teacher>{

	private Integer id;
	private String name;
	private Integer salary;
	
	public Teacher(Integer id, String name, Integer salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "\nTeacher [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	 @Override
	 public int compareTo(Teacher teacher) {
		return this.getSalary().compareTo(teacher.getSalary());
	}

}
