package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import Nilrre.Jason.Alex.Law.Player;

public class Chance_Cards {
	static ArrayList<String> CARDS = new ArrayList<>();
	private static int UsedCardJail;
	private static int nextDrawIndex = 0;

	public void Make_Cards() {
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
		if (nextDrawIndex >= CARDS.size()) {
			Shuffle();
			System.out.println("*Shuffles Cards*");
			nextDrawIndex = 0;
		}
		return retVal;

	}

	public void CardEffects(String retVal) throws IOException {
			DRAW();
		if (retVal == "GTG") {
			System.out.println("Advance to go (Get to  Two Hundred)");
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 0);
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			System.out.println("Go to Go, collect $200");
		}
		if (retVal == "GTJ") {
			Player.setInJail(Game.getPlayerWhosTurnItIs(), true);
			System.out.println("Go to Jail");
		}
		if (retVal == "C50") {
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 50);
			System.out.println("Bank pays your dividend of $50");
		}
		if (retVal == "GB3") {//EDITED
			Game.getPlayerWhosTurnItIs();
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(),
					(Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs())) - 3);
			System.out.println("Go Back 3 Steps");
		}
		if (retVal == "ADV1") {
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 40);//EDITED
			System.out.println("You advanced to Boardwalk");
			int[] space12 = Player.spaceNumberToBoardCords(40);
			int row40 = space12[0];
			int col40 = space12[1];
			Player.checkSpaceMovedToForOwner(row40, col40, Game.getPlayerWhosTurnItIs());
		}
		if (retVal == "P15") {
			Player.setMoney(Game.getPlayerWhosTurnItIs(), -15);
			System.out.println("Pay the poor tax, Pay $15");
		}
		if (retVal == "ADV2") {
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 37){
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 25);
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			System.out.println("You advanced to Illinois Ave. and You've Passed GO");
			System.out.println("Collect $200");			
			}
			else{
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 25);
			System.out.println("You advanced to Illinois Ave.");
			}
		}
		if (retVal == "PEP50") {
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
			Player.setMoney(Game.getPlayerWhosTurnItIs(), -50 * (Game.amountOfPlayers-1));
			System.out.println("You been Elected Chairman of the Board, Each player gets $50 form you");
			System.out.println("You've Lost $" + (-50 * (Game.amountOfPlayers-1)));
		}
		if (retVal == "ADV2NEARRAIL") {
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 8) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 16);
				System.out.println("You've Advanced to Pennsylvania RailRoad");
			}

			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 23) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 26);
				System.out.println("You've Advanced to B & O Railroad");
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 37) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 6);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
				System.out.println("You've Advanced to Reading Railroad, and you've passed GO");
				System.out.println("Collect $200");
				
			}

		}
		if (retVal == "ADV2READRAIL") {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 6);
				//WIP
		}
		if (retVal == "ADV3") {
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) > 12){
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 12);
				System.out.println("You've advanced to St.Charles Place");	
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) < 12){
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 12);
				System.out.println("You've advanced to St.Charles Place");
			}
		}
		if (retVal == "ADV2NEARUTIL") {//WIP check if owned and pay extra if it is
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 8) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 13);
				System.out.println("You've landed on Electric Company"); 
				int[] space12 = Player.spaceNumberToBoardCords(13);
				int row12 = space12[0];
				int col12 = space12[1];
				if (Game.getPlayerWhosTurnItIs() != Board.b.getOwnedBy(Board.board[row12][col12]) && Board.b.getOwnedBy(Board.board[row12][col12]) != null){
					System.out.println("But the Space is already Taken");
					Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getAmountOnDie(Game.getPlayerWhosTurnItIs()) * -10);
					
				}
				
			}

			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 23) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 29);
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 37) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 13);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			}
		}
		if (retVal == "C150") {
			Player.setMoney(Game.getPlayerWhosTurnItIs(),150);
		}
		if (retVal == "C100") {
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 100);
		}
		if (retVal == "GETOUT") {
			if(UsedCardJail==0){
				Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), true);
				UsedCardJail++;
				}
			if(UsedCardJail > 0){
				DRAW();
			}
				
		}
		if (retVal == "P25HOUSEPHOTEL100") {//WIP
			//int house = -25 * (NumberofHouses);
			//int hotel = -100 * (NumberofHotels);
			//int total = house + hotel;
			//Player.setMoney(Game.getPlayerWhosTurnItIs(), total);
		}
	}
}
