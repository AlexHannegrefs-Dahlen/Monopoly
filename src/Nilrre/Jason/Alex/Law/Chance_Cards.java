package Nilrre.Jason.Alex.Law;

import java.util.Random;

public class Chance_Cards {

	public static void main(String[] args) {
		CHANCE();

	}
	public static int CHANCE() {
		Random Chance_Number = new Random();
		int Which_Card = Chance_Number.nextInt(15);
		System.out.println(Which_Card);
		return Which_Card;

	}
}
