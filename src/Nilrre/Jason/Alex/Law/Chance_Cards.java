package Nilrre.Jason.Alex.Law;

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
			nextDrawIndex = 0;
		}
		return retVal;

	}

	public void CardEffects(String retVal) {

		if (retVal == "GTG") {
			System.out.println("Advance to go (Get to  Two Hundred)");
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 0);
			// |if player doesn't automatically get there $200
			// V
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);

		}
		if (retVal == "GTJ") {
			Player.setInJail(Game.getPlayerWhosTurnItIs(), true);
		}
		if (retVal == "C50") {
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 50);
		}
		if (retVal == "GB3") {
			Game.getPlayerWhosTurnItIs();
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(),
					(Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs())) - 3);
		}
		if (retVal == "ADV1") {
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 39);
			System.out.println("You advanced to Boardwalk");
		}
		if (retVal == "P15") {
			Player.setMoney(Game.getPlayerWhosTurnItIs(), -15);
		}
		if (retVal == "ADV2") {
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 24);
			System.out.println("You advanced to Illinois Ave.");
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
			Player.setMoney(Game.getPlayerWhosTurnItIs(), -50 * Game.amountOfPlayers);

		}
		if (retVal == "ADV2NEARRAIL") {
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 7) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 15);
			}

			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 22) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 25);
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 36) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 5);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			}

		}
		if (retVal == "ADV2READRAIL") {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 5);
				//WIP
		}
		if (retVal == "ADV3") {
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) > 11){
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 11);
				System.out.println("You've advanced to St.Charles Place");	
				Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) < 11){
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 11);
				System.out.println("You've advanced to St.Charles Place");
			}
		}
		if (retVal == "ADV2NEARUTIL") {//WIP check if owned and pay extra if it is
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 7) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 12);
			}

			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 22) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 28);
			}
			if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == 36) {
				Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 12);
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
