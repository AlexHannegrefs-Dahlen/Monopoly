package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;

//added existing BoardSpaces arraylist for trading properties
public class Trade {
	static int enterValue = 0;
	static int enter2Value = 0;
	static boolean currentJailCard = null != null;
	static boolean currentJailCard2 = null != null;
	static ArrayList<BoardSpaces> tradingLand = new ArrayList <BoardSpaces>();
	static ArrayList<BoardSpaces> tradingPlayerLand = new ArrayList <BoardSpaces>();
	
	public static Player whatPlayerToTradeWith(int inputPlayerNumber, Player player) throws IOException {	
		System.out.println("There are " + Game.amountOfPlayers + " Players currently playing");	
		inputPlayerNumber = ConsoleUI.promptForInt("Select another player to trade with", 1, 8);
		for (int i = 1; i <= Game.amountOfPlayers; i++){
			if (inputPlayerNumber == 1){
				player = Game.returnPlayerOne();
				return player;
			}
			else if (inputPlayerNumber == 2){
				player = Game.returnPlayerTwo();
				return player;
			}
			else if (inputPlayerNumber == 3){
				player = Game.returnPlayerThree();
				return player;
			}
			else if (inputPlayerNumber == 4){
				player = Game.returnPlayerFour();
				return player;
			}
			else if (inputPlayerNumber == 5){
				player = Game.returnPlayerFive();
				return player;
			}
			else if (inputPlayerNumber == 6){
				player = Game.returnPlayerSix();
				return player;
			}
			else if (inputPlayerNumber == 7){
				player = Game.returnPlayerSeven();
				return player;
			}	
			else if (inputPlayerNumber == 8){
				player = Game.returnPlayerEight();
				return player;
			}
		}
		return null;
	
	}
	
