package cluedo.main;

import cluedo.main.card.Card;
import cluedo.main.card.Person;
import cluedo.main.card.Room;
import cluedo.main.card.Weapon;

/**
 * Represents a set of 3 cluedo cards. 
 * Contains one card from each of rooms, weapons, and persons.
 * @author Darcy
 */
public class Envelope {
	
	private Room room;
	private Weapon weapon;
	private Person person;
	
	public Envelope(Room r, Weapon w, Person p) {
		room = r;
		weapon = w;
		person = p;
	}
	
	public Room getRoom() {
		return room;
	}
	
	public Weapon getWeapon() {
		return weapon;
	} 
	
	public Person getPerson() {
		return person;
	}
	
	/**
	 * Returns true if this envelope contains the specified card.
	 */
	public boolean contains(Card c) {
		
		if (c.equals(person) || c.equals(weapon) || c.equals(room)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (!(obj instanceof Envelope)) {
			return false;
		}
		
		Envelope e = (Envelope) obj;
		if (!(this.room.equals(e.room))) {
			return false;
		}
		
		if (!(this.weapon.equals(e.weapon))) {
			return false;
		}
		
		if (!(this.person.equals(e.person))) {
			return false;
		}
		
		return true; // true if all room, weapon, person are equal.
	}
	
	
	public void print() {
		System.out.println("Person:\t" + person);
		System.out.println("Weapon:\t" + weapon);
		System.out.println("Room:\t" + room);
	}

	
}
