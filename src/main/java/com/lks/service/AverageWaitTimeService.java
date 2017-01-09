package com.lks.service;

import com.lks.domain.SkierQueue;

public class AverageWaitTimeService {

	
	public static long getWaitTimeBySkierService(SkierQueue sq, String skier) {
		
		long startTime = sq.skiersMap.get(skier);
		return (System.nanoTime() - startTime)/1000000000;
		
	}

}
