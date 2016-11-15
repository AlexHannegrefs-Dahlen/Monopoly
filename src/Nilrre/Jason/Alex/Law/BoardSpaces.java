package Nilrre.Jason.Alex.Law;

public class BoardSpaces {
	private enum SpaceType {
		Property,
		Jail,
		Go, 
		FreeParking,
		GoToJail,
		CardDraw,
		Tax
	}
	
	
	private SpaceType type;
	private String name;
	private String color;
	private int rent;
	private int morgageValue;
	private int housePrice;
	private boolean isAvailable;
	
	public void LandOnSpace(BoardSpaces space){
		if(space.type == SpaceType.Jail){
			
		}
	}

	public String getName() {
		return name;
	}

	public String getColor() {
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

	public void setName(String newName, BoardSpaces space) {
		space.name = newName;
	}

	public void setColor(String newColor, BoardSpaces space) {
		space.color = newColor;
	}

	public void setRent(int newRent, BoardSpaces space) {
		space.rent = newRent;
	}

	public void setMorgageValue(int newMorgage, BoardSpaces space) {
		space.morgageValue = newMorgage;
	}
	
	public void setHousePrice(int newHouse, BoardSpaces space) {
		space.housePrice = newHouse;
	}
	
	public void setIsAvailable(boolean available, BoardSpaces space) {
		space.isAvailable = available;
	}


}
