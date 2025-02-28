package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.subhajit.model.Student;
import com.subhajit.model.Teacher;
import com.subhajit.model.TeacherSalarySorter;

public class StreamAnalysis {

	public static void main(String[] args) {
		
		//testIntStream();
		testStreamOperations();
		//testSortingOverArrayListSingleField();
		testSortingOverArrayListMultiFields();
		//testSortingOverHashMap();
		//testSortingOverHashSet();
		//testMultiFieldSortingOverArrayList();
			
	}

	private static void testSortingOverArrayListMultiFields() {
		List<Teacher> teacherList = new ArrayList<>();
		
		teacherList.add(new Teacher(1,"Subhajit",70000));
		teacherList.add(new Teacher(2,"Asim",95000));
		teacherList.add(new Teacher(3,"Suman",70000));
		teacherList.add(new Teacher(4,"Sourav",70000));
		teacherList.add(new Teacher(5,"Ram",75000));
		System.out.println("Main List : " + teacherList);
		System.out.println("------------------------------------------------------");
		
		// Asc sorting by salary and name
		System.out.println("Asc sorting by salary and name : " + teacherList
				.stream()
				.sorted(Comparator
						.comparing(Teacher :: getSalary)
						.thenComparing(Teacher :: getName))
				.collect(Collectors.toList())
		);
		System.out.println("------------------------------------------------------");
		
		// Desc sorting by salary and name
		System.out.println("Desc sorting by salary and name : " + teacherList
				.stream()
				.sorted(Comparator
						.comparing(Teacher :: getSalary)
						.thenComparing(Teacher :: getName)
						.reversed())
				.collect(Collectors.toList())
		);
		
		// Asc sorting by salary and desc by name
		System.out.println("Asc sorting by salary and desc by name  : " + teacherList
				.stream()
				.sorted(Comparator
						.comparing(Teacher :: getSalary)
						.thenComparing(Teacher :: getName))
				.collect(Collectors.toList())
		);
		System.out.println("------------------------------------------------------");
				
	}

	private static void testSortingOverHashSet() {
		// TODO Auto-generated method stub
		
	}

	private static void testSortingOverHashMap() {
		// TODO Auto-generated method stub
		
	}

