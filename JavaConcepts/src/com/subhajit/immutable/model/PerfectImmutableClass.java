package com.subhajit.immutable.model;

import java.util.List;
import java.util.stream.Collectors;

public final class PerfectImmutableClass {
	
	private final Integer integerValue;
	private final String stringValue;
	private final List<String> listOfString;
	
	public PerfectImmutableClass(Integer integerValue, String stringValue, List<String> listOfString) {
		super();
		this.integerValue = integerValue;
		this.stringValue = stringValue;
		this.listOfString = listOfString.stream().collect(Collectors.toList());
	}

	public Integer getIntegerValue() {
		return integerValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public List<String> getListOfString() {
		return listOfString.stream().collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "PerfectImmutableClass [integerValue=" + integerValue + ", stringValue=" + stringValue + ", listOfString="
				+ listOfString + "]";
	}

}
