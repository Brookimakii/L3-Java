package org.example.TextBasedRPG.model;

public class MainMap extends Map{
  
  private static final int PLAYER_ORIGIN_X = 0;
  private static final int PLAYER_ORIGIN_Y = 0;
  private static final int END_X = 9;
  private static final int END_Y = 9;
  private static final double RANDOM_ENCOUNTER_RATE = 0.50;
  
  private static final int[][] GRID_MAP = new int[][] {
      {1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
      {1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
      {1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
      {0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
      {0, 0, 0, 0, 1, 1, 0, 0, 1, 1}
  };
  
  public MainMap() {
    super(PLAYER_ORIGIN_X, PLAYER_ORIGIN_Y, RANDOM_ENCOUNTER_RATE, GRID_MAP, END_X, END_Y);
  }
}
