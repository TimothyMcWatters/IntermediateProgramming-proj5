/**
This program:
Uses Interfaces to calculate the carbon footprint of various objects.
Interfaces allow us to specify similar behavior for seemingly unrelated
classes. This program will use Interfaces to link building, automobile and food.

@author Timothy McWatters
@version 1.0

COP3022    Project 5
File Name: Building.java
*/

public class Building implements CarbonFootprint {
	private int bldgNumber = 0;
	private String street = "";
	private int zipCode = 0;
	private int peopleInBldg = 0;
	private int KWhUsed = 0;
	
	/**
	 * Default constructor for the Building class
	 */
	public Building() {
		setBldgNumber(0);
		setStreet("");
		setZipCode(0);
		setPeopleInBldg(0);
		setKWhUsed(0);
	} // end of default constructor
	
	/**
	 * Parameterized constructor for the Building class
	 * @param bldgNumber = house/bldg number of the bldg
	 * @param street = street the bldg is located
	 * @param zipCode = zipcode the bldg is located in
	 * @param peopleInBldg = number of people that use the building
	 * @param KWhUsed = KiloWatts used
	 */
	public Building(int bldgNumber, String street, int zipCode, int peopleInBldg, int KWhUsed) {
		setBldgNumber(bldgNumber);
		setStreet(street);
		setZipCode(zipCode);
		setPeopleInBldg(peopleInBldg);
		setKWhUsed(KWhUsed);
	} // end of parameterized constructor

	/**
	 * @return the bldgNumber = number of the building
	 */
	public int getBldgNumber() {
		return bldgNumber;
	}

	/**
	 * @param bldgNumber
	 */
	public void setBldgNumber(int bldgNumber) {
		this.bldgNumber = bldgNumber;
	}

	/**
	 * @return the street 
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the peopleInBldg
	 */
	public int getPeopleInBldg() {
		return peopleInBldg;
	}

	/**
	 * @param peopleInBldg the peopleInBldg to set
	 */
	public void setPeopleInBldg(int peopleInBldg) {
		this.peopleInBldg = peopleInBldg;
	}

	/**
	 * @return the KWhUsed
	 */
	public int getKWhUsed() {
		return KWhUsed;
	}

	/**
	 * @param KWhUsed the KWhUsed to set
	 */
	public void setKWhUsed(int KWhUsed) {
		this.KWhUsed = KWhUsed;
	}

	/**
	 * @return the zipCode
	 */
	public int getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * This method is only related to this class
	 * This method prints the address of the building
	 */
	public void printBldgAddress() {
		System.out.printf("\nThis building is located at %d %s, in the zip code of %d.\n", 
		getBldgNumber(), getStreet(), getZipCode());
		System.out.println();
	}
	
	/* 
	 * Calculates the carbon footprint for a building 
	 * @return carbon footprint = the double representation of the buildings carbon footprint
	 */
	@Override
	public double getCarbonFootprint() {
		int tonsConversion = 2205;
		double factor = 0.25;
		double footprint = ((getKWhUsed() * getPeopleInBldg()) * (factor/getKWhUsed()) * tonsConversion);
		return footprint;
	}
	
	/* 
	 * returns a nicely formatted string 
	 * @return the string representation 
	 */
	@Override
	public String toString() {
		String completeString = (String.format("The building at %d %s %d has a carbon footprint of %.2f per year.\n", 
				getBldgNumber(), getStreet(), getZipCode(), getCarbonFootprint()));
		return completeString;
	} // end of toString method
	
} // end of Building class
