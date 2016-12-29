package com.lks.thread;

import com.lks.service.AddToQueue;

public class NewSkier extends Thread {
	
	AddToQueue addToQueue;
	private final String skier;
	
	public NewSkier(String skierName, AddToQueue addToQueue) {

		this.skier = skierName;
		this.addToQueue = addToQueue;
		//setDaemon(true);
	}
	
	public void run() {
		
		try {
			addToQueue.addSkierToQueue(skier);
			Thread.sleep(1000);
			
		} catch (Exception ex) {
			
			System.out.println("Something went wrong: " + ex);
			
		}
	}

}
