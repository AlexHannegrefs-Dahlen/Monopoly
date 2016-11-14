package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Trade {
	public static void whatPlayerToTradeWith() {
		
	}
	
	//Spaced everything out to make it easier to read
	public static void askForTradeOption() throws IOException {

		String[] selection = new String[] { "No Trade", "Trade", "Wage" };

		int menuSelect = ConsoleUI.promptForMenuSelection(selection, false);

		if (menuSelect == 1) {
			System.out.println("There will be no trade");
		}

		if (menuSelect == 2) {

			System.out.println("Please select what you want to trade?");

			String[] tradingCards = new String[] { "Money", "Get out of jail free", "Properties" };

			int selectTrade = ConsoleUI.promptForMenuSelection(tradingCards, false);

			if (selectTrade == 1) {
				// Add array list for money
			}

			if (selectTrade == 2) {
				// Add array list for get outta jail
			}

			if (selectTrade == 3) {
				// Add array list for properties
			}
		}

		if (menuSelect == 3) {
			// Wage
		}
	}
}
