package com.lks.thread;

import com.lks.service.SkiLiftQueue;

public class NewSkier extends Thread {
	
	SkiLiftQueue addToQueue;
	private final String skier;
	
	public NewSkier(String skierName, SkiLiftQueue addToQueue) throws InterruptedException {

		this.skier = skierName;
		this.addToQueue = addToQueue;
		sleep(1000);
	}
	
	public void run() {
		
		try {
			
			addToQueue.addSkierToQueue(skier);
			
		} catch (Exception ex) {
			
			System.out.println("Something went wrong: " + ex);
			
		}
	}

}
