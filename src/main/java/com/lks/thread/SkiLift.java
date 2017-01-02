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
		sleep(4000);
	}
	
	public void run() {

		try {
			
			while(true) {
				skiLiftService.addSkierToSkiLiftChair(skierQueue);
				sleep(4000);
			}
			
		} catch(Exception ex) {
			System.out.println("Something went wrong: " + ex);
		}
	}

}
