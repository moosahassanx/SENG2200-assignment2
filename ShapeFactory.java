// TITLE: 					Assignment2
// COURSE: 					SENG2200
// AUTHOR: 					Moosa Hassan
// STUDENT NUMBER: 			3331532
// DATE: 					15/05/2020
// DESCRIPTION: 			used for recognising strings and returning proper object type returns

// importing java libraries (file scanner and string output)
import java.util.Scanner;

public class ShapeFactory {
    
    // class only needs on method
    public PlanarShape getShape(String shapeType){

        // case: string is null
        if(shapeType == null){
            return null;
        }

        Scanner file = new Scanner(shapeType);          // string scanner

        // scanner keeps looking for next character
        while (file.hasNext()) {
            String newText = file.next();		// declare string and assign input

            // case1: scanner detects polygon
            if (newText.equals("P")) {
                final int numOfPoints = file.nextInt();							// next int is assumed to be number of points
                final PlanarShape polygonObject = new Polygon(numOfPoints);		// new polygon object with number of points
                final Point[] pointArray = new Point[numOfPoints];				//  declare point array and set number of elements as number of points

                int i = 1, j = 0;								// declare int variables and instantiate
                while (i <= numOfPoints) {
                    // x and y alternates
                    final double x = file.nextDouble();
                    final double y = file.nextDouble();

                    pointArray[j] = new Point(x, y);			// create new point element
                    
                    polygonObject.insertPoint(x, y);			// inserting those points
                    
                    // iterate after each loop
                    j++;
                    i++;
                }

                // return proper object type
                return polygonObject;
            }

            // case2: scanner detects circle
            else if(newText.equals("C")){
                double x = file.nextDouble();
                double y = file.nextDouble();
                double r = file.nextDouble();			// radius

                // create new circle using parameters
                PlanarShape circleObject  = new Circle(r);
                circleObject.insertPoint(x, y);

                // return proper object type
                return circleObject;
            }

            // case3: scanner detects semicircle
            else if(newText.equals("S")){
                // new semicircle
                PlanarShape semiCircleObject = new SemiCircle();

                // inserting points
                for(int i = 0; i < 2; i++){
                    double x = file.nextDouble();
                    double y = file.nextDouble();
                    semiCircleObject.insertPoint(x, y);
                }

                // return proper object type
                return semiCircleObject;
            }
        }

        return null;
    }
}

