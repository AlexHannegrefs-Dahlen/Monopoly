package Nilrre.Jason.Alex.Law;

public class BoardSpaces {
	enum SpaceType {
		Property,
		Jail,
		Go, 
		FreeParking,
		GoToJail,
		CardDraw,
		Tax,
		Utilities,
		Nothing
	}
	
	enum SpaceColor {
		Blank,
		Purple,
		Silver,
		Pink,
		Orange,
		Red,
		Yellow,
		Green,
		Blue,
		Railroad,
		Utilities
	}
	
	
	private SpaceType type;
	private String name;
	private SpaceColor color;
	private int rent;
	private int morgageValue;
	private int housePrice;
	private boolean isAvailable;
	private int boardSpaceNumber;
	
	public SpaceType getType(BoardSpaces space, BoardSpaces.SpaceType Type){
		return space.type;
	}

	public String getName() {
		return name;
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
	
	public int getBoardSpaceNumber(BoardSpaces space){
		return space.boardSpaceNumber;
		
	}


	
	public void makeSpace(BoardSpaces space, SpaceColor color, String name, int rent, int morgage, int housePrice, boolean isAvail, SpaceType Type, int boardSpaceNumber){
		space.isAvailable = isAvail;
		space.color = color;
		space.name = name;
		space.rent = rent;
		space.morgageValue = morgage;
		space.housePrice = housePrice;
		space.type = Type;
		space.boardSpaceNumber = boardSpaceNumber;
	}
	
	public void makeSpaceBlank(BoardSpaces space, SpaceType Type){
		space.type = Type;
	}

}
