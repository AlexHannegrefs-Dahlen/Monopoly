package Nilrre.Jason.Alex.Law;

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

	public boolean getMortgaged(BoardSpaces space) {
		return space.mortgaged;
	}

	public void setMortgaged(BoardSpaces space, boolean mort) {
		space.mortgaged = mort;
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

	public void makeSpace(BoardSpaces space, SpaceColor color, String name, int rent, int morgage, int housePrice,
			boolean isAvail, SpaceType Type, int boardSpaceNumber) {
		space.isAvailable = isAvail;
		space.color = color;
		space.name = name;
		space.rent = rent;
		space.morgageValue = morgage;
		space.housePrice = housePrice;
		space.type = Type;
		space.boardSpaceNumber = boardSpaceNumber;
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
