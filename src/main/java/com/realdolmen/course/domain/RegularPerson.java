package com.realdolmen.course.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.source.realdolme.course.domain.profileEnums.FamilyState;

@Entity
@DiscriminatorValue("Reg")
public class RegularPerson extends Person {
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private Profile profile;
	
	public RegularPerson() {
	}
	
	public RegularPerson(String firstName, String lastName) {
		super(firstName, lastName);
	}

	public RegularPerson(String firstName, String lastName,Profile profile) {
		super(firstName, lastName);
		this.profile = profile;
	}

	public Profile getProfile() {
		return profile;
	}
	
	public void adjustFamilyState(FamilyState familyState){
		profile.setFamilyState(familyState);
	}
	
	
	
	
}
