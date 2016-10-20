package com.realdolmen.tweet;

import com.realdolmen.course.domain.Person;

public class TweetStatisticsParser {
	
	private Person person;
	
	private Double avg;

	public TweetStatisticsParser(Person person, Double avg) {
		super();
		this.person = person;
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "["+this.person.getFirstName()+" " +this.person.getLastName()+" -> " + this.avg + "]";
	}
	
	
	

	
	

}
