package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Community_Cards {

	public static int communityCards() {
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
		long which_Card = System.nanoTime();
		Collections.shuffle(comCards, new Random(which_Card));
		System.out.println(which_Card);
		return (int) which_Card;

	}

	public static void advanceToGo() throws IOException {
		Player.setSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs(), 0);
		Player.setMoney(Game.getPlayerWhosTurnItIs(), 200);
		// 200
	}

	public static void bankError() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 200);
	}

	public static void saleStock() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 50);

	}

	public static void doctorFees() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) - 50);
		// 50
	}

	public static void getOuttaJail() {
		Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
	}

	public static void goToJail() {
		Player.setInJail(Game.getPlayerWhosTurnItIs(), true);
	}

	public static void grandOperaNight() throws IOException {
		int total = 0;
		// How do i check to see each individual character
		Player night = Game.getPlayerWhosTurnItIs();
		if ((!(night == Game.returnPlayerOne())) && (Player.getPlayingGame(Game.returnPlayerOne()))) {
			Player.setMoney(Game.returnPlayerOne(), -50);
			total += 50;
		} else if ((!(night == Game.returnPlayerTwo())) && (Player.getPlayingGame(Game.returnPlayerTwo()))) {
			Player.setMoney(Game.returnPlayerTwo(), -50);
			total += 50;
		} else if ((!(night == Game.returnPlayerThree())) && (Player.getPlayingGame(Game.returnPlayerThree()))) {
			Player.setMoney(Game.returnPlayerThree(), -50);
			total += 50;
		} else if ((!(night == Game.returnPlayerFour())) && (Player.getPlayingGame(Game.returnPlayerFour()))) {
			Player.setMoney(Game.returnPlayerFour(), -50);
			total += 50;
		} else if ((!(night == Game.returnPlayerFive())) && (Player.getPlayingGame(Game.returnPlayerFive()))) {
			Player.setMoney(Game.returnPlayerFive(), -50);
			total += 50;
		} else if ((!(night == Game.returnPlayerSix())) && (Player.getPlayingGame(Game.returnPlayerSix()))) {
			Player.setMoney(Game.returnPlayerSix(), -50);
			total += 50;
		} else if ((!(night == Game.returnPlayerSeven())) && (Player.getPlayingGame(Game.returnPlayerSeven()))) {
			Player.setMoney(Game.returnPlayerSeven(), -50);
			total += 50;
		} else if ((!(night == Game.returnPlayerEight())) && (Player.getPlayingGame(Game.returnPlayerEight()))) {
			Player.setMoney(Game.returnPlayerEight(), -50);
			total += 50;
		}

		Player.setMoney(Game.getPlayerWhosTurnItIs(), total);
	}

	public static void holidayFundMatures() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 50);
	}

	public static void incomeTaxReturn() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 20);
	}

	public static void lifeInsuranceFunds() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 100);
	}

	public static void hospitalBill() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) - 100);
	}

	public static void schoolFee() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) - 150);
	}

	public static void serviceFee() throws IOException {
		Player.setMoney(Game.getPlayerWhosTurnItIs(), Player.getMoney(Game.getPlayerWhosTurnItIs()) + 25);
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