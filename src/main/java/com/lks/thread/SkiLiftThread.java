package com.lks.thread;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftService;
import com.lks.service.TakeUpRateService;

public class SkiLiftThread extends Thread {
	
	Thread runner;
	SkiLiftService skiLiftService;
	SkierQueue skierQueue;
	TakeUpRateService takeUp;
	
	public SkiLiftThread(SkiLiftService sls, SkierQueue sq, TakeUpRateService tu) throws InterruptedException {
		this.skiLiftService = sls;
		this.skierQueue = sq;
		this.takeUp = tu;
	}
	
	public void run() {

		try {
			
			while(true) {
				sleep(4000);
				skiLiftService.addSkierToSkiLiftChair(skierQueue, takeUp);
			}
			
		} catch(Exception ex) {
			System.out.println("Something went wrong: " + ex);
		}
	}

}
