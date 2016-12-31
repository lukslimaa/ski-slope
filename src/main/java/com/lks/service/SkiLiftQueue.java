package com.lks.service;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Service;

@Service
public class SkiLiftQueue {
	
	/* Defining all queues we're gonna use further. */
	private Queue<String> leftSingle = new ArrayBlockingQueue<String>(20);
	private Queue<String> rightSingle = new ArrayBlockingQueue<String>(20);
	private Queue<String> leftTriple = new ArrayBlockingQueue<String>(20);
	private Queue<String> rightTriple = new ArrayBlockingQueue<String>(20);
	
	public synchronized void addSkierToQueue(String skier) {
		
		System.out.println("LS:" + leftSingle.size() + " LT:" + leftTriple.size() + " RT:" + rightTriple.size() + " RS:" + rightSingle.size());
		
		if(leftSingle.size() < 2*leftTriple.size() 
				&& leftSingle.size() < 2*rightTriple.size() 
				&& leftSingle.size() < rightSingle.size()){
			
			leftSingle.add(skier);
			System.out.println("Skier " + skier + " added to Left-Single queue!");
			return;
			
		}
		
		if(rightSingle.size() < 2*leftTriple.size() 
				&& rightSingle.size() < 2*rightTriple.size() 
				&& rightSingle.size() <= leftSingle.size()) {
			
			rightSingle.add(skier);
			System.out.println("Skier " + skier + " added to Right-Single queue!");
			return;
		}
		
		if(leftTriple.size() <= rightTriple.size()) {
			leftTriple.add(skier);
			System.out.println("Skier " + skier + " added to Left-Triple queue!");
			return;
		}
		
		else {
			
			rightTriple.add(skier);
			System.out.println("Skier " + skier + " added to Right-Triple queue!");
			return;
			
		}
		
	}
	
	public synchronized void addSkierToSkiLift() {
		
		if(leftTriple.size() >= 3 || rightTriple.size() >= 3) {
			
			if(leftTriple.size() >=3 && rightTriple.size() >= 3) {
				
				Random Dice = new Random(); 
				int n = Dice.nextInt(2);
				int count = 0;
				
				switch (n) {
				case 1:
					
					while(count < 3) {
						
						System.out.println(">>>>> The skier ("+ leftTriple.remove() +") was .");
						count++;
					}
					
					break;

				case 2:
					
					while(count < 3) {
						
						System.out.println(">>>>> The skier ("+ rightTriple.remove() +") was .");
						count++;
						
					}
					
					break;
					
				}
			}
			
		} else {
			
		}
		
	}

}
