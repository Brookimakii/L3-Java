package org.example.TextBasedRPG.model.targetable;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Monster extends Targetable {
  
  public Monster(int health){
    super(health);
  }
}
