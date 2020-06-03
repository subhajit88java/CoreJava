package com.subhajit.main;

import com.subhajit.plain.interfaces.InterfaceTutorial;
import com.subhajit.utility.ImplementInterfaceTutorial;

public class TestInterfaceTutorial {

	public static void main(String[] args) {
		InterfaceTutorial interfaceTutorial = new ImplementInterfaceTutorial();
		System.out.println(interfaceTutorial.getName("Subhajit"));
		System.out.println(InterfaceTutorial.getStaticName(""));
		System.out.println(ImplementInterfaceTutorial.getStaticName(""));
		System.out.println(new ImplementInterfaceTutorial().getStaticName(""));
		System.out.println(interfaceTutorial.getDefaultName());
		System.out.println(new ImplementInterfaceTutorial().getDefaultName());
	}
}
