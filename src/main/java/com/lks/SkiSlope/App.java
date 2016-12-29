package com.lks.SkiSlope;

import com.lks.domain.SkierQueue;
import com.lks.service.SkiLiftQueue;
import com.lks.thread.NewSkier;
import com.lks.thread.SkiLift;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	
    	SkiLiftQueue addToQueue = new SkiLiftQueue();

    	for(int i = 0; i <= 15; i++){
    		new NewSkier("Lucas" + i, addToQueue).start();
    	}
    	
    	new SkiLift(addToQueue).start();
        
    }
}
