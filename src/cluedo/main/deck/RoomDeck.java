package cluedo.main.deck;

import java.util.ArrayList;
import java.util.List;

import cluedo.main.card.Room;
import cluedo.main.card.name.RoomName;

public class RoomDeck extends CardCollection<Room> {

	@Override
	protected List<Room> cards() {

		ArrayList<Room> cards = new ArrayList<Room>();
	
		for (RoomName pn : RoomName.values()) {
			cards.add(new Room(pn.toString()));
		}
		
		return cards;
	}

}
