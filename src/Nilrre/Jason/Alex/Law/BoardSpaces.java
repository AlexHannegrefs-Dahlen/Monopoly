package Nilrre.Jason.Alex.Law;

public class BoardSpaces {

	private static BoardSpaces BoardSpaces;
	private String name;
	private String color;
	private int rent;
	private int morgageValue;
	private int[] housePrice;
	private boolean isAvailable;

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getRent() {
		return rent;
	}

	public int getMorgageValue() {
		return morgageValue;
	}

	public int[] getHousePrice() {
		return housePrice;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setColor(String newColor) {
		color = newColor;
	}

	public void setRent(int newRent) {
		rent = newRent;
	}

	public void setMorgageValue(int newMorgage) {
		morgageValue = newMorgage;
	}
	
	public void setHousePrice(int[] newHouse) {
		housePrice = newHouse;
	}
	
	public void setIsAvailable(boolean available) {
		isAvailable = available;
	}

	public BoardSpaces getboardSpace(){
		getColor();
		getName();
		getIsAvailable();
		getRent();
		getHousePrice();
		getMorgageValue();
		return BoardSpaces;
	}
	
	
	public BoardSpaces setboardSpace(String color, String Name, boolean isAvailable, int rent, int morgageValue){
		setColor(color);
		setName(name);
		setIsAvailable(isAvailable);
		setRent(rent);
		setHousePrice(housePrice);
		setMorgageValue(morgageValue);
		return BoardSpaces;
	}
}
