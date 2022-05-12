package com.subhajit.utility;

import com.subhajit.plain.interfaces.DefaultMethodInterface;
import com.subhajit.plain.interfaces.DefaultMethodInterfaceTwo;

public class ImplementDefaultInterface implements DefaultMethodInterface{

	@Override
	public void getName() {
		System.out.println("overriden getName");
	}
	
	@Override
	public void getMethod1() {
		System.out.println("overriden getMethod1");
	}
	
	@Override
	public void getMethod2() {
		System.out.println("overriden getMethod2");
	}
	

}
