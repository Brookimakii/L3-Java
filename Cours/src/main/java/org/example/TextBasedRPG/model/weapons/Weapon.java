package org.example.TextBasedRPG.model.weapons;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.TextBasedRPG.model.targetable.Targetable;

@Getter
@AllArgsConstructor
public abstract class Weapon {
  protected final String name;
  @Setter protected double power;
  @Setter protected String damageType;
  protected double price;
  
  public abstract String getAsciiArt();
  
  public void attackTarget(Targetable d) {
    d.getDamage((int) power);
  }
}

