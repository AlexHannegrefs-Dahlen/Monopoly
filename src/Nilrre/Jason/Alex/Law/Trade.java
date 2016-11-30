package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;

//added existing BoardSpaces arraylist for trading properties
public class Trade {

	// private static ArrayList<BoardSpaces> tradingLand = new
	// ArrayList<BoardSpaces>();
	// private static ArrayList<BoardSpaces> tradingPlayerLand = new
	// ArrayList<BoardSpaces>();
	private static boolean exitTrade;
	private static boolean currentJailCard;
	private static boolean playersJailCard;
	private static int enterValue = 0;
	private static int enter2Value = 0;
	private static Player player = new Player();

	public static Player whatPlayerToTradeWith() throws IOException {
		boolean pickedThemself;
		int inputPlayerNumber;
		do {
			pickedThemself = false;

			inputPlayerNumber = ConsoleUI.promptForInt("Select player to trade with. 1 - 8", 1, 8);

			if (inputPlayerNumber == 1 && !(Game.returnPlayerOne().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerOne())) {
				player = Game.returnPlayerOne();
			} else if (inputPlayerNumber == 2 && !(Game.returnPlayerTwo().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerTwo())) {
				player = Game.returnPlayerTwo();
			} else if (inputPlayerNumber == 3 && !(Game.returnPlayerThree().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerThree())) {
				player = Game.returnPlayerThree();
			} else if (inputPlayerNumber == 4 && !(Game.returnPlayerFour().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerFour())) {
				player = Game.returnPlayerFour();
			} else if (inputPlayerNumber == 5 && !(Game.returnPlayerFive().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerFive())) {
				player = Game.returnPlayerFive();
			} else if (inputPlayerNumber == 6 && !(Game.returnPlayerSix().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerSix())) {
				player = Game.returnPlayerSix();
			} else if (inputPlayerNumber == 7 && !(Game.returnPlayerSeven().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerSeven())) {
				player = Game.returnPlayerSeven();
			} else if (inputPlayerNumber == 8 && !(Game.returnPlayerEight().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerEight())) {
				player = Game.getPlayerWhosTurnItIs();
			} else {
				System.out.println("Invalid Choice");
				pickedThemself = true;
			}
		} while (pickedThemself);
		return player;
	}

