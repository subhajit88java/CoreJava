package com.subhajit.main;

import com.subhajit.plain.interfaces.DefaultMethodInterface;

class TestDefaultMethod implements DefaultMethodInterface{
	public void test() {
		
		//DefaultMethodInterface.super.getName();
	}
}

public class TestMainTwo {
	
	public static void main(String[] args) {
		new TestDefaultMethod().getName();
	}

}
