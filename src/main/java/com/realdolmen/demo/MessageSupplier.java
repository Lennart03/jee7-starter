package com.realdolmen.demo;

import java.util.List;
import java.util.Random;

public interface MessageSupplier {
	
	static final Random random = new Random();

	String supplyRandomMessage();
	
	List<String> getMessages();
	
	default String getMessage(){
		Random random = new Random();
		int index = random.nextInt(getMessages().size());
		return getMessages().get(index);
		
	}
	
}
