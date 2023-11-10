package org.example.interfaceGraphic.shape;

import java.awt.Graphics;
import lombok.Getter;
import lombok.Setter;

@Getter
public class RectangleShape extends Shape{
  @Setter private int length;
  @Setter private int height;
  
  public RectangleShape(int length, int height){
    this.length = length;
    this.height = height;
  }
  
  @Override
  public Graphics draw(Graphics g) {
    g.setColor(getColor());
    g.drawRect(getCenterX()-(length/2), getCenterY()-(height/2), length, height);
    return g;
  }
}
