package com.subhajit.inheritance.main;

import com.subhajit.inheritance.package1.model.Child1Class;
import com.subhajit.inheritance.package1.model.Child2Class;
import com.subhajit.inheritance.package1.model.Child3Class;
import com.subhajit.inheritance.package1.model.Child5Class;
import com.subhajit.inheritance.package1.model.Child6Class;
import com.subhajit.inheritance.package1.model.ChildInstanceVarOne;
import com.subhajit.inheritance.package1.model.ChildInstanceVarThree;
import com.subhajit.inheritance.package1.model.ChildInstanceVarTwo;
import com.subhajit.inheritance.package1.model.ChildOneStaticMethods;
import com.subhajit.inheritance.package1.model.ChildThreeStaticMethods;
import com.subhajit.inheritance.package1.model.ChildTwoStaticMethods;
import com.subhajit.inheritance.package1.model.LeafChildStaticMethods;
import com.subhajit.inheritance.package1.model.MiddleChildStaticMethods;
import com.subhajit.inheritance.package1.model.Parent1Class;
import com.subhajit.inheritance.package1.model.Parent2Class;
import com.subhajit.inheritance.package1.model.Parent3Class;
import com.subhajit.inheritance.package1.model.Parent4Class;
import com.subhajit.inheritance.package1.model.ParentInstanceVarOne;
import com.subhajit.inheritance.package1.model.ParentStaticMethods;
import com.subhajit.inheritance.package2.model.Child4Class;

public class TestInheritance {
	
	public static void main(String[] args) {
		
		//inheritenceWithinSamePackage();
		//inheritenceWithinDifferentPackage();
		//method2();
		//inheritenceWithFinalFields();
		//inheritenceWithFinalClass();	
		//inheritenceOfStaticMethodsOne();
		inheritenceOfStaticMethodsTwo();
		//method3();
		//instanceVarOverriding();
	}

	private static void instanceVarOverriding() {
		ParentInstanceVarOne parent1 = new ChildInstanceVarOne();
		parent1.method();
		
		ChildInstanceVarOne child1 = new ChildInstanceVarOne();
		child1.method();
		
		ParentInstanceVarOne parent2 = new ChildInstanceVarTwo();
		parent2.method();
		
		ChildInstanceVarTwo child2 = new ChildInstanceVarTwo();
		child2.method();
		
		ParentInstanceVarOne parent3 = new ChildInstanceVarThree();
		parent3.method();
		
		ChildInstanceVarThree child3 = new ChildInstanceVarThree();
		child3.method();
		
	}

	private static void inheritenceOfStaticMethodsTwo() {
		// Parent
		ParentStaticMethods.method1();	
		new ParentStaticMethods().method1();
		
		// Child1
		ChildOneStaticMethods.method1();
		new ChildOneStaticMethods().method1();
		// method2, method3, method4 not visible
		
		// Child1
		ChildTwoStaticMethods.method1();
		new ChildTwoStaticMethods().method1();
		// method2, method3, method4 not visible
		
		System.out.println("----------------------------------------------");
		ParentStaticMethods parent1 = new ParentStaticMethods();
		parent1.callByObject();
		
		ParentStaticMethods parent2 = new MiddleChildStaticMethods();
		parent2.callByObject();
		
		ParentStaticMethods parent3 = new LeafChildStaticMethods();
		parent3.callByObject();
		
		MiddleChildStaticMethods middle1 = new MiddleChildStaticMethods();
		middle1.callByObject();
		
		MiddleChildStaticMethods middle2 = new LeafChildStaticMethods();
		middle2.callByObject();
		
		System.out.println("----------------------------------------------");
	}

	private static void inheritenceOfStaticMethodsOne() {
		// parent
		ParentStaticMethods.method1();
		// method2, method3, method4 not visible
		
		// Child1
		ChildOneStaticMethods.method1();
		// method2, method3, method4 not visible
		
		//Child2
		ChildTwoStaticMethods.method1();
		
		//Child3
		ChildThreeStaticMethods.method();
	}

	private static void inheritenceWithFinalClass() {
		Parent4Class pc1 = new Child6Class();
	}

	private static void inheritenceWithFinalFields() {
		Parent3Class pc1 = new Child5Class();
		pc1.getValues();
		
		Child5Class cc1 = new Child5Class();
		cc1.getValues();
	}

	private static void method3() {
		Parent3Class pc1 = new Parent3Class();
		System.out.println("pc1 : " + pc1.var1);
		pc1.getValues();
		
		Parent3Class pc2 = new Child3Class();
		System.out.println("pc2 : " + pc2.var1);
		pc2.getValues();
		
		Child3Class cc1 = new Child3Class();
		System.out.println("cc1 : " + cc1.var1);
		cc1.getValues();
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

	private static void inheritenceWithinSamePackage() {
		Parent1Class parent2 = new Child1Class("1","2","3","4");
		System.out.println("see " + parent2.getValues());
	}
	
	private static void inheritenceWithinDifferentPackage() {
		Parent1Class parent2 = new Child4Class("1","2","3","4");
		System.out.println("see " + parent2.getValues());
	}

}
