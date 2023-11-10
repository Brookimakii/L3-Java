package org.example.TextBasedRPG;

public class MainMap extends Map{
  
  private static final int PLAYER_ORIGIN_X = 8;
  private static final int PLAYER_ORIGIN_Y = 5;
  private static final double RANDOM_ENCOUNTER_RATE = 0.25;
  private static final int[][] GRID_MAP = new int[][] {
      {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
      {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
  };
  
  public MainMap() {
    super(PLAYER_ORIGIN_X, PLAYER_ORIGIN_Y, RANDOM_ENCOUNTER_RATE, GRID_MAP);
  }
}
