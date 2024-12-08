package com.subhajit.jvm.main;

import com.subhajit.jvm.model.InstanceTestModelOne;

public class TestStaticVarMemory {
	public static void main(String[] args) {
		try {
			Class.forName("com.subhajit.jvm.model.StaticTestModelOne");
			Class.forName("com.subhajit.jvm.model.StaticTestModelTwo");
			String var = "Subhajit";
			System.out.println("Main var : " + System.identityHashCode(var));
			InstanceTestModelOne instanceTestModelOne = new InstanceTestModelOne();
			instanceTestModelOne.method();
		} catch (Exception e) {
		}
	}
}
