package com.realdolmen.demo;

import javax.enterprise.event.Observes;


public class ShitCounter {

	private int numberOfShits;
	
	public void shitHappend(@Observes @ShitFortune String fortune){
		numberOfShits++;
		System.out.println("The number of shits is: " + numberOfShits);
	}
	
}
