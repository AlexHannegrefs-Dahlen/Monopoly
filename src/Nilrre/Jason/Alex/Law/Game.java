package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class Game {

	public static void RunGame() throws IOException {
		int amountOfPlayers = ConsoleUI.promptForInt("How many players?", 2, 8);
		for(int i = 1; i <= amountOfPlayers; i++){
			makePlayer(i);
		}
	}
	public static void makePlayer(int playerNumber) throws IOException{
		System.out.println("Player " + playerNumber);
		
		Player one = new Player();
		Player.setPiece(one);
		
	}
	
}
