package com.subhajit.immutable.model;

import java.util.List;

// This object can't be regarded as immutable as "listOfString" can be modified after object creation
public class BreakImmutableOne {

	private final Integer integerValue;
	private final String stringValue;
	private final List<String> listOfString;
	
	public BreakImmutableOne(Integer integerValue, String stringValue, List<String> listOfString) {
		super();
		this.integerValue = integerValue;
		this.stringValue = stringValue;
		this.listOfString = listOfString;
	}

	public Integer getIntegerValue() {
		return integerValue;
	}

	public String getStringValue() {
		return stringValue;
	}

	public List<String> getListOfString() {
		return listOfString;
	}

	@Override
	public String toString() {
		return "BreakImmutableOne [integerValue=" + integerValue + ", stringValue=" + stringValue + ", listOfString="
				+ listOfString + "]";
	}
	
}
