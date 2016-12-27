package com.lks.thread;

public class CreateNewSkier implements Runnable {
	
	public void run() {
		
		try {
			
			for(int i = 1; i <= 120; i++) {
				System.out.println("Skier ( " + i + " ) was added to the queue!\n");
				Thread.sleep(1000);
			}
			
		} catch (Exception ex) {
			System.out.println("Something went wrong: " + ex);
		}
	}

}
