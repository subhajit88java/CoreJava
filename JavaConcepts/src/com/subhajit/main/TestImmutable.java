package com.subhajit.main;

import com.subhajit.models.ModelOne;

public class TestImmutable {

	public static void main(String[] args) throws CloneNotSupportedException {
		ModelOne m1 = new ModelOne(1,"Subhajit");
		System.out.println(m1+" - "+System.identityHashCode(m1)+" - "+System.identityHashCode(m1.getName()));
		ModelOne m2 = (ModelOne) m1.clone();
		System.out.println(m2+" - "+System.identityHashCode(m2)+" - "+System.identityHashCode(m2.getName()));
	}
}
