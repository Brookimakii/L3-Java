package org.example.geometrie;

public class Triangle extends Shape {
  private double base;
  private double height;
  
  public Triangle(Point center, double base, double height) {
    super(center);
    this.base = base;
    this.height = height;
  }
  
  @Override
  public double calculateArea() {
    return (base * height) / 2;
  }
}
