package cluedo.main;

import cluedo.main.card.Card;

/**
 * Class representing a cluedo player.
 * @author Darcy
 */
public class Player {
	
	private Hand hand;
	private String name;
	
	public Player(String name) {
		this.name = name;
		hand = new Hand();
	}
	
	/**
	 * Allows a player to direct a guess at another player.
	 * @param p the player the guess is to be sent to.
	 * @return the card that the player responds to the guess with. Null if the player didn't have any of the cards in the guess.
	 */
	public Card sendGuess(Envelope g, Player p) {
		
		// the specified player processes the guess.
		return p.receiveGuess(g, this);
	}
	
	/**
	 * Allows a player to receive guesses from other players.
	 * @Param p the player the guess came from
	 * @return Either null or a card matching one of the cards from the guess.
	 */
	public Card receiveGuess(Envelope g, Player p) {
		
		Card[] matching = hand.processGuess(g).toArray(new Card[0]);
		
		if(matching.length == 0) {
			return null;
		} else {
			// there is at least one matching card. return a random one.
			int rand = (int) (Math.random() * matching.length);
			return matching[rand];
		}
	}
	
	
	/**
	 * To be called when dealing a card to a player. 
	 * Adds a specified card to the players hand.
	 * @param c The card to be added to this player's hand
	 */
	public void addToHand(Card c) {
		hand.addCard(c);
	}
	
	public void printHand() {
		for (Card c : hand) {
			System.out.println(c);
		}
	}
	
	public String toString() {
		return name;
	}
}
