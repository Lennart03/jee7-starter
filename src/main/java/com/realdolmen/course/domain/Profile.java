package com.realdolmen.course.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.source.realdolme.course.domain.profileEnums.AgeCategory;
import com.source.realdolme.course.domain.profileEnums.FamilyState;
import com.source.realdolme.course.domain.profileEnums.Intresse;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private AgeCategory ageCategory;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<Intresse> intresses = new HashSet<>();
	@Enumerated(EnumType.STRING)
	private FamilyState familyState;
	
	public Profile() {}

	public Profile(AgeCategory ageCategory, FamilyState familyState, Intresse...intresses ) {
		super();
		this.ageCategory = ageCategory;
		this.intresses = new HashSet<>(Arrays.asList(intresses));
		this.familyState = familyState;
	}

	public AgeCategory getAgeCategory() {
		return ageCategory;
	}

	protected void setAgeCategory(AgeCategory ageCategory) {
		this.ageCategory = ageCategory;
	}

	public FamilyState getFamilyState() {
		return familyState;
	}

	protected void setFamilyState(FamilyState familyState) {
		this.familyState = familyState;
	}

	public Set<Intresse> getIntresses() {
		return intresses;
	}
	
	protected void addIntresse(Intresse intresse) {
		intresses.add(intresse);
	}
	
	protected boolean removeInteresse(Intresse intresse){
		return intresses.remove(intresse);
	}

	
	
	
	
	
}
