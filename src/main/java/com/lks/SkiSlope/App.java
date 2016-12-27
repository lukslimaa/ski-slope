package com.lks.SkiSlope;

import com.lks.thread.CreateNewSkier;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        (new Thread(new CreateNewSkier())).start();
        
    }
}
