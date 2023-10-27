package org.example.geometrie;

public class PointMain {
  public static void main(String[] args) {
    Point p1 = new Point(10, 10);
    Point p2 = new Point(-5, 5);
    Point p3 = new Point(5, 10);
    Point p4 = new Point(10, -5);
    
    System.out.println("Point 1: " + p1);
    System.out.println("Point 2: " + p2);
    System.out.println("Point 3: " + p3);
    System.out.println("Point 4: " + p4);
    System.out.println("-------------------------------------------------------------------------");
    
    p1.moveTo(0, 0); //Move from (10;10) to (0;0)
    p2.rMoveTo(5, 0); //Move from (-5;5) to (0;5) by adding 5 to x
    p3.rMoveTo(0, -5); //Move from (5;10) to (5;5) by subtracting 5 to y
    p4.rMoveTo(-5, 5); //Move from (10;-5) to (5;0) by adding and subtracting 5 to y and x
    
    System.out.println("Point 1: " + p1);
    System.out.println("Point 2: " + p2);
    System.out.println("Point 3: " + p3);
    System.out.println("Point 4: " + p4);
    System.out.println("-------------------------------------------------------------------------");
    
    System.out.println(p1.distanceTo(p2)); // should return 5
    System.out.println(p1.distanceTo(p3)); // should return 7.07...
    System.out.println(p1.distanceTo(p4)); // should return 5
    System.out.println(p2.distanceTo(p3)); // should return 5
    System.out.println(p2.distanceTo(p4)); // should return 7.07...
    System.out.println(p3.distanceTo(p4)); // should return 5
    System.out.println("-------------------------------------------------------------------------");
    
    Point center = new Point(0, 0);
    Square square = new Square(center, 2);
    System.out.println(square.calculateArea()); // should return 4
    Rectangle rectangle = new Rectangle(center, 2D, 4D);
    System.out.println(rectangle.calculateArea()); // should return 8
    Triangle triangle = new Triangle(center, 4D, 8D);
    System.out.println(triangle.calculateArea()); // should return 16
    
    
    System.out.println("-------------------------------------------------------------------------");
    
  }
}
