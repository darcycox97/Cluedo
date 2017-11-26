package cluedo.main.card.name;

/**
 * Enum defining all valid room names.
 */
public enum RoomName {

	KITCHEN("Kitchen"),
	BALLROOM("Ballroom"),
	CONSERVATORY("Conservatory"),
	DINING("Dining Room"),
	BILLIARD("Billiard Room"),
	LIBRARY("Library"),
	LOUNGE("Lounge"),
	HALL("Hall"),
	STUDY("Study");
	
	private final String name;
	
	RoomName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
