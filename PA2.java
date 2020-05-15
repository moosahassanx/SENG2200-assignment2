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
		ShapeFactory shapeFactory = new ShapeFactory();										// shape factory
		String newText = "";

		try {
			// scanner keeps looking for next character
			while (file.hasNext()) {
				newText = file.next();		// declare string and assign input

				// case1: scanner detects polygon
				if (newText.equals("P")) {
					// creating line to send to shape factory
					String sendText = "P";
					final int numOfPoints = file.nextInt();							// next int is assumed to be number of points
					sendText += " ";
					sendText += numOfPoints;

					// concatenating onto sendText
					int i = 1;
					while(i <= numOfPoints){
						double x = file.nextDouble();
						sendText += " ";
						sendText += x;

						double y = file.nextDouble();
						sendText += " ";
						sendText += y;
						i++;
					}

					// sending sendText string
					PlanarShape shape = shapeFactory.getShape(sendText);
					
					// case: shape did not return properly
					if(shape != null){
						// adding onto lists
						unsortedList.append(shape);
						sortedList.insertOrdered(shape);
					}
				}

				// case2: scanner detects circle
				else if(newText.equals("C")){
					// creating line to send to shape factory
					String sendText = "C ";
					double x = file.nextDouble();
					double y = file.nextDouble();
					double r = file.nextDouble();			// radius
					
					// concatenating string
					sendText += x + " " + y + " " + r;

					// sending sendText string
					PlanarShape shape = shapeFactory.getShape(sendText);
					
					// case: shape did not return properly
					if(shape != null){
						unsortedList.append(shape);
						sortedList.insertOrdered(shape);
					}
				}

				// case3: scanner detects semicircle
				else if(newText.equals("S")){
					// creating line to send to shape factory
					String sendText = "S ";

					// concatenating string
					double x1 = file.nextDouble();
					double y1 = file.nextDouble();
					double x2 = file.nextDouble();
					double y2 = file.nextDouble();
					sendText += x1 + " " + y1 + " "+ x2 + " " + y2;

					// sending senxText string
					PlanarShape shape = shapeFactory.getShape(sendText);
					
					// case: shape did not return properly
					if(shape != null){
						unsortedList.append(shape);
						sortedList.insertOrdered(shape);
					}
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