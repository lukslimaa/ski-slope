package com.lks.thread;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftService;

public class SkiLift extends Thread {
	
	Thread runner;
	SkiLiftService skiLiftService;
	SkierQueue skierQueue;
	
	public SkiLift(SkiLiftService sls, SkierQueue sq) throws InterruptedException {
		this.skiLiftService = sls;
		this.skierQueue = sq;
	}
	
	public void run() {

		try {
			
			while(true) {
				sleep(4000);
				skiLiftService.addSkierToSkiLiftChair(skierQueue);
			}
			
		} catch(Exception ex) {
			System.out.println("Something went wrong: " + ex);
		}
	}

}
