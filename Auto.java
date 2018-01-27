import java.util.Date;

/**
This program:
Uses Interfaces to calculate the carbon footprint of various objects.
Interfaces allow us to specify similar behavior for seemingly unrelated
classes. This program will use Interfaces to link building, automobile and food.

@author Timothy McWatters
@version 1.0

COP3022    Project 5
File Name: Auto.java
*/

public class Auto implements CarbonFootprint {
	private String make = "";
	private String model = "";
	private int year = 0;
	private int milesDrove = 0;
	/**
	 * Default constructor for the Auto class
	 */
	public Auto() {
		setMake("");
		setModel("");
		setYear(0);
		setMilesDrove(0);
	} // end of default constructor
	
	/**
	 * Parameterized constructor for the Auto class
	 * @param make = The make of the Automobile 
	 * @param model = The model of the Automobile 
	 * @param year = The year of the Automobile 
	 * @param milesDrove = miles drove this year
	 */
	public Auto(String make, String model, int year, int milesDrove) {
		setMake(make);
		setModel(model);
		setYear(year);
		setMilesDrove(milesDrove);
	} // end of parameterized constructor
	
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return the milesDrove
	 */
	public int getMilesDrove() {
		return milesDrove;
	}

	/**
	 * @param milesDrove the milesDrove to set
	 */
	public void setMilesDrove(int milesDrove) {
		this.milesDrove = milesDrove;
	}

	/* 
	 * Calculates if the Auto is an antique  (25 years old)
	 * @return boolean = the boolean representation if antique is true, if not its false
	 */
	public boolean isAntique() {
		Date date = new Date();
		int currentYear = 1900 + date.getYear();
		if ((currentYear - getYear()) >= 25) {
			return true;
		} else {
			return false;
		}
	}
	
	/* 
	 * Calculates the carbon footprint for an Auto object 
	 * @return carbon footprint = the double representation of the Auto objects carbon footprint
	 */
	@Override
	public double getCarbonFootprint() {
		int tonsConversion = 2205;
		double efficiency = 0.002; // average from web-site
		double footprint = ((getMilesDrove() * efficiency) * tonsConversion);
		return footprint;
	}

	/* 
	 * returns a nicely formatted string 
	 * @return the string representation 
	 */
	@Override
	public String toString() {
		String completeString = (String.format("A %d %s %s has a carbon footprint of %.2f per year.\n", 
				getYear(), getMake(), getModel(), getCarbonFootprint()));
		return completeString;
	} // end of toString method
	
} // end of Auto class
