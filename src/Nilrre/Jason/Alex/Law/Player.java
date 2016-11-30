package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Nilrre.Jason.Alex.Law.GamePieces.diffPieces;

public class Player {
	private diffPieces piece;
	private int money;
	private int jailCard;
	private ArrayList<BoardSpaces> land = new ArrayList<>();
	private boolean GetOutOfJailChance = false;
	private boolean GetOutOfJailChest = false;
	private boolean inJail = false;
	private int spaceCurrentlyOn = 1;
	private String nameOfSpaceOn;
	private int rolledDoubles;
	private boolean myTurn = false;
	private boolean playingGame;
	private int amountOnDie;
	private int railroadsOwned;
	private int housesOwned;
	private int hotelsOwned;
	private boolean inAuction;

	public static Player getWhoWonAuction() {
		if (Player.getInAuction(Game.returnPlayerOne())) {
			return Game.returnPlayerOne();
		} else if (Player.getInAuction(Game.returnPlayerTwo())) {
			return Game.returnPlayerTwo();
		} else if (Player.getInAuction(Game.returnPlayerThree())) {
			return Game.returnPlayerThree();
		} else if (Player.getInAuction(Game.returnPlayerFour())) {
			return Game.returnPlayerFour();
		} else if (Player.getInAuction(Game.returnPlayerFive())) {
			return Game.returnPlayerFive();
		} else if (Player.getInAuction(Game.returnPlayerSix())) {
			return Game.returnPlayerSix();
		} else if (Player.getInAuction(Game.returnPlayerSeven())) {
			return Game.returnPlayerSeven();
		} else {
			return Game.returnPlayerEight();
		}
	}

	public static boolean getInAuction(Player auction) {
		return auction.inAuction;
	}

	public static void setInAuction(Player auction, boolean participating) {
		auction.inAuction = participating;
	}

	public static int getHousesOwned(Player houses) {
		return houses.housesOwned;
	}

	public static void setHousesOwned(Player houses, int amounttoadd) {
		houses.housesOwned += amounttoadd;
	}

	public static int getHotelsOwned(Player hotels) {
		return hotels.hotelsOwned;
	}

	public static void setHotelsOwned(Player hotels, int amounttoadd) {
		hotels.hotelsOwned += amounttoadd;
	}

	public static String getNameOfSpaceOn(Player space) {
		return space.nameOfSpaceOn;
	}

	public static void setNameOfSpaceOn(Player space, String spaceName) {
		space.nameOfSpaceOn = spaceName;
	}

	public static int getRailroadsOwned(Player railroad) {
		return railroad.railroadsOwned;
	}

	public static void setRailroadsOwned(Player railroad, int railroadsToAdd) {
		railroad.railroadsOwned = +railroadsToAdd;
	}

	public static int getAmountOnDie(Player rolling) {
		return rolling.amountOnDie;
	}

	public static void setAmountOnDie(Player rolling, int dieOne, int dieTwo) {
		rolling.amountOnDie = dieOne + dieTwo;
	}

	public static void setPlayingGame(Player game, boolean Game) {
		game.playingGame = Game;
	}

	public static boolean getPlayingGame(Player game) {
		return game.playingGame;
	}

	public static void setMyTurn(Player turn, boolean Turn) {
		turn.myTurn = Turn;
	}

	public static boolean getMyTurn(Player turn) {
		return turn.myTurn;
	}

	public static void setInJail(Player jail, boolean Jail) {
		jail.inJail = Jail;
	}

	public static boolean getInJail(Player jail) {
		return jail.inJail;
	}

	public static void setGetOutOfJailChance(Player JailChance, boolean haveCard) {
		JailChance.GetOutOfJailChance = haveCard;

	}

	public static boolean getGetOutOfJailChance(Player JailChance) {
		return JailChance.GetOutOfJailChance;

	}

	public static boolean getGetOutOfJailChest(Player JailChest) {
		return JailChest.GetOutOfJailChest;

	}

