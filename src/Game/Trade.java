package Game;

public class Trade {
	
	public static void wantToTrade(){
		String decideTrade = ConsoleUI.promptForBool("Would you like to trade with another player? [Y/N]", "Y", "N");
		//player decides to trade
		if (decideTrade == "Y"){
			
		}
		else {
			
		}
		
	}
	
	public static void askForTradeOption(){
		String[] selection = new String[]{"Modify Trade", "Wage"};
		int menuSelect = ConsoleUI.promptForMenuSelection(selection, false);
		if (menuSelect == 1){
			
		}
		if (menuSelect == 2){
			
		}
	}
}
