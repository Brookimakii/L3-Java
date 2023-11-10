package org.example.TextBasedRPG.model.weapons;

public class Fist extends Weapon {
  private static final String NAME = "Fist";
  private static final String DAMAGE_TYPE = "Bludgeoning";
  private static final double POWER = 1;
  private static final double PRICE = 0;
  
  public Fist() {super(NAME, POWER, DAMAGE_TYPE, PRICE);}
  
  @Override
  public String getAsciiArt() {
    return null;
  }
}
