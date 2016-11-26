package Nilrre.Jason.Alex.Law;

public class GamePieces {

	enum diffPieces {
		Thimble, Wheel_Barrow, Boot, Dog, RaceCar, Iron, Battleship, Tophat;

		private boolean taken;
	}

	private static GamePieces.diffPieces[] pieces = new GamePieces.diffPieces[8];

	public static GamePieces.diffPieces[] getPieces() {
		return GamePieces.diffPieces.values();
	}

	public static void makeGamePieces() {
		GamePieces.pieces[0] = GamePieces.diffPieces.Thimble;
		GamePieces.pieces[1] = GamePieces.diffPieces.Wheel_Barrow;
		GamePieces.pieces[2] = GamePieces.diffPieces.Boot;
		GamePieces.pieces[3] = GamePieces.diffPieces.Dog;
		GamePieces.pieces[4] = GamePieces.diffPieces.RaceCar;
		GamePieces.pieces[5] = GamePieces.diffPieces.Iron;
		GamePieces.pieces[6] = GamePieces.diffPieces.Battleship;
		GamePieces.pieces[7] = GamePieces.diffPieces.Tophat;
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