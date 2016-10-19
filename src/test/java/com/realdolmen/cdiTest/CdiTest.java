package com.realdolmen.cdiTest;

import static org.junit.Assert.*;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import com.realdolmen.cdiTest.MemeContainer;

public class CdiTest {
	
	@Test
	public void cdiTest(){
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		Repost repost = container.select(Repost.class).get();
		System.out.println(repost);
		assertNotNull(repost);
	}

}
