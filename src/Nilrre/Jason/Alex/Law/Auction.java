package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Auction {
	public static void startAuction(BoardSpaces space) throws IOException{
		int playerSelect = 1;
		int AuctionPrice = 0;
		
		if(playerSelect == 1 && Player.getInAuction(Game.returnPlayerOne())){
			System.out.println("Current Bid: $" + AuctionPrice);
			if(ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")){
				AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1, Player.getMoney(Game.returnPlayerOne()));
			} else {
				Player.setInAuction(Game.returnPlayerOne(), false);
			}
		}
		
	}
}
