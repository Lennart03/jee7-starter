package com.realdolmen.demo;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named("fortune")
public class FortuneService {

	@Inject
	@Profane
	MessageSupplier messageSupplier;
	
	@Inject
	@ShitFortune
	private Event<String> shitFortune;
	
	public String fortune(){
		String fortune = messageSupplier.supplyRandomMessage();
		if(fortune.toLowerCase().contains("shit")){
			shitFortune.fire(fortune);
		}
		return fortune;
	}
	
	
}
