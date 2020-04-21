// 2.4 The Abstract Class - PlanarShap

public abstract class PlanarShape{
    // declare fields
    // decalre non-abstract methods

    abstract void draw();
    
    public abstract String toString();

    // this will be the basis for ordering
    public abstract double calculateArea();

    // this will also be the basis for ordering (same thing as assignment1)
    public abstract double originDistance();

    // standard Comparable<T> interface are also meant to be implemented as you are comparing PlanarShape objects
}