package org.example.TextBasedRPG.model;

abstract class Map implements MapI {
  int[][] gridMap;
  int playerPosX, playerPosY, endX, endY;
  double randomEncounterRate;
  
  public Map(int originPlayerX, int originPlayerY, double randomEncounterRate, int[][] gridMap, int endX, int endY) {
    this.playerPosX = originPlayerX;
    this.playerPosY = originPlayerY;
    this.randomEncounterRate = randomEncounterRate;
    this.gridMap = gridMap;
    this.endX = endX;
    this.endY = endY;
  }
  
  public boolean doRansomEncounter() {
    double rand = Math.random();
    return rand <= randomEncounterRate;
  }
  
  public boolean doPlayerArrived(){
    return playerPosX == endX && playerPosY == endY;
  }
  
  @Override
  public void moveTo(Direction direction) {
    int newX = playerPosX + direction.getX();
    int newY = playerPosY + direction.getY();
    if (newX < 0 || newX > gridMap.length || newY < 0 || newY > gridMap[0].length) {
      System.out.println("You are on the edge of the map. Cannot go " + direction.name() + ".");
    } else if (gridMap[newX][newY] == 0) {
      System.out.println("There is an obstacle. Cannot go " + direction.name() + ".");
    } else {
      playerPosX = newX;
      playerPosY = newY;
    }
  }
  
  
  @Override
  public void printMap() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < gridMap.length; i++) {
      for (int j = 0; j < gridMap[i].length; j++) {
        if (i == playerPosX && j == playerPosY) {
          sb.append("P");
        } else {
          if (gridMap[i][j] == 1) {
            sb.append("☐");
          } else {
            sb.append("☒");
          }
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}
