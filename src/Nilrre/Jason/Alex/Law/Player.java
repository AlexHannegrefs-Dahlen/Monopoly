package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import Nilrre.Jason.Alex.Law.GamePieces.diffPieces;

public class Player {
	private diffPieces piece;
	private int money;
	private int jailCard;
	private ArrayList<BoardSpaces> land;
	private boolean GetOutOfJailChance = false;
	private boolean GetOutOfJailChest = false;
	private boolean inJail = false;
	private int spaceCurrentlyOn;
	private int rolledDoubles;
	private boolean myTurn = false;
	private boolean playingGame = false;
	private int amountOnDie;
	private int railroadsOwned;
	
	public static int getRailroadsOwned(Player railroad){
		return railroad.railroadsOwned;
	}
	
	public static void setRailroadsOwned(Player railroad, int railroadsToAdd){
		railroad.railroadsOwned =+ railroadsToAdd;
	}
	
	public static int getAmountOnDie(Player rolling){
		return rolling.amountOnDie;
	}
	
	public static void setAmountOnDie(Player rolling, int dieOne, int dieTwo){
		rolling.amountOnDie = dieOne + dieTwo;
	}
	
	public static void setPlayingGame(Player game, boolean Game){
		game.playingGame = Game;
	}
	
	public static boolean getPlayingGame(Player game){
		return game.playingGame;
	}
	
	public static void setMyTurn(Player turn, boolean Turn){
		turn.myTurn = Turn;
	}
	
	public static boolean getMyTurn(Player turn){
		return turn.myTurn;
	}
	
	public static void setInJail(Player jail, boolean Jail){
		jail.inJail = Jail;
	}
	
	public static boolean getInJail(Player jail){
		return jail.inJail;
	}
	
	public static void setGetOutOfJailChance(Player JailChance, boolean haveCard){
		JailChance.GetOutOfJailChance = haveCard;
		
	}
	
	public static boolean getGetOutOfJailChance(Player JailChance){
		return JailChance.GetOutOfJailChance;
		
	}
	
	public static boolean getGetOutOfJailChest(Player JailChest){
		return JailChest.GetOutOfJailChest;
		
	}
	
	public static void setGetOutOfJailChest(Player JailChest, boolean haveCard){
		JailChest.GetOutOfJailChest = haveCard;
		
	}

	public static void setSpaceCurrentlyOn(Player space, int spotOnBoard) {
		space.spaceCurrentlyOn = spotOnBoard;
	}
	
	public static int getSpaceCurrentlyOn(Player space) {
		return space.spaceCurrentlyOn;
	}
	
	public static ArrayList<BoardSpaces> getland(Player land){
		return land.land;
	}

	public static void removeLand(Player land, BoardSpaces property) {
		land.land.remove(property);
	}

	public static void buyLand(Player land, BoardSpaces property) {
		land.land.add(property);
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

	public static void setMoney(Player moneyVal, int valuetoadd) {
		moneyVal.money =+ valuetoadd;
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
			}
			else {
				GamePieces.takePiece(newPiece.piece);
			}
		} while (pieceAlreadyTaken);
	}

	public static void roll(Player rolling) {
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

	public static void makeMovement(int dieOne, int dieTwo, Player moving) {
		System.out.println("Moving");
		int movement = dieOne + dieTwo;	
		moving.spaceCurrentlyOn += movement;
		if((moving.spaceCurrentlyOn) > 40){
			moving.spaceCurrentlyOn -= 40;
			moving.money =+ 200;
			System.out.println("You passed go Collect $200. Current funds: $" + moving.money);
		}
		System.out.println("Moved to space " + moving.spaceCurrentlyOn);
		spaceNumberTo2dArray(moving);
	}
	
	public static void spaceNumberTo2dArray(Player moved){
		int space = moved.spaceCurrentlyOn;
		if(space == 1){
			//[10][9] property
		} else if (space == 2) {
			//[10][8] com chest
		} else if (space == 3) {
			//[10][7] property
		} else if (space == 4) {
			//[10][6] income tax
		} else if (space == 5) {
			//[10][5] prop rail
		} else if (space == 6) {
			//[10][4] prop
		} else if (space == 7) {
			//10 3 chance
		} else if (space == 8) {
			// 10 2 prop
		} else if (space == 9) {
			//10 2 prop
		} else if (space == 11) {
			//9 0 prop
		} else if (space == 12) {
			//8 0 util
		} else if (space == 13) {
			//7 0 prop
		} else if (space == 14) {
			//6 0 prop
		} else if (space == 15) {
			//5 0 prop
		} else if (space == 16) {
			//4 0 prop
		} else if (space == 17) {
			//3 0 com chest
		} else if (space == 18) {
			//2 0 prop
		} else if (space == 19) {
			//1 0 prop
		} else if (space == 21) {
			//0 1 prop
		} else if (space == 22) {
			//0 2 chance
		} else if (space == 23) {
			//0 3 prop
		} else if (space == 24) {
			//0 4 prop
		} else if (space == 25) {
			//0 5 prop rail
		} else if (space == 26) {
			//0 6 prop
		} else if (space == 27) {
			//0 7 prop
		} else if (space == 28) {
			//0 8 prop util
		} else if (space == 29) {
			//0 9 prop
		} else if (space == 30) {
			//0 10 got to jail
		} else if (space == 31) {
			//1 10 prop
		} else if (space == 32) {
			//2 10 prop
		} else if (space == 33) {
			//3 10 com chest
		} else if (space == 34) {
			//4 10 prop
		} else if (space == 35) {
			//5 10 prop rail
		} else if (space == 36) {
			//6 10 Chance
		}else if (space == 37) {
			//7 10 prop
		}else if (space == 38) {
			//8 10 lux tax
		}else if (space == 39) {
			//9 10 prop
		}
	}
	
	public static void checkSpaceMovedToForOwner(int row, int col, Player moved){
		if(Board.b.getIsAvailable(Board.board[row][col])){
			//prop avail
		} else{
			Player owner = Board.b.getOwnedBy(Board.board[row][col]);
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
		UpgradeLand.buyHousesOrHotel(upgrading);
	}

	public static void trade(Player trading) {
		Trade.whatPlayerToTradeWith();
	}

}
