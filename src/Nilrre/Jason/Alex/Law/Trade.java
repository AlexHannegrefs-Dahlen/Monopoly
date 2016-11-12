package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Trade {
	
	
	public static void askForTradeOption() throws IOException{
		String[] selection = new String[]{"Modify Trade", "Wage"};
		int menuSelect = ConsoleUI.promptForMenuSelection(selection, false);
		if (menuSelect == 1){
			
		}
		if (menuSelect == 2){
			
		}
	}
}
