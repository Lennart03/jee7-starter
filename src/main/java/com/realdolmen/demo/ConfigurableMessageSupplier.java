package com.realdolmen.demo;

import java.util.List;

import javax.inject.Inject;

@Prude
public class ConfigurableMessageSupplier implements MessageSupplier{

	private List<String> messages;
	
	@Inject
	public ConfigurableMessageSupplier(@Prude List<String> messages) {
		super();
		this.messages = messages;
	}
	
	@Override
	public List<String> getMessages() {
		return messages;
	}

	@Override
	public String supplyRandomMessage() {
		return messages.get(random.nextInt(messages.size()));
	}

}
