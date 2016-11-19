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
	static int amountOfPlayers;
	private static boolean gameRunning = true;

	public static void RunGame() throws IOException {
		GamePieces.makeGamePieces();
		amountOfPlayers = ConsoleUI.promptForInt("How many players?", 2, 8);

		for (int i = 1; i <= amountOfPlayers; i++) {
			makePlayer(i);
		}
		do {
			for (int i = 1; i <= amountOfPlayers; i++) {
				if (i == 1) {
					turn(one);
				} else if (i == 2) {
					turn(two);
				} else if (i == 3) {
					turn(three);
				} else if (i == 4) {
					turn(four);
				} else if (i == 5) {
					turn(five);
				} else if (i == 6) {
					turn(six);
				} else if (i == 7) {
					turn(seven);
				} else if (i == 8) {
					turn(eight);
				}
			}
		} while (gameRunning);

	}

	public static void makePlayer(int playerNumber) throws IOException {
		System.out.println("Player " + playerNumber);
		if (playerNumber == 1) {
			Player.setPiece(one);
		} else if (playerNumber == 2) {
			Player.setPiece(two);
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

	public static Player getPlayerWhosTurnItIs() {
		if (Player.getMyTurn(one)) {
			return one;
		} else if (Player.getMyTurn(two)) {
			return two;
		} else if (Player.getMyTurn(three)) {
			return three;
		} else if (Player.getMyTurn(four)) {
			return four;
		} else if (Player.getMyTurn(five)) {
			return five;
		} else if (Player.getMyTurn(six)) {
			return six;
		} else if (Player.getMyTurn(seven)) {
			return seven;
		} else {
			return eight;
		}

	}

	public static void turn(Player play) throws IOException {
		Player.setMyTurn(play, true);
		System.out.println(Player.getPiece(play) + "'s turn.");
		String[] options = new String[] { "1: Roll", "2: Buy Houses or Hotels", "3: Trade with another Player" };
		int turnSelect = ConsoleUI.promptForMenuSelection(options, false);
		if (turnSelect == 1) {
			Player.roll(play);
		} else if (turnSelect == 2) {
			Player.buyHousesOrHotel(play);
		} else if (turnSelect == 3) {
			Player.trade(play);
		}
		Player.setMyTurn(play, false);
	}
}
