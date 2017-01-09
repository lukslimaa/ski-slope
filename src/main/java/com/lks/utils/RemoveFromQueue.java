package com.lks.utils;


import com.lks.domain.SkierQueue;
import com.lks.service.AverageWaitTimeService;

public class RemoveFromQueue {
	
	private static String skier = "";
	
	public static String removeSkier(SkierQueue sq, String queue) throws InterruptedException {
		
		if (queue.equals("ls")) { 
			
			while(sq.leftSingle.isEmpty()) {
				sq.leftSingle.wait();
			}
			
			synchronized(sq.leftSingle) {
				sq.leftSingle.notifyAll();
				skier = sq.leftSingle.remove();
				sq.lsTimes.add((int) (AverageWaitTimeService.getWaitTimeBySkierService(sq, skier)));
				
			} 
		}
		
		
		if(queue.equals("lt")) { 
			
			while(sq.leftTriple.isEmpty()) {
				sq.leftTriple.wait();
			}
			
			synchronized(sq.leftTriple) {
				sq.leftTriple.notifyAll();
				skier = sq.leftTriple.remove();
				sq.ltTimes.add((int) (AverageWaitTimeService.getWaitTimeBySkierService(sq, skier)));
			}  
			
		}
		
		
		if(queue.equals("rs")) { 
			
			while(sq.rightSingle.isEmpty()) {
				sq.rightSingle.wait();
			}
			
			synchronized(sq.rightSingle) {
				sq.rightSingle.notifyAll();
				skier = sq.rightSingle.remove();
				sq.rsTimes.add((int) (AverageWaitTimeService.getWaitTimeBySkierService(sq, skier)));
			} 
			
		}
		
		
		if(queue.equals("rt")) {
			
			while(sq.rightTriple.isEmpty()) {
				sq.rightTriple.wait();
			}
			
			synchronized(sq.rightTriple) {
				sq.rightTriple.notifyAll();
				skier = sq.rightTriple.remove();
				sq.rtTimes.add((int) (AverageWaitTimeService.getWaitTimeBySkierService(sq, skier)));
			} 
			
		}
		
		
		sq.liftChair.add(skier);
		
		return skier;
		
	}
}
