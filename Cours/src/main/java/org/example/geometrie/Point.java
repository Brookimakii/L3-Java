package org.example.geometrie;

import lombok.Getter;

/**
 * Class for a point.
 */
public class Point {
  @Getter private double pointX;
  @Getter private double pointY;
  
  public Point(int pointX, int pointY) {
    this.pointX = pointX;
    this.pointY = pointY;
  }
  
  public void setPointX(int pointX) {
    this.pointX = pointX;
  }
  
  public void setPointY(int pointY) {
    this.pointY = pointY;
  }
  
  public void moveTo(int x, int y) {
    this.pointX = x;
    this.pointY = y;
  }
  
  public void rMoveTo(int x, int y) {
    this.pointX += x;
    this.pointY += y;
  }
  
  public double distanceTo(Point point) {
    double squareOfX = Math.pow(Math.abs(this.pointX - point.pointX), 2);
    double squareOfY = Math.pow(Math.abs(this.pointY - point.pointY), 2);
    return Math.sqrt(squareOfX + squareOfY);
  }
  
  @Override
  public String toString() {
    return "Point{" + "x=" + pointX + ", y=" + pointY + '}';
  }
}
