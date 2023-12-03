package org.example.RPGUI.ui;


import lombok.Getter;
import org.example.RPGUI.game.Game;
import org.example.RPGUI.game.GameMap;

import javax.swing.*;
import java.awt.*;

public class MapPanel extends JPanel {
  
  static final int cellSize = 24;
  
  private int[][] mapGrid;
  
  @Getter private Image playerImage;
  private int playerX;
  private int playerY;
  
  public MapPanel(Game game) {
    this.mapGrid = game.getMap().getMap();
    //TODO: CHANGE PATH TO IMAGE
    ImageIcon img = new ImageIcon(
        "C:\\Users\\Brookii-PC\\Documents\\Scolaire\\Sorbonne\\Java\\Repo Git\\Cours\\src\\main\\java\\org\\example\\RPGUI\\link.png");
    this.playerImage = img.getImage();
  }
  
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    int CoordX = 200;
    int CoordY = 50;
    
    for (int row = 0; row < this.mapGrid.length; row++) {
      for (int col = 0; col < this.mapGrid[0].length; col++) {
        Color color;
        switch (this.mapGrid[row][col]) {
          case 0:
            color = Color.BLACK;
            break;
          case 1:
            color = Color.WHITE;
            break;
          case 2:
            color = Color.CYAN;
            break;
          default:
            color = Color.GREEN;
        }
        g.setColor(color);
        g.fillRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
        if (row == playerX && col == playerY) {
          g.drawImage(
              this.getPlayerImage(), CoordX + cellSize * col, CoordY + cellSize * row, null);
        }
        g.setColor(Color.BLACK); // contours
        g.drawRect(CoordX + cellSize * col, CoordY + cellSize * row, cellSize, cellSize);
      }
    }
  }
  
  public void moveTo(int y, int x) {
    int newX = playerX + x;
    int newY = playerY + y;
    
    if (newX<0||newY<0||newX>=mapGrid.length||newY>=mapGrid[0].length){
      System.out.println("OOB");
      return;
    } else if (mapGrid[newX][newY] == 0) {
      System.out.println("There is an obstacle in the way.");
      return;
    } else {
      playerX = newX;
      playerY = newY;
    }
    System.out.println("Player at: " + playerX + ";" + playerY);
    
    repaint();
    
    end();
  }
  
  
  public void randomEncounter(){}
  public void end(){
    if (playerX == mapGrid.length-1 && playerY == mapGrid[0].length-1){
      System.out.println("GameEnded");
    }
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(500, 300);
  }
  
}
