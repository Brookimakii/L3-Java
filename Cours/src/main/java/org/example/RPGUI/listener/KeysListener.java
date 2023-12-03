package org.example.RPGUI.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.example.RPGUI.ui.GamePanel;
import org.example.RPGUI.ui.MapPanel;
import org.example.RPGUI.ui.ShopPanel;
import org.example.RPGUI.ui.StatusPanel;

public class KeysListener implements KeyListener {
  private GamePanel gamePanel;
  
  public KeysListener(GamePanel gamePanel) {
    System.out.println("Listener Set");
    this.gamePanel = gamePanel;
  }
  
  @Override
  //Key Typed doesn't recognize the arrow key.
  public void keyTyped(KeyEvent e) {
    System.out.println(gamePanel.getCurrentPanelName());
//    System.out.println("Key Typed: " + e.getKeyChar());
//    System.out.println("Key Typed: " + e.getKeyCode());
    System.out.print("Key Typed ");
    switch (gamePanel.getCurrentPanelName()) {
      case "Map" -> {
        System.out.print("Movement: ");
        keyToMapMovement(e.getKeyChar());
      }
      case "Status" -> {
        System.out.print("Status: ");
        statusNavigation(e.getKeyChar());
      }
      case "Shop" -> {
        System.out.print("Shop: ");
        shopNavigation(e.getKeyChar());
      }
    }
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
//    System.out.println("Key Pressed: " + e.getKeyCode());
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
//    System.out.println("Key Released: " + e.getKeyCode());
  }
  
  private void keyToMapMovement(char e) {
//    System.out.println(e);
    
    switch (e) {
      case KeyEvent.VK_ENTER -> {
        System.out.print("Enter");
        Object[] options = {"Status Window", "Shop Window"};
        int choice =
            JOptionPane.showOptionDialog(gamePanel, "Menue", "Main Menu", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]
            );
        
        switch (choice) {
          case 0 -> gamePanel.showPanel("Status");
          case 1 -> gamePanel.showPanel("Shop");
        }
      }
      case 'z' -> {
        System.out.print("Up/Z");
        gamePanel.getMapPanel().moveTo(0, -1);
      }
      case 's' -> {
        System.out.print("Down/S");
        gamePanel.getMapPanel().moveTo(0, 1);
      }
      case 'q' -> {
        System.out.print("Left/Q");
        gamePanel.getMapPanel().moveTo(-1, 0);
      }
      case 'd' -> {
        System.out.print("Right/D");
        gamePanel.getMapPanel().moveTo(1, 0);
      }
    }
  }
  
  private void shopNavigation(char e) {
    switch (e) {
      case KeyEvent.VK_ENTER -> {}
      case KeyEvent.VK_BACK_SPACE -> {
        System.out.print("Back Space");
        gamePanel.showPanel("Map");
      }
      case KeyEvent.VK_UP, KeyEvent.VK_Z -> {}
      case KeyEvent.VK_DOWN, KeyEvent.VK_S -> {}
      case KeyEvent.VK_LEFT, KeyEvent.VK_Q -> {}
      case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {}
    }
  }
  
  private void statusNavigation(char e) {
    switch (e) {
//      case KeyEvent.VK_ENTER -> {}
      case KeyEvent.VK_BACK_SPACE -> {
        System.out.print("Back Space");
        gamePanel.showPanel("Map");
      }
//      case KeyEvent.VK_UP, KeyEvent.VK_Z -> {}
//      case KeyEvent.VK_DOWN, KeyEvent.VK_S -> {}
//      case KeyEvent.VK_LEFT, KeyEvent.VK_Q -> {}
//      case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {}
    }
  }
}
