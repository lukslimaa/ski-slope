package com.lks.utils;

import java.util.ArrayList;

import com.lks.domain.SkierQueue;

public class RemoveFromQueue {
	
	private static String skier = "";
	private final int SIZE = 20;
	
	public static String removeSkier(SkierQueue sq, String queue) throws InterruptedException {
		
		if (queue.equals("ls")) { 
			
			while(sq.leftSingle.isEmpty()) {
				sq.leftSingle.wait();
			}
			
			synchronized(sq.leftSingle) {
				sq.leftSingle.notifyAll();
				skier = sq.leftSingle.remove();
			} 
		}
		
		
		if(queue.equals("lt")) { 
			
			while(sq.leftTriple.isEmpty()) {
				sq.leftTriple.wait();
			}
			
			synchronized(sq.leftTriple) {
				sq.leftTriple.notifyAll();
				skier = sq.leftTriple.remove();
			}  
			
		}
		
		
		if(queue.equals("rs")) { 
			
			while(sq.rightSingle.isEmpty()) {
				sq.rightSingle.wait();
			}
			
			synchronized(sq.rightSingle) {
				sq.rightSingle.notifyAll();
				skier = sq.rightSingle.remove();
			} 
			
		}
		
		
		if(queue.equals("rt")) {
			
			while(sq.rightTriple.isEmpty()) {
				sq.rightTriple.wait();
			}
			
			synchronized(sq.rightTriple) {
				sq.rightTriple.notifyAll();
				skier = sq.rightTriple.remove();
			} 
			
		}
		
		
		sq.liftChair.add(skier);
		
		return skier;
		
	}
}
