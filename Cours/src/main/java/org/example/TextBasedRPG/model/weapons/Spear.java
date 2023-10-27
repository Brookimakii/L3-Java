package org.example.TextBasedRPG.model.weapons;

public class Spear extends Weapon {
  private static final String NAME = "Spear";
  private static final String DAMAGE_TYPE = "Piercing";
  private static final double POWER = 5;
  private static final double PRICE = 1;
  
  public Spear() {super(NAME, POWER, DAMAGE_TYPE, PRICE);}
  
  public String getAsciiArt() {
    return """
                                                                               ▓▓▓▓▓▓▓▓
                                                                             ██▒▒░░░░██
                                                                           ██▒▒░░░░░░██
                                                                         ██▒▒░░░░░░  ██
                                                                       ██▒▒░░░░░░  ██░░
                                                                     ▓▓▒▒░░░░░░  ▓▓
                                                           ██████████▒▒░░░░░░  ██
                                                         ██▒▒░░░░    ██░░░░  ██
                                                           ████████    ██  ██
                                                               ██▒▒██    ██
                                                             ▓▓▒▒▒▒▒▒▓▓  ██
                                                           ██▒▒▒▒▒▒████░░██
                                                         ██▒▒▒▒▒▒██  ██░░██
                                                       ██▒▒▒▒▒▒██    ██▒▒██
                                                     ▒▒▒▒▒▒▒▒██░░    ░░██
                                                   ██▒▒▒▒▒▒██
                                                 ▓▓▒▒▒▒▒▒██
                                               ██▒▒▒▒▒▒██
                                             ██▒▒▒▒▒▒██
                                           ▒▒▒▒▒▒▒▒▓▓░░
                                         ██▒▒▒▒▒▒██
                                       ▓▓▒▒▒▒▒▒██
                                     ██▒▒▒▒▒▒██
                                   ██▒▒▒▒▒▒██
                                 ▒▒▒▒▒▒▒▒▓▓░░
                               ██▒▒▒▒▒▒██░░
                             ▓▓▒▒▒▒▒▒██
                           ██▒▒▒▒▒▒██
                         ██▒▒▒▒▒▒██
                       ▒▒▓▓▒▒▒▒██░░
                     ██▒▒▒▒▒▒██░░
                   ▓▓▒▒▒▒▒▒██
                 ██▒▒▒▒▒▒██
               ██▒▒▒▒▒▒██
             ▒▒▓▓▒▒▒▒▓▓░░
               ██▒▒██░░
                 ██
                 
           """;
  }
}
