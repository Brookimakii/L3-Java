package org.example.interfaceGraphic;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.example.interfaceGraphic.listener.ButtonListener;
import org.example.interfaceGraphic.listener.KeyListener;
import org.example.interfaceGraphic.listener.MousePanelInfo;
import org.example.interfaceGraphic.shape.CercleShape;
import org.example.interfaceGraphic.shape.RectangleShape;
import org.example.interfaceGraphic.shape.Shape;
import org.example.interfaceGraphic.shape.TriangleShape;

public class MainGUI {
  public static void main(String[] args) {
    JFrame window = new JFrame("Hello World");
    window.setSize(480, 270);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    
    PaintPanel panel = new PaintPanel();
    panel.setSize(window.getWidth(),window.getHeight());
    panel.setLayout(new FlowLayout());
    
//    JLabel label1 = new JLabel("Welcome: ");
//    JLabel label2 = new JLabel("output");
//    JButton button1 = new JButton("I am first");
//    JButton button2 = new JButton("I am second");
//
//    JLabel keyLabelInfo = new JLabel("");
//    JTextField keyTextInfo = new JTextField();
//    keyTextInfo.setColumns(10);
//    keyTextInfo.addKeyListener(new KeyListener(keyLabelInfo));
//    panel.add(keyLabelInfo);
//    panel.add(keyTextInfo);
    
    RectangleShape rectangle = new RectangleShape(100, 50);
    rectangle.setColor(Color.RED);
    panel.addShape(rectangle);
    
    CercleShape cercle = new CercleShape(50);
    cercle.setColor(Color.BLUE);
    panel.addShape(cercle);
    
    TriangleShape triangle = new TriangleShape(50);
    triangle.setColor(Color.GREEN);
    panel.addShape(triangle);
    
    for (Shape shape: panel.getShapes()){
      JButton button = new JButton(shape.getClass().getSimpleName());
      button.setName(String.valueOf(panel.getShapes().indexOf(shape)));
      button.addActionListener(new ButtonListener(panel));
      panel.add(button);
    }
    
    panel.addMouseMotionListener(new MouseMotionAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
      }
      
      @Override
      public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
      }
    });
    
    panel.setSize(panel.getWidth(), panel.getHeight()/2);
    panel.addMouseListener(new MousePanelInfo(panel));
    
    
//    button1.addActionListener(evt -> label2.setText("I am first"));
//    button2.addActionListener(evt -> label2.setText("I am second"));
    
//    button1.addActionListener(new ButtonListener(label2));
//    button2.addActionListener(new ButtonListener(label2));
//
//    panel.add(label1);
//    panel.add(button1);
//    panel.add(button2);
//    panel.add(label2);
    
    window.add(panel);
    window.setVisible(true);
  }
}
