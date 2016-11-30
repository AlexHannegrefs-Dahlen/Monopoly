package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Nilrre.Jason.Alex.Law.Player;

public class Chance_Cards {
	static ArrayList<String> CARDS = new ArrayList<>();
	private static int UsedCardJail;
	private static int nextDrawIndex = 0;
	static Property p = new Property();

	public static void Make_Cards() {
		// C = Collect
		// P = Pay
		CARDS.add("GTG");
		CARDS.add("GTJ");
		CARDS.add("C50");
		CARDS.add("GB3");/* go back 3 */
		CARDS.add("ADV1");
		CARDS.add("P15");
		CARDS.add("ADV2");
		CARDS.add("PEP50");/* Pay Each Player */
		CARDS.add("ADV2NEARRAIL");
		CARDS.add("ADV2READRAIL");
		CARDS.add("ADV3");
		CARDS.add("ADV2NEARUTIL");
		CARDS.add("C150");
		CARDS.add("C100");
		CARDS.add("GETOUT");
		CARDS.add("P25HOUSEPHOTEL100");

	}

	public static void Shuffle() {
		UsedCardJail = 0;
		System.out.println("*Shuffle Chance Cards*");
		for (int i = 0; i < 100; i++) {
			Random NUM = new Random();
			int number = NUM.nextInt(CARDS.size());
			int number2 = NUM.nextInt(CARDS.size());
			String Switch = CARDS.get(number);
			CARDS.set(number, CARDS.get(number2));
			CARDS.set(number2, Switch);
		}
	}

	static public String DRAW() {
		String retVal = CARDS.get(nextDrawIndex);
		nextDrawIndex++;
		System.out.println("*Draws Chance Card*");
		if (nextDrawIndex >= CARDS.size()) {
			Shuffle();
			System.out.println("*Shuffles Cards*");
			nextDrawIndex = 0;
		}
		return retVal;

	}

