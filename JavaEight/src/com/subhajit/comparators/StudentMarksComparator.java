package com.subhajit.comparators;

import java.util.Comparator;

import com.subhajit.model.Student;

public class StudentMarksComparator implements Comparator<Student>{

	@Override
	public int compare(Student student1, Student student2) {
		return student1.getMarks().compareTo(student2.getMarks());
	}

}
