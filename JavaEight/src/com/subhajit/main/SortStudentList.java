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

		studentList.add(new Student(1, "Subhajit", 75));
		studentList.add(new Student(2, "Asim", 90));
		studentList.add(new Student(3, "Suman", 65));
		studentList.add(new Student(4, "Ram", 80));
		studentList.add(new Student(5, "Sourav", 100));

		System.out.println("Unsorted : " + studentList);

		// Using a utility class that implements Comparator
		usingUtilityClass(studentList);

		// Defining Comparator interface body anonymously
		usingAnonymousBody(studentList);

		// Defining Comparator interface body by Lambda Expression
		usingLambdaExp(studentList);

		// Defining Comparator interface body by Method Reference
		usingMethodRef(studentList);

	}

	private static void usingMethodRef(List<Student> studentList) {

		Collections.sort(studentList, new StudentMarksComparator()::compare);
		System.out.println("Asc sorting on Marks : " + studentList);
	}

	private static void usingLambdaExp(List<Student> studentList) {

		Collections.sort(studentList, (student1, student2) -> {
			return student1.getMarks().compareTo(student2.getMarks());
		});
		System.out.println("Asc sorting on Marks : " + studentList);

	}

	private static void usingAnonymousBody(List<Student> studentList) {

		Collections.sort(studentList, new Comparator<Student>() {

			@Override
			public int compare(Student student1, Student student2) {
				return student1.getMarks().compareTo(student2.getMarks());
			}

		});

		System.out.println("Asc sorting on Marks : " + studentList);

	}

	private static void usingUtilityClass(List<Student> studentList) {

		Collections.sort(studentList, new StudentMarksComparator());
		System.out.println("Asc sorting on Marks : " + studentList);

	}
}
