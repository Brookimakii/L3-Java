package org.example.TextBasedRPG;

import java.util.Scanner;
import org.example.TextBasedRPG.model.targetable.Character;
import org.example.TextBasedRPG.model.targetable.Monster;
import org.example.TextBasedRPG.model.targetable.Obstacle;
import org.example.TextBasedRPG.model.weapons.Weapon;
import org.example.TextBasedRPG.model.weapons.Bow;
import org.example.TextBasedRPG.model.weapons.Spear;
import org.example.TextBasedRPG.model.weapons.Sword;
import org.example.TextBasedRPG.model.weapons.WarHammer;

public class StartRPG {
  public static void main(String[] args) {
    Character player = new Character();
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Choose a name for your character: ");
    String characterName = sc.nextLine();
    player.setName(characterName);
    String classChoices = """
                          Choose a Class among the following:
                          1. Fighter   → A slow big DPS class.
                          2. Rogue     → A swift small DPS class.
                          3. Barbarian → A Tank class.
                          4. Sorcerer  → A Ranged DPS class.
                          5. Clerc     → A Support class.""";
    String raceChoices = """
                         Choose a Specie among the following:
                         1. Elfe      → +INT -CON
                         2. Dwarf     → +STR -DEX
                         3. Human     → +DEX -STR
                         4. Dragonoid → +CON -INT""";
    System.out.println(classChoices);
    int choice;
    for (; ; ) {
      try {
        String userInput = sc.nextLine();
        choice = Integer.parseInt(userInput);
        if (choice < 6 && choice > 0) {
          break;
        }
        System.out.println("Invalid choice.");
      } catch (NumberFormatException e) {
        System.out.println("Invalid input.");
      }
    }
    switch (choice) {
      case 1 -> player.setCharacterClass("Fighter");
      case 2 -> player.setCharacterClass("Rogue");
      case 3 -> player.setCharacterClass("Barbarian");
      case 4 -> player.setCharacterClass("Sorcerer");
      case 5 -> player.setCharacterClass("Clerc");
    }
    
    System.out.println(raceChoices);
    choice = 0;
    for (; ; ) {
      try {
        String userInput = sc.nextLine();
        choice = Integer.parseInt(userInput);
        if (choice < 5 && choice > 0) {
          break;
        }
        System.out.println("Invalid choice.");
      } catch (NumberFormatException e) {
        System.out.println("Invalid input.");
      }
    }
    switch (choice) {
      case 1 -> {
        player.setCharacterSpecie("Elfe");
        player.updateInt(5);
        player.updateDex(-5);
      }
      case 2 -> {
        player.setCharacterSpecie("Dwarf");
        player.updateDex(5);
        player.updateCon(-5);
      }
      case 3 -> {
        player.setCharacterSpecie("Human");
        player.updateInt(5);
        player.updateStr(-5);
      }
      case 4 -> {
        player.setCharacterSpecie("Dragonoid");
        player.updateCon(5);
        player.updateInt(-5);
      }
    }
    
    System.out.println("Here is 10po.");
    player.setMoney(10);
    
    System.out.println("Setting up HP");
    player.setMaxHealth(player.getConstitution() * 2);
    System.out.println("HP set to " + player.getMaxHealth() + ".");
    
    System.out.println("Setting up MP");
    player.setMaxMana((int) (player.getIntelligence() * 1.5));
    System.out.println("MP set to " + player.getMaxMana() + ".");
    
    player.playerSleep();
    
    //CHARACTER SET
    
    player.printCharacterSheet();
    
    
    letsDoSomeShopping(player);
    
    battleAgainstAPeskyGoblin(player);
    
    epicBattleAgainstTheAllMightyRock(player);
  }
  
  private static void letsDoSomeShopping(Character player) {
    Shop weaponShop = new Shop();
    populateShop(weaponShop);
    System.out.println(weaponShop.welcomePlayer());
    buyingLoop(player, weaponShop);
    
    System.out.println(player);
    player.getWeapons().forEach(w -> System.out.println(w.getAsciiArt()));
    System.out.println(weaponShop);
  }
  
  private static void battleAgainstAPeskyGoblin(Character player) {
    Monster monster = new Monster();
    monster.setHealthPoint(20);
    System.out.println("Ho no! A goblin is blocking the road!");
    do {
      System.out.println("What to do?\n1. Attack\n2. Do Nothing");
      Scanner sc = new Scanner(System.in);
      try {
        
        String input = sc.nextLine();
        int choice = Integer.parseInt(input);
        
        switch (choice) {
          case 1: {
            player.getWeapons().get(0).attackTarget(monster);
            System.out.println(
                "The goblin looses " + player.getWeapons().get(0).getPower() + "HP!");
          }
          case 2:
            System.out.println("You stay idle.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input");
      }
      
    } while (monster.getHealthPoint() > 0);
    System.out.println("Yey! The goblin is defeated!");
  }
  
  private static void epicBattleAgainstTheAllMightyRock(Character player) {
    Obstacle obstacle = new Obstacle();
    obstacle.setHealthPoint(20);
    obstacle.setDamageResistance(0.5);
    System.out.println("Ho no! A rock is blocking the road!");
    do {
      System.out.println("What to do?\n1. Attack\n2. Do Nothing");
      Scanner sc = new Scanner(System.in);
      try {
        
        String input = sc.nextLine();
        int choice = Integer.parseInt(input);
        
        switch (choice) {
          case 1: {
            player.getWeapons().get(0).attackTarget(obstacle);
            System.out.println(
                "The rock looses " + (int) (player.getWeapons().get(0).getPower() / 2) + "HP!");
          }
          case 2:
            System.out.println("You stay idle.");
        }
      } catch (NumberFormatException e) {
        System.out.println("Invalid input");
      }
      player.getWeapons().get(0).attackTarget(obstacle);
    } while (obstacle.getHealthPoint() > 0);
    System.out.println("Yey! The rock is destroy!");
  }
  
  private static void buyingLoop(Character player, Shop weaponShop) {
    Scanner sc = new Scanner(System.in);
    for (; ; ) {
      try {
        String input = sc.nextLine();
        int choice = Integer.parseInt(input);
        Weapon weaponToBuy = weaponShop.getWeapons().get(choice - 1);
        
        if (player.getMoney() >= weaponToBuy.getPrice()) {
          
          weaponShop.removeToInventory(weaponToBuy);
          player.addWeapon(weaponToBuy);
          player.updateMoney(-weaponToBuy.getPrice());
          
          System.out.println("Thank you for your purchase");
          break;
        } else {
          System.out.println("Sorry sir, but you do not have enough money.");
        }
      } catch (IndexOutOfBoundsException e) {
        System.out.println("Sorry sir, I do not possess that item.");
      } catch (NumberFormatException e) {
        System.out.println("Sorry sir but I am not sure of what you are asking me.");
      }
    }
  }
  
  private static void populateShop(Shop weaponShop) {
    weaponShop.addToInventory(new Sword());
    weaponShop.addToInventory(new Bow());
    weaponShop.addToInventory(new Spear());
    weaponShop.addToInventory(new WarHammer());
  }
}
