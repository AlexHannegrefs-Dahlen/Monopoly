package Nilrre.Jason.Alex.Law;

import java.util.ArrayList;
import java.util.Random;

public class Chance_Cards {
	ArrayList<String> CARDS = new ArrayList<>();
	
	int nextDrawIndex = 0;

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
		CARDS.add("ADV2RAIL1");
		CARDS.add("ADV2RAIL2");
		CARDS.add("ADV3");
		CARDS.add("ADV4");
		CARDS.add("C150");
		CARDS.add("ADV5");
		CARDS.add("GETOUT");
		CARDS.add("P25HOUSEPHOTEL100");

	}

	public void Shuffle() {
		for (int i = 0; i < 100; i++) {
			Random NUM = new Random();
			int number = NUM.nextInt(CARDS.size());
			int number2 = NUM.nextInt(CARDS.size());
			String Switch = CARDS.get(number);
			CARDS.set(number, CARDS.get(number2));
			CARDS.set(number2, Switch);
		}
	}

	public String DRAW() {
		String retVal = CARDS.get(nextDrawIndex);
		nextDrawIndex++;
		if(nextDrawIndex >= CARDS.size()) {
			Shuffle();
			nextDrawIndex = 0;
		}
		return retVal;
	}


	public void CardEffects(String retVal,BoardSpaces.SpaceColor) {
		if (retVal == "GTG"){
			
		}
		if (retVal == "GTJ"){
			
		}
		if (retVal == "C50"){
		}
		if (retVal == "GB3"){
		}
		if (retVal == "ADV1"){
		}
		if (retVal == "P15"){
		}
		if (retVal == "ADV2"){
		}
		if (retVal == "PEP50"){
		}
		if (retVal == "ADV2RAIL1"){
		}
		if (retVal == "ADV2RAIL2"){
		}
		if (retVal == "ADV3"){
		}
		if (retVal == "ADV4"){
		}
		if (retVal == "C150"){
		}
		if (retVal == "ADV5"){
		}
		if (retVal == "GETOUT"){
		}
		if (retVal == "P25HOUSEPHOTEL100"){
		}
	}

