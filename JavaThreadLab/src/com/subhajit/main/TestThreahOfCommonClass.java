package com.subhajit.main;

import java.util.ArrayList;
import java.util.List;

public class TestThreahOfCommonClass {
	private static  boolean flag = false;
	private static StringBuilder sb = new StringBuilder("A");
	private static Boolean flag2 = false;
	private static volatile List<Integer> intList = new ArrayList<>();
	private static volatile int[] intArray = new int[3];
	private static  double[] dArray = new double[3];
    public static void main(String[] args) {
    	intArray[0]=100;
    	intArray[1]=200;
    	intArray[2]=300;
    	
    	dArray[0]=10.0;
    	dArray[1]=20.0;
    	dArray[2]=30.0;
    	
    	intList.add(100);
    	intList.add(200);
    	intList.add(300);
    	
        // Thread-1
        new Thread(new Runnable(){
            @Override
            public void run() {
				
                try {
					Thread.sleep(0);
				} catch (InterruptedException e) {}
                // changing status flag
                flag=true;
                intArray = new int[1];
                intArray[0]=1000;
                dArray[1]=50.0;
                intList.set(1, 700);
        		System.out.println("In Thread1 after update = " + intList + " - " + System.identityHashCode(intList));
        		
				}
            
            
        }).start();
        // Thread-2
        new Thread(new Runnable(){
            
            @Override
            public void run() {
        		System.out.println("In Thread2 = " + flag2 + " - " + System.identityHashCode(flag2));
                int i = 0;
                while (dArray[1]!=50.0){
            		//System.out.println("In Thread2 loop = " + intList + " - " + System.identityHashCode(intList));
                	i=5;
                }
        		System.out.println("In Thread2 end = " + dArray + " - " + System.identityHashCode(dArray)+" - "+i);
            }
            
        }).start();
    }
}
