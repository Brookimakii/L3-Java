package org.example.TextBasedRPG.model.targetable;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class Obstacle extends Targetable {
  private static final double DAMAGE_RESISTANCE = 0.5;
}
