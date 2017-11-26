package cluedo.main.deck;

import java.util.ArrayList;
import java.util.List;

import cluedo.main.card.Weapon;
import cluedo.main.card.name.WeaponName;

public class WeaponDeck extends CardCollection<Weapon> {
	
	@Override
	protected List<Weapon> cards() {

		ArrayList<Weapon> cards = new ArrayList<Weapon>();
	
		for (WeaponName pn : WeaponName.values()) {
			cards.add(new Weapon(pn.toString()));
		}
		
		return cards;
	}

}
