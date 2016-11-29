package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Community_Cards {
	private static int ReShuffle = 0;

	public static void communityCards() {
		ArrayList<String> comCards = new ArrayList<String>();
		comCards.add("Advance to go"); // Collect 200
		comCards.add("Bank error in your favor"); // Collect 200
		comCards.add("Doctor fees"); // Pay 50
		comCards.add("From sale of stock you get $50"); // Collect 50
		comCards.add("Get out of jail free"); // You can use this card to get
												// outta jail // out of jail
		comCards.add("Go to jail"); // You must go to jail
		comCards.add("Grand opera night opening"); // Collect 50 from every
													// player
		comCards.add("Holiday fund matures"); // Collect 100
		comCards.add("Income tax refund"); // Collect 20
		comCards.add("Life insurance matures"); // Collect 100
		comCards.add("Pay hospital funds of $100"); // Pay 100
		comCards.add("Pay school fees of $150"); // Pay 150
		comCards.add("Recieve $25 consultabcy fee"); // Collect 25
		comCards.add("You are accessed for street repairs"); // Pay 40 per house
																// and 115 per
																// hotel
		comCards.add("You have one second prize in a beauty contest"); // Collect
																		// 10
		comCards.add("You inherit $100"); // Collect 100
		// Randomly select each card

	}

	public static void Shuffle1(ArrayList<String> comCards) {// Not sure if it
																// works
		Random Rnum = new Random();
		int Namber = Rnum.nextInt(6) + 5;
		for (int i = 0; i < Namber; i++) {
			Collections.shuffle(comCards);
		}
	}

	public static String draw(ArrayList<String> comCards) {
		String getCard = comCards.get(ReShuffle);
		ReShuffle++;
		if (ReShuffle >= comCards.size()) {
			Shuffle1(comCards);
			ReShuffle = 0;
		}
		return getCard;
	}

	public static void effects(String getCard) throws IOException{
		if(getCard == "Advance to go"){
			Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 1);
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			System.out.println();
		}
		if(getCard == "Bank error in your favor"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
			System.out.println();
		}
		if(getCard == "Doctor fees"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(), -50);
			System.out.println();
		}
		if(getCard == "From sale of stock you get $50"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 50);	
			System.out.println();
		}
		if(getCard == "Get out of jail free"){
			Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
			System.out.println();
		}
		if(getCard == "Go to jail"){
			Player.setInJail(Game.getPlayerWhosTurnItIs(), true);
			System.out.println();
		}
		if(getCard == "Grand opera night opening"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 50 * (Game.amountOfPlayers-1));
			System.out.println();
			for(int i = 0; i < Game.amountOfPlayers; i++){
				if (i == 1 && (Game.returnPlayerOne() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerOne(), -50);
				} else if (i == 2 && (Game.returnPlayerTwo() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerTwo(), -50);
				} else if (i == 3 && (Game.returnPlayerThree() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerThree(), -50);
				} else if (i == 4 && (Game.returnPlayerFour() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerFour(), -50);
				} else if (i == 5 && (Game.returnPlayerFive() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerFive(), -50);
				} else if (i == 6 && (Game.returnPlayerSix() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerSix(), -50);
				} else if (i == 7 && (Game.returnPlayerSeven() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerSeven(), -50);
				} else if (i == 8 && (Game.returnPlayerEight() != Game.getPlayerWhosTurnItIs())) {
					Player.setMoney(Game.returnPlayerEight(), -50);
				}
			}
		}
		if(getCard == "Holiday fund matures"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 50);	
			System.out.println();
		}
		if(getCard == "Income tax refund"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(),20);
			System.out.println();
		}
		if(getCard == "Life insurance matures"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(),100);
			System.out.println();
		}
		if(getCard == "Pay hospital funds of $100"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(),-100);
			System.out.println();
		}
		if(getCard == "Pay school fees of $150"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(),-150);
			System.out.println();
		}
		if(getCard == "Recieve $25 consultabcy fee"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(),25);
			System.out.println();
		}
		if(getCard == "You are accessed for street repairs"){//WIP
			System.out.println();
		}
		if(getCard == "You have one second prize in a beauty contest"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(),10);
			System.out.println();
		}
		if(getCard == "You inherit $100"){
			Player.setMoney(Game.getPlayerWhosTurnItIs(), 100);
			System.out.println("You inherit $100");
		}
		
	}
	
	public static void beautyContest() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 10);
	}

	public static void inheritance() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 100);
	}

	public static void streetRepairs() throws IOException {
		int cost = 0;
		for (int i = 0; i < Player.getland(Game.getPlayerWhosTurnItIs()).size(); i++) {
			cost += Player.getland(Game.getPlayerWhosTurnItIs()).get(i)
					.getHotel(Player.getland(Game.getPlayerWhosTurnItIs()).get(i)) * 115;
			cost += Player.getland(Game.getPlayerWhosTurnItIs()).get(i)
					.getHouses(Player.getland(Game.getPlayerWhosTurnItIs()).get(i)) * 40;
		}
		Player.setMoney(Game.getPlayerWhosTurnItIs(), cost);
	}

}