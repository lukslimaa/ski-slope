package com.lks.domain;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@ToString
public @Data class SkierQueue implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer leftSingle;
}
