// 2.7 Semi-Circle Class

public class SemiCircle extends PlanarShape{

    private final Point[] pointArray = new Point[4];
    private int pointCounter;
    private double pointLowestFromOrigin;

    public SemiCircle(){
        pointCounter = 0;
        pointLowestFromOrigin = 0;
    }

    public double calculateRadius(){
        
        //double radius = Math.abs(pointArray[1].getX() - pointArray[0].getX()) - Math.abs(pointArray[1].getY() - pointArray[0].getY());
        
        double xDistance = Math.abs(pointArray[1].getX() - pointArray[0].getX());
        double yDistance = Math.abs(pointArray[1].getY() - pointArray[0].getY());

        // pythagoras theorem
        double radius = Math.pow((xDistance*xDistance) + (yDistance*yDistance), 0.5);

        return radius;
    }

    public double calculateArea(){

        double radius = calculateRadius();
        double area = Math.PI * (radius*radius);
        
        return area/2;
    }

    public String toString(){
        String line = "SEMI=";

        line += "[" + pointArray[0].toString() + " " + pointArray[1].toString() + "]: " + String.format("%6.2f", calculateArea());
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

		if (p == 0){ 																				// no existing points means the first point will be set as point closest to origin of polygon
			setLowestFromOrigin(pointArray[p].distanceFromOrigin());
		} else if (pointArray[p].distanceFromOrigin() < pointArray[q].distanceFromOrigin()){ 		// comparing new point to previous point and set as point closest to origin of polygon
			setLowestFromOrigin(pointArray[p].distanceFromOrigin());
		}
    }

    public double originDistance(){
        // distance = (distance from origin of the closest of the two data points) + (2 of the base extremedity points (x2, y2),  (x3, y3)  )
        
        if(pointArray[2].distanceFromOrigin() < pointLowestFromOrigin){
            pointLowestFromOrigin = pointArray[2].distanceFromOrigin();
        }else if(pointArray[3].distanceFromOrigin() < pointLowestFromOrigin){
            pointLowestFromOrigin = pointArray[3].distanceFromOrigin();
        }else{
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