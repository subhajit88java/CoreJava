package com.subhajit.HashMapLab;

import java.util.concurrent.ConcurrentHashMap;


public class ConcurrentHashMapLabMain {
	
	public static void main(String[] args) {
		ConcurrentHashMap<String, String> cm = new ConcurrentHashMap<String, String>();
		cm.put("a", null);
		cm.put("b", "bb");
		System.out.println(cm);
	}

}