	public static void setGetOutOfJailChest(Player JailChest, boolean haveCard) {
		JailChest.GetOutOfJailChest = haveCard;

	}

	public static void setSpaceCurrentlyOn(Player space, int spotOnBoard) {
		space.spaceCurrentlyOn = spotOnBoard;
	}

	public static int getSpaceCurrentlyOn(Player space) {
		return space.spaceCurrentlyOn;
	}

	public static ArrayList<BoardSpaces> getland(Player land) {
		return land.land;
	}

	public static void removeLand(Player land, BoardSpaces property) {
		land.land.remove(property);
	}

	public static void buyLand(Player land, BoardSpaces property, int price) throws IOException {
		land.land.add(property);
		property.setIsAvailable(property, false);
		Player.setMoney(land, -price);
	}

	public static int getJailcard(Player jailcard) {
		return jailcard.jailCard;
	}

	public static void useJailCard(Player jailcard) {
		jailcard.jailCard--;
	}

	public static void giveJailCard(Player jailcard) {
		jailcard.jailCard++;
	}

	public static int getMoney(Player moneyFinder) {
		return moneyFinder.money;
	}

	public static void setMoney(Player moneyVal, double valuetoadd) throws IOException {
		moneyVal.money += (int) + valuetoadd;
		if(moneyVal.money < 0){
			System.out.println("You must mortgage to afford this payment. What would you like to mortgage?");
		}
	}
	
	public static void unmortgage(Player unmortgaging) throws IOException{
		boolean validProp;
		do {
			validProp = true;
			int property = ConsoleUI.promptForInt(unmortgaging.land.toString() + "Enter number of property", 1, 40);
			if (unmortgaging.land.contains(property)) {
				int[] spaces = spaceNumberToBoardCords(property);

				int row = spaces[0];
				int col = spaces[1];
				if (!Board.board[row][col].getMortgaged(Board.board[row][col])) {
					Board.b.setMortgaged(Board.board[row][col], true);
				} else {
					System.out.println("This space is already unmortgaged");
					validProp = false;
				}
			} else {
				System.out.println("You do not own this space");
				validProp = false;
			}
		} while (!validProp);
	}

	public static void mortgage(Player mortgaging) throws IOException {
		boolean validProp;
		do {
			validProp = true;
			int property = ConsoleUI.promptForInt(mortgaging.land.toString() + "Enter number of property", 1, 40);
			if (mortgaging.land.contains(property)) {
				int[] spaces = spaceNumberToBoardCords(property);

				int row = spaces[0];
				int col = spaces[1];
				if (Board.board[row][col].getMortgaged(Board.board[row][col])) {
					Board.b.setMortgaged(Board.board[row][col], true);
				} else {
					System.out.println("This space is already mortgaged");
					validProp = false;
				}
			} else {
				System.out.println("You do not own this space");
				validProp = false;
			}
		} while (!validProp);
	}

	public static diffPieces getPiece(Player pieceFinder) {
		return pieceFinder.piece;
	}

	public static void setPiece(Player newPiece) throws IOException {
		boolean pieceAlreadyTaken;
		do {

			for (int i = 0; i < GamePieces.getPieces().length; i++) {
				System.out.print(i + 1 + ": " + GamePieces.getPieces()[i] + " ");
			}
			System.out.println("");
			int Selection = ConsoleUI.promptForInt("What piece would you like?", 1, GamePieces.getPieces().length);
			newPiece.piece = GamePieces.diffPieces.values()[Selection - 1];
			pieceAlreadyTaken = GamePieces.checkIfTaken(newPiece.piece);
			if (pieceAlreadyTaken) {
				System.out.println("Sorry. Piece Already Taken");
			} else {
				GamePieces.takePiece(newPiece.piece);
			}
		} while (pieceAlreadyTaken);
	}

