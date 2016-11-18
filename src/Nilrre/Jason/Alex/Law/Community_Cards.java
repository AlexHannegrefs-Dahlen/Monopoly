package Nilrre.Jason.Alex.Law;

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
		comCards.add("Get out of jail free"); // You can use this card to get outta jail											// out of jail
		comCards.add("Go to jail"); // You must go to jail
		comCards.add("Grand opera night opening"); // Collect 50 from every player
		comCards.add("Holiday fund matures"); // Collect 100
		comCards.add("Income tax refund"); // Collect 20
		comCards.add("Life insurance matures"); // Collect 100
		comCards.add("Pay hospital funds of $100"); // Pay 100
		comCards.add("Pay school fees of $150"); // Pay 150
		comCards.add("Recieve $25 consultabcy fee"); // Collect 25
		comCards.add("You are accessed for street repairs"); // Pay 40 per house and 115 per hotel
		comCards.add("You have one second prize in a beauty contest"); // Collect 10
		comCards.add("You inherit $100"); // Collect 100
		// Randomly select each card
		long which_Card = System.nanoTime();
		Collections.shuffle(comCards, new Random(which_Card));
		System.out.println(which_Card);
		return (int) which_Card;

	}

	public static void advanceToGo() {
		Player.setSpaceCurrentlyOn(player, boardspaces[10][10]);
		Player.setMoney(200);// Whatever they currently have plus
											// 200
	}

	public static void bankError() {
		Player.setMoney(200);// Whatever they currently have plus
											// 200
	}

	public static void doctorFees() {
		Player.setMoney(bankAccount - 50);// Whatever they currently have minus
											// 50
	}

	public static void getOuttaJail() {
		Player.setGetOutOfJailChest(JailChest, haveCard);
	}

	public static void goToJail() {
		if (player.contains(getOuttaJail()) {
			 boolean askForUse = ConsoleUI.promptForBool("Would you like to use your get out of jail card? [Yes/No]", "Yes", "No");
			 if (askForUse == true){
				 //remove get outta jail card
			 }
		}
			else {
				Player.setSpaceCurrentlyOn(player, boardspace[10][0]);
			}
		}
	
	public static void grandOperaNight() {
		int total = 0;
		if (Player1){
			Player.setMoney(bankAccount - 50);
			total += 50;
		}
		if (Player2){
			Player.setMoney(bankAccount - 50);
			total += 50;
		}
		if (Player3){
			Player.setMoney(bankAccount - 50);
			total += 50;
		}
		if (Player4){
			Player.setMoney(bankAccount - 50);
			total += 50;
		}
		if (Player5){
			Player.setMoney(bankAccount - 50);
			total += 50;
		}
		if (Player6){
			Player.setMoney(bankAccount - 50);
			total += 50;
	}
		if (Player7){
			Player.setMoney(bankAccount - 50);
			total += 50;
		}
		if (Player8){
			Player.setMoney(bankAccount - 50);
			total += 50;
		}
		
		Player.setMoney(bankAccount + total);
	}
	
	public static void holidayFundMatures() {
		Player.setMoney(backAccount + 50);
}
 	
 	public static void incomeTaxReturn() {
 		Player.setMoney(bankAccount + 20);
 	}
 	
 	public static void lifeInsuranceFunds() {
 		Player.setMoney(bankAccount + 100);
 	}
 	
 	public static void hospitalBill() {
 		Player.setMoney(bankAccount - 100);
 	}
  	public static void schoolFee() {
 		Player.setMoney(bankAccount - 150);
 	}
 	
 	public static void serviceFee() {
 		Player.setMoney(bankAccount + 25);
 	}
 	
 	public static void beautyContest() {
 		Player.setMoney(bankAccount + 10);
 	}
 	
 	public static void inheritance() {
 		Player.setMoney(bankAccount + 100);
 	}
 	
 	public static void streetRepairs() {
 		int houses = 0;
 	int hotels = 0;
 		for(int i  = 0; i < Land.size; i++){
 			if(land[i] == house){
 				houses++;	
 			}
 			else if(land[i] == hotels){
 				hotels++;
 			}
 		}
 		
 		houses *= 40;
 		hotels *= 115;
 		
 		Player.setMoney(bankAccount - (hotels + houses));
 	}
 }