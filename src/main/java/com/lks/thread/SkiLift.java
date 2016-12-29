package com.lks.thread;

import com.lks.service.SkiLiftQueue;

public class SkiLift extends Thread {
	
	SkiLiftQueue addToChair;
	
	public SkiLift(SkiLiftQueue slq) throws InterruptedException {
		this.addToChair = slq;
		sleep(4000);
	}
	
	public void run() {
		try {
			addToChair.addSkierToSkiLift();
		} catch(Exception ex) {
			System.out.println("Something went wrong: " + ex);
		}
	}

}
