package com.lks.service;


import java.util.Date;

import org.springframework.stereotype.Service;

import com.lks.domain.SkierQueue;

@Service
public class SkiLiftQueueService {
	
	private final int SIZE = 20;
	
	
	
public void addSkierToQueue(String skier, SkierQueue sq) throws InterruptedException {
		
		
		/* -------- Adding skier to the Left-Single queue -------- */
		if(sq.leftSingle.size() < (2*sq.leftTriple.size()) 
				&& sq.leftSingle.size() < (2*sq.rightTriple.size()) 
				&& sq.leftSingle.size() < sq.rightSingle.size()) {
			
			
			while(sq.leftSingle.size() == SIZE) {
				synchronized (sq.leftSingle) {
					sq.leftSingle.wait();
				}
			}
			
			synchronized(sq.leftSingle) {
				sq.leftSingle.add(skier);
				sq.leftSingle.notifyAll();
				sq.skiersMap.put(skier, System.nanoTime());
				System.out.println("Skier " + skier + " added to Left-Single queue!");
				return;
			}
			
		}
		
		/* -------- Adding skier to the Right-Single queue -------- */
		else if(sq.rightSingle.size() < (2*sq.leftTriple.size()) 
				&& sq.rightSingle.size() < (2*sq.rightTriple.size()) 
				&& sq.rightSingle.size() <= sq.leftSingle.size()) {
			
			while(sq.rightSingle.size() == SIZE) {
				synchronized(sq.rightSingle) {
					sq.rightSingle.wait();
				}
			}
			
			synchronized(sq.rightSingle) {
				sq.rightSingle.add(skier);
				sq.rightSingle.notifyAll();
				sq.skiersMap.put(skier, System.nanoTime());
				System.out.println("Skier " + skier + " added to Right-Single queue!");
				return;
			}
		}
		
		/* -------- Adding skier to the Left-Triple queue -------- */
		else if(sq.leftTriple.size() <= sq.rightTriple.size()) {
			
			while(sq.leftTriple.size() == SIZE) {
				synchronized(sq.leftTriple) {
					sq.leftTriple.wait();
				}
			}
			
			synchronized(sq.leftTriple) {
				sq.leftTriple.add(skier);
				sq.leftTriple.notifyAll();
				sq.skiersMap.put(skier, System.nanoTime());
				System.out.println("Skier " + skier + " added to Left-Triple queue!");
				return;
			}
		}
		
		/* -------- Adding skier to the Right-Triple queue -------- */
		else {
			
			while(sq.rightTriple.size() == SIZE) {
				synchronized(sq.rightTriple) {
					sq.rightTriple.wait();
				}
			}
			
			synchronized(sq.rightTriple) {
				sq.rightTriple.add(skier);
				sq.rightTriple.notifyAll();
				sq.skiersMap.put(skier, System.nanoTime());
				System.out.println("Skier " + skier + " added to Right-Triple queue!");
				return;
			}
			
		}
			
	}

}
