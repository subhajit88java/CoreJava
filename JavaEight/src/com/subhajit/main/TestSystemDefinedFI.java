package com.subhajit.main;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.subhajit.model.Student;

public class TestSystemDefinedFI {

	public static void main(String[] args) {

		testPredicate();  // input 1, return 1(boolean), method=test()
		testBiPredicate(); // inputs 2, return 1(boolean), method=test()
		testConsumer(); // input 1, return none, method=accept()
		testBiConsumer(); // inputs 2, return none, method=accept()
		testFunction(); // input 1, return 1, method=apply()
		testBiFunction(); // inputs 2, return 1, method=apply()
		testSupplier(); // input none, return 1, method=get()
		testUnaryOperator();
		testBinaryOperator();
	}



	private static void testUnaryOperator() {
		UnaryOperator<Integer> unaryOperator = UnaryOperator.identity();
		System.out.println("UnaryOperator identity : " + unaryOperator.apply(100));
		
	}



	private static void testBinaryOperator() {
		BinaryOperator<Integer> binaryOperatorMax = BinaryOperator.maxBy((x,y) ->{return x.compareTo(y);});
		System.out.println("Max value : " + binaryOperatorMax.apply(45, 55));
		
		BinaryOperator<Integer> binaryOperatorMin = BinaryOperator.minBy((x,y) ->{return x.compareTo(y);});
		System.out.println("Min value : " + binaryOperatorMin.apply(45, 55));
	}



	private static void testPredicate() {
		
		Student studentObj = new Student(1, "Asim", 50);

		Predicate<Student> predicate1 = student -> {
			return student.getMarks() > 60;
		};
		System.out.println("predicate1 test() : " + predicate1.test(studentObj));
		System.out.println("predicate1 negate() : " + predicate1.negate().test(studentObj));

		Predicate<Student> predicate2 = student -> {
			return student.getMarks() < 90;
		};
		System.out.println("predicate1 and() predicate2 : " + predicate1.and(predicate2).test(studentObj));

		Predicate<Student> predicate3 = student -> {
			return student.getName().matches("S(.*)");
		};
		System.out.println("predicate1 or() predicate3 : " + predicate1.or(predicate3).test(studentObj));
	}

	private static void testBiPredicate() {
		
		Student studentObj1 = new Student(1, "Subhajit", 92);
		String nameObj1 = "Subhajit";

		BiPredicate<Student, String> biPredicate1 = (student,name) -> {return student.getName().equals(name);};
			
		System.out.println("biPredicate1 test() : " + biPredicate1.test(studentObj1, nameObj1));
	}
	
	private static void testConsumer() {
		Student studentObj1 = new Student(1, "Subhajit", 92);

		Consumer<Student> consumer1 = student -> {System.out.println("Student name : " + student.getName());};
		consumer1.accept(studentObj1);
		
		Consumer<Student> consumer2 = student -> {System.out.println("Student marks : " + student.getMarks());};
		consumer1.andThen(consumer2).accept(studentObj1);
		
		DoubleConsumer doubleConsumer = average -> {System.out.println("Average is " + average);};
		doubleConsumer.accept(50.0);
	}
	

	private static void testBiConsumer() {
		Student studentObj1 = new Student(1, "Subhajit", 92);
		String countryName = "India";
		
		BiConsumer<Student,String> biConsumer1 = (student,country) -> {System.out.println("Student name : " + student.getName() +" of " + country);};
		biConsumer1.accept(studentObj1,countryName);	
	}
	
	private static void testFunction() {
		
		Student studentObj1 = new Student(1, "Subhajit", 92);

		Function<Student,String> function1 = student -> {return student.getName()+"_"+student.getMarks();};
		System.out.println("function1 result : " + function1.apply(studentObj1));
		
		Function<String,Integer> functionAfter = studentName -> {return studentName.length();};
		
		Function<Student, Integer> andThenFunction = function1.andThen(functionAfter);
		System.out.println("Student length : " + andThenFunction.apply(studentObj1));	
		
		Function<Integer,Student> functionBefore = studentMarks -> {
			studentObj1.setMarks(studentMarks);
			return studentObj1;
			};
		Function<Integer, String> composeFunction = function1.compose(functionBefore);
		System.out.println(composeFunction.apply(98));
		
		System.out.println(Function.identity().apply(100));
		
	}
	

	private static void testBiFunction() {
		
		Student studentObj1 = new Student(1, "Subhajit", 0);
		Integer studentMarks = 87;
		
		BiFunction<Student,Integer,Student> biFunction1 = (student,marks) -> {
			student.setMarks(marks);
			return student;
			};
		System.out.println("function1 result : " + biFunction1.apply(studentObj1, studentMarks));
		
	}



	private static void testSupplier() {
		Student studentObj1 = new Student(1, "Subhajit", 72);

		Supplier<Student> supplier = () -> {return studentObj1;};
		System.out.println("Supplier : " + supplier.get());
		
		BooleanSupplier booleanSupplier = () -> {return true;};
		System.out.println("booleanSupplier : " + booleanSupplier.getAsBoolean());
	}


}
