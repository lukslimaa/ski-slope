package com.lks.thread;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftQueueService;

public class SkierGeneratorThread extends Thread {
	
	SkiLiftQueueService skiLiftQueue;
	SkierQueue skierQueue;
	
	public SkierGeneratorThread(SkiLiftQueueService slq, SkierQueue sq) {
		this.skiLiftQueue = slq;
		this.skierQueue = sq;
	}
	
	public void run() {
		
		try {
			
			for(int i = 0; i <= 120; i++){
	    		new NewSkierThread("Lucas" + i, skiLiftQueue, skierQueue).start();
	    	}
			
		} catch (Exception e) {
			System.out.println("Something went wrong in the SkierGeneratorThread: " + e);
		}
		
	}
	
}
