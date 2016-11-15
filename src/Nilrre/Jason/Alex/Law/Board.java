package Nilrre.Jason.Alex.Law;

public class Board {

	public BoardSpaces[][] board = new BoardSpaces[11][11];
	BoardSpaces b = new BoardSpaces();
	
//	public void createBoard(BoardSpaces[][] board) {
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j < 10; j++) {
//			}
//		}
//	}

	
	// Print board with if statement in first for loop and make it branch out to different second for loops
	public void printBoard(BoardSpaces[][] board) {

		for(int i = 0; i < 11; i++){
			if(board[i] < 11 && board[i] > 0){
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
//		for(int i = 0; i < 11; i++){
//			System.out.print(board[i][0]);
//			for(int j = 0; j < 11; j++){
//				if(board[i].inde < 11 && board[i][j] > 0 ){
//					System.out.print(" ");
//				}
//				else{
//					System.out.print(board[i][j]);
//				}
//			}
//			System.out.print(board[i][11]);
//			System.out.println();
//		}

	}
	

	public int Dice() {
		int die = (int) (Math.random() * 6);
		int die2 = (int) (Math.random() * 6);
		return (die + die2);
	}
}
