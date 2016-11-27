package Nilrre.Jason.Alex.Law;

public class GamePieces {

	enum diffPieces {
		Exclamaion_Point, Question_Mark, Asterisk, At_Symbol, Hashtag, Dollar_Sign, Ampersand, SemiColon;

		private boolean taken;
	}

	private static GamePieces.diffPieces[] pieces = new GamePieces.diffPieces[8];

	public static GamePieces.diffPieces[] getPieces() {
		return GamePieces.diffPieces.values();
	}

	public static String getGamePieces(diffPieces type) {
		String ReturnSymbol;
		if (pieces[0] == type) {
			ReturnSymbol = "!";
		} else if (pieces[1] == type) {
			ReturnSymbol = "?";
		} else if (pieces[2] == type) {
			ReturnSymbol = "*";
		} else if (pieces[3] == type) {
			ReturnSymbol = "@";
		} else if (pieces[4] == type) {
			ReturnSymbol = "#";
		} else if (pieces[5] == type) {
			ReturnSymbol = "$";
		} else if (pieces[6] == type) {
			ReturnSymbol = "&";
		} else if (pieces[7] == type) {
			ReturnSymbol = ";";
		}else {
			ReturnSymbol = " 1";
		}
		
		return ReturnSymbol;
	}

	public static void makeGamePieces() {
		GamePieces.pieces[0] = GamePieces.diffPieces.Exclamaion_Point;
		GamePieces.pieces[1] = GamePieces.diffPieces.Question_Mark;
		GamePieces.pieces[2] = GamePieces.diffPieces.Asterisk;
		GamePieces.pieces[3] = GamePieces.diffPieces.At_Symbol;
		GamePieces.pieces[4] = GamePieces.diffPieces.Hashtag;
		GamePieces.pieces[5] = GamePieces.diffPieces.Dollar_Sign;
		GamePieces.pieces[6] = GamePieces.diffPieces.Ampersand;
		GamePieces.pieces[7] = GamePieces.diffPieces.SemiColon;
	}

	public static boolean checkIfTaken(GamePieces.diffPieces piece) {
		if (piece.taken) {
			return true;
		}
		return false;
	}

	public static void takePiece(GamePieces.diffPieces piece) {
		piece.taken = true;
	}

}