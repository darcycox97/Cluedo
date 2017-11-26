package cluedo.main.card.name;

/**
 * Enum defining all valid weapon names
 * @author Darcy
 */
public enum WeaponName {

	CANDLESTICK("Candlestick"),
	DAGGER("Dagger"),
	LEAD_PIPE("Lead Pipe"),
	REVOLVER("Revolver"),
	ROPE("Rope"),
	SPANNER("Spanner");
	
	private final String name;
	
	WeaponName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
