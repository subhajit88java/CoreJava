 package com.subhajit.volatilevar.main;

import com.subhajit.volatilevar.model.SharedModel1;
import com.subhajit.volatilevar.model.Thread1;
import com.subhajit.volatilevar.model.Thread2;

public class TestVolatileMain {

	public static void main(String[] args) {
		
		SharedModel1 sharedModel1 = new SharedModel1();
		Runnable r1 = new Thread1(sharedModel1);
		Runnable r2 = new Thread2(sharedModel1);
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}
