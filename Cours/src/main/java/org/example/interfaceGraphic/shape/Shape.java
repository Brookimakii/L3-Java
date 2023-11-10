package org.example.interfaceGraphic.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Shape {
  @Setter private int centerX;
  @Setter private int centerY;
  @Setter private Color color;
  
  public void mouseClick(MouseEvent e) {
    this.centerX = e.getX();
    this.centerY = e.getY();
  }
  
  public abstract Graphics draw(Graphics g);
}
