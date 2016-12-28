package com.lks.service;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Service;

@Service
public class AddToQueue {
	
	/* Defining all queues we're gonna use further. */
	private Queue<String> leftSingle = new ArrayBlockingQueue<String>(20);
	private Queue<String> rightSingle = new ArrayBlockingQueue<String>(20);
	private Queue<String> leftTriple = new ArrayBlockingQueue<String>(20);
	private Queue<String> rightTriple = new ArrayBlockingQueue<String>(20);
	
	public void addSkierToQueue(String skier) {
		
		if(leftSingle.size() < 2*leftTriple.size() 
				&& leftSingle.size() < 2*rightTriple.size() 
				&& leftSingle.size() < rightSingle.size()){
			
			leftSingle.add(skier);
			System.out.println("Skier " + skier + " added to Left-Single queue!");
			
		}
		
		if(rightSingle.size() < 2*leftTriple.size() && rightSingle.size() < 2*rightTriple.size() && rightSingle.size() <= leftSingle.size()) {
			rightSingle.add(skier);
			System.out.println("Skier " + skier + " added to Right-Single queue!");
		}
		
		if(leftTriple.size() <= rightTriple.size()) {
			leftTriple.add(skier);
			System.out.println("Skier " + skier + " added to Left-Triple queue!");
		}
		
		else {
			rightTriple.add(skier);
			System.out.println("Skier " + skier + " added to Right-Triple queue!");
		}
		
	}

}
