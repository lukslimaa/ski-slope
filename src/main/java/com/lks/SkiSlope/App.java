package com.lks.SkiSlope;

import com.lks.service.SkiLiftQueue;
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
    	
    	new SkierGeneratorThread(slq).start();
    	new SkiLift(slq).start();

    }
}
