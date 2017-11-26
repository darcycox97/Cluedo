package cluedo.main.deck;

import java.util.ArrayList;
import java.util.List;

import cluedo.main.card.Person;
import cluedo.main.card.name.PersonName;

public class PersonDeck extends CardCollection<Person> {

	@Override
	protected List<Person> cards() {

		ArrayList<Person> cards = new ArrayList<Person>();
	
		for (PersonName pn : PersonName.values()) {
			cards.add(new Person(pn.toString()));
		}
		
		return cards;
	}

}
