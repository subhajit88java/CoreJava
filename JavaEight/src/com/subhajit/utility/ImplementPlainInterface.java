package com.subhajit.utility;

import com.subhajit.plain.interfaces.PlainInterface;
import com.subhajit.plain.interfaces.PlainInterfaceTwo;

public class ImplementPlainInterface implements PlainInterface, PlainInterfaceTwo{

	@Override
	public void getName() {
		System.out.println("My name is Subhajit");
		
	}

}
