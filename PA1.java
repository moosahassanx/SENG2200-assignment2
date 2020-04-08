// TITLE: 					Assignment1
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					22/03/2020 
// DESCRIPTION: 			main file used for text scanning and final display

// importing java libraries (file scanner and string output)
import java.io.*;
import java.util.Scanner;

class PA1{
	public static void main(final String[] args) throws IOException {
		// create new linked list which will be unsorted
		final MyPolygons unsortedList = new MyPolygons();

		// create file scanner
		final Scanner file = new Scanner(new File(args[0]));
		// declare and instantiate string to store scanner inputs
		String newText = "";

		try {
			// loop as long as scanner can read another character
			while (file.hasNext()) {
				// declare string and assign input
				newText = file.next();

				if (newText.equals("P")) { // scanner reads "P"
					// declare int after P as number of points
					final int numOfPoints = file.nextInt();

					// declare new polygon object and set paranthesis with number of points
					final Polygon polygonObject = new Polygon(numOfPoints);

					// declare point array and set number of elements as number of points
					final Point[] pointArray = new Point[numOfPoints];

					// declare int variables and instantiate
					int i = 1, j = 0;
					while (i <= numOfPoints) {
						// declare x and y doubles and instantiate based on file input
						final double x = file.nextDouble();
						final double y = file.nextDouble();

						// declare point array and create new point
						pointArray[j] = new Point(x, y);
						// insert point into polygon object
						polygonObject.insertPoint(x, y);
						// iterate after each loop
						j++;
						i++;
					}

					// append polygon object into linked list
					unsortedList.append(polygonObject);
				}
			}
		} catch (final Exception e) {
			System.out.println("Error with reading files");
		}

		// close file after reading all characters
		file.close();

		// print unsorted list
		System.out.println("Unsorted List:");
		System.out.println(unsortedList.toString());

		// create new MyPolgyons and set it as unsortedList but after insertSorted() method
		final MyPolygons sortedList = unsortedList.insertSort();
		
		// print sorted list
		System.out.println(sortedList.toString());
	}
}