	public static void askCurrentPlayerForTrade(Player player) throws IOException {
		exitTrade = true;
		System.out.println("Would you like to continue trade?");
		String[] currentPlayerSelection = new String[] { "Accept", "Decline" };
		int menuSelect = ConsoleUI.promptForMenuSelection(currentPlayerSelection, false);

		if (menuSelect == 1) {

			System.out.println("Please select something you would like to trade:");
			String[] currentPlayerChooseTrade = new String[] { "Money", "Get Out of Jail Free", "Properties" };
			int selectWhatToTrade = ConsoleUI.promptForMenuSelection(currentPlayerChooseTrade, false);

			if (selectWhatToTrade == 1) {
				boolean currentPlayerMoneyExchange = ConsoleUI.promptForBool(
						"Would you like to exchange some cash with " + Player.getPiece(player).name() + "?" + "[Y/N]",
						"Y", "N");

				if (currentPlayerMoneyExchange == true) {
					boolean amountRight = true;
					do {
						int playersMoney = Player.getMoney(Game.getPlayerWhosTurnItIs());
						System.out.println("You have: " + playersMoney);
						enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to exchange:",
								0, Integer.MAX_VALUE);
						amountRight = true;
						exitTrade = true;
						if (enterValue > Player.getMoney(Game.getPlayerWhosTurnItIs())) {
							System.out.println("Error! " + Player.getPiece(Game.getPlayerWhosTurnItIs()).name()
									+ " :The amount specified is too high. You don't have that much money.");
							amountRight = true;
						} else {
							System.out.println("Money value is sufficient!");
							System.out.println("Amount To Be Exchanged: " + enterValue);
							amountRight = false;
						}
					} while (amountRight);
				} else if (currentPlayerMoneyExchange == false) {
					System.out.println("No cash will be exchanged");
					enterValue = 0;
				}
			}

			else if (selectWhatToTrade == 2) {
				boolean decideToTradeJailCard = ConsoleUI
						.promptForBool("Would you like to trade your Get Out of Jail Card?" + "[Y/N]", "Y", "N");

				if (decideToTradeJailCard == true) {
					System.out.println("Checking to see if player has card");
					if (!Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs())
							&& !Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
						System.out.println("Sorry, you don't possess a Get Out of Jail Free card");
						currentJailCard = false;
					} else if (Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs())
							|| Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
						System.out.println("Excellent! You are eligible for trade");
						currentJailCard = true;
					}

					else if (decideToTradeJailCard == false) {
						System.out.println("No Get Out of Jail Free cards will be traded");
					}
				}
			}

			else if (selectWhatToTrade == 3) {
				boolean decideToTradeProperty = ConsoleUI
						.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");

				if (decideToTradeProperty == true) {
					boolean decideTrade = true;
					while (decideTrade) {
						boolean continuePropTrade = ConsoleUI
								.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");

						if (continuePropTrade == true) {
							boolean ownLand;
							do{
							System.out.println("What property will you be trading?");
							System.out.println(Player.getland(Game.getPlayerWhosTurnItIs()));
							// tradingLand.addAll(Player.getland(Game.getPlayerWhosTurnItIs()));
							int landToTrade = ConsoleUI.promptForInt(
									"Select what property you want to trade and remove from your inventory", 1, 40);
							int[] space = Player.spaceNumberToBoardCords(landToTrade);
							int row = space[0];
							int col = space[1];
							if (!Board.b.getOwnedBy(Board.board[row][col]).equals(Game.getPlayerWhosTurnItIs())) {
								ownLand = false;
							} else {
								Player.getland(Game.getPlayerWhosTurnItIs()).remove(Board.board[row][col]);
								decideTrade = true;
								continuePropTrade = true;
								ownLand = true;
							}
							}while(!ownLand);
						} else {
							System.out.println("No more property will be traded");
							decideTrade = true;
							continuePropTrade = false;
						}
					}
				}

				else if (decideToTradeProperty == false) {
					System.out.println("No property will be traded");
				}
			}

		} else {
			System.out.println("There will be no trade");
			exitTrade = false;
		}
	}

	public static int selectWhatOtherPlayerTrades(Player player) throws IOException {

		System.out.println("What would you like to take from Player:" + Player.getPiece(player).name());
		String[] tradingWithOtherPlayer = new String[] { "Money", "Get Out of Jail Free", "Properties" };
		int requestOtherPlayerTrade = ConsoleUI.promptForMenuSelection(tradingWithOtherPlayer, false);

		if (requestOtherPlayerTrade == 1) {
			boolean exchangeMoneyWithOtherPlayer = ConsoleUI.promptForBool(
					"Would you like to request a money exchange from " + Player.getPiece(player).name() + "?" + "[Y/N]",
					"Y", "N");

			if (exchangeMoneyWithOtherPlayer == true) {
				int otherPlayersMoney = Player.getMoney(player);
				System.out.println("Player has: " + otherPlayersMoney);

				enter2Value = ConsoleUI.promptForInt("Enter in the value of money you would like to request", 0,
						otherPlayersMoney);

			}

			else if (exchangeMoneyWithOtherPlayer == false) {
				System.out.println("No cash will be exchanged");
				enter2Value = 0;
			}
			return enter2Value;
		}

		if (requestOtherPlayerTrade == 2) {
			boolean askPlayerForJailCard = ConsoleUI
					.promptForBool("Would you like to request a Get out of jail card from "
							+ Player.getPiece(player).name() + "?" + "[Y/N]", "Y", "N");

			if (askPlayerForJailCard == true) {
				System.out.println("Checking to see if player " + Player.getPiece(player).name() + " has a card");

				if (!Player.getGetOutOfJailChance(player) && !Player.getGetOutOfJailChest(player)) {
					System.out.println("Sorry, Player: " + Player.getPiece(player).name()
							+ " doesn't possess a Get out of jail free card");
					playersJailCard = false;
				} else if (Player.getGetOutOfJailChance(player) || Player.getGetOutOfJailChest(player)) {
					System.out.println("Excellent! " + Player.getPiece(player).name() + " is eligible for trade");
					playersJailCard = true;
				}
			}

			else if (askPlayerForJailCard == false) {
				System.out.println("No Get Out of Jail Free cards will be traded");
			}
		}
		if (requestOtherPlayerTrade == 3) {
			boolean requestToTradePlayerProperty = ConsoleUI.promptForBool(
					"Would you like to request some property from " + Player.getPiece(player).name() + " ?" + "[Y/N]",
					"Y", "N");

			if (requestToTradePlayerProperty == true) {
				boolean tradeRequest = true;

				while (tradeRequest) {
					boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]",
							"Y", "N");
					if (continuePropTrade == true) {
						System.out.println("What property do you want?");
						System.out.println(Player.getland(player));
						int requestLand = ConsoleUI.promptForInt("Select what property you want to take", 1,
						Player.getland(player).size());
						int[] space = Player.spaceNumberToBoardCords(requestLand);
						int row = space[0];
						int col = space[1];
						Player.getland(player).remove(Board.board[row][col]);
						tradeRequest = true;
						continuePropTrade = true;
					} else {
						System.out.println("No more property will be asked of");
						tradeRequest = true;
						continuePropTrade = false;
					}
				}
			}

			else if (requestToTradePlayerProperty == false) {
				System.out.println("No property will be asked of");
			}
		}
		return requestOtherPlayerTrade;
	}

	public static boolean acceptOrDeclinePlayerTradeRequest(Player player) throws IOException {
		System.out.println("Player: " + Player.getPiece(player).name() + " what will you do?");

		boolean acceptOrDecline = ConsoleUI.promptForBool(
				Player.getPiece(player).name() + "would you like to trade with the player intiating trade?" + "[Y/N]",
				"Y", "N");

		if (acceptOrDecline == true) {
			boolean willYouModifyTrade = ConsoleUI.promptForBool("Would you like to modify your trade?" + "[Y/N]", "Y",
					"N");

			if (willYouModifyTrade == true) {
				String[] modifyChoices = new String[] { "Money", "Get Out of Jail Free", "Properties" };
				int selectWhatToModify = ConsoleUI.promptForMenuSelection(modifyChoices, false);

				if (selectWhatToModify == 1) {
					boolean modifyExchange = ConsoleUI.promptForBool("Please modify exchange" + "[Y/N]", "Y", "N");
					if (modifyExchange == true) {

						boolean checkModifiedAmount = false;
						while (!checkModifiedAmount) {
							enter2Value = ConsoleUI.promptForInt("Modify money value", 0, Integer.MAX_VALUE);
							if (enter2Value > Player.getMoney(player)) {
								System.out.println(Player.getPiece(player).name() + " you don't have that much money");
								checkModifiedAmount = false;
							} else {
								System.out.println("Modified amount is sufficient");
								System.out.println("Amount To Be Exchanged: " + enter2Value);
								Player.setMoney(player, -enter2Value);
								Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2Value);
								System.out.println(Player.getPiece(Game.getPlayerWhosTurnItIs()).name() + " has "
										+ enter2Value + " added to their account");
								Player.setMoney(Game.getPlayerWhosTurnItIs(), -enterValue);
								Player.setMoney(player, enterValue);
								System.out.println(Player.getPiece(player).name() + " has " + enterValue
										+ " added to their account");
								checkModifiedAmount = true;
							}
						}
					}

					else if (modifyExchange == false) {
						System.out.println("No cash will be exchanged");
						enter2Value = 0;
						enterValue = 0;
					}
				}

				if (selectWhatToModify == 2) {
					boolean modifyJailCard = ConsoleUI.promptForBool(Player.getPiece(player).name()
							+ "Would you like to trade your Get Out of Jail Card?" + "[Y/N]", "Y", "N");

					if (modifyJailCard == true) {
						System.out.println("Checking to see if players have a card");
						if (playersJailCard == false && currentJailCard == false) {
							System.out.println("Sorry, no player possesses a Get Out of Jail Free card");
						}

						else if (playersJailCard == true && currentJailCard == false) {
							System.out.println(
									"Excellent! " + Player.getPiece(Game.getPlayerWhosTurnItIs()).name() + " is able to trade with current player.");
							if (Player.getGetOutOfJailChance(player) == true) {
								Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), true);
								Player.setGetOutOfJailChance(player, false);
							}
							if (Player.getGetOutOfJailChest(player) == true) {
								Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
								Player.setGetOutOfJailChest(player, false);
							}
						} else if (playersJailCard == false && currentJailCard == true) {
							System.out.println("Excellent! " + "current player can trade");
							if (Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs()) == true) {
								Player.setGetOutOfJailChance(player, true);
								Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), false);
							}
							if (Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
								Player.setGetOutOfJailChest(player, true);
								Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
							}
						} else if (playersJailCard == true && currentJailCard == true) {
							System.out.println("Excellent! Both players are able to trade with current player.");
							if (Player.getGetOutOfJailChance(player) == true) {
								Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), true);
								Player.setGetOutOfJailChance(player, false);
							}
							if (Player.getGetOutOfJailChest(player) == true) {
								Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
								Player.setGetOutOfJailChest(player, false);
							}
							if (Player.getGetOutOfJailChance(Game.getPlayerWhosTurnItIs()) == true) {
								Player.setGetOutOfJailChance(player, true);
								Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), false);
							}
							if (Player.getGetOutOfJailChest(Game.getPlayerWhosTurnItIs())) {
								Player.setGetOutOfJailChest(player, true);
								Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
							}
							System.out.println("Excellent! " + Player.getPiece(player).name()
									+ " is able to trade with current player.");
							Player.giveJailCard(Game.getPlayerWhosTurnItIs());
							Player.setGetOutOfJailChance(Game.getPlayerWhosTurnItIs(), true);
							Player.setGetOutOfJailChance(player, false);
						} else if (playersJailCard == false && currentJailCard == true) {
							Player.giveJailCard(Game.getPlayerWhosTurnItIs());
							Player.setGetOutOfJailChest(Game.getPlayerWhosTurnItIs(), true);
							Player.setGetOutOfJailChest(player, false);
							// if (!Player.getGetOutOfJailChance(player)
							// && !Player.getGetOutOfJailChest(player))
						}

						else if (modifyJailCard == false) {
							System.out.println("No Get out of jail free cards will be traded");
						}
					}
				}

				if (selectWhatToModify == 3) {
					boolean willYouTradePlayerProperty = ConsoleUI.promptForBool(
							"Would you like to trade some property " + Player.getPiece(player).name() + " ?" + "[Y/N]",
							"Y", "N");

					if (willYouTradePlayerProperty == true) {
						boolean isTradeTrue = true;
						while (isTradeTrue) {
							boolean continuePropTrade = ConsoleUI
									.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");

							if (continuePropTrade == true) {
								System.out.println("What property do you want?");
								System.out.println(Player.getland(Game.getPlayerWhosTurnItIs()));
								int tradeLand = ConsoleUI.promptForInt("Select what property you want to take", 1,
										40);
								int [] space = Player.spaceNumberToBoardCords(tradeLand);
								int row = space[0];
								int col = space[1];
								Player.getland(Game.getPlayerWhosTurnItIs()).remove(Board.board[row][col]);
								isTradeTrue = true;
								continuePropTrade = true;
							} else {
								System.out.println("No more property will be asked of");
								isTradeTrue = true;
								continuePropTrade = false;
							}

						}
					} else if (willYouTradePlayerProperty == false) {
						System.out.println("No property will be asked of");
					}
				}
			}

			else {
				System.out.println("Trade will commence");
				Player.setMoney(player, -enter2Value);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2Value);
				System.out.println(Player.getPiece(Game.getPlayerWhosTurnItIs()).name() + " has " + enter2Value
						+ " added to their account");
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -enterValue);
				Player.setMoney(player, enterValue);
				System.out.println(Player.getPiece(player).name() + " has " + enterValue + " added to their account");
				// MONEY

			}
		}

		else {
			System.out.println("Trade declined");
			System.out.println("Let's restart the process");
			enterValue = 0;
			enter2Value = 0;
			currentJailCard = null != null;
			playersJailCard = null != null;
			whatPlayerToTradeWith();
		}
		return acceptOrDecline;
	}

	public static void callAllMethods(Player player) throws IOException {
		player = whatPlayerToTradeWith();
		askCurrentPlayerForTrade(player);
		if (exitTrade == false) {
			return;
		} else {
			selectWhatOtherPlayerTrades(player);
			acceptOrDeclinePlayerTradeRequest(player);
		}
	}
}