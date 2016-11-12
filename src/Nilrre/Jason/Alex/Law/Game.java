package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Game {

	private static final Player one = new Player();
	private static final Player two = new Player();
	private static final Player three = new Player();
	private static final Player four = new Player();
	private static final Player five = new Player();
	private static final Player six = new Player();
	private static final Player seven = new Player();
	private static final Player eight = new Player();

	public static void RunGame() throws IOException {
		int amountOfPlayers = ConsoleUI.promptForInt("How many players?", 2, 8);

		for (int i = 1; i <= amountOfPlayers; i++) {
			makePlayer(i);
		}

		for (int i = 1; i <= amountOfPlayers; i++) {
			if (i == 1) {
				turn(one);
			} else if (i == 2) {
				turn(two);
			}
		}

	}

	public static void makePlayer(int playerNumber) throws IOException {
		System.out.println("Player " + playerNumber);
		if (playerNumber == 1) {
			Player.setPiece(one);
			System.out.println(Player.getPiece(one));
		} else if (playerNumber == 2) {
			Player.setPiece(two);
			System.out.println(Player.getPiece(two));
		} else if (playerNumber == 3) {
			Player.setPiece(three);
		} else if (playerNumber == 4) {
			Player.setPiece(four);
		} else if (playerNumber == 5) {
			Player.setPiece(five);
		} else if (playerNumber == 6) {
			Player.setPiece(six);
		} else if (playerNumber == 7) {
			Player.setPiece(seven);
		} else if (playerNumber == 8) {
			Player.setPiece(eight);
		}
	}

	public static void turn(Player play) throws IOException {
		String[] options = new String[] { "1: Roll", "2: Buy Houses or Hotels", "3: Trade with another Player" };
		int turnSelect = ConsoleUI.promptForMenuSelection(options, false);
		if (turnSelect == 1) {
			int move = 0;
			move = Player.roll();
			System.out.println(Player.getPiece(play) + " moves " + move + " spaces.");
		} else if (turnSelect == 2) {
			Player.buyHousesOrHotel();
		} else if (turnSelect == 3) {
			Trade.askForTradeOption();
		}
	}
}
