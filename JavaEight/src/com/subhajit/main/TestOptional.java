package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * 
 * Optional.of()
 * Optional.ofNullable()
 * Optional.empty()
 * 
 * optionalInstance.get(), optionalInstance.orElse(), optionalInstance.orElseGet(), optionalInstance.orElseThrow()
 * optionalInstance.isPresent(), optionalInstance.ifPresent(), optionalInstance.filter()
 * 
 */

public class TestOptional {

	public static void main(String[] args) {

		caseStudy1(); // Case study 1, with Optional.ofNullable(<value>) and null value
		caseStudy2(); // Case study 2, with with Optional.ofNullable(<value>) and not-null value
		caseStudy3(); // Case study 3, with Optional.of(<value>) and null value
		caseStudy4(); // Case study 4, with Optional.of(<value>) and not-null value
		caseStudy5(); // Case study 5, with Optional.empty()
		caseStudy6(); // Case study 6, with non - null List

	}

	private static void caseStudy1() {

		String s = null;
		Optional<String> stringOptional = Optional.ofNullable(s);
		try {
			System.out.println("[Case study 1] stringOptional.get() : " + stringOptional.get());
		} catch (Exception e) {
			System.out.println("[Case study 1] Exception message : " + e.getMessage());
		}
		System.out.println(
				"[Case study 1] stringOptional.orElse(<default value>) : " + stringOptional.orElse("Subhajit"));
		System.out.println("[Case study 1] stringOptional.toString() : " + stringOptional.toString());
		System.out.println("[Case study 1] stringOptional.isPresent() : " + stringOptional.isPresent());
		stringOptional.ifPresent(n -> {
			System.out.println("[Case study 1] Implementation of Consumer Functional Interface : " + n);
		});
		System.out.println("[Case study 1] stringOptional.filter() : " + stringOptional.filter(n -> {
			return n.equals("Subhajit");
		}));
		System.out.println("[Case study 1] stringOptional.orElseGet() : " + stringOptional.orElseGet(() -> {
			String temp = "India";
			if (temp.equals("India"))
				return "I love my India";
			else
				return "Ok bye";
		}));
		try {
			System.out.println("[Case study 1] stringOptional.orElseThrow() : " + stringOptional.orElseThrow(() -> {
				return new Exception("Throwing Exception");
			}));
		} catch (Exception e) {
			System.out.println("[Case study 1] stringOptional.orElseThrow() Exception message : " + e.getMessage());
		}
		System.out.println("----------------------------------------------------------------");

	}

	private static void caseStudy2() {

		String s = "Subhajit";
		Optional<String> stringOptional = Optional.ofNullable(s);
		try {
			System.out.println("[Case study 2] stringOptional.get() : " + stringOptional.get());
		} catch (Exception e) {
			System.err.println("[Case study 2] Exception message : " + e.getMessage());
		}
		System.out
				.println("[Case study 2] stringOptional.orElse(<default value>) : " + stringOptional.orElse("Pallobi"));
		System.out.println("[Case study 2] stringOptional.toString() : " + stringOptional.toString());
		System.out.println("[Case study 2] stringOptional.isPresent() : " + stringOptional.isPresent());
		stringOptional.ifPresent(n -> {
			System.out.println("[Case study 2] stringOptional.ifPresent() : " + n);
		});
		System.out.println("[Case study 2] stringOptional.filter() : " + stringOptional.filter(n -> {
			return n.equals("Pallobi");
		}));
		System.out.println("[Case study 2] stringOptional.orElseGet() : " + stringOptional.orElseGet(() -> {
			String temp = "India";
			if (temp.equals("India"))
				return "I love my India";
			else
				return "Ok bye";
		}));

		System.out.println("----------------------------------------------------------------");

	}

	private static void caseStudy3() {

		String s = null;
		try {
			Optional<String> stringOptionalNull = Optional.of(s); // Will throw Null Pointer Exception
		} catch (Exception e) {
			System.err.println("[Case study 3] Exception message : " + e.getMessage());
		}

		System.out.println("----------------------------------------------------------------");

	}

	private static void caseStudy4() {

		String s = "Subhajit";
		Optional<String> stringOptionalNull = Optional.of(s);
		System.out.println("[Case study 4] stringOptionalNull.get() : " + stringOptionalNull.get());
		System.out.println(
				"[Case study 4] stringOptionalNull.orElse(<default value>) : " + stringOptionalNull.orElse("Pallobi"));
		System.out.println("[Case study 4] stringOptionalNull.toString() : " + stringOptionalNull.toString());
		System.out.println("[Case study 4] stringOptionalNull.isPresent() : " + stringOptionalNull.isPresent());
		stringOptionalNull.ifPresent(n -> {
			System.out.println("[Case study 4] stringOptionalNull.ifPresent() : " + n);
		});
		System.out.println("[Case study 4] stringOptionalNull.filter() : " + stringOptionalNull.filter(n -> {
			return n.equals("Subhajit");
		}));
		System.out.println("[Case study 4] stringOptionalNull.orElseGet() : " + stringOptionalNull.orElseGet(() -> {
			String temp = "India";
			if (temp.equals("India"))
				return "I love my India";
			else
				return "Ok bye";
		}));

		System.out.println("----------------------------------------------------------------");
	}

	private static void caseStudy5() {

		Optional<String> stringOptionalEmpty = Optional.empty();
		try {
			System.out.println("[Case study 5] stringOptionalEmpty.get() : " + stringOptionalEmpty.get());
		} catch (Exception e) {
			System.err.println("[Case study 5] Exception message : " + e.getMessage());
		}
		System.out.println("[Case study 5] stringOptionalEmpty.orElse(<default value>) : "
				+ stringOptionalEmpty.orElse("Subhajit"));

		System.out.println("----------------------------------------------------------------");

	}

	private static void caseStudy6() {

		List<String> stringListOne = new ArrayList<>();
		stringListOne.add("Subhajit");
		stringListOne.add("Pallobi");
		
		List<String> stringListTwo = new ArrayList<>();
		stringListTwo.add("Durgapur");
		stringListTwo.add("Kolkata");
		stringListTwo.add("Delhi");

		Optional<List<String>> stringListOptional = Optional.ofNullable(stringListOne);
		try {
			System.out.println("[Case study 6] stringListOptional.get() : " + stringListOptional.get());
		} catch (Exception e) {
			System.out.println("[Case study 6] Exception message : " + e.getMessage());
		}
		System.out.println("[Case study 6] stringListOptional.orElse(<default value>) : "
				+ stringListOptional.orElse(stringListTwo));
		System.out.println("[Case study 6] stringListOptional.isPresent() : " + stringListOptional.isPresent());
		stringListOptional.ifPresent(n -> {
			System.out.println("[Case study 6] List Size : " + n.size());
		});
		System.out.println("[Case study 6] stringListOptional.filter() : " + stringListOptional.filter(n -> {
			return n.size() > 5;
		}));
		System.out.println("[Case study 6] stringListOptional.orElseGet() : " + stringListOptional.orElseGet(() -> {
			if (stringListTwo.size() > 0)
				System.out.println("[Case study 6] Size is > 0");

			return stringListTwo;
		}));

	}
}
