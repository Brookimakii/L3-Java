package org.example.TextBasedRPG.model.targetable;

import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.TextBasedRPG.model.weapons.Weapon;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Character {
  //Character Personal Infos
  private String name;
  private String characterClass;
  private String characterSpecie;
  
  //Character Stats
  private int strength = 10;
  private int dexterity = 10;
  private int constitution = 10;
  private int intelligence = 10;
  
  //Character Special Stat
  private int maxHealth;
  private int curHealth;
  private int maxMana;
  private int curMana;
  
  //Equipment
  private Weapon equipedWeapon;
  
  //Inventory
  private ArrayList<Weapon> weapons = new ArrayList<>();
  private double money;
  
  public void updateStr(int amount) {this.strength += amount;}
  
  public void updateDex(int amount) {this.dexterity += amount;}
  
  public void updateCon(int amount) {this.constitution += amount;}
  
  public void updateInt(int amount) {this.intelligence += amount;}
  
  public void updateMoney(double amount) {
    this.money += amount;
  }
  
  public void addWeapon(Weapon w) {
    weapons.add(w);
  }
  
  public void playerSleep() {
    this.curHealth = this.maxHealth;
    this.curMana = this.maxMana;
  }
  
  public void printCharacterSheet() {
    String sheet = """
                   Name: %s
                   Class: %s
                   Specie: %s
                   | Str | Dex | Con | Int |
                   |-----|-----|-----|-----|
                   |  %d |  %d |  %d |  %d |
                   HP: %d/%d
                   MP: %d/%d
                   Money: %2f po.
                   Weapon %s.
                   """.formatted(name, characterClass, characterSpecie, strength, dexterity,
        constitution, intelligence,curHealth,maxHealth,curMana,maxMana,money,equipedWeapon);
    
    System.out.println();
  }
  
}
