package org.example.TextBasedRPG.model.weapons;

public class Fist extends Weapon {
  private static final String NAME = "Fist";
  private static final String DAMAGE_TYPE = "Bludgeoning";
  private static final double POWER = 2;
  private static final double PRICE = 0;
  
  public Fist() {super(NAME, POWER, DAMAGE_TYPE, PRICE);}
  
  public String getAsciiArt() {
    return "";
  }
}
