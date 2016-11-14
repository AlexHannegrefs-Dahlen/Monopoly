package Nilrre.Jason.Alex.Law;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Community_Cards {

	public static void main(String[] args) {

	}

	public static int communityCards() {
		ArrayList <String> comCards = new ArrayList <String>();
		comCards.add("Advance to go");
		comCards.add("Bank error in your favor");
		comCards.add("Doctor fees");
		comCards.add("From sale of stock you get $50");
		comCards.add("Get out of jail free");
		comCards.add("Go to jail");
		comCards.add("Grand opera night opening");
		comCards.add("Holiday fund matures");
		comCards.add("Income tax refund");
		comCards.add("It is your birthday");
		comCards.add("Life insurance matures");
		comCards.add("Pay hospital funds of $100");
		comCards.add("Pay school fees of $150");
		comCards.add("Recieve $25 consultabcy fee");
		comCards.add("You are accessed for street repairs");
		comCards.add("You have one second prize in a beauty contest");
		comCards.add("You inherit $100");
		long which_Card = System.nanoTime();
		Collections.shuffle(comCards, new Random(which_Card));
		System.out.println(which_Card);
		return (int) which_Card;

	}
}
