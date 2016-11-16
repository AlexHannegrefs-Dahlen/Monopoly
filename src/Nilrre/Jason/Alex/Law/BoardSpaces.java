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
	
	
//	public void setType(BoardSpaces space, BoardSpaces.SpaceType Type){
//		space.type = Type;
//	}
//	
//	public SpaceType getType(BoardSpaces space, BoardSpaces.SpaceType Type){
//		return space.type;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public SpaceColor getColor() {
//		return color;
//	}
//
//	public int getRent(BoardSpaces space) {
//		return space.rent;
//	}
//
//	public int getMorgageValue(BoardSpaces space) {
//		return space.morgageValue;
//	}
//
//	public int getHousePrice(BoardSpaces space) {
//		return space.housePrice;
//	}
//
//	public boolean getIsAvailable(BoardSpaces space) {
//		return space.isAvailable;
//	}
//
//	public void setName(String newName, BoardSpaces space) {
//		space.name = newName;
//	}
//
//	public void setColor(SpaceColor newColor, BoardSpaces space) {
//		space.color = newColor;
//	}
//
//	public void setRent(int newRent, BoardSpaces space) {
//		space.rent = newRent;
//	}
//
//	public void setMorgageValue(int newMorgage, BoardSpaces space) {
//		space.morgageValue = newMorgage;
//	}
//	
//	public void setHousePrice(int newHouse, BoardSpaces space) {
//		space.housePrice = newHouse;
//	}
//	
//	public void setIsAvailable(boolean available, BoardSpaces space) {
//		space.isAvailable = available;
//	}
	
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
