package com.dl.service;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component("bat")
public class CricketBat {
	
	public CricketBat() {
		System.out.println("0-param contructor");
		
	}
	
	public int scoreRun() {
		System.out.println("CricketBat.scoreRun()");
	 return new Random().nextInt(0, 300);
	}

}
