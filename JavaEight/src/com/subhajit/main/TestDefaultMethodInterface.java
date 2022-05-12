package com.subhajit.main;

import com.subhajit.plain.interfaces.DefaultMethodInterface;
import com.subhajit.utility.ImplementDefaultInterface;

public class TestDefaultMethodInterface {

	public static void main(String[] args) {
		
		ImplementDefaultInterface implementDefaultInterface = new ImplementDefaultInterface();
		implementDefaultInterface.getMethod1();
		implementDefaultInterface.getMethod2();
		implementDefaultInterface.getName();
		
		DefaultMethodInterface defaultMethodInterface = new ImplementDefaultInterface();
		defaultMethodInterface.getMethod1();
		defaultMethodInterface.getMethod2();
		defaultMethodInterface.getName();
	}
}
