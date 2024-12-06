package com.subhajit.modifiers.main;

import com.subhajit.modifiers1.model.ChangeModifierChildFour;
import com.subhajit.modifiers1.model.ChangeModifierChildThree;
import com.subhajit.modifiers1.model.ChangeModifierChildTwo;
import com.subhajit.modifiers1.model.FinalClassChildOne;
import com.subhajit.modifiers1.model.FinalClassParent;
import com.subhajit.modifiers1.model.ParentClass;

public class TestModifierMain {
	public static void main(String[] args) {
		ParentClass parent = new ParentClass();
		parent.method1(); // only public method is visible
		
		ParentClass parent2 = new ChangeModifierChildThree();
		parent2.method1(); 
		// though we have widened the modifier in Child class, still method3 is not visible because we are using parent reference
		
		ChangeModifierChildThree child = new ChangeModifierChildThree();
		child.method1();
		child.method3(); // as we have widened the modifier in Child class, method3 is visible because we are using child reference
		
		ParentClass parent3 = new ChangeModifierChildFour();
		parent3.method1();
		
		FinalClassParent finalClassParent = new FinalClassParent();
		finalClassParent.method1();
		
		FinalClassChildOne finalClassChild = new FinalClassChildOne();
		finalClassChild.method1();
		
		
	}
}
