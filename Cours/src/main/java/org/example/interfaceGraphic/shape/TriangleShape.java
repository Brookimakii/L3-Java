package org.example.interfaceGraphic.shape;

import java.awt.Graphics;
import lombok.Getter;
import lombok.Setter;

@Getter
public class TriangleShape extends Shape {
  @Setter private int length;
  
  public TriangleShape(int length) {
    this.length = length;
  }
  
  @Override
  public Graphics draw(Graphics g) {
    g.setColor(getColor());
    
    
    g.drawPolygon(
        new int[] {
            getCenterX(),
            (int) (getCenterX() + length/2),
            (int) (getCenterX() - length/2)
        },
        new int[] {
            (int) (getCenterY() - (Math.sqrt(3)/3)*length),
            (int) (getCenterY() + (Math.sqrt(3)/6)*length),
            (int) (getCenterY() + (Math.sqrt(3)/6)*length)
        },
        3);
    return g;
  }
}
