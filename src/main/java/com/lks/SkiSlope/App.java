package com.lks.SkiSlope;

import com.lks.service.AddToQueue;
import com.lks.thread.NewSkier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	AddToQueue addToQueue = new AddToQueue();
    	
    	for(int i = 0; i <= 100; i++){
    		new NewSkier("Lucas" + i, addToQueue).start();
    	}
        
    }
}
