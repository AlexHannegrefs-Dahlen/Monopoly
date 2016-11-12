package Nilrre.Jason.Alex.Law;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Player {
	private String piece;
	
	

	public static String getPiece(Player pieceFinder){
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

	public static void buyBoardPiece() {

	}

	public static int roll() {
		Random gen = new Random();
		int movement = (gen.nextInt(11) + 2);
		return movement;
	}

	public static void buyHousesOrHotel() {

	}

}
