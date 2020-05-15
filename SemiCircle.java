// TITLE: 					Assignment1
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					22/03/2020 
// DESCRIPTION: 			creating semicircles using 4 input variables

public class SemiCircle extends PlanarShape{

    // declaring variables
    private final Point[] pointArray = new Point[2];
    private int pointCounter;
    
    // constructor
    public SemiCircle() {
        // instantiating
        pointCounter = 0;
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
		//testLowestFromOrigin(pointCounter);                                 // test if new point is closer than previous point
		pointCounter++;                                                     // iterate number of points
    }

    public double originDistance(){
        //setting extremdity points
        Point extremedity1 = new Point(pointArray[0].getX() - Math.abs(pointArray[0].getY()-pointArray[1].getY()), pointArray[0].getY()+Math.abs(pointArray[0].getX()-pointArray[1].getX()));
        Point extremedity2 = new Point(pointArray[0].getX() + Math.abs(pointArray[0].getY()-pointArray[1].getY()), pointArray[0].getY()-Math.abs(pointArray[0].getX()-pointArray[1].getX()));

        double minimumDistance = Double.MAX_VALUE;

        // case1: comparing extremidity point to lowest from origin
        if(extremedity1.distanceFromOrigin() < minimumDistance){
            minimumDistance = extremedity1.distanceFromOrigin();
        }
        
        // case2: comparing extremedity point to lowest from origin
        if(extremedity2.distanceFromOrigin() < minimumDistance){
            minimumDistance = extremedity2.distanceFromOrigin();
        }

        // case3: comparing 
        if(pointArray[0].distanceFromOrigin() < minimumDistance){
            minimumDistance = pointArray[0].distanceFromOrigin();
        }

        if(pointArray[1].distanceFromOrigin() < minimumDistance){
            minimumDistance = pointArray[1].distanceFromOrigin();
        }

        return minimumDistance;
    }

    @Override
    public void draw() {
        System.out.println("Inside SemiCircle::draw() method");
    }
}