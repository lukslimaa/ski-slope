package com.lks.SkiSlope;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftQueueService;
import com.lks.service.SkiLiftService;
import com.lks.service.TakeUpRateService;
import com.lks.thread.SkiLiftThread;
import com.lks.thread.SkierGeneratorThread;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
    	SkiLiftQueueService slq = new SkiLiftQueueService();
    	SkiLiftService sls = new SkiLiftService();
    	TakeUpRateService tu = new TakeUpRateService();
    	SkierQueue sq = new SkierQueue();
    	
    	new SkierGeneratorThread(slq, sq).start();
    	new SkiLiftThread(sls, sq, tu).start();

    }
}
