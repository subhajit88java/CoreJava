package com.subhajit.main;

import java.util.function.BiConsumer;

public class TestConsumer {
	
	public static void main(String[] args) {
		
		BiConsumer<Integer, Integer> c = (a,b) -> System.out.println(a+b);
		c.accept(100,  200);
	}

}
