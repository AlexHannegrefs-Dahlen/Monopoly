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

	public static void setMoney(Player moneyVal, int valuetochange) {
		moneyVal.money =+ valuetochange;
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
		Random gen = new Random();
		int dieOne = (gen.nextInt(6) + 1);
		int dieTwo = (gen.nextInt(6) + 1);
		if (rolling.inJail) {
			boolean doubles = checkForDoubles(dieOne, dieTwo);
			if (doubles) {
				setInJail(rolling, false);
				makeMovement(dieOne, dieTwo, rolling);
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
				makeMovement(dieOne, dieTwo, rolling);
			}
		}
	}

	public static void makeMovement(int dieOne, int dieTwo, Player moving) {
		int movement = dieOne + dieTwo;	
		if((moving.spaceCurrentlyOn =+ movement) > 40){
			moving.spaceCurrentlyOn =- 40;
		}
		
	}

	private static boolean checkForDoubles(int dieOne, int dieTwo) {
		boolean rolledDoubles = false;

		if (dieOne == dieTwo) {
			rolledDoubles = true;
		}
		return rolledDoubles;
	}

	public static void buyHousesOrHotel(BoardSpaces property) {

	}

	public static void trade(Player trading) {
		Trade.whatPlayerToTradeWith();
	}

}
