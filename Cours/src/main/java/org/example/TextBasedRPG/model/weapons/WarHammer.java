package org.example.TextBasedRPG.model.weapons;

public class WarHammer extends Weapon {
  private static final String NAME = "War Hammer";
  private static final String DAMAGE_TYPE = "Blunt";
  private static final double POWER = 20;
  private static final double PRICE = 20;
  
  public WarHammer() {super(NAME, POWER, DAMAGE_TYPE, PRICE);}
  
  public String getAsciiArt() {
    return """
                                       ░░
                                     ▒▒▒▒▒▒
                                   ░░░░░░░░░░
                                 ▒▒▒▒▒▒▒▒▒▒▒▒▒▒████
                               ░░░░░░░░░░░░░░░░░░██
                             ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░░
                               ░░░░░░░░░░░░░░░░░░░░░░
                                 ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                   ░░░░░░░░░░░░░░░░░░░░░░
                                     ▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                                   ████░░░░░░░░░░░░░░░░░░
                                 ██████  ▒▒▒▒▒▒▒▒▒▒▒▒▒▒
                               ██████      ░░░░░░░░░░
                             ██████          ▒▒▒▒▒▒
                           ██████              ░░
                         ██████
                       ██████
                     ██████
                   ██████
                   ████                                                ²
           """;
  }
}
