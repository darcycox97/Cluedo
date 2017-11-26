package cluedo.main.card;

/**
 * Abstract representation of a cluedo card.
 * @author Darcy
 */
public abstract class Card {
	
	private String name;
	protected CardType type;
	
	/**
	 * Constructs a card instance with the specified name.
	 * Valid names are those given when calling toString on 
	 * either the RoomName, WeaponName, or PersonName enums, depending on
	 * what type of card is being constructed.
	 * Runtime exception is thrown in case of an invalid name.
	 */
	public Card(String name) {
		if (!nameValid(name)) { 
			throw new RuntimeException("Invalid name provided to Card constructor");
		}
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Returns true if the name is valid.
	 * This will differ with each type of card so should be implemented by
	 * subclasses.
	 */
	protected abstract boolean nameValid(String name);
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}
		
		if (this.type != ((Card)obj).type) {
			return false;
		}
		
		return this.name.equals(((Card)obj).name);
	}
	
	@Override public String toString() {
		return this.name;
	}
}
