package org.example.TextBasedRPG.model;

import lombok.Getter;

public interface MapI {
  int[][] gridMap = new int[0][0];
  int playerPosX = 0, playerPosY = 0;
  
  void moveTo(Direction direction);
  
  void printMap();
  
  @Getter
  enum Direction {
    North(-1, 0), Est(0, 1), South(1, 0), West(0, -1);
    
    private final int x;
    private final int y;
    
    Direction(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
