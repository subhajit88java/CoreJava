package com.subhajit.ArrayListLab;

import java.util.List;

public class ThreadClassOne implements Runnable{
	
	private List<String> stringList;
	
	public ThreadClassOne(List<String> stringList) {
		this.stringList = stringList;
	}
	

	@Override
	public void run() {
		for(String s : stringList) {
			System.out.println("From ThreadClassOne :  " + s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
		
		
	}

}
