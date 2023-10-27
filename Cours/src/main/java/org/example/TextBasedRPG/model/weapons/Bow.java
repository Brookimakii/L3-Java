package org.example.TextBasedRPG.model.weapons;

public class Bow extends Weapon {
  private static final String NAME = "Bow";
  private static final String DAMAGE_TYPE = "Piercing";
  private static final double POWER = 15;
  private static final double PRICE = 10;
  
  public Bow() {super(NAME, POWER, DAMAGE_TYPE, PRICE);}
  
  public String getAsciiArt() {
    return """
           ▓▓
           ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
             ░░        ████▓▓
               ░░          ██▓▓
                 ░░          ██▓▓
                   ░░          ██▓▓
                     ░░          ██▓▓
                       ░░          ██▓▓
                         ░░          ██▓▓
                           ░░        ████
                             ░░        ██
                               ░░      ██
                                 ░░    ██
                                   ░░  ██
                                     ░░██
                                       ████
           """;
  }
}
