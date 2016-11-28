package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class LandValue {

	public static void buyPurpleProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[10][9].getOwnedBy(Board.board[10][9]) && Game.getPlayerWhosTurnItIs() == Board.board[10][7].getOwnedBy(Board.board[10][7])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*50);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[10][9].setHouses(Board.board[10][9], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[10][7].setHouses(Board.board[10][7], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[10][9].getHouses(Board.board[10][9]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*50);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[10][9].setHotel(Board.board[10][9], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[10][7].setHotel(Board.board[10][7], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}
	
	public static void buySilverProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[10][4].getOwnedBy(Board.board[10][4]) && Game.getPlayerWhosTurnItIs() == Board.board[10][2].getOwnedBy(Board.board[10][1]) && Game.getPlayerWhosTurnItIs() == Board.board[10][1].getOwnedBy(Board.board[10][1])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*50);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[10][4].setHouses(Board.board[10][4], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[10][2].setHouses(Board.board[10][2], 1);
						house--;
						spaceSelected = 3;
					} else if (spaceSelected == 3){
						Board.board[10][1].setHouses(Board.board[10][1], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[10][9].getHouses(Board.board[10][9]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*50);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[10][4].setHotel(Board.board[10][4], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[10][2].setHotel(Board.board[10][2], 1);
						hotel--;
						spaceSelected = 3;
					}else if (spaceSelected == 3){
						Board.board[10][1].setHotel(Board.board[10][1], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}

	public static void buyPinkProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[9][0].getOwnedBy(Board.board[9][0]) && Game.getPlayerWhosTurnItIs() == Board.board[7][0].getOwnedBy(Board.board[7][0]) && Game.getPlayerWhosTurnItIs() == Board.board[6][0].getOwnedBy(Board.board[6][0])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*100);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[9][0].setHouses(Board.board[9][0], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[7][0].setHouses(Board.board[7][0], 1);
						house--;
						spaceSelected = 3;
					} else if (spaceSelected == 3){
						Board.board[6][0].setHouses(Board.board[6][0], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[9][0].getHouses(Board.board[9][0]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*100);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[9][0].setHotel(Board.board[9][0], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[7][0].setHotel(Board.board[7][0], 1);
						hotel--;
						spaceSelected = 3;
					}else if (spaceSelected == 3){
						Board.board[6][0].setHotel(Board.board[6][0], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}

	public static void buyOrangeProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[4][0].getOwnedBy(Board.board[4][0]) && Game.getPlayerWhosTurnItIs() == Board.board[2][0].getOwnedBy(Board.board[2][0]) && Game.getPlayerWhosTurnItIs() == Board.board[1][0].getOwnedBy(Board.board[1][0])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*100);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[4][0].setHouses(Board.board[4][0], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[2][0].setHouses(Board.board[2][0], 1);
						house--;
						spaceSelected = 3;
					} else if (spaceSelected == 3){
						Board.board[1][0].setHouses(Board.board[1][0], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[4][0].getHouses(Board.board[4][0]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*100);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[4][0].setHotel(Board.board[4][0], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[2][0].setHotel(Board.board[2][0], 1);
						hotel--;
						spaceSelected = 3;
					}else if (spaceSelected == 3){
						Board.board[1][0].setHotel(Board.board[1][0], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}

	public static void buyRedProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[0][1].getOwnedBy(Board.board[0][1]) && Game.getPlayerWhosTurnItIs() == Board.board[0][4].getOwnedBy(Board.board[0][4]) && Game.getPlayerWhosTurnItIs() == Board.board[0][3].getOwnedBy(Board.board[0][3])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*150);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[0][1].setHouses(Board.board[0][1], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[0][3].setHouses(Board.board[0][3], 1);
						house--;
						spaceSelected = 3;
					} else if (spaceSelected == 3){
						Board.board[0][4].setHouses(Board.board[0][4], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[0][1].getHouses(Board.board[0][1]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*150);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[0][1].setHotel(Board.board[0][1], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[0][3].setHotel(Board.board[0][3], 1);
						hotel--;
						spaceSelected = 3;
					}else if (spaceSelected == 3){
						Board.board[0][4].setHotel(Board.board[0][4], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}

	public static void buyYellowProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[0][6].getOwnedBy(Board.board[0][6]) && Game.getPlayerWhosTurnItIs() == Board.board[0][7].getOwnedBy(Board.board[0][7]) && Game.getPlayerWhosTurnItIs() == Board.board[0][9].getOwnedBy(Board.board[0][9])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*150);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[0][6].setHouses(Board.board[0][6], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[0][7].setHouses(Board.board[0][7], 1);
						house--;
						spaceSelected = 3;
					} else if (spaceSelected == 3){
						Board.board[0][9].setHouses(Board.board[0][9], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[0][6].getHouses(Board.board[0][6]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*150);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[0][6].setHotel(Board.board[0][6], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[0][7].setHotel(Board.board[0][7], 1);
						hotel--;
						spaceSelected = 3;
					}else if (spaceSelected == 3){
						Board.board[0][9].setHotel(Board.board[0][9], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}

	public static void buyGreenProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[1][10].getOwnedBy(Board.board[1][10]) && Game.getPlayerWhosTurnItIs() == Board.board[2][10].getOwnedBy(Board.board[2][10]) && Game.getPlayerWhosTurnItIs() == Board.board[4][10].getOwnedBy(Board.board[4][10])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*200);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[1][10].setHouses(Board.board[1][10], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[2][10].setHouses(Board.board[2][10], 1);
						house--;
						spaceSelected = 3;
					} else if (spaceSelected == 3){
						Board.board[4][10].setHouses(Board.board[4][10], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[1][10].getHouses(Board.board[1][10]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*200);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[1][10].setHotel(Board.board[1][10], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[2][10].setHotel(Board.board[2][10], 1);
						hotel--;
						spaceSelected = 3;
					}else if (spaceSelected == 3){
						Board.board[4][10].setHotel(Board.board[4][10], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}

	public static void buyBlueProperty() throws IOException{
		if(Game.getPlayerWhosTurnItIs() == Board.board[7][10].getOwnedBy(Board.board[7][10]) && Game.getPlayerWhosTurnItIs() == Board.board[9][10].getOwnedBy(Board.board[9][10])){
			String[] options = new String[2];
			options[0] = "Houses";
			options[1] = "Hotels";
			int choice = ConsoleUI.promptForMenuSelection(options, true);
			
			if(choice == 1){
				int house = ConsoleUI.promptForInt("How many Houses would you like?", 1, 8);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -house*200);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[7][10].setHouses(Board.board[7][10], 1);
						house--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[9][10].setHouses(Board.board[9][10], 1);
						house--;
						spaceSelected = 1;
					}
				}while(house > 0);
			}
			else if(choice == 2){
				if(Board.board[7][10].getHouses(Board.board[7][10]) >= 4){
				int hotel = ConsoleUI.promptForInt("How many Hotels would you like?", 1, 2);
				Player.setMoney(Game.getPlayerWhosTurnItIs(), -hotel*200);
				// find a way to switch between lands
				int spaceSelected = 1;
				do{
					if(spaceSelected == 1){
						Board.board[7][10].setHotel(Board.board[7][10], 1);
						hotel--;
						spaceSelected = 2;
					} else if (spaceSelected == 2){
						Board.board[9][10].setHotel(Board.board[9][10], 1);
						hotel--;
						spaceSelected = 1;
					}
				}while(hotel > 0);
				}
			}
		}
	}

}