	// Spaced everything out to make it easier to read
	public static int askCurrentPlayerForTrade() throws IOException {
		System.out.println(Game.getPlayerWhosTurnItIs() + " what will you do");
		String[] firstSelection = new String[] { "Accept", "Decline"};
		int menuSelect = ConsoleUI.promptForMenuSelection(firstSelection, true);
		// They want to trade
		if (menuSelect == 1) {
			
			System.out.println("Please select what you want to trade?");
			String[] stuffToTrade = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectWhatToTrade = ConsoleUI.promptForMenuSelection(stuffToTrade, false);
			
			if (selectWhatToTrade == 1) {
				boolean moneyExchange = ConsoleUI.promptForBool("Would you like to exchange some cash?" + "[Y/N]", "Y","N");

				if (moneyExchange == true) {
					enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,Integer.MAX_VALUE);
					boolean amountRight = false;
					while (!amountRight){
					if (enterValue > Player.getMoney(Game.getPlayerWhosTurnItIs())){
						System.out.println("Error! Amount specified is too high. You don't have that much money.");
						amountRight = false; 
					}
					else {
						System.out.println("Amount To Be Exchanged: " + enterValue);
						amountRight = true;
						}
					}
				}
				else if (moneyExchange == false) {
					System.out.println("No cash will be exchanged");
				}
			}
			if (selectWhatToTrade == 2) {
				boolean tradeJailCard = ConsoleUI.promptForBool("Would you like to trade your Get out of jail card?" + "[Y/N]", "Y", "N");
				if (tradeJailCard == true) {
					System.out.println("Checking to see if player has card");
					currentJailCard = Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs()) || Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs());
					if (!Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs())
							&& !Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
						System.out.println("Sorry, you don't possess a Get out of jail free card");
						currentJailCard = false;
					}
					else if (Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs()) || Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
						System.out.println("Excellent! You are eligible for trade");
						currentJailCard = true;
						//Set to give to other player when ready
					}
				}
				else if (tradeJailCard == false) {
					System.out.println("No Get out of jail free cards will be traded");
					}
			}

			if (selectWhatToTrade == 3) {
				boolean tradeProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
					if (tradeProperty == true){
						boolean tradeCon = true;
					while (tradeCon) {
							boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");
							
							if (continuePropTrade == true) {
								System.out.println("What property will you be trading?");
								System.out.println(Player.getland(Game.getPlayerWhosTurnItIs()));
								tradingLand.addAll(Player.getland(Game.getPlayerWhosTurnItIs()));
								int tradeLand = ConsoleUI.promptForInt("Select what property you want to remove from your inventory", 1, tradingLand.size());
						tradingLand = Player.getland(Game.getPlayerWhosTurnItIs());	
						tradingLand.remove(tradeLand);
						tradeCon = true;
						continuePropTrade = true;
						
					}
					else {
						System.out.println("No more property will be traded");
						tradeCon = true;
						continuePropTrade = false;
					}
					} 
				}
				
				else if (tradeProperty == false){
					System.out.println("No property will be traded");
				}
			}
			
			else if (menuSelect == 2) {
				System.out.println("There will be no trade");
				// Player doesn't want to trade with anyone
				// Exit trade
			}
		}
		return menuSelect;
	}
			
		public static int selectWhatOtherPlayerTrades() throws IOException {
			int inputPlayerNumber = 0;
			Player player = null;
			whatPlayerToTradeWith(inputPlayerNumber, player);
			System.out.println("What would you like to take from " + whatPlayerToTradeWith(inputPlayerNumber, player));
			
			String[] tradingOtherPlayer = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectPlayerTrade = ConsoleUI.promptForMenuSelection(tradingOtherPlayer, false);

			if (selectPlayerTrade == 1) {
				boolean moneyPlayerExchange = ConsoleUI.promptForBool("What would you like for the other player to exchange?" + "[Y/N]", "Y", "N");
				if (moneyPlayerExchange == true) {
					int otherPlayersMoney = Player.getMoney(player);
					enter2Value = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,Integer.MAX_VALUE);
						if (otherPlayersMoney < enter2Value){
							System.out.println("Error! " + player + " doesn't have that money money in their account. Try Again.");
						}
						else {
							System.out.println("Amount To Be Exchanged: " + enter2Value);
						}
				}

				else if (moneyPlayerExchange == false) {
					System.out.println("No cash will be exchanged");
				}
			}

			if (selectPlayerTrade == 2) {
				boolean askPlayerForJailCard = ConsoleUI.promptForBool("Would you like to request a Get out of jail card?" + "[Y/N]", "Y", "N");

				if (askPlayerForJailCard == true) {
					System.out.println("Checking to see if player " + player + " has a card");
					currentJailCard2 = Player.getGetOutOfJailChance(player) || Player.getGetOutOfJailChest(player);
					if (!Player.getGetOutOfJailChance(player)
							&& !Player.getGetOutOfJailChest(player)) {
						System.out.println("Sorry, " + player + " doesn't possess a Get out of jail free card");
						currentJailCard2 = false;
					}
					else if (Player.getGetOutOfJailChance(player) || Player.getGetOutOfJailChest(player)){
						System.out.println("Excellent! They are eligible for trade");
						currentJailCard2 = true;
					}
				}

				else if (askPlayerForJailCard == false) {
					System.out.println("No Get out of jail free cards will be traded");
				}
			}
			if (selectPlayerTrade == 3) {
				boolean tradePlayerProperty = ConsoleUI.promptForBool("Would you like to request some property?" + "[Y/N]", "Y", "N");
					if (tradePlayerProperty == true){
						boolean tradeCon = true;
						while (tradeCon) {
							boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");
							if (continuePropTrade == true) {
								System.out.println("What property do you want?");
								System.out.println(Player.getland(player)); 
								tradingPlayerLand.addAll(Player.getland(player));
								int tradeLand = ConsoleUI.promptForInt("Select what property you want to take", 1, tradingPlayerLand.size());
						tradingPlayerLand = Player.getland(player);	
						tradingPlayerLand.remove(tradeLand);
						tradeCon = true;
						continuePropTrade = true;
					}
					else {
						System.out.println("No more property will be asked of");
						tradeCon = true;
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
		int inputPlayerNumber = 0;
		Player player = null;
		whatPlayerToTradeWith(inputPlayerNumber, player);
		Player.getMyTurn(player);
		boolean acceptOrDecline = ConsoleUI.promptForBool(player + "Would you like to trade with " + Game.getPlayerWhosTurnItIs() + " intiating trade?" + "[Y/N]", "Y", "N");
		
		if (acceptOrDecline == true) {
			boolean modifyOrNah = ConsoleUI.promptForBool("Would you like to modify your trade?" + "[Y/N]", "Y", "N");
			if (modifyOrNah == true) {
				String[] modifyChoice = new String[] { "Money", "Get out of jail free", "Properties" };
				int selectWhatToModify = ConsoleUI.promptForMenuSelection(modifyChoice, false);

				if (selectWhatToModify == 1) {
					boolean wannaExchange = ConsoleUI.promptForBool("What would you like to exchange money?" + "[Y/N]", "Y", "N");
					if (wannaExchange == true) {
						enter2Value = 0;
						enter2Value = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,Integer.MAX_VALUE);
						boolean checkAmount = false;
						while (!checkAmount)
						if (enter2Value < Player.getMoney(player)){
								System.out.println(player + " you don't have that much money");
								checkAmount = false;
						}
						else {
						System.out.println("Amount To Be Exchanged: " + enter2Value);
						Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2Value);
						System.out.println("Current player now has " + enter2Value + " added to their account");
						Player.setMoney(player, enterValue);
						System.out.println(player + " now has " + enterValue + " added to their account");
						checkAmount = true;
						}
					}

					else if (wannaExchange == false) {
						System.out.println("No cash will be exchanged");
						enter2Value = 0;
						enterValue = 0;
					}
				}

				if (selectWhatToModify == 2) {
					boolean modifyJailCard = ConsoleUI.promptForBool("Would you like to trade your Get out of jail card?" + "[Y/N]", "Y", "N");

					if (modifyJailCard == true) {
						System.out.println("Checking to see if that player has a card");
//						if (!Player.getGetOutOfJailChance(player)
//								&& !Player.getGetOutOfJailChest(player)) 
						if (currentJailCard2 = false){
							System.out.println("Sorry, " + player + "  you still don't possess a Get Out of Jail Free card");	
						}

//						else if (Player.getGetOutOfJailChance(player) || Player.getGetOutOfJailChest(player))
						if (currentJailCard2 = true) {
							System.out.println("Excellent! You are eligible for trade");
							if (currentJailCard2 = Player.getGetOutOfJailChance(player)){
							Player.giveJailCard(Game.getPlayerWhosTurnItIs());
							Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), true);
							Player.setGetOutOfJailChance(player, false);
						}
							else if (currentJailCard2 = Player.getGetOutOfJailChest(player)) {
							Player.giveJailCard(Game.getPlayerWhosTurnItIs());	
							Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
							Player.setGetOutOfJailChest(player, false);
							}
					}

					else if (modifyJailCard == false) {
						System.out.println("No Get out of jail free cards will be traded");
					}	
				}

				if (selectWhatToModify == 3) {
					boolean wannaTradePlayerProperty = ConsoleUI.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");
					if (wannaTradePlayerProperty == true){
						boolean tradeCon = true;
						while (tradeCon) {
						boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");
						if (continuePropTrade == true) {
						System.out.println("What property do you want?");
						System.out.println(Player.getland(Game.getPlayerWhosTurnItIs())); 
						int tradeLand = ConsoleUI.promptForInt("Select what property you want to take", 1, Integer.MAX_VALUE);
						ArrayList<BoardSpaces> land = Player.getland(Game.getPlayerWhosTurnItIs());	
						land.remove(tradeLand);
						tradeCon = true;
						continuePropTrade = true;
						}
						else {
							System.out.println("No more property will be asked of");
							tradeCon = true;
							continuePropTrade = false;
						}
						}
					}
					
					else if (wannaTradePlayerProperty == false){
						System.out.println("No property will be asked of");
						
					}
		}
				else if (modifyOrNah = false) {
					System.out.println("Trade will commence");
					Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2Value);
					System.out.println("Current player now has " + enter2Value + " added to their account");
					Player.setMoney(player, enterValue);
					System.out.println(player + " now has " + enterValue + " added to their account");
					
				}

		else if (acceptOrDecline == false) {
			System.out.println("Trade declined");
			System.out.println("Let's restart the process");
			enterValue = 0;
			enter2Value = 0;
			whatPlayerToTradeWith(inputPlayerNumber, player);
				}
			}
		} 
	}
		return acceptOrDecline;
 }
}
