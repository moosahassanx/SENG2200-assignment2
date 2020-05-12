// 2.4 The Abstract Class - PlanarShape

public abstract class PlanarShape implements Comparable<PlanarShape>{
    public abstract String toString();
    public abstract double calculateArea();
    public abstract double originDistance();
    public abstract double getLowestFromOrigin();
	public abstract void insertPoint(double x, double y);
    
    public boolean compareTo(PlanarShape data){
        double difference = (Math.abs(this.calculateArea() - data.calculateArea()));

        // test difference in area
        if(difference <= 0.001){
            if(this.getLowestFromOrigin() < data.getLowestFromOrigin()){
                return true;
            }
            return false;
        } 
        
        // new shape area is greater than previous shape
        else if(this.calculateArea() < data.calculateArea()){
            return true;
        }
        
        // new shape area is less than previous shape
        else{
            return false;
        }
    }
}

// standard Comparable<T> interface are also meant to be implemented as you are comparing PlanarShape objects
