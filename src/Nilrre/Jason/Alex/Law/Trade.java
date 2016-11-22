package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Trade {
	public static void whatPlayerToTradeWith() {

	}

	// Spaced everything out to make it easier to read
	public static void askForTradeOption() throws IOException {

		String[] selection = new String[] { "Accept", "Decline" };
		int menuSelect = ConsoleUI.promptForMenuSelection(selection, false);

		// They want to trade
		if (menuSelect == 1) {
			System.out.println("Please select what you want to trade?");

			// The player selects what they want to trade
			// Multiple if statments so that they can trade multiple things
			String[] stuffToTrade = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectWhatToTrade = ConsoleUI.promptForMenuSelection(stuffToTrade, false);

			if (selectWhatToTrade == 1) {

				boolean moneyExchange = ConsoleUI.promptForBool("Would you like to exchange some cash?" + "[Y/N]", "Y","N");

				if (moneyExchange == true) {
					int enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,Integer.MAX_VALUE);
					Player.setMoney(Game.getPlayerWhosTurnItIs(), enterValue);
					System.out.println("Amount To Be Exchanged: " + enterValue);
				}

				if (moneyExchange == false) {
					System.out.println("No cash will be exchanged");
				}
			}

			if (selectWhatToTrade == 2) {
				// Check to see if they have a get out of jail card
				boolean tradeJailCard = ConsoleUI.promptForBool("Would you like to trade your Get Out of Jail Card?" + "[Y/N]", "Y", "N");

				if (tradeJailCard == true) {
					// Check to see if player has a card
					System.out.println("Checking to see if player has card");
					if (!Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs())
							&& !Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
						System.out.println("Sorry, you don't possess a Get Out of Jail Free card");
					}

					else {
						System.out.println("Excellent! You are eligible for trade");
					}
				}

				else if (tradeJailCard == false) {
					System.out.println("No Get Out of Jail Free cards will be traded");
				}
			}

			if (selectWhatToTrade == 3) {
				boolean tradeProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
				if (tradeProperty == true){
					System.out.println("What property will you be trading?");
					Player.getland(Game.getPlayerWhosTurnItIs());
					
				}
				
				else if (tradeProperty == false){
					System.out.println("No property will be traded");
				}
			}
			
			
			// Allow choose another player
			Player.getPlayingGame(Game.getPlayerWhosTurnItIs()); //Not sure if this line needs to be here
			System.out.println("There are " + Game.amountOfPlayers + "Players");
			int inputPlayerNumber = ConsoleUI.promptForInt("Select another player to trade with", 1, 8);
			for (int i = 1; i <= Game.amountOfPlayers; i++){
				if (inputPlayerNumber == 1){
					Game.returnPlayerOne();
				}
				
				else if (inputPlayerNumber == 2){
					Game.returnPlayerTwo();
				}
				
				else if (inputPlayerNumber == 3){
					Game.returnPlayerThree();
				}
				
				else if (inputPlayerNumber == 4){
					Game.returnPlayerFour();
				}
				
				else if (inputPlayerNumber == 5){
					Game.returnPlayerFive();
				}
				
				else if (inputPlayerNumber == 6){
					Game.returnPlayerSix();
				}
				
				else if (inputPlayerNumber == 7){
					Game.returnPlayerSeven();
				}
				
				else if (inputPlayerNumber == 8){
					Game.returnPlayerEight();
				}
			}

			System.out.println("What would you like to take from them?");
			String[] tradingPlayer = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectPlayerTrade = ConsoleUI.promptForMenuSelection(tradingPlayer, false);

			if (selectPlayerTrade == 1) {
				
				int enter2ndValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,
				Player.getMoney(Game.getPlayerWhosTurnItIs()));
				Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2ndValue);
				System.out.println("Amount To Be Exchanged: " + enter2ndValue);
			}

			if (selectPlayerTrade == 2) {
				boolean askForJailCard = ConsoleUI.promptForBool("Would you like to trade your Get Out of Jail Card?" + "[Y/N]", "Y", "N");

				if (askForJailCard == true) {
					// Check to see if player has a card
					System.out.println("Checking to see if that player has a card");
					if (!Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs())
							&& !Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
						System.out.println("Sorry, you don't possess a Get Out of Jail Free card");
					}

					else {
						System.out.println("Excellent! You are eligible for trade");
					}
				}

				else if (askForJailCard == false) {
					System.out.println("No Get Out of Jail Free cards will be traded");
				}
			}

			if (selectPlayerTrade == 3) {
				boolean askForProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
				if (askForProperty == true){
					System.out.println("What property will you be trading?");
					Player.getland(Game.getPlayerWhosTurnItIs());
					

				}
				
				else if (askForProperty == false){
					System.out.println("No property will be traded");
				}
			}

			// Sends to method below
			boolean otherPlayerRequest = Trade.acceptOrDeclinePlayerTradeRequest();

		}

		if (menuSelect == 2) {
			System.out.println("There will be no trade");
			// Player doesn't want to trade with anyone
			// Exit trade
		}
	}

	public static boolean acceptOrDeclinePlayerTradeRequest() throws IOException {
		boolean acceptOrDecline = ConsoleUI.promptForBool("Would you like to trade with player intiating trade?" + "[Y/N]", "Y", "N");

		if (acceptOrDecline == true) {
			boolean modifyOrNah = ConsoleUI.promptForBool("Would you like to modify your trade?" + "[Y/N]", "Y", "N");

			if (modifyOrNah == true) {
				String[] modifyChoice = new String[] { "Money", "Get out of jail free", "Properties" };
				int selectWhatToModify = ConsoleUI.promptForMenuSelection(modifyChoice, false);

				if (selectWhatToModify == 1) {
					boolean wouldYouLikeToChangeCurrency = ConsoleUI.promptForBool("Would you like to change the amount to trade?" + "[Y/N]", "Y", "N");
					
					if (wouldYouLikeToChangeCurrency == true){
					int enter3rdValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade instead", 0, Integer.MAX_VALUE);
					Player.setMoney(Game.getPlayerWhosTurnItIs(), enter3rdValue);
					System.out.println("Amount To Be Exchanged: " + enter3rdValue);
					}
					
					else if (wouldYouLikeToChangeCurrency == false){
						System.out.println("Currency will not be changed");
					}
				}

				if (selectWhatToModify == 2) {
					boolean modifyJailCard = ConsoleUI.promptForBool("Would you like to trade your Get Out of Jail Card?" + "[Y/N]", "Y", "N");

					if (modifyJailCard == true) {
						// Check to see if player has a card
						System.out.println("Checking to see if that player has a card");
						if (!Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs())
								&& !Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
							System.out.println("Sorry, you don't possess a Get Out of Jail Free card");
						}

						else {
							System.out.println("Excellent! You are eligible for trade");
						}
					}

					else if (modifyJailCard == false) {
						System.out.println("No Get Out of Jail Free cards will be traded");
					}	
				}

				if (selectWhatToModify == 3) {
					boolean tradeProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
					if (tradeProperty == true){
						System.out.println("What property will you be trading?");
						Player.getland(Game.getPlayerWhosTurnItIs());
						

					}
					
					else if (tradeProperty == false){
						System.out.println("No property will be traded");
					}
				}
			}

			else if (modifyOrNah == false) {
				System.out.println("There will be no modification of cards");
				// initiate the trade right here since other player doesn't want the
				// cards to be modified but wants to trade
			}

		}

		else if (acceptOrDecline == false) {
			System.out.println("Trade declined");
			System.out.println("Let's restart the process");
			askForTradeOption();
			// sends back to method above
		}
		return acceptOrDecline;
	}
}
