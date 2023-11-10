package org.example.interfaceGraphic.listener;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.example.interfaceGraphic.PaintPanel;

public class ButtonListener implements ActionListener {
  
  
  private JLabel label;
  private JPanel panel;
  
  public ButtonListener(JLabel label) {
    this.label = label;
  }
  
  public ButtonListener(JPanel panel) {
    this.panel = panel;
  }
  
  public ButtonListener() {
  
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource().getClass() == JButton.class) {
      JButton btn = (JButton) e.getSource();
      if (panel != null && panel.getClass() == PaintPanel.class) {
        ((PaintPanel) panel).setCurrentShape(Integer.parseInt(btn.getName()));
      }
      
    }

//    if (e.getSource().getClass() == JButton.class) {
//      JButton btn = (JButton) e.getSource();
//      label.setText(btn.getText());
//    }
    
  }
}
