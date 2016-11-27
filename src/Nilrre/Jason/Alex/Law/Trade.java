package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;

//added existing BoardSpaces arraylist for trading properties
public class Trade {
	
	public static int whatPlayerToTradeWith() throws IOException {	
		Player.getPlayingGame(Game.getPlayerWhosTurnItIs()); //Not sure if this line needs to be here
		System.out.println("There are " + Game.amountOfPlayers + "Players");
		System.out.println("Select a player");		
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
		return inputPlayerNumber;
	}
	
	// Spaced everything out to make it easier to read
	public static int askCurrentPlayerForTrade() throws IOException {
		String[] firstSelection = new String[] { "Accept", "Decline" };
		int menuSelect = ConsoleUI.promptForMenuSelection(firstSelection, false);
		// They want to trade
		if (menuSelect == 1) {
			System.out.println("Please select what you want to trade?");
			String[] stuffToTrade = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectWhatToTrade = ConsoleUI.promptForMenuSelection(stuffToTrade, false);
			if (selectWhatToTrade == 1) {
				boolean moneyExchange = ConsoleUI.promptForBool("Would you like to exchange some cash?" + "[Y/N]", "Y","N");

				if (moneyExchange == true) {
					int enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,Integer.MAX_VALUE);
					//What if they don't have the money they want to exchange
//					Player.setMoney(Game.getPlayerWhosTurnItIs(), enterValue); Not sure this line needs to be here
					System.out.println("Amount To Be Exchanged: " + enterValue);
				}

				if (moneyExchange == false) {
					System.out.println("No cash will be exchanged");
				}
			}

			if (selectWhatToTrade == 2) {
				boolean tradeJailCard = ConsoleUI.promptForBool("Would you like to trade your Get out of jail card?" + "[Y/N]", "Y", "N");
	
				if (tradeJailCard == true) {
					// Check to see if player has a card
					System.out.println("Checking to see if player has card");
					if (!Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs())
							&& !Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
						System.out.println("Sorry, you don't possess a Get out of jail free card");
					}

					else {
						System.out.println("Excellent! You are eligible for trade");
					}
				}

				else if (tradeJailCard == false) {
					System.out.println("No Get out of jail free cards will be traded");
					}
			}

			if (selectWhatToTrade == 3) {
				boolean tradeProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
				if (tradeProperty == true){
					boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");
					while (continuePropTrade) {
					if (continuePropTrade == true) {
					System.out.println("What property will you be trading?");
					System.out.println(Player.getland(Game.getPlayerWhosTurnItIs()));
					int tradeLand = ConsoleUI.promptForInt("Select what property you want to remove from your inventory", 1, Integer.MAX_VALUE);
					ArrayList<BoardSpaces> land = Player.getland(Game.getPlayerWhosTurnItIs());	
					land.remove(tradeLand);
					continuePropTrade = true;
					}
					else {
						System.out.println("No more property will be traded");
						continuePropTrade = false;
					}
					}
				}
				
				else if (tradeProperty == false){
					System.out.println("No property will be traded");
				}
			}
			
