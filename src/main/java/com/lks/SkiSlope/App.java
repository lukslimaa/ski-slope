package com.lks.SkiSlope;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftQueue;
import com.lks.service.SkiLiftService;
import com.lks.thread.SkiLift;
import com.lks.thread.SkierGeneratorThread;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
    	SkiLiftQueue slq = new SkiLiftQueue();
    	SkiLiftService sls = new SkiLiftService();
    	SkierQueue sq = new SkierQueue();
    	
    	new SkierGeneratorThread(slq, sq).start();
    	new SkiLift(sls, sq).start();

    }
}
