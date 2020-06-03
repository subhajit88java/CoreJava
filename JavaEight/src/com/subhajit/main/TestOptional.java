package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestOptional {

	public static void main(String[] args) {
		/*
		 * Integer a = 200; Optional<Integer> oa = Optional.ofNullable(a);
		 * System.out.println(oa.of(a).get());
		 */

		// Case study 1, with Optional.ofNullable(<value>) and null value
		String s = null;
		Optional<String> stringOptional = Optional.ofNullable(s);
		try {
			System.out.println("[Case study 1] stringOptional.get() : " + stringOptional.get());
		} catch (Exception e) {
			System.err.println("[Case study 1] Exception message : " + e.getMessage());
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
		System.out.println("----------------------------------------------------------------");

		// Case study 2, with with Optional.ofNullable(<value>) and not-null value
		s = "Subhajit";
		stringOptional = Optional.ofNullable(s);
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
			System.out.println("[Case study 2] Implementation of Consumer Functional Interface : " + n);
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

		// Case study 3, with Optional.of(<value>) and null value
		s = null;
		try {
			Optional<String> stringOptionalNull = Optional.of(s); // Will throw Null Pointer Exception
		} catch (Exception e) {
			System.err.println("[Case study 3] Exception message : " + e.getMessage());
		}

		System.out.println("----------------------------------------------------------------");

		// Case study 4, with Optional.of(<value>) and not-null value
		s = "Subhajit";
		Optional<String> stringOptionalNull = Optional.of(s);
		System.out.println("[Case study 4] stringOptional.get() : " + stringOptional.get());
		System.out
				.println("[Case study 4] stringOptional.orElse(<default value>) : " + stringOptional.orElse("Pallobi"));
		System.out.println("[Case study 4] stringOptional.toString() : " + stringOptional.toString());
		System.out.println("[Case study 4] stringOptional.isPresent() : " + stringOptional.isPresent());
		stringOptional.ifPresent(n -> {
			System.out.println("[Case study 4] Implementation of Consumer Functional Interface : " + n);
		});
		System.out.println("[Case study 4] stringOptional.filter() : " + stringOptional.filter(n -> {
			return n.equals("Subhajit");
		}));
		System.out.println("[Case study 4] stringOptional.orElseGet() : " + stringOptional.orElseGet(() -> {
			String temp = "India";
			if (temp.equals("India"))
				return "I love my India";
			else
				return "Ok bye";
		}));

		System.out.println("----------------------------------------------------------------");

		// Case study 5, with Optional.empty()
		Optional<String> stringOptionalEmpty = Optional.empty();
		try {
			System.out.println("[Case study 5] stringOptionalEmpty.get() : " + stringOptionalEmpty.get());
		} catch (Exception e) {
			System.err.println("[Case study 5] Exception message : " + e.getMessage());
		}
		System.out.println("[Case study 5] stringOptionalEmpty.orElse(<default value>) : " + stringOptional.orElse("Subhajit"));

		System.out.println("----------------------------------------------------------------");

		// Case study 6, with null List
		List<String> stringList = null;
		List<String> stringListTwo = new ArrayList<>();
		stringListTwo.add("Subhajit");
		stringListTwo.add("Pallobi");

		Optional<List<String>> stringListOptional = Optional.ofNullable(stringList);
		try {
			System.out.println("[Case study 6] stringListOptional.get() : " + stringListOptional.get());
		} catch (Exception e) {
			System.err.println("[Case study 6] Exception message : " + e.getMessage());
		}
		System.out.println("[Case study 6] stringListOptional.orElse(<default value>) : " + stringListOptional.orElse(stringListTwo));
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
