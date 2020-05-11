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
		final MyPolygons unsortedList = new MyPolygons();			// unsorted linked list
		final Scanner file = new Scanner(new File(args[0]));		// EXECUTE: java PA2 inputfile.txt
		String newText = "";

		try {
			// scanner keeps looking for next character
			while (file.hasNext()) {
				newText = file.next();							// declare string and assign input

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
					
					System.out.println(polygonObject.toString());
					unsortedList.append(polygonObject);				// append polygon object into linked list
				}

				// case2: scanner detects circle
				else if(newText.equals("C")){
					double x = file.nextDouble();
					double y = file.nextDouble();
					double r = file.nextDouble();			// radius

					// create new circle using parameters
					PlanarShape circleObject  = new Circle(r);
					circleObject.insertPoint(x, y);

					// for testing
					System.out.println(circleObject.toString());
				}

				// case3: scanner detects semicircle
				else if(newText.equals("S")){
					// new semicircle
					PlanarShape semiCircleObject = new SemiCircle();
					final Point[] pointArray = new Point[2];

					// inserting points
					for(int i = 0; i < 2; i++){
						double x = file.nextDouble();
						double y = file.nextDouble();
						pointArray[i] = new Point(x, y);
						semiCircleObject.insertPoint(x, y);
					}

					// for testing
					System.out.println(semiCircleObject.toString());
				}
			}
		} catch (final Exception e) {
			System.out.println("FILE ERROR: " + e);
		}

		file.close();		// close file (good practice)

		// print unsorted list
		System.out.println("Unsorted List:");
		System.out.println(unsortedList.toString());

		// print sorted list
		//final MyPolygons sortedList = unsortedList.insertSort();
		//System.out.println(sortedList.toString());
	}
}

/* INPUT
P 5 4.0 0 4 8.1 7.2 8 7 3 9 0
C 5.1 4.0 3.2
S 4 3 5.0 4.0
*/

/* OUTPUT
Unsorted list
SEMI=[(4.00 , 3.00)(5.00 , 4.00)]: 39.27
CIRC=[(5.10 , 4.00)) 3.20]: 32.17
POLY=[(4.00 , 0.00)(4.00 , 8.10)(7.20 , 8.00)(7.00 , 3.00)(9.00 , 0.00)]: 27.66
Sorted list
POLY=[(4.00 , 0.00)(4.00 , 8.10)(7.20 , 8.00)(7.00 , 3.00)(9.00 , 0.00)]: 27.66
CIRC=[(5.10 , 4.00)) 3.20]: 32.17
SEMI=[(4.00 , 3.00)(5.00 , 4.00)]: 39.27
*/