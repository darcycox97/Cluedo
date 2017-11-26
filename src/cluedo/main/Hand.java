package cluedo.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import cluedo.main.card.Card;

/**
 * Class representing a cluedo hand. i.e a set of cards.
 * @author Darcy
 *
 */
public class Hand implements Iterable<Card>{
	
	private Set<Card> hand;
	
	public Hand() {
		hand = new HashSet<Card>();
	}
	
	/**
	 * Returns true if this hand contains the specified card.
	 */
	public boolean contains(Card c) {
		return hand.contains(c);
	}
	
	/** 
	 * Add the specified card to this hand
	 */
	public void addCard(Card c) {
		hand.add(c);
	}
	
	/**
	 * Removes the specified card from this hand
	 */
	public void removeCard(Card c) {
		hand.remove(c);
	}

	@Override
	public Iterator<Card> iterator() {
		return hand.iterator();
	}
	
	/**
	 * Returns all cards in this set that match cards in the specified guess.
	 */
	public Set<Card> processGuess(Envelope g) {
		
		Set<Card> matching = new HashSet<Card>();
		
		for (Card c : hand) {
			if (g.contains(c)) {
				matching.add(c); // add a card to the set if it matches a card in the guess.
			}
		}
		
		return matching;
	}

}
