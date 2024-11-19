package com.subhajit.model;


public class TeacherSalarySorter {

	public int sort(Teacher o1, Teacher o2) {
		return o1.getSalary().compareTo(o2.getSalary());
	}

}
