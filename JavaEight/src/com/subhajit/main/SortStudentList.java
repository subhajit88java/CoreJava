package com.subhajit.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.subhajit.comparators.StudentMarksComparator;
import com.subhajit.model.Student;

public class SortStudentList {

	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		
		studentList.add(new Student(1,"Subhajit", 75));
		studentList.add(new Student(2,"Asim", 90));
		studentList.add(new Student(3,"Suman", 65));
		studentList.add(new Student(4,"Ram", 80));
		studentList.add(new Student(5,"Sourav", 100));
		
		System.out.println(studentList);
		
		// Using a utility class that implements Comparator 
		/*
		 * Collections.sort(studentList, new StudentMarksComparator());
		 * System.out.println(studentList);
		 */
		
		// Defining Comparator interface body anonymously
		/*
		 * Collections.sort(studentList, new Comparator<Student>() {
		 * 
		 * @Override public int compare(Student student1, Student student2) { return
		 * student1.getMarks().compareTo(student2.getMarks()); }
		 * 
		 * });
		 * 
		 * System.out.println(studentList);
		 */

		// Defining Comparator interface body by Lambda Expression
		/*
		 * Collections.sort(studentList, (student1, student2) -> {return
		 * student1.getMarks().compareTo(student2.getMarks()); });
		 * System.out.println(studentList);
		 */
		
		// Defining Comparator interface body by Method Reference
		Collections.sort(studentList, new StudentMarksComparator() :: compare);
		System.out.println(studentList);
	}
}