	public static void roll(Player rolling) throws IOException {
		System.out.println("Rolling");
		Random gen = new Random();
		int dieOne = (gen.nextInt(6) + 1);
		int dieTwo = (gen.nextInt(6) + 1);
		setAmountOnDie(rolling, dieOne, dieTwo);
		if (rolling.inJail) {
			boolean doubles = checkForDoubles(dieOne, dieTwo);
			if (doubles) {
				setInJail(rolling, false);
			}
		} else {

			boolean doubles = checkForDoubles(dieOne, dieTwo);
			if (doubles) {
				rolling.rolledDoubles++;
				if (rolling.rolledDoubles == 3) {
					setInJail(rolling, true);
					System.out.println("You went to jail for rolling doubles three times in a row");
					rolling.rolledDoubles = 0;
					return;
				}
			}
		}
		makeMovement(dieOne, dieTwo, rolling);
	}

	public static void makeMovement(int dieOne, int dieTwo, Player moving) throws IOException {
		System.out.println("Moving");
		int movement = dieOne + dieTwo;
		moving.spaceCurrentlyOn += movement;
		if ((moving.spaceCurrentlyOn) > 41) {
			moving.spaceCurrentlyOn -= 41;
			Player.setMoney(moving, 200);
			System.out.println("You passed go Collect $200. Current funds: $" + moving.money);
		}
		spaceNumberTo2dArray(moving);
	}

	public static void printSpaceNameMovedTo(int row, int col, Player moved) {
		Player.setNameOfSpaceOn(moved, Board.board[row][col].getName(Board.board[row][col]));
		System.out.println("You moved to space " + moved.nameOfSpaceOn);
	}

	public static void spaceNumberTo2dArray(Player moved) throws IOException {
		int space = moved.spaceCurrentlyOn;
		int row = 0;
		int col = 0;
		if (space == 2) {
			row = 10;
			col = 9;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 3) {
			row = 10;
			col = 8;
			printSpaceNameMovedTo(row, col, moved);
			Community_Cards.effects();
		} else if (space == 4) {
			row = 10;
			col = 7;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 5) {
			row = 10;
			col = 6;
			printSpaceNameMovedTo(row, col, moved);
			Player.setMoney(moved, -200);
		} else if (space == 6) {
			row = 10;
			col = 5;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 7) {
			row = 10;
			col = 4;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 8) {
			row = 10;
			col = 3;
			printSpaceNameMovedTo(row, col, moved);
			Chance_Cards.CardEffects();
		} else if (space == 9) {
			row = 10;
			col = 2;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 10) {
			row = 10;
			col = 1;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 11) {
			row = 10;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
		} else if (space == 12) {
			row = 9;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 13) {
			row = 8;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 14) {
			row = 7;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 15) {
			row = 6;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 16) {
			row = 5;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 17) {
			row = 4;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 18) {
			row = 3;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			Community_Cards.effects();
		} else if (space == 19) {
			row = 2;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 20) {
			row = 1;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 21){
			row = 0;
			col = 0;
			printSpaceNameMovedTo(row, col, moved);
		} else if (space == 22) {
			row = 0;
			col = 1;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 23) {
			row = 0;
			col = 2;
			printSpaceNameMovedTo(row, col, moved);
			Chance_Cards.CardEffects();
		} else if (space == 24) {
			row = 0;
			col = 3;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 25) {
			row = 0;
			col = 4;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 26) {
			row = 0;
			col = 5;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 27) {
			row = 0;
			col = 6;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 28) {
			row = 0;
			col = 7;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 29) {
			row = 0;
			col = 8;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 30) {
			row = 0;
			col = 9;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 31) {
			printSpaceNameMovedTo(row, col, moved);
			Player.setSpaceCurrentlyOn(moved, 10);
			Player.setInJail(moved, true);
		} else if (space == 32) {
			row = 1;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 33) {
			row = 2;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 34) {
			row = 3;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			Community_Cards.effects();
		} else if (space == 35) {
			row = 4;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 36) {
			row = 5;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 37) {
			row = 6;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			Chance_Cards.DRAW();
		} else if (space == 38) {
			row = 7;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 39) {
			row = 8;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			Player.setMoney(moved, -75);
		} else if (space == 40) {
			row = 9;
			col = 10;
			printSpaceNameMovedTo(row, col, moved);
			checkSpaceMovedToForOwner(row, col, moved);
		}
	}

