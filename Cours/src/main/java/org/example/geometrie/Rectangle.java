package org.example.geometrie;

public class Rectangle extends Shape {
  private double length;
  private double width;
  
  public Rectangle(Point center, double length, double width) {
    super(center);
    this.length = length;
    this.width = width;
  }
  
  @Override
  public double calculateArea() {
    return length * width;
  }
}
