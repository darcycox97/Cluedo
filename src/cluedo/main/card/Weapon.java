package cluedo.main.card;

import cluedo.main.card.name.WeaponName;

public class Weapon extends Card {

	public Weapon(String name) {
		super(name);
		super.type = CardType.WEAPON;
	}

	@Override
	protected boolean nameValid(String name) {
		for (WeaponName wn : WeaponName.values()) {
			if (wn.toString().equals(name)) {
				return true; // provided name matches a valid weapon name
			}
		}
		return false;
	}

}
