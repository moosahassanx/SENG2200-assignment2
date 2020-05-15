// TITLE: 					Assignment2
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532 
// DATE: 					15/05/2020 
// DESCRIPTION: 			abstract class which uses calls methods in terms of object type

public abstract class PlanarShape implements Comparable<PlanarShape>{
    
    // common methods
    public abstract void draw();
    public abstract String toString();
    public abstract double calculateArea();
    public abstract double originDistance();
	public abstract void insertPoint(double x, double y);
    
    @Override
    public int compareTo(PlanarShape data){

        if(data == null){
            return 1;
        }

        // case1: difference in area between 2 shapes is less than 0.001
        double difference = (Math.abs(this.calculateArea() - data.calculateArea()));
        if(difference <= 0.001){
            if(this.originDistance() < data.originDistance()){
                return -1;
            }
            return 1;
        }

        // case2: the new shape is smaller than the previous shape
        if(this.calculateArea() > data.calculateArea()){
            return 1;
        }

        // case3: the new shape is equal to the previous shape
        else if(this.calculateArea() == data.calculateArea()){
            return 0;
        }
        
        // case4: assumed the new shape is greater than the previous shape
        else{
            return -1;
        }
    }
}