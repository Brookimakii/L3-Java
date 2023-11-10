package org.example.interfaceGraphic.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import org.example.interfaceGraphic.PaintPanel;

public class MousePanelInfo implements MouseListener {
  JPanel panel;
  
  public MousePanelInfo(JPanel panel) {
    this.panel = panel;
  }
  
  public MousePanelInfo() {
  
  }
  
  @Override
  public void mouseClicked(MouseEvent e) {
    System.out.println(
        "CLICKED\nx: " + e.getLocationOnScreen().x + " y:" + e.getLocationOnScreen().y);
    if (e.getSource().getClass() == PaintPanel.class) {
      PaintPanel pn = (PaintPanel) e.getSource();
      pn.mouseClick(e);
    }
  }
  
  
  @Override
  public void mousePressed(MouseEvent e) {
  
  }
  
  @Override
  public void mouseReleased(MouseEvent e) {
  
  }
  
  @Override
  public void mouseEntered(MouseEvent e) {
    System.out.println(
        "ENTERED\nx: " + e.getLocationOnScreen().x + "y:" + e.getLocationOnScreen().y);
    
  }
  
  @Override
  public void mouseExited(MouseEvent e) {
    System.out.println(
        "EXITED\nx: " + e.getLocationOnScreen().x + "y:" + e.getLocationOnScreen().y);
    
  }
}