	public static void CardEffects() throws IOException {
		String retVal = DRAW();
		if (retVal == "GTG") {// Finished
			System.out.println("Advance to go (Get to  Two Hundred)");
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 1);
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			System.out.println("Go to Go, collect $200");
		}
		if (retVal == "GTJ") {// Finished
			Player.setInJail(Game.getPlayerWhosTurnItIs(), true);
			System.out.println("Go to Jail");
		}
		if (retVal == "C50") {// Finished
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 50);
			System.out.println("Bank pays your dividend of $50");
		}
		if (retVal == "GB3") {// Finished
			Game.getPlayerWhosTurnItIs();
			if(Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 3){
				Player.spaceNumberToBoardCords(40);
			}
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(),
					(Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs())) - 3);
			System.out.println("Go Back 3 Steps");
		}
		if (retVal == "ADV1") {// Finished
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 40);
			System.out.println("You advanced to Boardwalk");
			int[] space12 = Player.spaceNumberToBoardCords(40);
			int row40 = space12[0];
			int col40 = space12[1];
			Player.checkSpaceMovedToForOwner(row40, col40, Game.getPlayerWhosTurnItIs());
		}
		if (retVal == "P15") {// Finished
			Player.setMoney(Game.getPlayerWhosTurnItIs(), -15);
			System.out.println("Pay the poor tax, Pay $15");
		}
		if (retVal == "ADV2") {// Finished
			int[] space12 = Player.spaceNumberToBoardCords(25);
			int row40 = space12[0];
			int col40 = space12[1];
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 37) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 25);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
				System.out.println("You advanced to Illinois Ave., and You've Passed GO");
				System.out.println("Collect $200");
				Player.checkSpaceMovedToForOwner(row40, col40, Game.getPlayerWhosTurnItIs());
			} else {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 25);
				System.out.println("You advanced to Illinois Ave.");
				Player.checkSpaceMovedToForOwner(row40, col40, Game.getPlayerWhosTurnItIs());
			}
		}
		if (retVal == "PEP50") {// Finished
			for (int i = 1; i < Game.amountOfPlayers; i++) {
				if (i == 1 && (Game.returnPlayerOne() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerOne(), 50);
				} else if (i == 2 && (Game.returnPlayerTwo() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerTwo(), 50);
				} else if (i == 3 && (Game.returnPlayerThree() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerThree(), 50);
				} else if (i == 4 && (Game.returnPlayerFour() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerFour(), 50);
				} else if (i == 5 && (Game.returnPlayerFive() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerFive(), 50);
				} else if (i == 6 && (Game.returnPlayerSix() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerSix(), 50);
				} else if (i == 7 && (Game.returnPlayerSeven() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerSeven(), 50);
				} else if (i == 8 && (Game.returnPlayerEight() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerEight(), 50);
				}

			}
			Player.setMoney(Game.getPlayerWhosTurnItIs(), -50 * (Game.amountOfPlayers - 1));
			System.out.println("You been Elected Chairman of the Board, Each player gets $50 form you");
			System.out.println("You've Lost $" + (-50 * (Game.amountOfPlayers - 1)));
		}
		if (retVal == "ADV2NEARRAIL") {// Finished
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 8) {
				int[] space12 = Player.spaceNumberToBoardCords(16);
				int row12 = space12[0];
				int col12 = space12[1];
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 16);
				System.out.println("You've Advanced to Pennsylvania RailRoad");
				if (Game.getPlayerWhosTurnItIs() != Board.b.getOwnedBy(Board.board[row12][col12])
						&& Board.b.getOwnedBy(Board.board[row12][col12]) != null) {
					int val = p.PennsylvaniaRailroad();
					Player.setMoney(Game.getPlayerWhosTurnItIs(), -val);
					Player.setMoney(Board.b.getOwnedBy(Board.board[row12][col12]), val);
					System.out.println("But this spot is taken(and you have to pay double)");
					Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
				} else {
					Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
				}
			}

			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 23) {
				int[] space12 = Player.spaceNumberToBoardCords(26);
				int row12 = space12[0];
				int col12 = space12[1];
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 26);
				System.out.println("You've Advanced to B & O Railroad");
				if (Game.getPlayerWhosTurnItIs() != Board.b.getOwnedBy(Board.board[row12][col12])
						&& Board.b.getOwnedBy(Board.board[row12][col12]) != null) {
					int val = p.BandORailroad();
					Player.setMoney(Game.getPlayerWhosTurnItIs(), -val);
					Player.setMoney(Board.b.getOwnedBy(Board.board[row12][col12]), val);
					System.out.println("But this spot is taken(and you have to pay double)");
					Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
				} else {
					Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
				}
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 37) {
				int[] space12 = Player.spaceNumberToBoardCords(6);
				int row12 = space12[0];
				int col12 = space12[1];
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 6);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
				System.out.println("You've Advanced to Reading Railroad, and you've passed GO");
				System.out.println("Collect $200");
				if (Game.getPlayerWhosTurnItIs() != Board.b.getOwnedBy(Board.board[row12][col12])
						&& Board.b.getOwnedBy(Board.board[row12][col12]) != null) {
					int val = p.ReadingRailroad() * 2;
					Player.setMoney(Game.getPlayerWhosTurnItIs(), -val);
					Player.setMoney(Board.b.getOwnedBy(Board.board[row12][col12]), val);
					System.out.println("But this spot is taken(and you have to pay double)");
					Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
				} else {
					Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
				}
			}

		}
		if (retVal == "ADV2READRAIL") {// Finished
			int[] space12 = Player.spaceNumberToBoardCords(6);
			int row12 = space12[0];
			int col12 = space12[1];
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 6);
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			System.out.println("You've Advanced to Reading Railroad, and you've passed GO");
			System.out.println("Collect $200");
			Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
		}
		if (retVal == "ADV3") {// Finished
			int[] space12 = Player.spaceNumberToBoardCords(12);
			int row12 = space12[0];
			int col12 = space12[1];
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) > 12) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 12);
				System.out.println("You've advanced to St.Charles Place" + "\n" + "You Also Passed Go");
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
				Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());

			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) < 12) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 12);
				System.out.println("You've advanced to St.Charles Place");
				Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
			}
		}

		if (retVal == "ADV2NEARUTIL") {// Finished
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 8) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 13);
				System.out.println("You've landed on Electric Company");
				int[] space12 = Player.spaceNumberToBoardCords(13);
				int row12 = space12[0];
				int col12 = space12[1];
				if (Game.getPlayerWhosTurnItIs() != Board.b.getOwnedBy(Board.board[row12][col12])
						&& Board.b.getOwnedBy(Board.board[row12][col12]) != null) {
					int[] space121 = Player.spaceNumberToBoardCords(13);
					int row121 = space121[0];
					int col121 = space121[1];
					int val = Player.getAmountOnDie(Game.getPlayerWhosTurnItIs()) * 10;
					Player.setMoney(Game.getPlayerWhosTurnItIs(), -val);
					Player.setMoney(Board.b.getOwnedBy(Board.board[row121][col121]), val);
					System.out.println("But the Space is already Taken, you pay $" + val);

				} else {
					Player.checkSpaceMovedToForOwner(row12, col12, Game.getPlayerWhosTurnItIs());
				}
			}

			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 23) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 29);
				System.out.println("You've landed on Water Works");
				int[] space12 = Player.spaceNumberToBoardCords(29);
				int row12 = space12[0];
				int col12 = space12[1];
				if (Game.getPlayerWhosTurnItIs() != Board.b.getOwnedBy(Board.board[row12][col12])
						&& Board.b.getOwnedBy(Board.board[row12][col12]) != null) {
					int[] space121 = Player.spaceNumberToBoardCords(29);
					int row121 = space121[0];
					int col121 = space121[1];
					int val = Player.getAmountOnDie(Game.getPlayerWhosTurnItIs()) * 10;
					Player.setMoney(Game.getPlayerWhosTurnItIs(), -val);
					Player.setMoney(Board.b.getOwnedBy(Board.board[row121][col121]), val);
					System.out.println("But the Space is already Taken, you pay $" + val);
				}
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 37) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 13);
				System.out.println("You've landed on Electric Company");
				int[] space12 = Player.spaceNumberToBoardCords(13);
				int row12 = space12[0];
				int col12 = space12[1];
				if (Game.getPlayerWhosTurnItIs() != Board.b.getOwnedBy(Board.board[row12][col12])
						&& Board.b.getOwnedBy(Board.board[row12][col12]) != null) {
					int[] space121 = Player.spaceNumberToBoardCords(13);
					int row121 = space121[0];
					int col121 = space121[1];
					int val = Player.getAmountOnDie(Game.getPlayerWhosTurnItIs()) * 10;
					Player.setMoney(Game.getPlayerWhosTurnItIs(), -val);
					Player.setMoney(Board.b.getOwnedBy(Board.board[row121][col121]), val);
					System.out.println("But the Space is already Taken, you pay $" + val);
					Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
				}
			}
		}
		if (retVal == "C150") {// Finished
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 150);
			System.out.println("Your Loan matures, Collect $150");
		}
		if (retVal == "C100") {// Finished
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 100);
			System.out.println("you won a crossword competition, Collect $100");
		}
		if (retVal == "GETOUT") {// Finished
			if (UsedCardJail == 0) {
				Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), true);
				UsedCardJail++;
				System.out.println("You gained a Get out of Jail card");
			}
			if (UsedCardJail > 0) {
				DRAW();
			}

		}
		if (retVal == "P25HOUSEPHOTEL100") {// Finished?
			if ((Player.getHousesOwned(Game.getPlayerWhosTurnItIs()) == 0)
					&& Player.getHotelsOwned(Game.getPlayerWhosTurnItIs()) == 0) {
				throw new NullPointerException("You were accessed for street repairs, you don't own any real estate");
			}
			Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getHousesOwned(Game.getPlayerWhosTurnItIs()) * -20);
			Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getHotelsOwned(Game.getPlayerWhosTurnItIs()) * -100);
			System.out.println("You are accessed for street repairs, you pay $"
					+ (((Player.getHousesOwned(Game.getPlayerWhosTurnItIs())) * 20)
							+ (Player.getHotelsOwned(Game.getPlayerWhosTurnItIs()) * 100)));
		}
	}
}
