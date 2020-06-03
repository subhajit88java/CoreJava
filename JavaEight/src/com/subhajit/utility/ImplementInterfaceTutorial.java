package com.subhajit.utility;

import com.subhajit.plain.interfaces.InterfaceTutorial;
import com.subhajit.plain.interfaces.InterfaceTutorialTwo;

public class ImplementInterfaceTutorial implements InterfaceTutorial, InterfaceTutorialTwo{

	@Override
	public String getName(String name) {
		getDefaultName();
		return "Hello "+ name;
	}
	

	public static String getStaticName(String name) { 
		return "I love my Country";
	}
	
	
	
	
	@Override
	public String getDefaultName() {
		System.out.println(InterfaceTutorial.super.getDefaultName());
		System.out.println(InterfaceTutorialTwo.super.getDefaultName());
		return "Subha";
	}
	 
	 
	
}
