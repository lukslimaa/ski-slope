package com.lks.service;

public class TakeUpRateService {
	
	private final int SKI_LIFT_SIZE = 4;
	private int count = 0;
	private float avg = 0;
	private float rate = 0;
	
	public float getTakeUpRate(int seatsTaken) {
		
		count++;
		rate = rate + (seatsTaken/SKI_LIFT_SIZE);
		avg = (rate/count)*100;
		
		System.out.println("\nTaxa de Aproveitamento: " + avg + "% \n");
		
		return avg;
		
	}

}
