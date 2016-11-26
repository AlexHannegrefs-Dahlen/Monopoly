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
		if((moving.spaceCurrentlyOn) > 40){
			moving.spaceCurrentlyOn -= 40;
			moving.money =+ 200;
			System.out.println("You passed go Collect $200. Current funds: $" + moving.money);
		}
		System.out.println("Moved to space " + moving.spaceCurrentlyOn);
		spaceNumberTo2dArray(moving);
	}
	
	public static void spaceNumberTo2dArray(Player moved) throws IOException{
		int space = moved.spaceCurrentlyOn;
		int row = 0;
		int col = 0;
		if(space == 1){
			row = 10;
			col = 9;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 2) {
			//[10][8] com chest
		} else if (space == 3) {
			row = 10;
			col = 7;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 4) {
			Player.setMoney(moved, -200);
		} else if (space == 5) {
			row = 10;
			col = 5;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 6) {
			row = 10;
			col = 4;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 7) {
			Chance_Cards.DRAW();
		} else if (space == 8) {
			row = 10;
		col = 2;
		checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 9) {
			row = 10;
			col = 1;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 11) {
			row = 9;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 12) {
			row = 8;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 13) {
			row = 7;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
		} else if (space == 14) {
			row = 6;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
			//6 0 prop
		} else if (space == 15) {
			row = 5;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
			//5 0 prop
		} else if (space == 16) {
			row = 4;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
			//4 0 prop
		} else if (space == 17) {
			//3 0 com chest
		} else if (space == 18) {
			row = 2;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
			//2 0 prop
		} else if (space == 19) {
			row = 1;
			col = 0;
			checkSpaceMovedToForOwner(row, col, moved);
			//1 0 prop
		} else if (space == 21) {
			row = 0;
			col = 1;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 1 prop
		} else if (space == 22) {
			row = 0;
			col = 2;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 2 chance
		} else if (space == 23) {
			row = 0;
			col = 3;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 3 prop
		} else if (space == 24) {
			row = 0;
			col = 4;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 4 prop
		} else if (space == 25) {
			row = 0;
			col = 5;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 5 prop rail
		} else if (space == 26) {
			row = 0;
			col = 6;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 6 prop
		} else if (space == 27) {
			row = 0;
			col = 7;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 7 prop
		} else if (space == 28) {
			row = 0;
			col = 8;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 8 prop util
		} else if (space == 29) {
			row = 0;
			col = 9;
			checkSpaceMovedToForOwner(row, col, moved);
			//0 9 prop
		} else if (space == 30) {
			Player.setSpaceCurrentlyOn(moved, 10);
			Player.setInJail(moved, true);
			//0 10 got to jail
		} else if (space == 31) {
			row = 1;
			col = 10;
			checkSpaceMovedToForOwner(row, col, moved);
			//1 10 prop
		} else if (space == 32) {
			row = 2;
			col = 10;
			checkSpaceMovedToForOwner(row, col, moved);
			//2 10 prop
		} else if (space == 33) {
			//3 10 com chest
		} else if (space == 34) {
			row = 4;
			col = 10;
			checkSpaceMovedToForOwner(row, col, moved);
			//4 10 prop
		} else if (space == 35) {
			row = 5;
			col = 10;
			checkSpaceMovedToForOwner(row, col, moved);
			//5 10 prop rail
		} else if (space == 36) {
			Chance_Cards.DRAW();
			//6 10 Chance
		}else if (space == 37) {
			row = 7;
			col = 10;
			checkSpaceMovedToForOwner(row, col, moved);
			//7 10 prop
		}else if (space == 38) {
			Player.setMoney(moved, -75);
			//8 10 lux tax
		}else if (space == 39) {
			row = 9;
			col = 10;
			checkSpaceMovedToForOwner(row, col, moved);
			//9 10 prop
		}
	}
	
	public static void checkSpaceMovedToForOwner(int row, int col, Player moved) throws IOException{
		if(Board.b.getIsAvailable(Board.board[row][col])){
			if(ConsoleUI.promptForBool("Woud you like to buy " + Board.b.getName(Board.board[row][col]) + " [y/n]", "y", "n")){
				Player.buyLand(moved, Board.board[row][col]);
			}
			else{
				//do an auction
			}
		} else if(!Board.b.getMortgaged(Board.board[row][col])){
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
