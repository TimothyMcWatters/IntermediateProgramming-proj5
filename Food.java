
/**
This program:
Uses Interfaces to calculate the carbon footprint of various objects.
Interfaces allow us to specify similar behavior for seemingly unrelated
classes. This program will use Interfaces to link building, automobile and food.

@author Timothy McWatters
@version 1.0

COP3022    Project 5
File Name: Food.java
*/

public class Food implements CarbonFootprint {
	private String name = "";
	private String foodGroup = "";
	private int calories = 0;
	
	
	/**
	 * Default constructor for the Food class
	 */
	public Food() {
		setName("");
		setFoodGroup("");
		setCalories(0);
	} // end of default constructor
	
	/**
	 * Parameterized constructor for the Food class
	 * @param name = name of the Food 
	 * @param foodGroup = one of the 6 food groups (fruit, vegetables, grain, protein, oils, dairy)
	 * @param calories = The number of calories the food is
	 */
	public Food(String name, String foodGroup, int calories) {
		setName(name);
		setFoodGroup(foodGroup);
		setCalories(calories);
	} // end of parameterized constructor

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the foodGroup
	 */
	public String getFoodGroup() {
		return foodGroup;
	}

	/**
	 * @param foodGroup the foodGroup to set
	 */
	public void setFoodGroup(String foodGroup) {
		this.foodGroup = foodGroup;
	}

	/**
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}

	/**
	 * @param calories the calories to set
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}

	/* 
	 * This method is only related to this class
	 * Calculates the number of servings the food object is based off of a 100 calorie per serving formula
	 * @return int = number of servings
	 */
	public int calculateNumberOfServings() {
		return ((int) (getCalories() / 100)); 
	}	
	
	/* 
	 * Calculates the carbon footprint for a Food object 
	 * @return carbon footprint = the double representation of the Food objects carbon footprint
	 */
	@Override
	public double getCarbonFootprint() {
		int tonsConversion = 2205;
		double daysPerYear = 365;
		double factor = 0.0;
		
		if (getFoodGroup().equalsIgnoreCase("dairy")) {
			factor = .00003;
		} else if (getFoodGroup().equalsIgnoreCase("protein")) {
			factor = .00005;
		} else if (getFoodGroup().equalsIgnoreCase("fruit")) {
			factor = .00001;
		} else if (getFoodGroup().equalsIgnoreCase("vegetables")) {
			factor = .00001;
		} else if (getFoodGroup().equalsIgnoreCase("oils")) {
			factor = .00003;
		} else if (getFoodGroup().equalsIgnoreCase("grains")) {
			factor = .00002;
		} else {
			factor = .00003;
		}
		double footprint = (getCalories() * daysPerYear * factor * tonsConversion);
		return footprint;
	}

	/* 
	 * returns a nicely formatted string 
	 * @return the string representation 
	 */
	@Override
	public String toString() {
		String completeString = (String.format("A(n) %s has a carbon footprint of %.2f per year.\n", 
				getName(), getCarbonFootprint()));
		return completeString;
	} // end of toString method
	
	
} // end of Food class
