package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String piece;
	private int money;
	private int jailCard;
	private ArrayList<String> land;
	private boardspace spaceCurrentlyOn;
	

	public static void SetSpaceCurrentlyOn(Player space, boardspace spotOnBoard){
		space.spaceCurrentlyOn = spotOnBoard;
	}
	
	public static void removeLand(Player land, boardspace property) {
		land.land.remove(property);
	}

	public static void buyLand(Player land, boardspace property) {
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

	public static void setMoney(Player moneyVal) {
		moneyVal.money = 1500;
	}

	public static String getPiece(Player pieceFinder) {
		return pieceFinder.piece;
	}

	public static void setPiece(Player newPiece) throws IOException {
		ArrayList<String> pieces = GamePieces.theseAreGamePieces();
		for (int i = 0; i < pieces.size(); i++) {
			System.out.print(i + 1 + ": " + pieces.get(i) + " ");
		}
		System.out.println("");
		int Selection = ConsoleUI.promptForInt("What piece would you like?", 1, pieces.size());
		newPiece.piece = pieces.get(Selection - 1);
	}

	public static void roll(Player rolling) {
		Random gen = new Random();
		int dieOne = (gen.nextInt(11) + 2);
		int dieTwo = (gen.nextInt(11) + 2);
		if(rolling.spaceCurrentlyOn == boardspace.inJail){
			boolean doubles = checkForDoubles(dieOne, dieTwo);
			if(doubles){
				rolling.spaceCurrentlyOn = boardspace.visitingJail;
				makeMovement(dieOne, dieTwo, rolling);
			}
		}
		else{
			int doublesCounter;
			boolean doubles = checkForDoubles(dieOne, dieTwo);
			if (doubles){
				doublesCounter++;
				if(doublesCounter == 3){
					rolling.spaceCurrentlyOn = boardspace.inJail;
					System.out.println("You went to jail for rolling doubles three times in a row");
					return;
				}
				makeMovement(dieOne, dieTwo, rolling);
			}
		}
	}
	
	public static void makeMovement(int dieOne, int dieTwo, Player moving){
		int movement = dieOne + dieTwo;
		moving.spaceCurrentlyOn = moving.spaceCurrentlyOn + movement;
	}

	public static boolean checkForDoubles(int dieOne, int dieTwo) {
		boolean rolledDoubles = false;

		if (dieOne == dieTwo) {
			rolledDoubles = true;
		}
		return rolledDoubles;
	}

	public static void buyHousesOrHotel(boardspace property) {

	}
	
	public static void trade(Player trading){
		Trade.whatPlayerToTradeWith();
	}

}
