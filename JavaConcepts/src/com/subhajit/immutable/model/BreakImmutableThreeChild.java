package com.subhajit.immutable.model;

import java.util.List;

// This class is bluffing the users by pretending to be BreakImmutableThree
public class BreakImmutableThreeChild extends BreakImmutableThree{
	
	private Integer integerValue;
	private String stringValue;
	private List<String> listOfString;

	public BreakImmutableThreeChild(Integer integerValue, String stringValue, List<String> listOfString) {
		super(integerValue, stringValue, listOfString);
		this.integerValue = integerValue;
		this.stringValue = stringValue;
		this.listOfString = listOfString;
	}
	
	@Override
	public List<String> getListOfString() {
		return listOfString;
	}

	@Override
	public String toString() {
		return "BreakImmutableThreeChild [integerValue=" + integerValue + ", stringValue=" + stringValue
				+ ", listOfString=" + listOfString + "]";
	}
	
}
