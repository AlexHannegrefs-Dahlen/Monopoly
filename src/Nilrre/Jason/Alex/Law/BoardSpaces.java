package Nilrre.Jason.Alex.Law;

import java.io.IOException;

public class BoardSpaces {
	enum SpaceType {
		Property, Jail, Go, FreeParking, GoToJail, CardDraw, Tax, Utilities, Nothing
	}

	enum SpaceColor {
		Blank, Purple, Silver, Pink, Orange, Red, Yellow, Green, Blue, Railroad, Utilities
	}

	private SpaceType type;
	private String name;
	private SpaceColor color;
	private int rent;
	private int morgageValue;
	private int housePrice;
	private boolean isAvailable;
	private int boardSpaceNumber;
	private int houses;
	private int hotel;
	private int railroad;
	private Player ownedBy;
	private boolean mortgaged;
	private int landValue;

	public int getLandValue(BoardSpaces space){
		return space.landValue;
	}
	
	public void setLandValue(BoardSpaces space, int value){
		space.landValue = value;
	}
	
	public boolean getMortgaged(BoardSpaces space) {
		return space.mortgaged;
	}

	public void setMortgaged(BoardSpaces space, boolean mort) throws IOException {
		if (space.houses == 0 && space.hotel == 0) {
			if (mort && !space.mortgaged) {
				Player.setMoney(space.ownedBy, space.morgageValue);
			} else {
				Player.setMoney(space.ownedBy, space.morgageValue * 1.1);
			}
			space.mortgaged = mort;
		} else {
			System.out.println("You must sell all houses or hotel on this property before mortgaging it");
		}
	}

	public Player getOwnedBy(BoardSpaces space) {
		return space.ownedBy;
	}

	public void setOwnedBy(Player buying, BoardSpaces space) {
		space.ownedBy = buying;
	}

	public int getRailroad(BoardSpaces space) {
		return space.railroad;
	}

	public void setRailroad(BoardSpaces space, int numberOfRailroads) {
		space.railroad = numberOfRailroads;
	}

	public int getHouses(BoardSpaces space) {
		return space.houses;
	}

	public void setHouses(BoardSpaces space, int numberOfHouses) {
		space.houses = numberOfHouses;
	}

	public int getHotel(BoardSpaces space) {
		return space.hotel;
	}

	public void setHotel(BoardSpaces space, int numberOfHotels) {
		space.hotel = numberOfHotels;
	}

	public SpaceType getType(BoardSpaces space) {
		return space.type;
	}

	public String getName(BoardSpaces space) {
		return space.name;
	}

	public SpaceColor getColor() {
		return color;
	}

	public int getRent(BoardSpaces space) {
		return space.rent;
	}

	public int getMorgageValue(BoardSpaces space) {
		return space.morgageValue;
	}

	public int getHousePrice(BoardSpaces space) {
		return space.housePrice;
	}

	public boolean getIsAvailable(BoardSpaces space) {
		return space.isAvailable;
	}

	public int getBoardSpaceNumber(BoardSpaces space) {
		return space.boardSpaceNumber;

	}

	public void makeSpace(BoardSpaces space, SpaceColor color, String name, int rent, int morgage, int housePrice, int PropertyValue,
			boolean isAvail, SpaceType Type, int boardSpaceNumber) {
		space.isAvailable = isAvail;
		space.color = color;
		space.name = name;
		space.rent = rent;
		space.morgageValue = morgage;
		space.housePrice = housePrice;
		space.type = Type;
		space.boardSpaceNumber = boardSpaceNumber;
		space.landValue = PropertyValue;
	}

	public void makeSpaceBlank(BoardSpaces space) {
		space.name = "   ";
	}

	@Override
	public String toString() {
		String whatever = "   ";

		if (name != whatever) {

			whatever = " " + Integer.toString(boardSpaceNumber);
			if (boardSpaceNumber >= 1 && boardSpaceNumber <= 9) {
				whatever = "  " + Integer.toString(boardSpaceNumber);

			}

		}
		return whatever;
	}

}
