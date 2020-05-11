// 2.6 Circle Class

public class Circle extends PlanarShape{

    private final Point[] pointArray = new Point[1];
    private double radius;

    public Circle(double r) {
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

        line += "[" + pointArray[0].toString() + " " + radius + "]: " + String.format("%6.2f", calculateArea());

        return line;
    }

	public void insertPoint(final double xInput, final double yInput) {
        // adding array of point as a new point
		pointArray[0] = new Point(xInput, yInput);
    }

    // VSCODE GENERATED 
    @Override
    void draw() {
        // TODO Auto-generated method stub

    }
}