package cluedo.main.card.name;

/**
 * Enum defining all valid person names.
 */
public enum PersonName {
	SCARLET("Miss Scarlet"),
	PLUM("Professor Plum"),
	PEACOCK("Mrs. Peacock"),
	GREEN("Reverend Green"),
	MUSTARD("Colonel Mustard"),
	WHITE("Mrs. White");

	private final String name;
	
	PersonName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
