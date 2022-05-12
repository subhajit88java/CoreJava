package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.subhajit.model.Student;
import com.subhajit.model.StudentMarks;

public class TestMapFlatmap {

	public static void main(String[] args) {

		//test1MapWithUserDefObject();
		//test2MapWithUserDefObject();
		test2FlatMapWithUserDefObject();
		//test1MapToIntWithUserDefObject();

		/*
		 * List<String> listString = Arrays.asList("1", "2", "3", "4", "5");
		 * System.out.println(listString);
		 * 
		 * List<Integer> listInteger =
		 * listString.stream().map(Integer::valueOf).collect(Collectors.toList());
		 * System.out.println(listInteger);
		 * 
		 * List<String> listString1 = Arrays.asList("1", "2", "3"); List<String>
		 * listString2 = Arrays.asList("4", "5", "6"); List<String> listString3 =
		 * Arrays.asList("7", "8");
		 * 
		 * Stream<List<String>> streamString = Stream.of(listString1, listString2,
		 * listString3);
		 * 
		 * List<Integer> combinedList = streamString.flatMap(stream ->
		 * stream.stream()).map(Integer::valueOf) .collect(Collectors.toList());
		 * System.out.println(combinedList);
		 */

	}

	private static void test2FlatMapWithUserDefObject() {
		
		Student student1 = new Student(1, "Subhajit", 78);
		Student student2 = new Student(2, "Asim", 97);
		Student student3 = new Student(3, "Ram", 56);
		Student student4 = new Student(4, "Suman", 70);
		Student student5 = new Student(5, "Sourav", 98);
		Student student6 = new Student(6, "Ganesh", 67);
		Student student7 = new Student(7, "Raja", 85);
		

		List<Student> studentList1 = new ArrayList<>();
		studentList1.add(student1);
		studentList1.add(student2);
		studentList1.add(student3);

		List<Student> studentList2 = new ArrayList<>();
		studentList2.add(student4);
		studentList2.add(student5);

		List<Student> studentList3 = new ArrayList<>();
		studentList3.add(student6);
		studentList3.add(student7);

		List<List<Student>> masterList = new ArrayList<>();
		masterList.add(studentList1);
		masterList.add(studentList2);
		masterList.add(studentList3);

		System.out.println("masterList : " + masterList);

		System.out.println("Test case 1, converting Stream of List<Student> object to Stream of Sudent and collecting in List<Student>");
		Stream<List<Student>> streamOfListOfStudent = masterList.stream(); // Stream[studentList1,studentList2,studentList3]
				
		Stream<Student> streamOfStudent = streamOfListOfStudent.flatMap(studentList -> {
			return studentList.stream();
		}); // Returns Stream[student1,student2,student3,student4,student5,student6,student7]

		List<Student> studentListFinal = streamOfStudent.map(studentObj -> {
			studentObj.setName("Mr. " + studentObj.getName());
			return studentObj;
		}).collect(Collectors.toList());

		System.out.println("studentListFinal : " + studentListFinal);
		
	}

	private static void test1MapToIntWithUserDefObject() {
		
		// 1. IntStream, LongStream and DoubleStream are for primitive types int, long and double resp.
		// 2. boxing means primitive to wrapper
		// 3. unboxing means wrapper to primitive
		
		Student student1 = new Student(1, "Subhajit", 78);
		Student student2 = new Student(2, "Asim", 97);
		Student student3 = new Student(3, "Ram", 56);
		Student student4 = new Student(4, "Suman", 70);
		Student student5 = new Student(5, "Sourav", 98);

		List<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);

		System.out.println("studentList : " + studentList);

		System.out.println("Test case 1, converting Stream of Student object to IntStream and collecting in List<Integer>");
		Stream<Student> studentStream = studentList.stream(); // Stream[student1,student2,student3,student4,student5]
		IntStream marksStream = studentStream.mapToInt(studentObj -> {return studentObj.getMarks();}); // IntStream of primitive type int
		
		Stream<Integer> studentMarksStream = marksStream.boxed(); // IntStream boxed to Stream<Integer>
		List<Integer> studentMarksList = studentMarksStream.collect(Collectors.toList());
		
		System.out.println("studentMarksList : " + studentMarksList);
		System.out.println("-------------------------------------------------------------------------");
		
		System.out.println("Test case 2, converting Stream of Student object to IntStream and collecting in List<Integer>");
		studentStream = studentList.stream(); // Stream[student1,student2,student3,student4,student5]
		marksStream = studentStream.mapToInt(studentObj -> {return studentObj.getMarks();}); // IntStream of primitive type int
		
		studentMarksStream = marksStream.mapToObj(Integer::valueOf);
		studentMarksList = studentMarksStream.collect(Collectors.toList());
		
