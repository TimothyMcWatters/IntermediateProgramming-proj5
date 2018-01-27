/**
This program:
Uses Interfaces to calculate the carbon footprint of various objects.
Interfaces allow us to specify similar behavior for seemingly unrelated
classes. This program will use Interfaces to link building, automobile and food.

@author Timothy McWatters
@version 1.0

COP3022    Project 5
File Name: CarbonFootprint.java
*/

public interface CarbonFootprint {

	/**
	 *  used to return the carbon footprint of an object
	 *  @return carbonFootprint = double representation of the objects carbon footprint
	 */
	public double getCarbonFootprint();
} // end of CarbonFootprint interface