	private static void testMultiFieldSortingOverArrayList() {
		
		List<Teacher> teacherList = new ArrayList<>();
		
		teacherList.add(new Teacher(1,"Subhajit",70000));
		teacherList.add(new Teacher(2,"Asim",70000));
		teacherList.add(new Teacher(3,"Suman",99000));
		teacherList.add(new Teacher(4,"Sourav",99000));
		teacherList.add(new Teacher(5,"Ram",75000));
		
		System.out.println("Main List : " + teacherList);
		System.out.println("------------------------------------------------------");
		
		Comparator<Teacher> compByMarks = (teacher1, teacher2) -> {return teacher1.getSalary().compareTo(teacher2.getSalary());};
		Comparator<Teacher> compByName = (teacher1, teacher2) -> {return teacher1.getName().compareTo(teacher2.getName());};
		
		Stream<Teacher> teacherStream = teacherList.stream();
		System.out.println("Asc Order based on marks and name : " + teacherStream.sorted(compByMarks.thenComparing(compByName)).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");
		
		teacherStream = teacherList.stream();
		System.out.println("Asc Order based on marks and name : " + teacherStream.sorted(Comparator.comparing((Teacher teacher) -> teacher.getSalary()).thenComparing((Teacher teacher) -> teacher.getName())).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");
	
	}

	private static void testSortingOverArrayListSingleField() {
		
		List<Teacher> teacherList = new ArrayList<>();
		
		teacherList.add(new Teacher(1,"Subhajit",70000));
		teacherList.add(new Teacher(2,"Asim",95000));
		teacherList.add(new Teacher(3,"Suman",65000));
		teacherList.add(new Teacher(4,"Sourav",99000));
		teacherList.add(new Teacher(5,"Ram",75000));
		teacherList.add(new Teacher(6,"Sourav",99000));
		System.out.println("Main List : " + teacherList);
		System.out.println("------------------------------------------------------");
		
		// Ascending order sorting using dynamic comparator body
		// sorted() will take a user-defined anonymous Comparator body
		// Asc or Desc order will depend on the order of input objects used in comparison
		
		System.out.println("Asc order based on salary[Lambda expression] : " + teacherList.stream().sorted((teacher1, teacher2) -> {return teacher1.getSalary().compareTo(teacher2.getSalary());}).collect(Collectors.toList()));
		System.out.println("Asc order based on salary[Method reference] : " + teacherList.stream().sorted(new TeacherSalarySorter() :: sort).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");

		// Descending order sorting using dynamic comparator body
		// sorted() will take a user-defined anonymous Comparator body
		// Asc or Desc order will depend on the order of input objects used in comparison
		System.out.println("Desc order based on salary[Lambda expression] : " + teacherList.stream().sorted((teacher1, teacher2) -> {return teacher2.getSalary().compareTo(teacher1.getSalary());}).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");

		// Ascending order sorting using fixed Comparable logic
		// Comparable must be implemented by the object in comparison while calling Comparator.naturalOrder()
		// Natural Order means, the sorting will be as per the logic written in CompareTo method after implementing Comparable interface
		// Type 1
		System.out.println("Asc Order based on salary : " + teacherList.stream().sorted().collect(Collectors.toList()));
		// Type 2
		System.out.println("Asc Order based on salary : " + teacherList.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");

		// Descending order sorting using fixed Comparable logic
		// Comparable must be implemented by the object in comparison while calling Comparator.reverseOrder()
		// Reverse Order means, the sorting will be exactly the reverse of the logic written in CompareTo method after implementing Comparable interface
		// Type 1
		System.out.println("Reverse Order based on salary : " + teacherList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		// Type 2
		//System.out.println("Reverse Order based on salary : " + teacherList.stream().sorted(Comparator.naturalOrder().reversed()).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");

		// Ascending order sorting using dynamic Comparable field, that will be used for Comparison
		// We know that when Comparable interface is implemented, the body definition of compareTo method will be fixed 
		// i.e the body can't be changed by the caller class/method based on requirement
		// With the help of Comparator.comparing(keyExtractor), we can use dynamic Comparable field provided by the caller class/method 
		// That dynamic key will be used during comparison(default comparison will be in Asc. order)
		// No need to implement Comparable Interface here
		// Type 1
		System.out.println("Aesc based on salary [Labmda expression] : " + teacherList.stream().sorted(Comparator.comparing((Teacher teacher) -> teacher.getSalary())).collect(Collectors.toList()));
		// Type 2
		System.out.println("Aesc based on salary [Method reference] : " + teacherList.stream().sorted(Comparator.comparing(Teacher :: getSalary)).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");

		// Descending order sorting using dynamic Comparable field along with  the dynamic Comparator body related to that field 
		// We know that when Comparable interface is implemented, the body definition of compareTo method will be fixed 
		// i.e the body can't be changed by the caller class/method based on requirement
		// With the help of Comparator.comparing(keyExtractor, keyComparator), we can use dynamic Comparable field provided by the caller class/method, as well as the Comparator logic associated with that field 
		// That dynamic key will be used during comparison(comparison will depend over the dynamic comparator body defined)
		// No need to implement Comparable Interface here		
		// Type 1
		System.out.println("Desc based on salary and downstream comparator [lambda expression] : " + teacherList.stream().sorted(Comparator.comparing((Teacher teacher) -> teacher.getSalary(), (salary1, salary2) -> {return salary1.compareTo(salary2);})).collect(Collectors.toList()));
		// Type 2
		System.out.println("Desc based on salary [lambda expression] : " + teacherList.stream().sorted(Comparator.comparing((Teacher teacher) -> teacher.getSalary()).reversed()).collect(Collectors.toList()));
		// Type 3
		//System.out.println("Desc based on salary [method reference] : " + teacherStream.sorted(Comparator.comparing(Teacher :: getSalary).reversed()).collect(Collectors.toList()));
		
		System.out.println("------------------------------------------------------");

		// Descending order sorting using dynamic Comparable field, that will be used for Comparison
		// We know that when Comparable interface is implemented, the body definition of compareTo method will be fixed 
		// i.e the body can't be changed by the caller class/method based on requirement
		// With the help of Comparator.comparing(), we can use dynamic Comparable field provided by the caller class/method 
		// That dynamic key will be used during comparison(default comparison will be in Asc. order), reversed() method calling will reverse the list
		// No need to implement Comparable Interface here
		System.out.println("Desc based on id : " + teacherList.stream().sorted(Comparator.comparing((Teacher teacher) -> teacher.getId()).reversed()).collect(Collectors.toList()));
		System.out.println("------------------------------------------------------");
		
		// Dealing with null objects
		teacherList.add(null);
		teacherList.add(null);
		
		System.out.println("Null first aesc based on salary : " + teacherList.stream().sorted(Comparator.nullsFirst((teacher1, teacher2) -> {return teacher1.getSalary().compareTo(teacher2.getSalary());})).collect(Collectors.toList()));
	
		System.out.println("Null last aesc based on salary : " + teacherList.stream().sorted(Comparator.nullsLast((teacher1, teacher2) -> {return teacher1.getSalary().compareTo(teacher2.getSalary());})).collect(Collectors.toList()));
		
		// Dealing with null field on the basis of which sorting has to be done
		teacherList.add(new Teacher(6,"Debojit",null));
		
		System.out.println("------------------------------------------------------");
		// Aesc sorting if one of the class level field is null
		// Type 1
		System.out.println("[Type 1] Asc based on salary as null : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.comparing(Teacher :: getSalary, 
								Comparator.nullsFirst((Integer salary1, Integer salary2) -> {return salary1.compareTo(salary2);})))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
		
		// Type 2
		System.out.println("[Type 2] Asc based on salary as null : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.comparing(Teacher :: getSalary, 
								Comparator.nullsFirst(Comparator.naturalOrder())))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
		
		// Type 3
		System.out.println("[Type 3] Asc based on salary as null : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.comparing((Teacher teacher) -> teacher.getSalary(), 
								Comparator.nullsFirst(Comparator.naturalOrder())))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
		
		// Type 1
		System.out.println("[Type 1] Desc based on salary as null : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.comparing(Teacher :: getSalary, 
								Comparator.nullsFirst((Integer salary1, Integer salary2) -> {return salary2.compareTo(salary1);})))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
				
		// Type 2
		System.out.println("[Type 2] Desc based on salary as null : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.comparing(Teacher :: getSalary, 
								Comparator.nullsFirst(Comparator.reverseOrder())))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
				
		// Type 3
		System.out.println("[Type 3] Desc based on salary as null : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.comparing((Teacher teacher) -> teacher.getSalary(), 
								Comparator.nullsFirst(Comparator.reverseOrder())))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
		
		
		// Dealing with null objects in the list as well as class level variable as null based on which sorting has to be done
		System.out.println("Asc based on salary as null as well as null object in the list : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.nullsFirst(Comparator
								.comparing(Teacher :: getSalary, 
										Comparator
										.nullsFirst(Comparator.naturalOrder()))))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
		
		System.out.println("Desc based on salary as null as well as null object in the list : " + 
				teacherList
				.stream()
				.sorted(Comparator
						.nullsFirst(Comparator
								.comparing(Teacher :: getSalary, 
										Comparator
										.nullsFirst(Comparator.reverseOrder()))))
				.collect(Collectors.toList()));	
		System.out.println("------------------------------------------------------");
		
	}

