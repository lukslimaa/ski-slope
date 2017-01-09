package com.lks.thread;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftQueueService;

public class NewSkierThread extends Thread {
	
	SkiLiftQueueService skiLiftQueue;
	SkierQueue skierQueue;
	private final String skier;
	
	public NewSkierThread(String skierName, SkiLiftQueueService skiLiftQueue, SkierQueue skierQueue) throws InterruptedException {

		this.skier = skierName;
		this.skiLiftQueue = skiLiftQueue;
		this.skierQueue = skierQueue;
		sleep(500);
	}
	
	public void run() {
		
		try {
			
			skiLiftQueue.addSkierToQueue(skier, skierQueue);
			
		} catch (Exception ex) {
			
			System.out.println("Something went wrong: " + ex);
			
		}
	}

}
