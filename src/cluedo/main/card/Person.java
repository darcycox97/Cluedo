package cluedo.main.card;

import cluedo.main.card.name.PersonName;

public class Person extends Card {

	public Person(String name) {
		super(name);
		super.type = CardType.PERSON;
	}

	@Override
	protected boolean nameValid(String name) {
		for (PersonName pn : PersonName.values()) {
			if (pn.toString().equals(name)) {
				return true; // provided name matches a valid person name
			}
		}
		return false;
	}

}
