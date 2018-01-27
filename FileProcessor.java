
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
This program:
Uses Interfaces to calculate the carbon footprint of various objects.
Interfaces allow us to specify similar behavior for seemingly unrelated
classes. This program will use Interfaces to link building, automobile and food.

@author Timothy McWatters
@version 1.0

COP3022    Project 5
File Name: FileProcessor.java
*/

public class FileProcessor {
	//constant
	public static final int ARRAY_SIZE = 9;
	
	private String fileName = "";
	private Scanner fileIn = null; // default empty
	static CarbonFootprint[] carbonFootprintObjects = null;
	
	/**
	 *  constructor for the FileProcessor class
	 */
	public FileProcessor(String fileName) {
		setFileName(fileName);
		carbonFootprintObjects = new CarbonFootprint[ARRAY_SIZE];
	} // end of FileProcessor constructor
	
	/**
	 * returns the name of the file to process
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	} // end of getfileName method

	/**
	 * sets the name of the file to process 
	 * @param fileName = the name of the file to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	} // end of setfileName method

	/**
	 * attempts to open the file to process, and throws an exception if it can't
	 */
	public void openFile() {
		try {
			// Attempt to open the file
			fileIn = new Scanner(new FileInputStream(getFileName()));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
			System.exit(0);
		}
	} // end of openFile method
	
	/**
	 * processes the file (reads in the file, processes in the information to create 
	 * Building, Food and Auto objects stored in the file) 
	 */
	public void processFile() {
		String trash = "";
		String theLine = "";
		String[] theTokens = null;
		
		// Auto
		String make = "";
		String model = "";
		int year = 0;
		int milesDrove = 0;
		
		// Building
		int bldgNumber = 0;
		String street = "";
		int zipCode = 0;
		int peopleInBldg = 0;
		int KWhUsed = 0;
		
		// Food
		String name = "";
		String foodGroup = "";
		int calories = 0;
		
		trash = fileIn.nextLine();
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		bldgNumber = Integer.parseInt(theTokens[0]);
		street = theTokens[1];
		zipCode = Integer.parseInt(theTokens[2]);
		peopleInBldg = Integer.parseInt(theTokens[3]);
		KWhUsed = Integer.parseInt(theTokens[4]);
		carbonFootprintObjects[0] = new Building(bldgNumber, street, zipCode, peopleInBldg, KWhUsed);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		bldgNumber = Integer.parseInt(theTokens[0]);
		street = theTokens[1];
		zipCode = Integer.parseInt(theTokens[2]);
		peopleInBldg = Integer.parseInt(theTokens[3]);
		KWhUsed = Integer.parseInt(theTokens[4]);
		carbonFootprintObjects[1] = new Building(bldgNumber, street, zipCode, peopleInBldg, KWhUsed);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		bldgNumber = Integer.parseInt(theTokens[0]);
		street = theTokens[1];
		zipCode = Integer.parseInt(theTokens[2]);
		peopleInBldg = Integer.parseInt(theTokens[3]);
		KWhUsed = Integer.parseInt(theTokens[4]);
		carbonFootprintObjects[2] = new Building(bldgNumber, street, zipCode, peopleInBldg, KWhUsed);
	
		trash = fileIn.nextLine();
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		make = theTokens[0]; 
		model = theTokens[1]; 
		year = Integer.parseInt(theTokens[2]);
		milesDrove = Integer.parseInt(theTokens[3]);
		carbonFootprintObjects[3] = new Auto(make, model, year, milesDrove);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		make = theTokens[0]; 
		model = theTokens[1]; 
		year = Integer.parseInt(theTokens[2]);
		milesDrove = Integer.parseInt(theTokens[3]);
		carbonFootprintObjects[4] = new Auto(make, model, year, milesDrove);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		make = theTokens[0]; 
		model = theTokens[1]; 
		year = Integer.parseInt(theTokens[2]);
		milesDrove = Integer.parseInt(theTokens[3]);
		carbonFootprintObjects[5] = new Auto(make, model, year, milesDrove);
	
		trash = fileIn.nextLine();
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		name = theTokens[0]; 
		foodGroup = theTokens[1]; 
		calories = Integer.parseInt(theTokens[2]);
		carbonFootprintObjects[6] = new Food(name, foodGroup, calories);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		name = theTokens[0]; 
		foodGroup = theTokens[1]; 
		calories = Integer.parseInt(theTokens[2]);
		carbonFootprintObjects[7] = new Food(name, foodGroup, calories);
	
		theLine = fileIn.nextLine();
		theTokens = theLine.split(",");
		name = theTokens[0]; 
		foodGroup = theTokens[1]; 
		calories = Integer.parseInt(theTokens[2]);
		carbonFootprintObjects[8] = new Food(name, foodGroup, calories);
	} // end of processFile method

	/**
	 * Returns the object located at the index number passed in as a parameter
	 * @param int = the index number of the object to return 
	 * @return CarbonFootprint = the CarbonFootprint object in carbonFootprintObjects array at index passed in
	 */
	public CarbonFootprint getCarbonFootprintObject(int i) {
		return carbonFootprintObjects[i];
	} // end of getCarbonFootprintObject method
	
} // end of FileProcessor class
