package com.realdolmen.demo;

import static org.junit.Assert.assertNotNull;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FortuneServiceIntegrationTest {
	
	private WeldContainer weldContainer;

	@Before
	public void init(){
		Weld weld = new Weld();
		weldContainer = weld.initialize();
		
	}
	
	@After
	public void destroy(){
		weldContainer.close();
	}
	
	@Test
	public void fortuneYieldsProfaneMessage(){
		FortuneService fortuneService = weldContainer.instance().select(FortuneService.class).get();
		String message = fortuneService.fortune();
		System.out.println("\n"+message+"\n");
		assertNotNull(message);
	}

}
