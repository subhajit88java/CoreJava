package com.subhajit.ArrayListLab;

import java.util.List;

public class ThreadClassTwo implements Runnable{
	
	private List<String> stringList;
	
	public ThreadClassTwo(List<String> stringList) {
		this.stringList = stringList;
	}
	

	@Override
	public void run() {

		synchronized (stringList) {
			for (String s : stringList) {
				System.out.println("From ThreadClassTwo :  " + s);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}

		/*
		 * for(int i=0;i<10;i++) { stringList.add("Value Added");
		 * System.out.println("ThreadClassTwo................... value added"); try {
		 * Thread.sleep(1000); } catch (InterruptedException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * 
		 * }
		 */
	}

}