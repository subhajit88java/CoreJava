package com.subhajit.deadcode.main;

public class TestDeadCode {
	
	public static void main(String[] args) {
		unreachableCode1();
		deadCode1();
		unreachableCode2();
		unreachableCode3();
		unreachableCode4();
		unreachableCode5();
		unreachableCode6();
		unreachableCode7();
		unreachableCode8();
		deadCode2();
		unreachableCode9();
	}	

	private static void unreachableCode1() {
		System.out.println("1st statement");
		return;
		System.out.println("2nd statement");		
	}
	
	private static void deadCode1() {
		System.out.println("1st statement");
		if(true)
			return;
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode2() {
		System.out.println("1st statement");
		boolean flag = true;
		if(flag)
			return;
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode3() {
		System.out.println("1st statement");
		if(true)
			return;
		else
			return;
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode4() {
		System.out.println("1st statement");
		while(true)
			return;
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode5() {
		System.out.println("1st statement");
		boolean flag = true;
		while(flag)
			return;
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode6() {
		System.out.println("1st statement");
		do {
			return;
		}while(true); // false, same result
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode7() {
		System.out.println("1st statement");
		for(;;)
			return;
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode8() {
		System.out.println("1st statement");
		for(;;)
			return;
		System.out.println("2nd statement");		
	}
	
	private static void deadCode2() {
		System.out.println("1st statement");
		for(int i = 0;i < 1;i++)
			return;
		System.out.println("2nd statement");		
	}
	
	private static void unreachableCode9() {
		System.out.println("1st statement");
		switch(10) {
		case 10 : 
			return;
		default :
			return;
		}
		System.out.println("2nd statement");		
	}

}
