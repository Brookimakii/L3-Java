package org.example.interfaceGraphic.shape;

import java.awt.Graphics;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CercleShape extends Shape {
  @Setter private int radius;
  
  public CercleShape(int radius) {
    this.radius = radius;
  }
  
  @Override
  public Graphics draw(Graphics g) {
    g.setColor(getColor());
    g.drawOval(getCenterX() - radius/2, getCenterY() - radius/2, radius, radius);
    return g;
  }
}
