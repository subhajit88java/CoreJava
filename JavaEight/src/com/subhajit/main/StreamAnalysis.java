package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.subhajit.model.Student;

public class StreamAnalysis {

	public static void main(String[] args) {
		/*
		 * List<String> testList = new ArrayList<>(); testList.add("Z");
		 * testList.add("A"); testList.add("Y"); testList.add("B"); testList.add("S");
		 * 
		 * System.out.println(testList);
		 * 
		 * 
		 * 
		 * String output = testList.stream().filter(string ->
		 * string.equalsIgnoreCase("A") ||
		 * string.equalsIgnoreCase("Z")).collect(Collectors.joining("-"));
		 * System.out.println(output);
		 */
		
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student(1,"Subhajit",70));
		studentList.add(new Student(2,"Asim",95));
		studentList.add(new Student(3,"Suman",65));
		studentList.add(new Student(4,"Sourav",99));
		studentList.add(new Student(5,"Ram",75));
		studentList.add(new Student(4,"Sourav",99));
		
		
		//SQL - Select * from T1
		List<Student> newList = studentList.stream().collect(Collectors.toList());
		System.out.println("SQL 1 : " + newList);
		
		//SQL - Select * from T1 where id=2
		newList = studentList.stream().filter(student -> student.getId() == 2 ).collect(Collectors.toList());
		System.out.println("SQL 2 : " + newList);
		
		//SQL - Select * from T1 where name like 'S%'
		newList = studentList.stream().filter(student -> student.getName().matches("S(.*)") ).collect(Collectors.toList());
		System.out.println("SQL 3 : " + newList);
		
		//SQL - Select * from T1 where marks > 70
		newList = studentList.stream().filter(student -> student.getMarks() > 70 ).collect(Collectors.toList());
		System.out.println("SQL 4 : " + newList);
		
		//SQL - Select * from T1 where name like 'S%' and marks > 70
		newList = studentList.stream().filter(student ->student.getName().matches("S(.*)")).filter(student -> student.getMarks() > 70 ).collect(Collectors.toList());
		System.out.println("SQL 5 : " + newList);
		
		//SQL - Select * from T1 where name like 'S%' or marks > 90
		newList = studentList.stream().filter(student ->student.getName().matches("S(.*)") || student.getMarks() > 90).collect(Collectors.toList());
		System.out.println("SQL 6 : " + newList);		
		
		//SQL - Select distinct * from T1 where name like 'S%' or marks > 90
		newList  = studentList.stream().distinct().collect(Collectors.toList());
		System.out.println("SQL 7 : " + newList);

		// Let's practise aggregate functions
		// SQL - Select count(*) from T1 where name like 'S%' or marks > 90
		long count = studentList.stream().filter(student -> student.getName().matches("S(.*)") || student.getMarks() > 90).count();
		System.out.println("SQL 8 : " + count);
			
		// SQL - Select sum(marks) from T1
		int sum = studentList.stream().mapToInt(student -> student.getMarks()).sum();
		System.out.println("SQL 9 : " + sum);
		
		// SQL - Select max(marks) from T1
		int maxmarks = studentList.stream().mapToInt(student -> student.getMarks()).max().getAsInt();
		System.out.println("SQL 10 : " + maxmarks);
		
		// SQL - Select min(marks) from T1
		int minmarks = studentList.stream().mapToInt(student -> student.getMarks()).min().getAsInt();
		System.out.println("SQL 10 : " + minmarks);
		
		// SQL - Select avg(marks) from T1
		double avg = studentList.stream().mapToInt(student -> student.getMarks()).average().getAsDouble();
		System.out.println("SQL 11 : " + avg);
		
		// SQL - Select to-upper(name) from T1
		newList  = studentList.stream().map(student -> {student.setName(student.getName().toUpperCase()); return student;}).collect(Collectors.toList());
		System.out.println("SQL 12 : " + newList);		
	}
	
	
}
