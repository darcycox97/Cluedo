package cluedo.main;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import cluedo.main.card.Card;
import cluedo.main.card.Person;
import cluedo.main.card.Room;
import cluedo.main.card.Weapon;
import cluedo.main.card.name.PersonName;
import cluedo.main.card.name.RoomName;
import cluedo.main.card.name.WeaponName;
import cluedo.main.deck.Deck;

public class Main {

	private static final Scanner INPUT = new Scanner(System.in);

	public static void main(String[] args) {

		Player[] players;
		Player self;
		Envelope answer;
		Deck deck;

		System.out.println("||========================================||");
		System.out.println("||           Welcome to Cluedo!           ||");
		System.out.println("||========================================||");
		System.out.println(); 

		System.out.print("Enter number of players: ");
		int numPlayers = INPUT.nextInt();
		INPUT.nextLine();

		players = new Player[numPlayers];

		System.out.print("Enter your name: ");
		players[0] = new Player(INPUT.nextLine());
		self = players[0];

		// initialize players that aren't the user.
		for (int i = 1; i < numPlayers; i++) {
			StringBuilder sb = new StringBuilder();
			sb.append("Player ");
			sb.append(i);
			players[i] = new Player(sb.toString());
		}
		System.out.println();

		deck = new Deck();
		answer = deck.initializeEnvelope(); // the three cards that the player needs to guess.

		// deal cards to each player
		int index = 0;
		for (Card c: deck) {
			players[index++].addToHand(c);
			if (index >= players.length) {
				index = 0;
			}
		}

		// all cards have been dealt. can begin allowing player to make guesses.
		System.out.println("You may now start making deductions.");
		System.out.println();

		String control = "";
		do {

			// show the player their hand
			System.out.println("Your hand:");
			self.printHand();
			System.out.println();

			// vars used for the guess
			Envelope guess;
			Card result;

			// the player to direct the guess at
			Player player;

			// used to store user selections.
			int selection;

			// get the player to direct the guess at
			System.out.println("Which player do you want to ask?");
			selection = getSelectionIndexFromArray(Arrays.copyOfRange(players,1,players.length));
			player = players[selection + 1]; // add 1 to selection because this index applies to a sub array.

			// construct the guess
			guess = constructGuess();
			System.out.println("You selected:");
			guess.print();
			System.out.println();

			// pass the guess onto the specified player and get their answer.
			result = players[0].sendGuess(guess, player);
			if (result == null) {
				System.out.println(player + " did not have any of those cards!");
			} else {
				System.out.println(player + " shows you they have " + result);
			}
			System.out.println();

			System.out.print("Press \"g\" if you are ready to make the final guess. Or any other key to continue deducting: ");
			control = INPUT.nextLine();

		} while (!(control.equals("g")));

		Envelope finalGuess = constructGuess();

		if (finalGuess.equals(answer)) {
			System.out.println("That was correct! You win!");
		} else {
			System.out.println("Sorry that wasn't right! Better luck next time.");
		}

		System.out.println("The answer was");
		answer.print();


		INPUT.close();
	}


	// helper method to get a user selection from any array. 
	// returns the index of the selected item.
	private static int getSelectionIndexFromArray(Object[] arr) {

		boolean validSel;
		int sel;
		do {
			try {
				int index = 1;
				for (Object o : arr) {
					System.out.println(index + ")\t" + o);
					index++;
				}

				System.out.print("Enter number corresponding to selection: ");
				sel = INPUT.nextInt();
				INPUT.nextLine(); 
				
				// no exception thrown. selection valid if 
				if (sel > 0 && sel <= arr.length) {
					validSel = true;
				} else {
					validSel = false;
				} 
				
				System.out.println();
			} catch (InputMismatchException e) {
				validSel = false;
				sel = -1;
			}
			
			if (!validSel) {
				System.out.println("Please select a valid number.");
				System.out.println();
			}
			
		} while (!validSel);

		return sel - 1; // take away one to adjust for zero index
	}

	// helper to construct a user deduction or guess.
	private static Envelope constructGuess() {

		int selection;
		Person person;
		Weapon weapon;
		Room room;

		// get the person used for the guess
		System.out.println("Which Person?");
		selection = getSelectionIndexFromArray(PersonName.values());
		person = new Person(PersonName.values()[selection].toString());


		// get the weapon used for the guess
		System.out.println("Which weapon?");
		selection = getSelectionIndexFromArray(WeaponName.values());
		weapon = new Weapon(WeaponName.values()[selection].toString());


		// get the room used for the guess
		System.out.println("Which room?");
		selection = getSelectionIndexFromArray(RoomName.values());
		room = new Room(RoomName.values()[selection].toString());

		return new Envelope(room, weapon, person);
	}

}
