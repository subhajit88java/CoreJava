package com.subhajit.inheritance.main;

import com.subhajit.inheritance.package1.model.Child1Class;
import com.subhajit.inheritance.package1.model.Child2Class;
import com.subhajit.inheritance.package1.model.Child3Class;
import com.subhajit.inheritance.package1.model.Parent1Class;
import com.subhajit.inheritance.package1.model.Parent2Class;
import com.subhajit.inheritance.package1.model.Parent3Class;

public class TestInheritance {
	
	public static void main(String[] args) {
		
		//method1();
		method2();
		//method3();
		
		
	}

	private static void method3() {
		Parent3Class pc1 = new Parent3Class();
		System.out.println("pc1 : " + pc1.x);
		pc1.m();
		
		Parent3Class pc2 = new Child3Class();
		System.out.println("pc2 : " + pc2.x);
		pc2.m();
		
		Child3Class cc1 = new Child3Class();
		System.out.println("cc1 : " + cc1.x);
		cc1.m();
	}

	private static void method2() {
		Parent2Class pc1 = new Parent2Class();
		System.out.println("pc1 : " + pc1.x);
		pc1.m();
		System.out.println("pc1 static : " + pc1.y);

		
		Child2Class cc1 = new Child2Class();
		System.out.println("cc1 : " + cc1.x);
		cc1.m();
		System.out.println("cc1 static : " + cc1.y);

		
		Parent2Class pc2 = new Child2Class();
		System.out.println("pc2 : " + pc2.x);
		pc2.m();
		System.out.println("pc2 static : " + pc2.y);
		
	}

	private static void method1() {
		Parent1Class parent2 = new Child1Class("1","2","3","4");
		System.out.println("see " + parent2.getValues());
	}

}
