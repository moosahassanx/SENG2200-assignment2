// 2.4 The Abstract Class - PlanarShap

public abstract class PlanarShape{
    // declare fields
    // decalre non-abstract methods

    abstract void draw();



    abstract String toString(){
        // method
    }

    // this will be the basis for ordering
    abstract double calculateArea(){
        // method
        return 0;
    }

    // this will also be the basis for ordering (same thing as assignment1)
    abstract double originDistance(){
        // method
        return 0;
    }

    // standard Comparable<T> interface are also meant to be implemented as you are comparing PlanarShape objects
}