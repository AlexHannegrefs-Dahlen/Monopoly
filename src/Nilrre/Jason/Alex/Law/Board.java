package Nilrre.Jason.Alex.Law;

import Nilrre.Jason.Alex.Law.BoardSpaces.SpaceColor;
import Nilrre.Jason.Alex.Law.BoardSpaces.SpaceType;

public class Board {

	public BoardSpaces[][] board = new BoardSpaces[11][11];
	BoardSpaces b = new BoardSpaces();
	
	public void createBoard() {
				
				//Bottom row
				b.makeSpace(board[10][10], SpaceColor.Blank, "GO", 0, 0, 0, false, SpaceType.Go);
				b.makeSpace(board[10][9], SpaceColor.Purple, "Mediteranian Avenue", 2, 30, 50, true, SpaceType.Property);
				b.makeSpace(board[10][8], SpaceColor.Blank, "Community Chest", 0, 0, 0, false, SpaceType.CardDraw);
				b.makeSpace(board[10][7], SpaceColor.Purple, "Baltic Avenue", 4, 30, 50, true, SpaceType.Property);
				b.makeSpace(board[10][6], SpaceColor.Blank, "Income Tax", 0, 0, 0, false, SpaceType.Tax);
				b.makeSpace(board[10][5], SpaceColor.Railroad, "Reading Railroad", 25, 100, 0, true, SpaceType.Property);
				b.makeSpace(board[10][4], SpaceColor.Silver, "Oriental Avenue", 6, 50, 50, true, SpaceType.Property);
				b.makeSpace(board[10][3], SpaceColor.Blank, "Chance", 0, 0, 0, true, SpaceType.CardDraw);
				b.makeSpace(board[10][2], SpaceColor.Silver, "Vermont Avene", 6, 50, 50, true, SpaceType.Property);
				b.makeSpace(board[10][1], SpaceColor.Silver, "Connecticut Avenue", 8, 60, 50, true, SpaceType.Property);
				
				//Left Column
				b.makeSpace(board[10][0], SpaceColor.Blank, "Jail", 0, 0, 0, false, SpaceType.Jail);				
				b.makeSpace(board[9][0], SpaceColor.Pink, "St. Charles Place", 10, 70, 100, true, SpaceType.Property);
				// Look up electric company rules
				b.makeSpace(board[8][0], SpaceColor.Utilities, "Electric Company", 0, 0, 0, true, SpaceType.Utilities);
				b.makeSpace(board[7][0], SpaceColor.Pink, "States Avenue", 10, 70, 100, true, SpaceType.Property);
				b.makeSpace(board[6][0], SpaceColor.Pink, "Virgina Avenue", 12, 80, 100, true, SpaceType.Property);
				b.makeSpace(board[5][0], SpaceColor.Railroad, "Pennsylvania RailRoad", 25, 100, 0, true, SpaceType.Property);
				b.makeSpace(board[4][0], SpaceColor.Orange, "St James Place", 14, 90, 100, true, SpaceType.Property);
				b.makeSpace(board[3][0], SpaceColor.Blank, "Community Chest", 0, 0, 0, false, SpaceType.CardDraw);
				b.makeSpace(board[2][0], SpaceColor.Orange, "Tennessee Avenue", 14, 90, 100, true, SpaceType.Property);
				b.makeSpace(board[1][0], SpaceColor.Orange, "New York Avenue", 16, 100, 100, true, SpaceType.Property);
				b.makeSpace(board[0][0], SpaceColor.Blank, "Free Parking", 0, 0, 0, false, SpaceType.FreeParking);
				
				//Top Row
				b.makeSpace(board[0][1], SpaceColor.Red, "Kentucky Avenue", 18, 110, 150, true, SpaceType.Property);
				b.makeSpace(board[0][2], SpaceColor.Blank, "Chance", 0, 0, 0, false, SpaceType.CardDraw);
				b.makeSpace(board[0][3], SpaceColor.Red, "Indiana Avenue", 18, 110, 150, true, SpaceType.Property);
				b.makeSpace(board[0][4], SpaceColor.Red, "Illinois Avenue", 20, 120, 150, true, SpaceType.Property);
				b.makeSpace(board[0][5], SpaceColor.Railroad, "B & O RailRoad", 25, 100, 0, true, SpaceType.Property);
				b.makeSpace(board[0][6], SpaceColor.Yellow, "Atlantic Avenue", 22, 130, 150, true, SpaceType.Property);
				b.makeSpace(board[0][7], SpaceColor.Yellow, "Ventnor Avenue", 22, 130, 150, true, SpaceType.Property);
				b.makeSpace(board[0][8], SpaceColor.Utilities, "Water Works", 0, 0, 0, true, SpaceType.Utilities);
				b.makeSpace(board[0][9], SpaceColor.Yellow, "Marvin Gardens", 24, 140, 150, true, SpaceType.Property);
				b.makeSpace(board[0][10], SpaceColor.Blank, "Go To Jail", 0, 0, 0, false, SpaceType.Jail);
				
				// Right Column
				b.makeSpace(board[1][10], SpaceColor.Green, "Pacific Avenue", 26, 150, 200, true, SpaceType.Property);
				b.makeSpace(board[2][10], SpaceColor.Green, "North Carolina Avenue", 26, 150, 200, true, SpaceType.Property);
				b.makeSpace(board[3][10], SpaceColor.Blank, "Community Chest", 0, 0, 0, false, SpaceType.CardDraw);
				b.makeSpace(board[4][10], SpaceColor.Green, "Pennsylvania Avenue", 28, 160, 200, true, SpaceType.Property);
				b.makeSpace(board[5][10], SpaceColor.Railroad, "Short Line", 25, 100, 0, true, SpaceType.Property);
				b.makeSpace(board[6][10], SpaceColor.Blank, "Chance", 0, 0, 0, false, SpaceType.CardDraw);
				b.makeSpace(board[7][10], SpaceColor.Blue, "Park Place", 35, 175, 200, true, SpaceType.Property);
				b.makeSpace(board[8][10], SpaceColor.Blank, "Luxury Tax", 0, 0, 0, false, SpaceType.Tax);
				b.makeSpace(board[9][10], SpaceColor.Blue, "Boardwalk", 50, 200, 200, true, SpaceType.Property);
			
				//Center of the board
				for(int i = 1; i < 10; i++){
					for(int j = 1; j < 10; i++){
						b.makeSpaceBlank(board[i][j], SpaceType.Nothing);
					}
				}
				
	}
	
	public void printBoard(BoardSpaces[][] board){
		
		for(int i = 0; i < 11; i++){
			for(int j = 0; j < 11; j++){
				System.out.println(board[i][j]);
			}
		}
	}
	
	
	
	public int Dice() {
		int die = (int) (Math.random() * 6);
		int die2 = (int) (Math.random() * 6);
		return (die + die2);
	}
}
