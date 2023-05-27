package com.subhajit.casestudy.model;

import java.util.Objects;

public class Model1 {
	
	private String college;
	private String course;
	private String name;
	
	public Model1(String college, String course, String name) {
		super();
		this.college = college;
		this.course = course;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Model1 [college=" + college + ", course=" + course + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(college, course);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model1 other = (Model1) obj;
		return Objects.equals(college, other.college) && Objects.equals(course, other.course);
	}
	
	

}
