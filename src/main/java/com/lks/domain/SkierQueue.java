package com.lks.domain;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import lombok.ToString;

@ToString
public class SkierQueue implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Queue<String> leftSingle = new ArrayBlockingQueue<String>(20);
	public Queue<String> rightSingle = new ArrayBlockingQueue<String>(20);
	public Queue<String> leftTriple = new ArrayBlockingQueue<String>(20);
	public Queue<String> rightTriple = new ArrayBlockingQueue<String>(20);
	public HashMap<String, Long> skiersMap = new HashMap<String, Long>();
	public ArrayList<String> liftChair = new ArrayList<String>();
	
	public List<Integer> lsTimes = new ArrayList<Integer>();
	public List<Integer> ltTimes = new ArrayList<Integer>();
	public List<Integer> rsTimes = new ArrayList<Integer>();
	public List<Integer> rtTimes = new ArrayList<Integer>();
	
	DecimalFormat df = new DecimalFormat("#,##");
	
	
	public Double getLSWaitTimeAverage() {
		
		double sum = 0;
		double result = 0;
		
		for(int i = 0; i < lsTimes.size(); i++) {
			sum = sum + lsTimes.get(i);
		}
		
		if(!lsTimes.isEmpty()) {
			result = (double)(sum/lsTimes.size());
		}
		
		return Double.valueOf(df.format(result));
	}
	
	public Double getLTWaitTimeAverage() {
		
		double sum = 0;
		double result = 0;
		
		for(int i = 0; i < ltTimes.size(); i++) {
			sum = sum + ltTimes.get(i);
		}
		
		if(!ltTimes.isEmpty()) {
			result = (double)(sum/ltTimes.size());
		}
		
		return Double.valueOf(df.format(result));
	}
	
	public Double getRSWaitTimeAverage() {
		
		double sum = 0;
		double result = 0;
		
		for(int i = 0; i < rsTimes.size(); i++) {
			sum = sum + rsTimes.get(i);
		}
		
		if(!rsTimes.isEmpty()) {
			result = (double)(sum/rsTimes.size());
		}
		
		return Double.valueOf(df.format(result));
	}
	
	public Double getRTWaitTimeAverage() {
		
		double sum = 0;
		double result = 0;
		
		for(int i = 0; i < rtTimes.size(); i++) {
			sum = sum + rtTimes.get(i);
		}
		
		if(!rtTimes.isEmpty()) {
			result = (double)(sum/rtTimes.size());
		}
		
		return Double.valueOf(df.format(result));
	}

	
}
