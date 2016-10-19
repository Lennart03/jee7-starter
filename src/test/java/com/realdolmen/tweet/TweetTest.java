package com.realdolmen.tweet;

import java.util.Set;

import javax.crypto.CipherInputStream;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.realdolmen.course.domain.Person;

public class TweetTest {

	private ValidatorFactory factory;
	private Validator validator;
	private Person testPerson;

	@Before
	public void init() {
		factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		testPerson = new Person("Test", "Person");
		testPerson.setEmail("person@derp.com");
		testPerson.setPassword("derp");
	}

	@After
	public void destroyFactory() {
		factory.close();
	}

	@Test
	public void dateMustBeInThePast() throws InterruptedException {
		Tweet tweet = new Tweet(testPerson, "MessageSDCSC");
		Thread.sleep(20);
		Set<ConstraintViolation<Tweet>> violations = validator.validate(tweet);
		assertEquals(0, violations.size());
		System.out.println();
	}

	@Test
	public void userNameIsMandatory() {
		Tweet tweet = new Tweet(null, "MessageSDCSC");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(tweet);
		assertEquals(1, violations.size());
		ConstraintViolation<Tweet> error = violations.iterator().next();
		assertEquals("may not be null", error.getMessage());
		System.out.println();
	}

	@Test
	public void tweetIsPrude() {
		Tweet tweet = new Tweet(testPerson, "Have a nice day");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(tweet);
		assertEquals(0, violations.size());
	}

	@Test
	public void activateGroup() {
		Tweet tweet = new Tweet(testPerson, "Have a nice day");
		Set<ConstraintViolation<Tweet>> violations = validator.validate(tweet, Tags.class);
		ConstraintViolation<Tweet> error = violations.iterator().next();
		System.out.println(error.getMessage());
		assertEquals(1, violations.size());
	}

}
