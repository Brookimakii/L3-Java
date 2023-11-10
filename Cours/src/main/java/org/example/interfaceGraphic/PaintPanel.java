package org.example.interfaceGraphic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import lombok.Getter;
import lombok.Setter;
import org.example.interfaceGraphic.shape.Shape;

@Getter
public class PaintPanel extends JPanel {
  private final ArrayList<Shape> shapes = new ArrayList<>();
  @Setter int currentShape = 0;
  
  public void addShape(Shape s){
    this.shapes.add(s);
  }
  
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    shapes.get(currentShape).draw(g);
  }
  
  public void mouseClick(MouseEvent e) {
    shapes.get(currentShape).mouseClick(e);
    this.repaint();
  }
  
  public void addFreeHand(int x, int y){
//    this.drawing
  }
}
