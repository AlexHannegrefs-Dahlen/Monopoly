package Nilrre.Jason.Alex.Law;

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
	private static GamePieces[] pieces = new GamePieces[8];
	
	public static GamePieces[] getPieces(){
		return GamePieces.pieces;
	}
	
	public static void makeGamePieces(){
		GamePieces.pieces[0] = Thimble;
		GamePieces.pieces[1] = Wheel_Barrow;
		GamePieces.pieces[2] = Boot;
		GamePieces.pieces[3] = Dog;
		GamePieces.pieces[4] = RaceCar;
		GamePieces.pieces[5] = Iron;
		GamePieces.pieces[6] = Battleship;
		GamePieces.pieces[7] = Tophat;
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