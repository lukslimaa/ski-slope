package com.lks.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
	public ArrayList<String> liftChair = new ArrayList<String>();
	
}
