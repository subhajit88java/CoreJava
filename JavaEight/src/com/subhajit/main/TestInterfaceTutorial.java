package com.subhajit.main;

import com.subhajit.plain.interfaces.InterfaceTutorial;
import com.subhajit.plain.interfaces.InterfaceTutorialTwo;
import com.subhajit.utility.ImplementInterfaceTutorial;

public class TestInterfaceTutorial {

	public static void main(String[] args) {
		
		ImplementInterfaceTutorial implementInterfaceTutorial = new ImplementInterfaceTutorial();
		System.out.println(implementInterfaceTutorial.getName("Subhajit"));
		System.out.println(implementInterfaceTutorial.getDefaultName());
		System.out.println(ImplementInterfaceTutorial.getStaticName("Pallobi"));	
		System.out.println(implementInterfaceTutorial.getId(100));
		System.out.println(implementInterfaceTutorial.getId());
		System.out.println("------------------------------------------------------");
		
		InterfaceTutorial interfaceTutorial = new ImplementInterfaceTutorial();
		System.out.println(interfaceTutorial.getName("Subhajit"));
		System.out.println(interfaceTutorial.getDefaultName());
		System.out.println(InterfaceTutorial.getStaticName("Subhajit"));
		System.out.println(interfaceTutorial.getId());
		System.out.println("------------------------------------------------------");	
		
		InterfaceTutorialTwo interfaceTutorialTwo = new ImplementInterfaceTutorial();
		System.out.println(interfaceTutorialTwo.getName("Subhajit"));
		System.out.println(interfaceTutorialTwo.getDefaultName());
		System.out.println(InterfaceTutorialTwo.getStaticName("Subhajit"));
		System.out.println(interfaceTutorialTwo.getId(100));
		System.out.println("------------------------------------------------------");	
		
	}
}
