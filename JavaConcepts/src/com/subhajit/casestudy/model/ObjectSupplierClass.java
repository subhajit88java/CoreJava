package com.subhajit.casestudy.model;

import java.util.ArrayList;
import java.util.List;

public class ObjectSupplierClass {
	
	public static List<String> getStringListRepeatedValues() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("B");
		list.add("B");
		list.add("C");
		list.add("C");
		list.add("D");
		return list;
	}
	
	public static List<String> getStringListRepeatedValuesAndNull() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("A");
		list.add("B");
		list.add("B");
		list.add("B");
		list.add("C");
		list.add("C");
		list.add("D");
		list.add(null);
		list.add(null);
		return list;
	}
	
	public static List<Model1> getModel1ListRepeatedValues() {
		List<Model1> list = new ArrayList<>();
		list.add(new Model1("heritage","mca","subhajit"));
		list.add(new Model1("heritage","mca","asim"));
		list.add(new Model1("heritage","mca","ram"));
		list.add(new Model1("heritage","mca","suman"));
		list.add(new Model1("techno","btech","x"));
		list.add(new Model1("techno","btech","y"));
		list.add(new Model1("techno","mca","m"));
		list.add(new Model1("techno","mca","n"));
		list.add(new Model1("heritage","btech","A"));
		list.add(new Model1("heritage","btech","B"));
		return list;
	}

}
