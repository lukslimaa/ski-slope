package com.lks.SkiSlope;

import com.lks.service.AddToQueue;
import com.lks.thread.CreateNewSkier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	AddToQueue addToQueue = new AddToQueue();
    	
    	for(int i = 0; i <= 5; i++){
    		new CreateNewSkier("Lucas" + i, addToQueue);
    	}
        
    }
}