			if (menuSelect == 2) {
				System.out.println("There will be no trade");
				// Player doesn't want to trade with anyone
				// Exit trade
			}
		}
		return menuSelect;
	}
			
		public static int selectWhatOtherPlayerTrades() throws IOException {
			System.out.println("What would you like to take from them?");
			String[] tradingOtherPlayer = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectPlayerTrade = ConsoleUI.promptForMenuSelection(tradingOtherPlayer, false);

			if (selectPlayerTrade == 1) {
				boolean moneyPlayerExchange = ConsoleUI.promptForBool("What would you like for the other player to exchange?" + "[Y/N]", "Y", "N");
				if (moneyPlayerExchange == true) {
					int enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,Integer.MAX_VALUE);
					//What if they don't have the money they want to exchange
//					Player.setMoney(Game.getPlayerWhosTurnItIs(), enterValue); Not sure this line needs to be here
					System.out.println("Amount To Be Exchanged: " + enterValue);
				}

				if (moneyPlayerExchange == false) {
					System.out.println("No cash will be exchanged");
				}
			}

			if (selectPlayerTrade == 2) {
				boolean askPlayerForJailCard = ConsoleUI.promptForBool("Would you like to trade your Get Out of Jail Card?" + "[Y/N]", "Y", "N");

				if (askPlayerForJailCard == true) {
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

				else if (askPlayerForJailCard == false) {
					System.out.println("No Get Out of Jail Free cards will be traded");
				}
			}

			if (selectPlayerTrade == 3) {
				boolean tradePlayerProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
				if (tradePlayerProperty == true){
					boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");
					while (continuePropTrade) {
					if (continuePropTrade == true) {
					System.out.println("What property do you want?");
					System.out.println(Player.getland(Game.getPlayerWhosTurnItIs())); 
					int tradeLand = ConsoleUI.promptForInt("Select what property you want to take", 1, Integer.MAX_VALUE);
					ArrayList<BoardSpaces> land = Player.getland(Game.getPlayerWhosTurnItIs());	
					land.remove(tradeLand);
					continuePropTrade = true;
					}
					else {
						System.out.println("No more property will be asked of");
						continuePropTrade = false;
					}
					}
				}
				
				else if (tradePlayerProperty == false){
					System.out.println("No property will be asked of");
				}
			}

			// Sends to method below
			boolean otherPlayerRequest = Trade.acceptOrDeclinePlayerTradeRequest();
			return selectPlayerTrade;
		}

		

	public static boolean acceptOrDeclinePlayerTradeRequest() throws IOException {
		boolean acceptOrDecline = ConsoleUI.promptForBool("Would you like to trade with player intiating trade?" + "[Y/N]", "Y", "N");
		
		if (acceptOrDecline == true) {
			boolean modifyOrNah = ConsoleUI.promptForBool("Would you like to modify your trade?" + "[Y/N]", "Y", "N");

			if (modifyOrNah == true) {
				String[] modifyChoice = new String[] { "Money", "Get out of jail free", "Properties" };
				int selectWhatToModify = ConsoleUI.promptForMenuSelection(modifyChoice, false);

				if (selectWhatToModify == 1) {
					boolean wannaExchange = ConsoleUI.promptForBool("What would you like for the other player to exchange?" + "[Y/N]", "Y", "N");
					if (wannaExchange == true) {
						int enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,Integer.MAX_VALUE);
						//What if they don't have the money they want to exchange
//						Player.setMoney(Game.getPlayerWhosTurnItIs(), enterValue); Not sure this line needs to be here
						System.out.println("Amount To Be Exchanged: " + enterValue);
					}

					if (wannaExchange == false) {
						System.out.println("No cash will be exchanged");
					}
				}

				if (selectWhatToModify == 2) {
					boolean modifyJailCard = ConsoleUI.promptForBool("Would you like to trade your Get out of jail card?" + "[Y/N]", "Y", "N");

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
						System.out.println("No Get out of jail free cards will be traded");
					}	
				}

				if (selectWhatToModify == 3) {
					boolean wannaTradePlayerProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
					if (wannaTradePlayerProperty == true){
						boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");
						while (continuePropTrade) {
						if (continuePropTrade == true) {
						System.out.println("What property do you want?");
						System.out.println(Player.getland(Game.getPlayerWhosTurnItIs())); 
						int tradeLand = ConsoleUI.promptForInt("Select what property you want to take", 1, Integer.MAX_VALUE);
						ArrayList<BoardSpaces> land = Player.getland(Game.getPlayerWhosTurnItIs());	
						land.remove(tradeLand);
						continuePropTrade = true;
						}
						else {
							System.out.println("No more property will be asked of");
							continuePropTrade = false;
						}
						}
					}
					
					else if (wannaTradePlayerProperty == false){
						System.out.println("No property will be asked of");
					}
		}

		else if (acceptOrDecline == false) {
			System.out.println("Trade declined");
			System.out.println("Let's restart the process");
			askCurrentPlayerForTrade();
			// sends back to method above
		}
			}
		}
		return acceptOrDecline; 
	}
}
