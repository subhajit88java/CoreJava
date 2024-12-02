package com.subhajit.eenum.main;

import com.subhajit.eenum.model.EnumOne;
import com.subhajit.eenum.model.EnumThree;
import com.subhajit.eenum.model.EnumTwo;

public class TestEnumMain {

	public static void main(String[] args) {
		//testEnumOne();
		testEnumTwo();
		//testEnumThree();
	}	

	private static void testEnumOne() {
		EnumOne e1 = EnumOne.SUBHAJIT;
		System.out.println("e1 : " + e1);
		System.out.println("------------------------");
		EnumOne[] enumList = EnumOne.values();
		for(EnumOne e : enumList) {
			System.out.println("e : " + e);
		}
		System.out.println("------------------------");
		EnumOne e2 = EnumOne.valueOf("RAM");
		System.out.println("e2 : " + e2);
		System.out.println("------------------------");
		System.out.println("Name and Ordinal : " + e2.name() + " , " + e2.ordinal());
		EnumOne e3 = EnumOne.valueOf("asim");
		System.out.println("e3" + e3);
	}
	
	private static void testEnumTwo() {
		EnumOne e1 = EnumOne.SUBHAJIT;
		EnumTwo e2 = EnumTwo.SUBHAJIT;
		EnumOne e3 = EnumOne.RAM;
		System.out.println("e1 address : " + System.identityHashCode(e1));
		System.out.println("e2 address : " + System.identityHashCode(e2));
		System.out.println("e3 address : " + System.identityHashCode(e3));
	}
	
	private static void testEnumThree() {
		for(EnumThree e : EnumThree.values()) {
			System.out.println("e : " + e + ", " + e.getId() + "," + e.getCity());
		}
	}
}
