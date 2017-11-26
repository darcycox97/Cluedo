package cluedo.main.deck;

import java.util.ArrayList;
import java.util.List;

import cluedo.main.Envelope;
import cluedo.main.card.Card;
import cluedo.main.card.Person;
import cluedo.main.card.Room;
import cluedo.main.card.Weapon;

/**
 * Class to represent a collection of all cards in cluedo.
 * @author Darcy
 */
public class Deck extends CardCollection<Card> {
	
	// constants representing all cards from each of the three categories.
	private static final RoomDeck ROOMS = new RoomDeck();
	private static final WeaponDeck WEAPONS = new WeaponDeck();
	private static final PersonDeck PERSONS = new PersonDeck();

	@Override
	protected List<Card> cards() {
		
		ArrayList<Card> cards = new ArrayList<Card>();
		
		// add all cards from each category to the deck.
		for (Card c : ROOMS) {
			cards.add(c); 
		}
		
		for (Card c : WEAPONS) {
			cards.add(c);
		}
		
		for (Card c : PERSONS) {
			cards.add(c); 
		}
		
		return cards;
	}
	
	public Envelope initializeEnvelope() {
		
		// get the first card from each collection category and place it in the envelope.
		// each of these collections is already shuffled so no action needs to be taken to ensure the card is random.
		Room room = ROOMS.iterator().next();
		Weapon weapon = WEAPONS.iterator().next();
		Person person = PERSONS.iterator().next();
		
		// remove each card from the deck then add each to the envelope.
		remove(room);
		remove(weapon);
		remove(person);
		
		return new Envelope(room, weapon, person);
	}

}
