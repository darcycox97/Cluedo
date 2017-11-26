package cluedo.main.deck;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cluedo.main.card.Card;

/**
 * Class representing a collection of cluedo cards. 
 * @param T the type of card that this collection contains.
 * @author Darcy
 */
public abstract class CardCollection<T extends Card> implements Iterable<T> {

	protected List<T> cards;

	/**
	 * Constructs a collection of cards.
	 * The cards are shuffled as part of construction.
	 */
	public CardCollection() {

		// query subclasses for the cards in this collection.
		cards = new ArrayList<T>(cards());

		shuffle();
	}
	
	/**
	 * Shuffles the collection of cards.
	 */
	public void shuffle() {
		// iterate over each card in the array and swap it with a random position
		for (int i = 0; i < cards.size(); i++) {
			
			int rand = (int) (Math.random() * cards.size());

			T temp = cards.get(i);
			cards.set(i, cards.get(rand));
			cards.set(rand, temp);
		}
	}
	
	
	public void print() {
		for (int i = 0; i < cards.size() ; i++) {
			System.out.println(cards.get(i));
		}
		
		System.out.println("\n");
	}

	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < cards.size();
			}

			@Override
			public T next() {
				return cards.get(index++);
			}
			
		};
	}
	
	/**
	 * Removes the specified card from the collection.
	 */
	public void remove(T c) {
		cards.remove(c);
	}
	
	/**
	 * Returns all the cards to be in this collection.
	 */
	protected abstract List<T> cards(); 
}
