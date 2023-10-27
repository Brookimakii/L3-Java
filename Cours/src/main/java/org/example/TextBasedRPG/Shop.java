package org.example.TextBasedRPG;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.TextBasedRPG.model.weapons.Weapon;

@Getter
@ToString
public class Shop {
  @Setter private ArrayList<Weapon> weapons;
  
  public Shop() {
    this.weapons = new ArrayList<>();
  }
  
  public void addToInventory(Weapon w) {
    weapons.add(w);
  }
  
  public void removeToInventory(Weapon w) {
    weapons.remove(w);
  }
  
  public String welcomePlayer() {
    StringBuilder welcomingMessage =
        new StringBuilder("Welcome to the Shop !!\nHere are all available weapons:\n");
    for (Weapon weapon : this.weapons) {
      welcomingMessage.append("\t ").append(this.weapons.indexOf(weapon) + 1).append(". ")
          .append(weapon.getName()).append(" for ").append(weapon.getPrice()).append("po.\n");
    }
    welcomingMessage.append("What will be your choice Sir?");
    return welcomingMessage.toString();
  }
  
  
}
