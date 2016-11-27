package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class testPrint {

	public static void main(String[] args) throws IOException {
		Board b = new Board();
		b.createBoard();

		System.out.println("Player is on " + Player.getSpaceCurrentlyOn(Game.returnPlayerOne()));

		for (int row = 0; row < 11; row++) {
			for (int column = 0; column < 11; column++) {				
				if (Player.getSpaceCurrentlyOn(Game.getPlayerWhosTurnItIs()) == Board.b.getBoardSpaceNumber(Board.board[row][column])) {
					b.printBoard(Board.board);	
				} else {
//					System.out.println("This dosent match up");
					System.out.println("Board space is " + Board.b.getBoardSpaceNumber(Board.board[row][column]) + " At location ["+row+"] ["+column+"]");
				}
			}
		}

	}

}
