import java.util.Date;

/**
This program:
Uses Interfaces to calculate the carbon footprint of various objects.
Interfaces allow us to specify similar behavior for seemingly unrelated
classes. This program will use Interfaces to link building, automobile and food.

@author Timothy McWatters
@version 1.0

COP3022    Project 5
File Name: CarbonFootprintTester.java
*/

public class CarbonFootprintTester {

	public static void main(String[] args) {
		String fileName = "Project 5 input data.txt";
		FileProcessor file = new FileProcessor(fileName);
		file.openFile();
		file.processFile();
		
		// Tests the Building class' unique method: printBldgAddress()
		Building bldg1 = (Building) file.getCarbonFootprintObject(0);
		bldg1.printBldgAddress();
		// Tests the Auto class' unique method: isAntique()
		Auto auto1 = (Auto) file.getCarbonFootprintObject(3);
		System.out.println(auto1.isAntique());
		System.out.println();
		// Tests the Food class' unique method:numberOfServings()
		Food food1 = (Food) file.getCarbonFootprintObject(6);
		System.out.println(food1.calculateNumberOfServings());
		System.out.println();
		
		// Polymorphic iteration of array that produces the required output
		for (int i = 0; i < FileProcessor.ARRAY_SIZE; i++) {
			System.out.println(file.getCarbonFootprintObject(i).toString());
		}
		
		
		
	} // end of main method
} // end of CarbonFootprintTester class
