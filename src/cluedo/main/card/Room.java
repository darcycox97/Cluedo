package cluedo.main.card;

import cluedo.main.card.name.RoomName;

public class Room extends Card {

	public Room(String name) {
		super(name);
		super.type = CardType.ROOM;
	}

	@Override
	protected boolean nameValid(String name) {
		for (RoomName rn : RoomName.values()) {
			if (rn.toString().equals(name)) {
				return true; // provided name matches a valid room name
			}
		}
		return false;
	}
	
}
