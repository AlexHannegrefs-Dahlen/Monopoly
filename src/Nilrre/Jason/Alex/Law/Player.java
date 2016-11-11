package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;

public class Player {
	private static String piece;
	private String playerNumber;
	
	public static void setPlayerNUmber(Player name, int number){
		String Number = Integer.toString(number);
		name.playerNumber = Number;
	}

	public static String getPiece(Player piece){
		return Player.piece;
	}

	public static void setPiece(Player newPiece) throws IOException {
		ArrayList<String> pieces = GamePieces.theseAreGamePieces();
		for (int i = 0; i < pieces.size(); i++) {
			System.out.print(i + 1 + ": " + pieces.get(i) + " ");
		}
		System.out.println("");
		int Selection = ConsoleUI.promptForInt("What piece would you like?", 1, pieces.size());
		Player.piece = pieces.get(Selection - 1);
	}

	public void buyBoardPiece() {

	}

	public static void roll() {

	}

	public void buyHousesOrHotel() {

	}

}
