package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Auction {
	public static void startAuction(BoardSpaces space) throws IOException {
		int playerSelect = 1;
		int AuctionPrice = 0;
		int playersInAuction = Game.amountOfPlayers;

		for (int i = 1; i <= Game.amountOfPlayers; i++) {
			if (i == 1 && Player.getPlayingGame(Game.returnPlayerOne())) {
				Player.setInAuction(Game.returnPlayerOne(), true);
			} else if (i == 2 && Player.getPlayingGame(Game.returnPlayerTwo())) {
				Player.setInAuction(Game.returnPlayerTwo(), true);
			} else if (i == 3 && Player.getPlayingGame(Game.returnPlayerThree())) {
				Player.setInAuction(Game.returnPlayerThree(), true);
			} else if (i == 4 && Player.getPlayingGame(Game.returnPlayerFour())) {
				Player.setInAuction(Game.returnPlayerFour(), true);
			} else if (i == 5 && Player.getPlayingGame(Game.returnPlayerFive())) {
				Player.setInAuction(Game.returnPlayerFive(), true);
			} else if (i == 6 && Player.getPlayingGame(Game.returnPlayerSix())) {
				Player.setInAuction(Game.returnPlayerSix(), true);
			} else if (i == 7 && Player.getPlayingGame(Game.returnPlayerSeven())) {
				Player.setInAuction(Game.returnPlayerSeven(), true);
			} else if (i == 8 && Player.getPlayingGame(Game.returnPlayerEight())) {
				Player.setInAuction(Game.returnPlayerEight(), true);
			}
		}
		do {
			if (playerSelect == 1 && Player.getInAuction(Game.returnPlayerOne())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				Game.returnPlayerOne();
				System.out.println(Player.getPiece(Game.returnPlayerOne()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerOne()));
				} else {
					Player.setInAuction(Game.returnPlayerOne(), false);
					playersInAuction--;
				}
				playerSelect++;
			} else if (playerSelect == 2 && Player.getInAuction(Game.returnPlayerTwo())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				System.out.println(Player.getPiece(Game.returnPlayerTwo()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerTwo()));
				} else {
					Player.setInAuction(Game.returnPlayerTwo(), false);
					playersInAuction--;
				}
				playerSelect++;
			} else if (playerSelect == 3 && Player.getInAuction(Game.returnPlayerThree())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				System.out.println(Player.getPiece(Game.returnPlayerThree()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerThree()));
				} else {
					Player.setInAuction(Game.returnPlayerThree(), false);
					playersInAuction--;
				}
				playerSelect++;
			} else if (playerSelect == 4 && Player.getInAuction(Game.returnPlayerFour())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				System.out.println(Player.getPiece(Game.returnPlayerFour()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerFour()));
				} else {
					Player.setInAuction(Game.returnPlayerFour(), false);
					playersInAuction--;
				}
				playerSelect++;
			} else if (playerSelect == 5 && Player.getInAuction(Game.returnPlayerFive())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				System.out.println(Player.getPiece(Game.returnPlayerFive()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerFive()));
				} else {
					Player.setInAuction(Game.returnPlayerFive(), false);
					playersInAuction--;
				}
				playerSelect++;
			} else if (playerSelect == 6 && Player.getInAuction(Game.returnPlayerSix())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				System.out.println(Player.getPiece(Game.returnPlayerSix()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerSix()));
				} else {
					Player.setInAuction(Game.returnPlayerSix(), false);
				}
				playerSelect++;
			} else if (playerSelect == 7 && Player.getInAuction(Game.returnPlayerSeven())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				System.out.println(Player.getPiece(Game.returnPlayerSeven()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerSeven()));
				} else {
					Player.setInAuction(Game.returnPlayerSeven(), false);
				}
				playerSelect++;
			} else if (playerSelect == 8 && Player.getInAuction(Game.returnPlayerEight())) {
				System.out.println("Current Bid: $" + AuctionPrice);
				System.out.println(Player.getPiece(Game.returnPlayerEight()).name());
				if (ConsoleUI.promptForBool("Would you like to bid? [y/n]", "y", "n")) {
					AuctionPrice = ConsoleUI.promptForInt("How much would you like to bid?", AuctionPrice + 1,
							Player.getMoney(Game.returnPlayerEight()));
				} else {
					Player.setInAuction(Game.returnPlayerEight(), false);
				}
				playerSelect++;
			} else {
				if (playerSelect == 9) {
					playerSelect = 1;
				} else {
					playerSelect++;
				}
			}
		} while (playersInAuction-- != 1);
		System.out.println(Player.getPiece(Player.getWhoWonAuction()).name() + " you won " + space.getName(space) + " for $" + AuctionPrice);
		Player.buyLand(Player.getWhoWonAuction(), space, AuctionPrice);
	}
}
