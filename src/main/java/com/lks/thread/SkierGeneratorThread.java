package com.lks.thread;

import com.lks.service.SkiLiftQueue;

public class SkierGeneratorThread extends Thread {
	
	SkiLiftQueue skiLiftQueue;
	
	public SkierGeneratorThread(SkiLiftQueue slq) {
		this.skiLiftQueue = slq;
	}
	
	public void run() {
		
		try {
			
			for(int i = 0; i <= 120; i++){
	    		new NewSkier("Lucas" + i, skiLiftQueue).start();
	    	}
			
		} catch (Exception e) {
			System.out.println("Something went wrong in the SkierGeneratorThread: " + e);
		}
		
	}
	
}
