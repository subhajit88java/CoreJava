package com.subhajit.main;

import com.subhajit.plain.interfaces.PlainInterface;

public class TestMainOne{// implements PlainInterface{

	//@Override
	public void getName() {
		System.out.println("Subhajit from plain interface");
		
	}
	
	public static void main(String[] args) {
		new TestMainOne().getName();
	}

}
