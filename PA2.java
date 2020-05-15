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
		final LinkedList<PlanarShape> unsortedList = new LinkedList<PlanarShape>();			// unsorted linked list
		final LinkedList<PlanarShape> sortedList = new LinkedList<PlanarShape>();			// sorted linked list
		final Scanner file = new Scanner(new File(args[0]));								// EXECUTE: java PA2 inputfile.txt
		String newText = "";

		try {
			// scanner keeps looking for next character
			while (file.hasNext()) {
				newText = file.next();		// declare string and assign input

				// case1: scanner detects polygon
				if (newText.equals("P")) {
					final int numOfPoints = file.nextInt();							// next int is assumed to be number of points
					final PlanarShape polygonObject = new Polygon(numOfPoints);		// new polygon object with number of points
					final Point[] pointArray = new Point[numOfPoints];				//  declare point array and set number of elements as number of points

					int i = 1, j = 0;								// declare int variables and instantiate
					while (i <= numOfPoints) {
						// x and y alternates
						final double x = file.nextDouble();
						final double y = file.nextDouble();

						pointArray[j] = new Point(x, y);			// create new point element
						
						polygonObject.insertPoint(x, y);			// inserting those points
						
						// iterate after each loop
						j++;
						i++;
					}

					// inserting into linked list
					unsortedList.append(polygonObject);				// append polygon object into linked list
					sortedList.insertOrdered(polygonObject);
				}

				// case2: scanner detects circle
				else if(newText.equals("C")){
					double x = file.nextDouble();
					double y = file.nextDouble();
					double r = file.nextDouble();			// radius

					// create new circle using parameters
					PlanarShape circleObject  = new Circle(r);
					circleObject.insertPoint(x, y);

					// inserting into linked list
					unsortedList.append(circleObject);				// append circle object into linked list
					sortedList.insertOrdered(circleObject);
				}

				// case3: scanner detects semicircle
				else if(newText.equals("S")){
					// new semicircle
					PlanarShape semiCircleObject = new SemiCircle();

					// inserting points
					for(int i = 0; i < 2; i++){
						double x = file.nextDouble();
						double y = file.nextDouble();
						semiCircleObject.insertPoint(x, y);
					}

					// inserting into linked list
					unsortedList.append(semiCircleObject);				// append semicircle object into linked list
					sortedList.insertOrdered(semiCircleObject);
				}
			}
		} 
		// file reading error
		catch (final Exception e) {
			System.out.println("FILE ERROR: " + e);
		}

		file.close();		// close file (good practice)

		// print unsorted list
		System.out.println("Unsorted List:");
		System.out.println(unsortedList.toString());

		// print sorted list
		System.out.println("Sorted List:");
		System.out.println(sortedList.toString());
	}
}