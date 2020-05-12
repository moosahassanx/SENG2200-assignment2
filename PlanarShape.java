// 2.4 The Abstract Class - PlanarShape

public abstract class PlanarShape implements Comparable<PlanarShape>{
    public abstract String toString();
    public abstract double calculateArea();
    public abstract double originDistance();
	public abstract void insertPoint(double x, double y);
    
    public int compareTo(PlanarShape data){
        
        // case1: the new shape is smaller than the previous shape
        if(this.calculateArea() > data.calculateArea()){
            return 1;
        }
        
        // case2: the new shape is greater than the previous shape
        else{
            return -1;
        }
    }
}

// standard Comparable<T> interface are also meant to be implemented as you are comparing PlanarShape objects
