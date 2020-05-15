// 2.7 Semi-Circle Class

public class SemiCircle extends PlanarShape{

    // declaring variables
    private final Point[] pointArray = new Point[4];
    private int pointCounter;
    private double pointLowestFromOrigin;


    // constructor
    public SemiCircle(){
        // instantiating
        pointCounter = 0;
        pointLowestFromOrigin = 0;
    }

    public double calculateRadius(){
        
        double xDistance = Math.abs(pointArray[1].getX() - pointArray[0].getX());       // distance between 2 x coordinates
        double yDistance = Math.abs(pointArray[1].getY() - pointArray[0].getY());       // distance between 2 y coordinates

        // pythagoras theorem
        double radius = Math.pow((xDistance*xDistance) + (yDistance*yDistance), 0.5);

        return radius;
    }

    public double calculateArea(){

        // pi*r^2 formula calculates area of circle
        double radius = calculateRadius();
        double area = Math.PI * (radius*radius);
        
        // semicircle is half that
        return area/2;
    }

    public String toString(){
        String line = "SEMI=";

        line += "[" + pointArray[0].toString() + "" + pointArray[1].toString() + "]: " + String.format("%6.2f", calculateArea());       // concatenate line

        return line;
    }

	// add point to the semiCircle
	public void insertPoint(final double xInput, final double yInput) {
        pointArray[pointCounter] = new Point(xInput, yInput);               // adding array of point as a new point
		testLowestFromOrigin(pointCounter);                                 // test if new point is closer than previous point
		pointCounter++;                                                     // iterate number of points
    }
    
    // take point closest to origin and set as lowest distance of the polygon
	public void testLowestFromOrigin(final int p){
		// declaring and instantiating variable
		final int q = p - 1;

        // case1: no existing points
		if (p == 0){
			setLowestFromOrigin(pointArray[p].distanceFromOrigin());        // first point will be set as point closest to origin of polygon
        } 

        // case2: comparing new point to previous point
        else if (pointArray[p].distanceFromOrigin() < pointArray[q].distanceFromOrigin()){
			setLowestFromOrigin(pointArray[p].distanceFromOrigin());        // set as point closest to origin of polygon
		}
    }

    public double originDistance(){
        
        // case1: comparing extremidity point to lowest from origin
        if(pointArray[2].distanceFromOrigin() < pointLowestFromOrigin){
            pointLowestFromOrigin = pointArray[2].distanceFromOrigin();
        }
        
        // case2: compariding extremedity point to lowest from origin
        else if(pointArray[3].distanceFromOrigin() < pointLowestFromOrigin){
            pointLowestFromOrigin = pointArray[3].distanceFromOrigin();
        }
        
        // case3L assume both extremedity points were not lowest from origin
        else{
            return pointLowestFromOrigin;
        }

        return pointLowestFromOrigin;
    }
    
    // mutator method
	public void setLowestFromOrigin(final double s) {
		pointLowestFromOrigin = s;
    }
    
    // accessor method
	public double getLowestFromOrigin(){
		return pointLowestFromOrigin;
	}
}