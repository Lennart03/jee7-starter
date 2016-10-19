package com.realdolmen.demo;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;

public class MessageFactory {

	@Produces
	@Prude
	public List<String> createMessages() {
		return Arrays.asList("Hello", "Nice weather", "This is a nice message");
	}

}