		System.out.println("studentMarksList : " + studentMarksList);
		System.out.println("-------------------------------------------------------------------------");
				

	}

	private static void test2MapWithUserDefObject() {

		Student student1 = new Student(1, "Subhajit", 78);
		Student student2 = new Student(2, "Asim", 97);
		Student student3 = new Student(3, "Ram", 56);
		Student student4 = new Student(4, "Suman", 70);
		Student student5 = new Student(5, "Sourav", 98);
		Student student6 = new Student(6, "Ganesh", 67);
		Student student7 = new Student(7, "Raja", 85);
		

		List<Student> studentList1 = new ArrayList<>();
		studentList1.add(student1);
		studentList1.add(student2);
		studentList1.add(student3);

		List<Student> studentList2 = new ArrayList<>();
		studentList2.add(student4);
		studentList2.add(student5);

		List<Student> studentList3 = new ArrayList<>();
		studentList3.add(student6);
		studentList3.add(student7);

		List<List<Student>> masterList = new ArrayList<>();
		masterList.add(studentList1);
		masterList.add(studentList2);
		masterList.add(studentList3);

		System.out.println("masterList : " + masterList);

		System.out.println("Test case 1, converting Stream of List<Student> object to Stream of STudent and collecting in List<Student>");
		Stream<List<Student>> streamOfListOfStudent = masterList.stream(); // Stream[studentList1,studentList2,studentList3]
		List<Student> studentListFinal = new ArrayList<>();

		Stream<Integer> intList = streamOfListOfStudent.map(studentList -> {
			studentList.forEach(studentObj -> {
				studentObj.setName("Mr. " + studentObj.getName());
				studentListFinal.add(studentObj);
			});
			return 1;
		}); // returning 1 and intList is used as dummy just to fill the syntax
		List<Integer> temp = intList.collect(Collectors.toList()); // Collection is must, otherwise any stream operation will not work
		System.out.println("studentListFinal : " + studentListFinal);
		System.out.println("-------------------------------------------------------------------------");
		
		
		System.out.println("Test case 2, converting Stream of List<Student> object to Stream of List<Student> and collecting in List<List<Student>>");
		streamOfListOfStudent = masterList.stream(); // Stream[studentList1,studentList2,studentList3]
		Stream<List<Student>> streamOfListOfStudentTemp = streamOfListOfStudent.map(studentList -> {
			List<Student> innerList = studentList.stream().map(studentObj -> {
				studentObj.setName("Mr. " + studentObj.getName());
				return studentObj;
			}).collect(Collectors.toList());
			return innerList;
		});

		System.out.println("streamOfListOfStudentTemp : " + streamOfListOfStudentTemp.collect(Collectors.toList()));
		System.out.println("-------------------------------------------------------------------------");

		System.out.println("Test case 3, converting Stream of List<Student> object to Stream of List<Student> and collecting in List<List<Student>>");
		streamOfListOfStudent = masterList.stream(); // Stream[studentList1,studentList2,studentList3]
		Stream<Stream<Student>> streamOfStreamOfStudent = streamOfListOfStudent.map(studentList -> {
			return studentList.stream();
		});

		Stream<List<Student>> streamListOfStudent = streamOfStreamOfStudent.map(studentStream -> {
			return studentStream.collect(Collectors.toList());
		});

		System.out.println("studentListFinal : " + streamListOfStudent.collect(Collectors.toList()));
		System.out.println("-------------------------------------------------------------------------");

		/*
		 * List<Student> test = studentList1.stream().flatMap(studentObj -> { return
		 * Stream.of(studentObj); }).collect(Collectors.toList());
		 * 
		 * List<Stream<Student>> test = studentList1.stream().map(studentObj -> { return
		 * Stream.of(studentObj); }).collect(Collectors.toList());
		 * 
		 * Stream<List<Student>> temp = test.stream().map(studentStream -> { return
		 * studentStream.collect(Collectors.toList()); });
		 * System.out.println(temp.collect(Collectors.toList()));
		 */
	}

	private static void test1MapWithUserDefObject() {

		Student student1 = new Student(1, "Subhajit", 78);
		Student student2 = new Student(2, "Asim", 97);
		Student student3 = new Student(3, "Ram", 56);
		Student student4 = new Student(4, "Suman", 70);
		Student student5 = new Student(5, "Sourav", 98);

		List<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);

		System.out.println("studentList : " + studentList);

	
		System.out.println("Test case 1, converting Stream of Student object to Stream of the same student object");
		Stream<Student> studentStreamList = studentList.stream(); // Stream[student1,student2,student3,student4,student5]
		Stream<Student> studentStreamMrList = studentStreamList.map(studentObj -> {			
			studentObj.setName("Mr. " + studentObj.getName());
			return studentObj;
		}); // Returns Stream[student1,student2,student3,student4,student5]
		
		List<Student> studentListFinal = studentStreamMrList.collect(Collectors.toList());

		System.out.println("studentListFinal : " + studentListFinal);
		System.out.println("-------------------------------------------------------------------------");
		
		System.out.println("Test case 2, converting Stream of Student object to Stream of the Integer");
		studentStreamList = studentList.stream(); // Stream[student1,student2,student3,student4,student5]
		Stream<Integer> marksStream = studentStreamList.map(studentObj -> {			
			return studentObj.getMarks();
		}); // Returns Stream[Integer,Integer,Integer,Integer,Integer]
		
		List<Integer> studentMarksList = marksStream.collect(Collectors.toList());

		System.out.println("studentMarksList : " + studentMarksList);
		System.out.println("-------------------------------------------------------------------------");
		
		System.out.println("Test case 3, converting Stream of Student object to Stream of StudentMarks object");
		studentStreamList = studentList.stream(); // Stream[student1,student2,student3,student4,student5]
		Stream<StudentMarks> studentMarksStream = studentStreamList.map(studentObj -> {			
			Supplier<StudentMarks> supplier = () -> {return new StudentMarks(studentObj.getId(), studentObj.getMarks());};
			return supplier.get();
		}); // Returns Stream[StudentMarks,StudentMarks,StudentMarks,StudentMarks,StudentMarks]
		
		List<StudentMarks> studentMarksObjectList = studentMarksStream.collect(Collectors.toList());

		System.out.println("studentMarksObjectList : " + studentMarksObjectList);
		System.out.println("-------------------------------------------------------------------------");

	}

}
