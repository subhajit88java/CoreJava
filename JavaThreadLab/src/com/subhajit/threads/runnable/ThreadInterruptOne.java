package com.subhajit.threads.runnable;

public class ThreadInterruptOne implements Runnable{

	@Override
	public void run() {
		System.out.println("ThreadInterruptOne Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());
		
		try {
			System.out.println("Block 1 : ThreadInterruptOne going to sleep");
			int i = 0;
			while(i < 1) { 
				if(Thread.currentThread().isInterrupted()) // For any other code except sleeping, we need to check interruption status, if interrupted we need to throw an exception
					throw new Exception();
				System.out.println("Block 1 : " + i);
			}
			//Thread.sleep(9000); // If thread is interrupted during sleeping, an exception will be thrown as "sleeping exception"
			System.out.println("Block 1 : ThreadInterruptOne sleep over");
		}catch(Exception e) {
			System.out.println("Block 1 : Interrupt exception ThreadInterruptOne >> " + e.getMessage());
		}
		
		try {
			System.out.println("Block 2 : ThreadInterruptOne going to sleep");
			Thread.sleep(20000);
			System.out.println("Block 2 : ThreadInterruptOne sleep over");
		}catch(Exception e) {
			System.out.println("Block 2 : Interrupt exception ThreadInterruptOne >> " + e.getMessage());
		}
		System.out.println("ThreadInterruptOne ends.....");
	}

}
