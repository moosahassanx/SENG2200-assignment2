// TITLE: 					Assignment1
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					22/03/2020 
// DESCRIPTION: 			creating circles using 3 input variables

public class Circle extends PlanarShape{

    // declaring variables and objects
    private final Point[] pointArray = new Point[1];
    private double radius;

    // constructors
    public Circle(double r) {
        // instantiating
        radius = r;
	}

	public double calculateArea(){
        // method use area = pi * radius squared
        double area;
        area = 3.14159265359 * (radius*radius);
        return area;
    }

    public double originDistance(){
        // distance = (distance from origin of centre) - (radius of circle, which can be negative)
        double originDistance = pointArray[0].distanceFromOrigin() - Math.abs(radius);
        return originDistance;
    }

    public String toString(){
        String line = "CIRC=";

        // concatenate line
        line += "[" + pointArray[0].toString() + " " + radius + "]: " + String.format("%6.2f", calculateArea());

        return line;
    }

	public void insertPoint(final double xInput, final double yInput) {
        // adding array of point as a new point
		pointArray[0] = new Point(xInput, yInput);
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method");
    }
}