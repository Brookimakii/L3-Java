package org.example.geometrie;

public class Shape {
  protected Point center;
  
  
  public Shape(Point center) {
    this.center = center;
  }
  
  public void moveCenter(Point point){
    this.center = point;
  }
  
  public double calculateArea(){
    return 0;
  }
}
