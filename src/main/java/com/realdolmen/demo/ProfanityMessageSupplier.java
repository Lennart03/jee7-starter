package com.realdolmen.demo;

import java.util.Arrays;
import java.util.List;

@Profane
public class ProfanityMessageSupplier implements MessageSupplier {

	private List<String> messages = Arrays.asList(
			"Nobody gives one shit single fuck about your opinions, in fact I believe it would make the world a better place if you went away and never came back",
			"Why on earth do you reek like shit you live in a ditch, did you sleep with a corpse recently?",
			"Go fuck your stuffed animals, you sorry douche.");

	@Override
	public String supplyRandomMessage() {
		return messages.get(random.nextInt(messages.size()));
	}

	@Override
	public List<String> getMessages() {
		return messages;
	}

}
