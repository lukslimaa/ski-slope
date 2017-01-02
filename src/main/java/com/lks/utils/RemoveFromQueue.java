package com.lks.utils;

import java.util.ArrayList;

import com.lks.domain.SkierQueue;

public class RemoveFromQueue {
	
	private static String skier = "";
	
	public static String removeSkier(SkierQueue sq, String queue) {
		
		if (queue.equals("ls")) { 
			skier = sq.leftSingle.remove(); 
		}
		
		if(queue.equals("lt")) { 
			skier = sq.leftTriple.remove(); 
		}
		
		if(queue.equals("rs")) { 
			skier = sq.rightSingle.remove(); 
		}
		
		if(queue.equals("rt")) { 
			skier = sq.rightTriple.remove(); 
		}
		
		sq.liftChair.add(skier);
		
		return skier;
		
	}
}
