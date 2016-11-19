package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Trade {
	public static void whatPlayerToTradeWith() {
		
	}

	//Spaced everything out to make it easier to read
	
	public static void askForTradeOption() throws IOException{
		String[] selection = new String[]{"Accept", "Decline"};
		int menuSelect = ConsoleUI.promptForMenuSelection(selection, false);

		if (menuSelect == 1) {

			System.out.println("Please select what you want to trade?");

			String[] tradingCards = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectTrade = ConsoleUI.promptForMenuSelection(tradingCards, false);

			if (selectTrade == 1) {
				int enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0, Integer.MAX_VALUE);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), enterValue);
				System.out.println("Amount To Be Exchanged: " + enterValue);
			}

			if (selectTrade == 2) {
				// Add array list for get outta jail
			}

			if (selectTrade == 3) {
				
			}
			
			System.out.println("Select another player to trade with");
			
			
			String[] tradingPlayer = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectPlayerTrade = ConsoleUI.promptForMenuSelection(tradingPlayer, false);
			
			if (selectPlayerTrade == 1){
				int enter2ndValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0, Player.getMoney(Game.getPlayerWhosTurnItIs()));
				Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2ndValue);
				System.out.println("Amount To Be Exchanged: " + enter2ndValue);
			}
			
			if (selectPlayerTrade == 2){
				
			}
			
			if (selectPlayerTrade == 3){
				
			}
			
			boolean otherPlayerRequest = Trade.acceptOrDeclinePlayerTradeRequest();
			
			
		}

		if (menuSelect == 2) {
			System.out.println("There will be no trade");
			//Player doesn't want to trade with anyone
			//End trade
		}
	}
	
	public static boolean acceptOrDeclinePlayerTradeRequest() throws IOException{
		boolean acceptOrDecline = ConsoleUI.promptForBool("Would you like to trade with player?" + "[Y/N]", "Y", "N");
		
		if (acceptOrDecline == true){
		boolean modifyOrNah = ConsoleUI.promptForBool("Would you like to modify your trade?" + "[Y/N]", "Y", "N");
		
		if (modifyOrNah == true){
			String[] modifyChoice = new String[] { "Money", "Get out of jail free", "Properties" };
			int selectWhatToModify = ConsoleUI.promptForMenuSelection(modifyChoice, false);
			
			if (selectWhatToModify == 1){
				int enter3rdValue = ConsoleUI.promptForInt("Enter in the value of money you would like to trade instead", 0, Integer.MAX_VALUE);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), enter3rdValue);
				System.out.println("Amount To Be Exchanged: " + enter3rdValue);
			}
			
			if (selectWhatToModify == 2){
				
			}
			
			if (selectWhatToModify == 3){
				
			}
		}
		
		if (modifyOrNah == false){
			System.out.println("There will be no modification of cards");
			//initiate the trade right here since other player doesn't want cards to be modified but wants to trade
		}
		
		}
		
		else if (acceptOrDecline == false){
			System.out.println("Trade declined");
			//send back to other method
		}
		return acceptOrDecline;
	}
}
