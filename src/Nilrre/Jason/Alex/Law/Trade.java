package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;

//added existing BoardSpaces arraylist for trading properties
public class Trade {

	private static ArrayList<BoardSpaces> tradingLand = new ArrayList<BoardSpaces>();
	private static ArrayList<BoardSpaces> tradingPlayerLand = new ArrayList<BoardSpaces>();
	private static boolean exitTrade = null != null;
	private static boolean currentJailCard = null != null;
	private static boolean playersJailCard = null != null;
	private static int enterValue = 0;
	private static int enter2Value = 0;

	public static Player whatPlayerToTradeWith(int inputPlayerNumber, Player player) throws IOException {
		Player playerToTradeWith = null;
		boolean pickedThemself;
		int saved = inputPlayerNumber;
		do {
			pickedThemself = false;
			
			if (saved == 0) {
				inputPlayerNumber = ConsoleUI.promptForInt("Select player to trade with. 1 - 8", 1, 8);
			}
			
			if (inputPlayerNumber == 1 && !(Game.returnPlayerOne().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerOne())) {
				playerToTradeWith = Game.returnPlayerOne();
			} else if (inputPlayerNumber == 2 && !(Game.returnPlayerTwo().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerTwo())) {
				playerToTradeWith = Game.returnPlayerTwo();
			} else if (inputPlayerNumber == 3 && !(Game.returnPlayerThree().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerThree())) {
				playerToTradeWith = Game.returnPlayerThree();
			} else if (inputPlayerNumber == 4 && !(Game.returnPlayerFour().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerFour())) {
				playerToTradeWith = Game.returnPlayerFour();
			} else if (inputPlayerNumber == 5 && !(Game.returnPlayerFive().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerFive())) {
				playerToTradeWith = Game.returnPlayerFive();
			} else if (inputPlayerNumber == 6 && !(Game.returnPlayerSix().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerSix())) {
				playerToTradeWith = Game.returnPlayerSix();
			} else if (inputPlayerNumber == 7 && !(Game.returnPlayerSeven().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerSeven())) {
				playerToTradeWith = Game.returnPlayerSeven();
			} else if (inputPlayerNumber == 8 && !(Game.returnPlayerEight().equals(Game.getPlayerWhosTurnItIs()))
					&& Player.getPlayingGame(Game.returnPlayerEight())) {
				playerToTradeWith = Game.getPlayerWhosTurnItIs();
			} else {
				System.out.println("Invalid Choice");
				pickedThemself = true;
			}
		} while (pickedThemself);
		return playerToTradeWith;
	}