	private static void testStreamOperations() {
		
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
		
		//SQL - Select distinct * from T1 
		newList  = studentList.stream().distinct().collect(Collectors.toList());
		System.out.println("SQL 7 : " + newList);

		// Let's Practice aggregate functions
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
		double avg = studentList.stream().mapToInt(student -> {return student.getMarks();}).average().getAsDouble();
		System.out.println("SQL 11 : " + avg);
		
		// SQL - Select to-upper(name) from T1
		newList  = studentList.stream().map(student -> {student.setName(student.getName().toUpperCase()); return student;}).collect(Collectors.toList());
		System.out.println("SQL 12 : " + newList);	
		
	}

	private static void testIntStream() {
		
		//Stream<Integer> streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		Stream<Integer> streamOfInteger = Stream.of(Integer.valueOf(10),
				Integer.valueOf(30),
				Integer.valueOf(50),
				Integer.valueOf(20),
				Integer.valueOf(30),
				Integer.valueOf(40),
				Integer.valueOf(10));

		System.out.println("Max : " + streamOfInteger.max((int1,int2) -> {return int1.compareTo(int2);}).get());
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		System.out.println("Min : " + streamOfInteger.min((int1,int2) -> {return int1.compareTo(int2);}).get());
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		System.out.println("Count : " + streamOfInteger.count());
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		System.out.println("Average : " + streamOfInteger.mapToInt(Integer::valueOf).average().getAsDouble());
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		System.out.println("Distinct : " + streamOfInteger.distinct().collect(Collectors.toList()));
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		System.out.println("Asc Sorted : " + streamOfInteger.sorted().collect(Collectors.toList()));
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		System.out.println("Desc Sorted 1 : " + streamOfInteger.sorted((int1,int2) -> {return int2.compareTo(int1);}).collect(Collectors.toList()));
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);
		System.out.println("Desc Sorted 2 : " + streamOfInteger.sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		streamOfInteger = Stream.of(10,30,50,20,30,40,10);		
		System.out.println("Limit : " + streamOfInteger.limit(3).collect(Collectors.toList()));
		System.out.println("-----------------------------------------------------------------------------");
		
		IntStream intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Max : " + intStream.max().getAsInt());
		intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Min : " + intStream.min().getAsInt());
		intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Count : " + intStream.count());
		intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Average : " + intStream.average().getAsDouble());
		intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Distinct : " + intStream.distinct().boxed().collect(Collectors.toList()));
		intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Asc Sorted : " + intStream.sorted().boxed().collect(Collectors.toList()));		
		intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Desc Sorted : " + intStream.boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));		
		intStream = IntStream.of(10,30,50,20,30,40,10);
		System.out.println("Limit : " + intStream.limit(3).boxed().collect(Collectors.toList()));
		System.out.println("-----------------------------------------------------------------------------");

	}
	
	
}
