package org.example.TextBasedRPG.model.targetable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public abstract class Targetable {
  @Setter @Getter protected int healthPoint;
  @Setter protected double damageResistance = 1;
  
  public void getDamage(int amount){
    this.healthPoint -= (int) (amount * damageResistance);
  }
  
}
