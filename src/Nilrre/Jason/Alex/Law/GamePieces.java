package Nilrre.Jason.Alex.Law;

import java.util.ArrayList;

public class GamePieces {
	private boolean taken;
	private static GamePieces Thimble;
	
	private static GamePieces Wheel_Barrow;
	private static GamePieces Boot;
	private static GamePieces Dog;
	private static GamePieces RaceCar;
	private static GamePieces Iron;
	private static GamePieces Battleship;
	private static GamePieces Tophat;
	
	public static ArrayList<GamePieces> theseAreGamePieces() {
		Thimble.taken = false;
		Wheel_Barrow.taken = false;
		ArrayList<GamePieces> pieces = new ArrayList<GamePieces>();
		pieces.add(Thimble);
		pieces.add(Wheel_Barrow);
		pieces.add(Boot);
		pieces.add(Dog);
		pieces.add(RaceCar);
		pieces.add(Iron);
		pieces.add(Battleship);
		pieces.add(Tophat);
		return pieces;
	}
	
	public static boolean checkIfTaken(GamePieces piece){	
		if (piece.taken){
			return true;
		}
		return false;
	}
	
	public static void takePiece(GamePieces piece){
		piece.taken = true;
	}
}