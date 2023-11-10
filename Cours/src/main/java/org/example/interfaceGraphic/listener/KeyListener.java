package org.example.interfaceGraphic.listener;

import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import org.example.interfaceGraphic.PaintPanel;

public class KeyListener implements java.awt.event.KeyListener {
  private JLabel label;
  private PaintPanel paintPanel;
  
  public KeyListener(JLabel l) {this.label = l;}
  
  public KeyListener(PaintPanel paintPanel) {
    this.paintPanel = paintPanel;
  }
  
  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println("TYPED");
    this.label.setText("TYPED");
    
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println("PRESSED");
    this.label.setText("PRESSED");
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println("RELEASED");
    this.label.setText("RELEASED");
    if (e.getKeyCode() == KeyEvent.VK_SPACE) {
      this.label.setText("SPACE key released");
    }
  }
}

