package com.subhajit.immutable.model;

import java.util.List;
import java.util.stream.Collectors;

// This object can't be regarded as immutable as "listOfString" can be modified after object creation
public class BreakImmutableThree {

	private Integer integerValue;
	private String stringValue;
	private List<String> listOfString;
	
	public BreakImmutableThree(Integer integerValue, String stringValue, List<String> listOfString) {
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
		return "BreakImmutableThree [integerValue=" + integerValue + ", stringValue=" + stringValue + ", listOfString="
				+ listOfString + "]";
	}
	
}

