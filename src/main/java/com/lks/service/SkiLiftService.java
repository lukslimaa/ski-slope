package com.lks.service;

import java.util.ArrayList;
import java.util.Random;

import javax.ejb.Remove;

import com.lks.domain.Skier;
import com.lks.domain.SkierQueue;
import com.lks.utils.RemoveFromQueue;

public class SkiLiftService {

	private int lsSize = 0,
				ltSize = 0,
				rsSize = 0,
				rtSize = 0,
				count = 0;
	
	public void addSkierToSkiLiftChair(SkierQueue sq) throws InterruptedException {
		
		/* getting the queue size */
		lsSize = sq.leftSingle.size();
		ltSize = sq.leftTriple.size();
		rsSize = sq.rightSingle.size();
		rtSize = sq.rightTriple.size();
		
		/* cleaning the lift chair to be used again for new skiers */
		sq.liftChair.clear();
		
		if(count == 0) {count++;}else{count--;}
		
		
		if(ltSize >= 3 || rtSize >=3) {
			System.out.println("=-------------------------------- Ski Lift Service Starting (triple) --------------------------------=");
			takeSkierFromTripleQueues(sq);
			System.out.println("=-------------------------------- Ski Lift Service Finishing --------------------------------=");
		} 
		
		/* case LT and RT are empty*/
		else if(lsSize >= 4 || rsSize >= 4) {
			System.out.println("=-------------------------------- Ski Lift Service Starting (single) --------------------------------=");
			takeSkierFromSingleQueues(sq);
			System.out.println("=-------------------------------- Ski Lift Service Finishing --------------------------------=");
		}
		
		System.out.println("------=== [ LS:" + sq.leftSingle.size() +
				" LT:" + sq.leftTriple.size() +
				" RS:" + sq.rightSingle.size() +
				" RT:" + sq.rightTriple.size()+ " ]===------");
		

	}
	
	public void takeSkierFromTripleQueues(SkierQueue sq) throws InterruptedException {
		
		if(sq.leftTriple.size() >= 3 && sq.rightTriple.size() >=3) {
			
			/* taking 3 skiers off from triple queue*/
			if(count == 0) {	
				while(sq.liftChair.size() < 3) {
					System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "lt") + " added to the chair!");
				}
				
			} 
			
			else {
				while(sq.liftChair.size() < 3) {
					System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "rt") + " added to the chair!");
				}
			}
			
			takeSuplementerSkier(sq);
			
		/* if just left triple queue is not empty*/	
		} else if (sq.leftTriple.size() >= 3) {
			
			while(sq.liftChair.size() < 3) {
				System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "lt") + " added to the chair!");
			}
			
			takeSuplementerSkier(sq);
		}
		
		/* if only right triple is not empty*/
		else {
			
			while(sq.liftChair.size() < 3) {
				System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "rt") + " added to the chair!");
			}
			
			takeSuplementerSkier(sq);
		}
		
	}
	
	public void takeSkierFromSingleQueues(SkierQueue sq) throws InterruptedException {
		
		if(sq.leftSingle.size() >= 4 && sq.rightSingle.size() >= 4) {
			
			while(sq.liftChair.size() < 4) {
				
				if(count == 0) {
					System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "ls") + " added to the chair!");
				} else {
					System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "rs") + " added to the chair!");
				}
			}
			
		} else if(sq.leftSingle.size() >= 4) {
			while(sq.liftChair.size() < 4) {
				System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "ls") + " added to the chair!");
			}
		} else if(sq.rightSingle.size() >= 4) {
			while(sq.liftChair.size() < 4) {
				System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "rs") + " added to the chair!");
			}
		}
		
	}
	
	public void takeSuplementerSkier(SkierQueue sq) throws InterruptedException {
		
		if(sq.leftSingle.size() >=1 && sq.rightSingle.size() >= 1) {
			
			if(count == 0) {
				System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "ls") + " added to the chair!");
			} else {
				System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "rs") + " added to the chair!");
			}
			
		} else if(sq.leftSingle.size() >= 1) {
			System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "ls") + " added to the chair!");
		} else {
			System.out.println(">>>> Skier " + RemoveFromQueue.removeSkier(sq, "rs") + " added to the chair!");
		}
		
	}
	

}
