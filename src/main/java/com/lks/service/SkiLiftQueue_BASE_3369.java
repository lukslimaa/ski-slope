package com.lks.service;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Service;

import com.lks.domain.SkierQueue;

@Service
public class SkiLiftQueue {
	
	/* Defining all queues we're gonna be used further. */
//	private Queue<String> leftSingle = new ArrayBlockingQueue<String>(20);
//	private Queue<String> rightSingle = new ArrayBlockingQueue<String>(20);
//	private Queue<String> leftTriple = new ArrayBlockingQueue<String>(20);
//	private Queue<String> rightTriple = new ArrayBlockingQueue<String>(20);
	
	
	public synchronized void addSkierToQueue(String skier, SkierQueue sq) {
		
		System.out.println("queues: LS:" + sq.leftSingle.size() +
				" LT:" + sq.leftTriple.size() +
				" RS:" + sq.rightSingle.size() +
				" RT:" + sq.rightTriple.size());
		
		if(sq.leftSingle.size() < (2*sq.leftTriple.size()) 
				&& sq.leftSingle.size() < (2*sq.rightTriple.size()) 
				&& sq.leftSingle.size() < sq.rightSingle.size()) {
		
			sq.leftSingle.add(skier);
			System.out.println("Skier " + skier + " added to Left-Single queue!");
			return;
			
		}
		
		else if(sq.rightSingle.size() < (2*sq.leftTriple.size()) 
				&& sq.rightSingle.size() < (2*sq.rightTriple.size()) 
				&& sq.rightSingle.size() <= sq.leftSingle.size()) {
			
			sq.rightSingle.add(skier);
			System.out.println("Skier " + skier + " added to Right-Single queue!");
			return;
		}
		
		else if(sq.leftTriple.size() <= sq.rightTriple.size()) {
			
			sq.leftTriple.add(skier);
			System.out.println("Skier " + skier + " added to Left-Triple queue!");
			return;
		}
		
		else {
			
			sq.rightTriple.add(skier);
			System.out.println("Skier " + skier + " added to Right-Triple queue!");
			return;
			
		}
			
	}

}
