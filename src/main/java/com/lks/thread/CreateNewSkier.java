package com.lks.thread;

import org.springframework.beans.factory.annotation.Autowired;

import com.lks.service.AddToQueue;

public class CreateNewSkier implements Runnable {
	
	AddToQueue addToQueue;
	
	Thread t;
	private final String skier;
	
	public CreateNewSkier(String skierName, AddToQueue addToQueue) {

		skier = skierName;
		this.addToQueue = addToQueue;
		t = new Thread(this, skier);
		t.start();
		
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
