package org.example.TextBasedRPG.model.weapons;

public class Sword extends Weapon {
  private static final String NAME = "Sword";
  private static final String DAMAGE_TYPE = "Slashing";
  private static final double POWER = 10;
  private static final double PRICE = 5;
  
  public Sword() {super(NAME, POWER, DAMAGE_TYPE, PRICE);}
  
  public String getAsciiArt() {
    return """
                                           ▓▓▓▓▓▓
                                         ▓▓  ▒▒▓▓
                                       ▓▓  ▒▒  ▓▓
                                     ▓▓  ▒▒  ▓▓
                                   ▓▓  ▒▒  ▓▓
                                 ▓▓  ▒▒  ▓▓
                     ▓▓▓▓      ▓▓  ▒▒  ▓▓
                     ▓▓▒▒▓▓  ▓▓  ▒▒  ▓▓
                       ▓▓▒▒▓▓  ▒▒  ▓▓
                       ▓▓▒▒▓▓▒▒  ▓▓
                         ▓▓▒▒▓▓▓▓
                       ▓▓▓▓▓▓▒▒▒▒▓▓
                     ▓▓▓▓██  ▓▓▓▓▒▒▓▓
                 ▓▓▓▓▓▓██        ▓▓▓▓
                 ▓▓  ▓▓
                 ▓▓▓▓▓▓
           """;
  }
}
