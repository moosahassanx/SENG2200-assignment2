// TITLE: 					Assignment2
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					15/05/2020 
// DESCRIPTION: 			main file used for text scanning and final display

// importing java libraries (file scanner and string output)
import java.io.*;
import java.util.Scanner;

class PA2{
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
				else if(newText.equals("C")){

					double x = file.nextDouble();
					double y = file.nextDouble();
					double r = file.nextDouble();

					Circle circleObject  = new Circle(r);

					circleObject.insertPoint(x, y);

					// for testing
					System.out.println(circleObject.toString());
				}
				else if(newText.equals("S")){
					
					SemiCircle semiCircleObject = new SemiCircle();

					final Point[] pointArray = new Point[2];

					for(int i = 0; i < 2; i++){
						double x = file.nextDouble();
						double y = file.nextDouble();
						pointArray[i] = new Point(x, y);
						semiCircleObject.insertPoint(x, y);
					}

					System.out.println(semiCircleObject.toString());
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

/* CODE NEEDS TO READ
P 5 4.0 0 4 8.1 7.2 8 7 3 9 0
C 5.1 4.0 3.2
S 4 3 8.0 6.0
*/


/*
Unsorted list
POLY=[(4.00 , 0.00)(4.00 , 8.10)(7.20 , 8.00)(7.00 , 3.00)(9.00 , 0.00)]: 27.66
CIRC=[(5.10 , 4.00)) 3.20]: 5.62
SEMI=[(4.00 , 3.00)(5.00 , 4.00)]: 3.51
Sorted list
SEMI=[(4.00 , 3.00)(5.00 , 4.00)]: 3.51
CIRC=[(5.10 , 4.00)) 3.20]: 5.62
POLY=[(4.00 , 0.00)(4.00 , 8.10)(7.20 , 8.00)(7.00 , 3.00)(9.00 , 0.00)]: 27.66
*/