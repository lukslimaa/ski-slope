package com.lks.thread;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftQueue;

public class SkierGeneratorThread extends Thread {
	
	SkiLiftQueue skiLiftQueue;
	SkierQueue skierQueue;
	
	public SkierGeneratorThread(SkiLiftQueue slq, SkierQueue sq) {
		this.skiLiftQueue = slq;
		this.skierQueue = sq;
	}
	
	public void run() {
		
		try {
			
			for(int i = 0; i <= 120; i++){
	    		new NewSkier("Lucas" + i, skiLiftQueue, skierQueue).start();
	    	}
			
		} catch (Exception e) {
			System.out.println("Something went wrong in the SkierGeneratorThread: " + e);
		}
		
	}
	
}
