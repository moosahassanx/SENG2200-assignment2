// 2.7 Semi-Circle Class

public class SemiCircle{




    public double calculateArea(){
        // area = (pi * radius squared) / 2

        return 0;
    }

    public double originDistance(){
        // distance = (distance from origin of the closest of the two data points) + (2 of the base extremedity points (x2, y2),  (x3, y3)  )

        return 0;
    }

    // example input type: S x0 y0 x1 y1 (E.g., S 4 3 5.1 4.2)
    public String toString(){
        String line = "SEMI=";

        line = "[point0 point1]: " + calculateArea();

        return line;
    }
}