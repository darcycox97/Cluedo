package cluedo.test;

import static org.junit.Assert.*;

import org.junit.Test;
import cluedo.main.card.*;
import cluedo.main.card.name.PersonName;

public class Tests {

	@Test
	public void testCard() {
		
		assertTrue(new Person(PersonName.GREEN.toString()).equals(new Person(PersonName.GREEN.toString())));
		
		assertFalse(new Person(PersonName.WHITE.toString()).equals(new Person(PersonName.GREEN.toString())));
		
		try {
			new Room(PersonName.MUSTARD.toString());
			fail();
		} catch (RuntimeException e) {
			
		}
		
	}

}
