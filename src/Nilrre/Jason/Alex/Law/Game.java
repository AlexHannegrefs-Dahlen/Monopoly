package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
	private static final Player one = new Player();
	private static final Player two = new Player();
	private static final Player three = new Player();
	private static final Player four = new Player();
	private static final Player five = new Player();
	private static final Player six = new Player();
	private static final Player seven = new Player();
	private static final Player eight = new Player();
	private static ArrayList<Player> players = new ArrayList<>();
	static int amountOfPlayers;
	private static boolean gameRunning = true;

	public static Player returnPlayerOne() {
		return one;
	}

	public static Player returnPlayerTwo() {
		return two;
	}

	public static Player returnPlayerThree() {
		return three;
	}

	public static Player returnPlayerFour() {
		return four;
	}

	public static Player returnPlayerFive() {
		return five;
	}

	public static Player returnPlayerSix() {
		return six;
	}

	public static Player returnPlayerSeven() {
		return seven;
	}

	public static Player returnPlayerEight() {
		return eight;
	}

	public static void RunGame() throws IOException {
		GamePieces.makeGamePieces();
		amountOfPlayers = ConsoleUI.promptForInt("How many players?", 2, 8);
		Board b = new Board();
		b.createBoard();

		for (int i = 1; i <= amountOfPlayers; i++) {
			makePlayer(i);
		}
		do {
			for (int i = 1; i <= amountOfPlayers; i++) {
				if (i == 1) {
					turn(one);
					System.out.println("\nMoney: " + Player.getMoney(one));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(one));
					System.out.println("Land Owned: " + Player.getland(one) + "\n");

				} else if (i == 2) {
					turn(two);
					System.out.println("\nMoney: " + Player.getMoney(two));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(two));
					System.out.println("Land Owned: " + Player.getland(two) + "\n");
					
				} else if (i == 3) {
					turn(three);
					System.out.println("\nMoney: " + Player.getMoney(three));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(three));
					System.out.println("Land Owned: " + Player.getland(three) + "\n");
				} else if (i == 4) {
					turn(four);
					System.out.println("\nMoney: " + Player.getMoney(four));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(four));
					System.out.println("Land Owned: " + Player.getland(four) + "\n");
				} else if (i == 5) {
					turn(five);
					System.out.println("\nMoney: " + Player.getMoney(five));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(five));
					System.out.println("Land Owned: " + Player.getland(five) + "\n");
				} else if (i == 6) {
					turn(six);
					System.out.println("\nMoney: " + Player.getMoney(six));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(six));
					System.out.println("Land Owned: " + Player.getland(six) + "\n");
				} else if (i == 7) {
					turn(seven);
					System.out.println("\nMoney: " + Player.getMoney(seven));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(seven));
					System.out.println("Land Owned: " + Player.getland(seven) + "\n");
				} else if (i == 8) {
					turn(eight);
					System.out.println("\nMoney: " + Player.getMoney(eight));
					System.out.println("Jail Cards Owned: " + Player.getJailcard(eight));
					System.out.println("Land Owned: " + Player.getland(eight) + "\n");
					
					
					if(Player.getPlayingGame(one))
						turn(one);
					else
						break;
				} else if (i == 2) {
					if(Player.getPlayingGame(two))
						turn(two);
					else
						break;
				} else if (i == 3) {
					if(Player.getPlayingGame(three))
						turn(three);
					else
						break;
				} else if (i == 4) {
					if(Player.getPlayingGame(four))
						turn(four);
					else
						break;
				} else if (i == 5) {
					if(Player.getPlayingGame(five))
						turn(five);
					else
						break;
				} else if (i == 6) {
					if(Player.getPlayingGame(six))
						turn(six);
					else
						break;
				} else if (i == 7) {
					if(Player.getPlayingGame(seven))
						turn(seven);
					else
						break;
				} else if (i == 8) {
					if(Player.getPlayingGame(eight))
						turn(eight);
					else
						break;
				}
				b.printBoard(Board.board);
			}
		} while (gameRunning);

	}

	public static void makePlayer(int playerNumber) throws IOException {
		System.out.println("Player " + playerNumber);
		if (playerNumber == 1) {
			Player.setPiece(one);
			Player.setMoney(one, 1500);
			Player.setSpaceCurrentlyOn(one, 1);
			players.add(one);
		} else if (playerNumber == 2) {
			Player.setPiece(two);
			Player.setMoney(two, 1500);
			players.add(two);
			Player.setSpaceCurrentlyOn(two, 1);
		} else if (playerNumber == 3) {
			Player.setPiece(three);
			Player.setMoney(three, 1500);
			Player.setSpaceCurrentlyOn(three, 1);
			players.add(three);
		} else if (playerNumber == 4) {
			Player.setPiece(four);
			Player.setMoney(four, 1500);
			Player.setSpaceCurrentlyOn(four, 1);
			players.add(four);
		} else if (playerNumber == 5) {
			Player.setPiece(five);
			Player.setMoney(five, 1500);
			Player.setSpaceCurrentlyOn(five, 1);
			players.add(five);
		} else if (playerNumber == 6) {
			Player.setPiece(six);
			Player.setMoney(six, 1500);
			Player.setSpaceCurrentlyOn(six, 1);
			players.add(six);
		} else if (playerNumber == 7) {
			Player.setPiece(seven);
			Player.setMoney(seven, 1500);
			Player.setSpaceCurrentlyOn(seven, 1);
			players.add(seven);
		} else if (playerNumber == 8) {
			Player.setPiece(eight);
			Player.setMoney(eight, 1500);
			Player.setSpaceCurrentlyOn(eight, 1);
			players.add(eight);
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
		String[] options = new String[] { "1: Roll", "2: Buy Houses or Hotels", "3: Trade with another Player " };
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
