package com.lks.domain;

import java.io.Serializable;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import lombok.Data;
import lombok.ToString;

@ToString
public @Data class SkierQueue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Queue<String> leftSingle = new ArrayBlockingQueue<String>(20);
	private Queue<String> rightSingle = new ArrayBlockingQueue<String>(20);
	private Queue<String> leftTriple = new ArrayBlockingQueue<String>(20);
	private Queue<String> rightTriple = new ArrayBlockingQueue<String>(20);
	
}