	public static int[] spaceNumberToBoardCords(int space) {
		int row = 0;
		int col = 0;
		if (space == 2) {
			row = 10;
			col = 9;
		} else if (space == 4) {
			row = 10;
			col = 7;
		} else if (space == 6) {
			row = 10;
			col = 5;
		} else if (space == 7) {
			row = 10;
			col = 4;
		} else if (space == 9) {
			row = 10;
			col = 2;
		} else if (space == 10) {
			row = 10;
			col = 1;
		} else if (space == 12) {
			row = 9;
			col = 0;
		} else if (space == 13) {
			row = 8;
			col = 0;
		} else if (space == 14) {
			row = 7;
			col = 0;
		} else if (space == 15) {
			row = 6;
			col = 0;
		} else if (space == 16) {
			row = 5;
			col = 0;
		} else if (space == 17) {
			row = 4;
			col = 0;
		} else if (space == 19) {
			row = 2;
			col = 0;
		} else if (space == 20) {
			row = 1;
			col = 0;
		} else if (space == 22) {
			row = 0;
			col = 1;
		} else if (space == 23) {
			row = 0;
			col = 2;
		} else if (space == 24) {
			row = 0;
			col = 3;
		} else if (space == 25) {
			row = 0;
			col = 4;
		} else if (space == 26) {
			row = 0;
			col = 5;
		} else if (space == 27) {
			row = 0;
			col = 6;
		} else if (space == 28) {
			row = 0;
			col = 7;
		} else if (space == 29) {
			row = 0;
			col = 8;
		} else if (space == 30) {
			row = 0;
			col = 9;
		} else if (space == 32) {
			row = 1;
			col = 10;
		} else if (space == 33) {
			row = 2;
			col = 10;
		} else if (space == 35) {
			row = 4;
			col = 10;
		} else if (space == 36) {
			row = 5;
			col = 10;
		} else if (space == 38) {
			row = 7;
			col = 10;
		} else if (space == 40) {
			row = 9;
			col = 10;
		}
		int[] boards = new int[2];
		boards[0] = row;
		boards[1] = col;
		return boards;
	}

	public static void checkSpaceMovedToForOwner(int row, int col, Player moved) throws IOException {
		if (Board.b.getIsAvailable(Board.board[row][col])) {
			if (ConsoleUI.promptForBool("Woud you like to buy " + Board.b.getName(Board.board[row][col]) + " [y/n]",
					"y", "n")) {
				Player.buyLand(moved, Board.board[row][col], Board.board[row][col].getLandValue(Board.board[row][col]));
			} else {
				Auction.startAuction(Board.board[row][col]);
			}
		} else if (!Board.b.getMortgaged(Board.board[row][col])) {
			Player owner = Board.b.getOwnedBy(Board.board[row][col]);
			System.out.println("You owe " + owner + ".");
			Player.setMoney(moved, -Board.board[row][col].getRent(Board.board[row][col]));
			Player.setMoney(owner, Board.board[row][col].getRent(Board.board[row][col]));
		}
	}

	private static boolean checkForDoubles(int dieOne, int dieTwo) {
		boolean rolledDoubles = false;

		if (dieOne == dieTwo) {
			rolledDoubles = true;
		}
		return rolledDoubles;
	}

	public static void buyHousesOrHotel(Player upgrading) {
		//LandValue;
	}

	public static void trade(Player trading) throws IOException {
		Trade.callAllMethods(trading);
//		Trade.whatPlayerToTradeWith(0, Game.getPlayerWhosTurnItIs());
	}

}
