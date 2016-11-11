package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Trade {
	
	public static void wantToTrade() throws IOException{
		boolean decideTrade = ConsoleUI.promptForBool("Would you like to trade with another player? [Y/N]", "Y", "N");
		//player decides to trade
		if (decideTrade == true){
			
		}
		else {
			
		}
		
	}
	
	public static void askForTradeOption() throws IOException{
		String[] selection = new String[]{"Modify Trade", "Wage"};
		int menuSelect = ConsoleUI.promptForMenuSelection(selection, false);
		if (menuSelect == 1){
			
		}
		if (menuSelect == 2){
			
		}
	}
}
