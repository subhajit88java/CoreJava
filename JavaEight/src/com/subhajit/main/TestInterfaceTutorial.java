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
		
		InterfaceTutorial interfaceTutorial = new ImplementInterfaceTutorial();
		System.out.println(interfaceTutorial.getName("Subhajit"));
		System.out.println(interfaceTutorial.getDefaultName());
		System.out.println(InterfaceTutorial.getStaticName("Subhajit"));
		
		InterfaceTutorialTwo interfaceTutorialTwo = new ImplementInterfaceTutorial();
		System.out.println(interfaceTutorialTwo.getName("Subhajit"));
		System.out.println(interfaceTutorialTwo.getDefaultName());
		System.out.println(InterfaceTutorialTwo.getStaticName("Subhajit"));
		
	}
}
