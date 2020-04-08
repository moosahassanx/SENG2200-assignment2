// TITLE: 					Assignment1
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					22/03/2020 
// DESCRIPTION: 			creating points and distance from origin to draw a polygon

import java.lang.Math;

public class Point{
	// declaring coordinates and distance doubles
	private final double xCoord, yCoord;
	private double distance;

	// constructor
	public Point(final double x, final double y) {
		// setting x and y coordinates
		xCoord = x;
		yCoord = y;
		// initiating distance variable
		distance = 0.0;
	}
	
	// method to calculate distance from point coordinates to (0, 0)
	public double distanceFromOrigin() {
		// pythagora's theorem
		distance = Math.sqrt(Math.pow(Math.abs(xCoord), 2) + Math.pow(Math.abs(yCoord), 2));
		
		return distance;
	}

	// return point as a string
	public String toString() {
		return String.format("(%4.2f, %4.2f)", xCoord, yCoord);
	}

	// accessor method
	public double getX(){
		return xCoord;
	}

	// accessor method
	public double getY(){
		return yCoord;
	}
}