	public static int askCurrentPlayerForTrade() throws IOException {

		int inputPlayerNumber = 0;
		Player player = null;
		whatPlayerToTradeWith(inputPlayerNumber, player);

		System.out.println("Would you like to continue trade?");
		String[] currentPlayerSelection = new String[] { "Accept", "Decline" };
		int menuSelect = ConsoleUI.promptForMenuSelection(currentPlayerSelection, false);

		if (menuSelect == 1) {

			System.out.println("Please select what you want to trade:");
			String[] currentPlayerChooseTrade = new String[] { "Money", "Get Out of Jail Free", "Properties" };
			int selectWhatToTrade = ConsoleUI.promptForMenuSelection(currentPlayerChooseTrade, false);

			if (selectWhatToTrade == 1) {
				boolean currentPlayerMoneyExchange = ConsoleUI
						.promptForBool("Would you like to exchange some cash?" + "[Y/N]", "Y", "N");

				if (currentPlayerMoneyExchange == true) {
					int playersMoney = Player.getMoney(Game.getPlayerWhosTurnItIs());
					System.out.println("You have: " + playersMoney);
					enterValue = ConsoleUI.promptForInt("Enter in the value of money you would like to exchange:", 0,
							Integer.MAX_VALUE);
					boolean amountRight = false;
					while (!amountRight) {
						if (enterValue > Player.getMoney(Game.getPlayerWhosTurnItIs())) {
							System.out.println("Error! Amount specified is too high. You don't have that much money.");
							amountRight = false;
						} else {
							System.out.println("Money value is sufficient!");
							System.out.println("Amount To Be Exchanged: " + enterValue);
							amountRight = true;
						}
					}
				} else if (currentPlayerMoneyExchange == false) {
					System.out.println("No cash will be exchanged");
					enterValue = 0;
				}
				return enterValue;
			}

			if (selectWhatToTrade == 2) {
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

			if (selectWhatToTrade == 3) {
				boolean decideToTradeProperty = ConsoleUI
						.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");

				if (decideToTradeProperty == true) {
					boolean decideTrade = true;
					while (decideTrade) {
						boolean continuePropTrade = ConsoleUI
								.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");

						if (continuePropTrade == true) {
							System.out.println("What property will you be trading?");
							System.out.println(Player.getland(Game.getPlayerWhosTurnItIs()));
							tradingLand.addAll(Player.getland(Game.getPlayerWhosTurnItIs()));
							int landToTrade = ConsoleUI.promptForInt(
									"Select what property you want to trade and remove from your inventory", 1,
									tradingLand.size());
							tradingLand = Player.getland(Game.getPlayerWhosTurnItIs());
							tradingLand.remove(landToTrade);
							decideTrade = true;
							continuePropTrade = true;

						} else {
							System.out.println("No more property will be traded");
							decideTrade = true;
							continuePropTrade = false;
						}
					}
				}

				else if (decideToTradeProperty == false) {
					System.out.println("No property will be traded");
					tradingLand = Player.getland(Game.getPlayerWhosTurnItIs());
				}
			}

			else if (menuSelect == 2) {
				System.out.println("There will be no trade");
				exitTrade = false;
				// exitTrade = ConsoleUI.promptForBool("Are you sure you want to
				// quit trade?" + "[Y/N]", "Y", "N");

			}
		}
		return menuSelect;
	}

	public static int selectWhatOtherPlayerTrades() throws IOException {

		int inputPlayerNumber = 0;
		Player player = null;
		whatPlayerToTradeWith(inputPlayerNumber, player);

		System.out
				.println("What would you like to take from Player:" + whatPlayerToTradeWith(inputPlayerNumber, player));
		String[] tradingWithOtherPlayer = new String[] { "Money", "Get Out of Jail Free", "Properties" };
		int requestOtherPlayerTrade = ConsoleUI.promptForMenuSelection(tradingWithOtherPlayer, false);

		if (requestOtherPlayerTrade == 1) {
			boolean exchangeMoneyWithOtherPlayer = ConsoleUI
					.promptForBool("Would you like to request a money exchange?" + "[Y/N]", "Y", "N");

			if (exchangeMoneyWithOtherPlayer == true) {
				int otherPlayersMoney = Player.getMoney(player);
				System.out.println("Player has: " + otherPlayersMoney);
				enter2Value = ConsoleUI.promptForInt("Enter in the value of money you would like to trade", 0,
						Integer.MAX_VALUE);
				boolean otherRightAmount = false;
				while (!otherRightAmount)
					if (otherPlayersMoney < enter2Value) {
						System.out.println("Error! Player: " + whatPlayerToTradeWith(inputPlayerNumber, player)
								+ " doesn't have that money money in their account. Try Again.");
						otherRightAmount = false;
					} else {
						System.out.println("They have enough funds in their account");
						System.out.println("Amount To Be Exchanged: " + enter2Value);
						otherRightAmount = true;
					}

			}

			else if (exchangeMoneyWithOtherPlayer == false) {
				System.out.println("No cash will be exchanged");
				enter2Value = 0;
			}
			return enter2Value;
		}

		if (requestOtherPlayerTrade == 2) {
			boolean askPlayerForJailCard = ConsoleUI
					.promptForBool("Would you like to request a Get out of jail card?" + "[Y/N]", "Y", "N");

			if (askPlayerForJailCard == true) {
				System.out.println("Checking to see if player " + player + " has a card");

				if (!Player.getGetOutOfJailChance(player) && !Player.getGetOutOfJailChest(player)) {
					System.out.println("Sorry, Player: " + whatPlayerToTradeWith(inputPlayerNumber, player)
							+ " doesn't possess a Get out of jail free card");
					playersJailCard = false;
				} else if (Player.getGetOutOfJailChance(player) || Player.getGetOutOfJailChest(player)) {
					System.out.println("Excellent! They are eligible for trade");
					playersJailCard = true;
				}
			}

			else if (askPlayerForJailCard == false) {
				System.out.println("No Get Out of Jail Free cards will be traded");
			}
		}
		if (requestOtherPlayerTrade == 3) {
			boolean requestToTradePlayerProperty = ConsoleUI
					.promptForBool("Would you like to request some property?" + "[Y/N]", "Y", "N");

			if (requestToTradePlayerProperty == true) {
				boolean tradeCon = true;

				while (tradeCon) {
					boolean continuePropTrade = ConsoleUI.promptForBool("Would you like to continue trade?" + "[Y/N]",
							"Y", "N");
					if (continuePropTrade == true) {
						System.out.println("What property do you want?");
						System.out.println(Player.getland(player));
						tradingPlayerLand.addAll(Player.getland(player));
						int requestLand = ConsoleUI.promptForInt("Select what property you want to take", 1,
								tradingPlayerLand.size());
						tradingPlayerLand = Player.getland(player);
						tradingPlayerLand.remove(requestLand);
						tradeCon = true;
						continuePropTrade = true;
					} else {
						System.out.println("No more property will be asked of");
						tradeCon = true;
						continuePropTrade = false;
					}
				}
			}

			else if (requestToTradePlayerProperty == false) {
				System.out.println("No property will be asked of");
				tradingPlayerLand = Player.getland(Game.getPlayerWhosTurnItIs());
			}
		}
		return requestOtherPlayerTrade;
	}

	public static boolean acceptOrDeclinePlayerTradeRequest() throws IOException {

		int inputPlayerNumber = 0;
		Player player = null;
		whatPlayerToTradeWith(inputPlayerNumber, player);
		System.out.println("Player being requested for trade what will you do?");

		boolean acceptOrDecline = ConsoleUI.promptForBool(whatPlayerToTradeWith(inputPlayerNumber, player)
				+ "would you like to trade with the player intiating trade?" + "[Y/N]", "Y", "N");

		if (acceptOrDecline == true) {
			boolean willYouModifyTrade = ConsoleUI.promptForBool("Would you like to modify your trade?" + "[Y/N]", "Y",
					"N");

			if (willYouModifyTrade == true) {
				String[] modifyChoices = new String[] { "Money", "Get Out of Jail Free", "Properties" };
				int selectWhatToModify = ConsoleUI.promptForMenuSelection(modifyChoices, false);

				if (selectWhatToModify == 1) {
					boolean modifyExchange = ConsoleUI.promptForBool("Please modify exchange" + "[Y/N]", "Y", "N");
					if (modifyExchange == true) {
						enter2Value = 0;
						enter2Value = ConsoleUI.promptForInt("Modify money value", 0, Integer.MAX_VALUE);
						boolean checkModifiedAmount = false;
						while (!checkModifiedAmount) {
							if (enter2Value > Player.getMoney(player)) {
								System.out.println(player + " you don't have that much money");
								checkModifiedAmount = false;
							} else {
								System.out.println("Modified amount is sufficient");
								System.out.println("Amount To Be Exchanged: " + enter2Value);
								Player.setMoney(player, -enter2Value);
								Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2Value);
								System.out.println("Current player has " + enter2Value + " added to their account");
								Player.setMoney(Game.getPlayerWhosTurnItIs(), -enterValue);
								Player.setMoney(player, enterValue);
								System.out.println(whatPlayerToTradeWith(inputPlayerNumber, player) + " has "
										+ enterValue + " added to their account");
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
					boolean modifyJailCard = ConsoleUI
							.promptForBool("Would you like to trade your Get Out of Jail Card?" + "[Y/N]", "Y", "N");

					if (modifyJailCard == true) {
						System.out.println("Checking to see if that player has a card");
						if (playersJailCard == false && currentJailCard == false) {
							System.out.println("Sorry, no player possesses a Get Out of Jail Free card");
						}

						else if (playersJailCard == true && currentJailCard == false) {
							System.out.println("Excellent! " + whatPlayerToTradeWith(inputPlayerNumber, player)
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
					boolean willYouTradePlayerProperty = ConsoleUI
							.promptForBool("Would you like to trade some property?" + "[Y/N]", "Y", "N");

					if (willYouTradePlayerProperty == true) {
						boolean isTradeTrue = true;
						while (isTradeTrue) {
							boolean continuePropTrade = ConsoleUI
									.promptForBool("Would you like to continue trade?" + "[Y/N]", "Y", "N");

							if (continuePropTrade == true) {
								System.out.println("What property do you want?");
								System.out.println(Player.getland(Game.getPlayerWhosTurnItIs()));
								int tradeLand = ConsoleUI.promptForInt("Select what property DO you want to take", 1,
										Integer.MAX_VALUE);
								tradingLand = Player.getland(Game.getPlayerWhosTurnItIs());
								tradingLand.remove(tradeLand);
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
				} else if (willYouModifyTrade = false) {
					System.out.println("Trade will commence");
					Player.setMoney(player, -enter2Value);
					Player.setMoney(Game.getPlayerWhosTurnItIs(), enter2Value);
					System.out.println("Current player has " + enter2Value + " added to their account");
					Player.setMoney(Game.getPlayerWhosTurnItIs(), -enterValue);
					Player.setMoney(player, enterValue);
					System.out.println(whatPlayerToTradeWith(inputPlayerNumber, player) + " has " + enterValue
							+ " added to their account");
					// MONEY

				}
			}

			else if (acceptOrDecline == false) {
				System.out.println("Trade declined");
				System.out.println("Let's restart the process");
				enterValue = 0;
				enter2Value = 0;
				currentJailCard = null != null;
				playersJailCard = null != null;
				whatPlayerToTradeWith(inputPlayerNumber, player);
			}
		}
		return acceptOrDecline;
	}

	public static Player callAllMethods() throws IOException {
		int inputPlayerNumber = 0;
		Player player = Game.getPlayerWhosTurnItIs();
		whatPlayerToTradeWith(inputPlayerNumber, player);
		askCurrentPlayerForTrade();
		if (exitTrade = false) {

		} else {
			selectWhatOtherPlayerTrades();
			acceptOrDeclinePlayerTradeRequest();
		}
		return null;
	}
}
