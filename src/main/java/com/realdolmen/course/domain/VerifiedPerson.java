package com.realdolmen.course.domain;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Ver")
public class VerifiedPerson extends Person{

	private Date verificationDate;
	private Integer verificationID;
	private String creditCard;
	
	public VerifiedPerson() {}
	
	public VerifiedPerson(String firstName, String lastName, Date verificationDate, Integer verificationID, String creditCard) {
		super(firstName, lastName);
		this.verificationDate = verificationDate;
		this.verificationID = verificationID;
		this.creditCard = creditCard;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public Date getVerificationDate() {
		return verificationDate;
	}

	public Integer getVerificationID() {
		return verificationID;
	}
	
	
	
	
	
	
	
}
