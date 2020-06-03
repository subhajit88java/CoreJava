package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;

import com.subhajit.threads.SharedVolatilePrimitiveThreadOne;
import com.subhajit.threads.SharedVolatilePrimitiveThreadTwo;

public class TestPrimitiveVolatileMain {

	static int valueMain = 10;
	static StringBuilder stringValueMain = new StringBuilder("Subhajit");
	static List<Integer> intList = new ArrayList<>();
	
	public static void main(String[] args) {
		
		intList.add(100);
		intList.add(200);
		intList.add(300);
		
		System.out.println("In main -- int address : " + System.identityHashCode(valueMain)+", StringBuilder address : " + System.identityHashCode(stringValueMain)+", List address : " + System.identityHashCode(intList));
		SharedVolatilePrimitiveThreadOne sharedVolatilePrimitiveThreadOne = new SharedVolatilePrimitiveThreadOne(valueMain,stringValueMain,intList);
		SharedVolatilePrimitiveThreadTwo sharedVolatilePrimitiveThreadTwo = new SharedVolatilePrimitiveThreadTwo(valueMain,stringValueMain,intList);

		Thread t1 = new Thread(sharedVolatilePrimitiveThreadOne);
		Thread t2 = new Thread(sharedVolatilePrimitiveThreadTwo);
		
		t1.start();
		t2.start();

	}
}
