package com.subhajit.main;

import java.util.HashMap;
import java.util.Map;

import com.subhajit.threads.runnable.ThreadOne;
import com.subhajit.threads.runnable.ThreadOneHashMap;
import com.subhajit.threads.runnable.ThreadTwo;
import com.subhajit.threads.runnable.ThreadTwoHashMap;

public class MapTestingThreadLab {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("A", "AA");
		map.put("B", "BB");
		map.put("C", "CC");
		map.put("D", "DD");
		map.put("E", "EE");
		Runnable threadOneHashMap = new ThreadOneHashMap(map);
		Runnable threadTwoHashMap = new ThreadTwoHashMap(map);
		
		Thread t1 = new Thread(threadOneHashMap);
		Thread t2 = new Thread(threadTwoHashMap);
		t1.start();
		t2.start();
		System.out.println("Main ends................");
	}

}
