package org.example.TextBasedRPG;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.example.TextBasedRPG.model.MainMap;
import org.example.TextBasedRPG.model.MapI;
import org.example.TextBasedRPG.model.targetable.Character;
import org.example.TextBasedRPG.model.targetable.Monster;
import org.example.TextBasedRPG.model.targetable.Obstacle;
import org.example.TextBasedRPG.model.weapons.Weapon;
import org.example.TextBasedRPG.model.weapons.Bow;
import org.example.TextBasedRPG.model.weapons.Spear;
import org.example.TextBasedRPG.model.weapons.Sword;
import org.example.TextBasedRPG.model.weapons.WarHammer;

public class StartRPG {
  //☒
  //TODO: GAMEPLAY LOOP:
  // - Menu avec option: Déplacement, Inventaire, Status.
  //   ☒ Menu Déplacement: Movement; Nord, Sud, Est, Ouest.
  //   ☒ Menu Inventaire: Visionnage du contenue de l'inventaire: or, équipement actuel et en
  //   réserve.
  //   ☒ Menu Status: Visionnage de la fiche de status: race, classe, état actuel, ...
  // - Lors de Déplacement chance aléatoire de déclencher un combat:
  //   ☒ Choix de l'action: Attaquer, Fuir.
  
  private static final MainMap mainMap = new MainMap();
  private static final Character player = new Character();
  private static final Shop weaponShop = new Shop();
  
  
  public static void main(String[] args) {
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
    ArrayList<String> classChoice = new ArrayList<>(
        List.of("Fighter   → A slow big DPS class.", "Rogue     → A swift small DPS class.",
            "Barbarian → A Tank class.", "Sorcerer  → A Ranged DPS class.",
            "Clerc     → A Support class."
        ));
    ArrayList<String> raceChoice = new ArrayList<>(
        List.of("Elfe      → +INT -CON", "Dwarf     → +STR -DEX", "Human     → +DEX -STR",
            "Dragonoid → +CON -INT"
        ));
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
    
    ArrayList<Weapon> shoppingItems =
        new ArrayList<>(List.of(new Sword(), new Bow(), new Spear(), new WarHammer()));
    shoppingItems.forEach(weaponShop::addToInventory);
    
    mainGameplayLoop();
    
    System.out.println("Congratulation! you've arrived to the end!");


//    letsDoSomeShopping(player);
//
//    battleAgainstAPeskyGoblin(player);
//
//    epicBattleAgainstTheAllMightyRock(player);
  }
  
  private static void mainGameplayLoop() {
    while (!mainMap.doPlayerArrived()) {
      ArrayList<String> mainChoices =
          new ArrayList<>(List.of("Déplacement", "Inventaire", "Status", "Shop", "Close"));
      switch (playerChoice(mainChoices)) {
        case 1:
          movementLoop();
          break;
        case 2:
          inventoryLoop();
          break;
        case 3:
          statusLoop();
          break;
        case 4:
          shopLoop();
          break;
        case 5:
          return;
      }
    }
  }
  
  private static void movementLoop() {
    while (!mainMap.doPlayerArrived()) {
      mainMap.printMap();
      ArrayList<String> movementChoice =
          new ArrayList<>(List.of("Nord", "Est", "Sud", "Ouest", "Exit"));
      int choice = playerChoice(movementChoice);
      System.out.println(choice);
      switch (choice) {
        case 1:
          System.out.println("Moving North.");
          mainMap.moveTo(MapI.Direction.North);
          break;
        case 2:
          System.out.println("Moving Est.");
          mainMap.moveTo(MapI.Direction.Est);
          break;
        case 3:
          System.out.println("Moving South.");
          mainMap.moveTo(MapI.Direction.South);
          break;
        case 4:
          System.out.println("Moving West.");
          mainMap.moveTo(MapI.Direction.West);
          break;
        case 5:
          System.out.println("Stopping Moving.");
          return;
      }
      if (mainMap.doRansomEncounter()) {
        battleLoop();
      }
    }
  }
  
  private static void battleLoop() {
    Monster goblin = new Monster(20);
    ArrayList<String> battleChoice = new ArrayList<>(List.of("Attack", "Flee"));
    System.out.println("Ho no! A goblin is blocking the road!");
    do {
      switch (playerChoice(battleChoice)) {
        case 1: {
          player.getEquipedWeapon().attackTarget(goblin);
          System.out.println("The goblin looses " + player.getEquipedWeapon().getPower() + "HP!");
          break;
        }
        case 2: {
          double fleeRate = Math.random() * player.getDexterity();
          if (fleeRate >= 0.5) {
            System.out.println("You manage to flee.");
            return;
          } else {
            System.out.println("You try to flee... but you somehow fail...");
          }
          break;
        }
      }
    } while (goblin.getHealthPoint() > 0);
    System.out.println("Yey! The goblin is defeated!");
  }
  
  private static void inventoryLoop() {
    for (; ; ) {
      System.out.printf("""
                        --- Player Equipment Sheet ---
                        Current Gold: .0%fpo.
                        ==============================
                        Equipped Weapon: %s
                        %n""", player.getMoney(), player.getEquipedWeapon());
      ArrayList<String> inventoryLoop = new ArrayList<>(List.of("Equip Weapon.", "Exit"));
      switch (playerChoice(inventoryLoop)) {
        case 1: {
          ArrayList<String> weaponToEquip = new ArrayList<>();
          player.getWeapons().forEach(weapon -> weaponToEquip.add(weapon.getName()));
          int choice = playerChoice(weaponToEquip);
          if (choice == weaponToEquip.size() + 1) {
            return;
          } else {
            player.setEquipedWeapon(player.getWeapons().get(choice - 1));
          }
          break;
        }
        case 2:
          return;
      }
    }
    
  }
  
  private static void statusLoop() {
    for (; ; ) {
      System.out.printf("""
                        -------- Player Status Sheet --------
                        Name:    %s
                        Species: %s
                        Class:   %s
                        =====================================
                        Strength: %d             HP: %d/%d
                        Dexterity: %d            MP: %d/%d
                        Constitution: %d
                        Intelligence: %d
                        =====================================
                        %n""", player.getName(), player.getCharacterSpecie(),
          player.getCharacterClass(), player.getStrength(), player.getCurHealth(),
          player.getMaxHealth(), player.getDexterity(), player.getCurMana(), player.getMaxMana(),
          player.getConstitution(), player.getIntelligence()
      );
      ArrayList<String> statusList = new ArrayList<>(List.of("Exit"));
      if (playerChoice(statusList) == 1) {
        return;
      }
    }
  }
  
  private static void shopLoop() {
    for (; ; ) {
      ArrayList<String> shoppingChoices = new ArrayList<>();
      weaponShop.getWeapons().forEach(weapon -> shoppingChoices.add(
          weapon.getName() + " - " + weapon.getPower() + " " + weapon.getDamageType() + " -- "
          + weapon.getPrice() + "po."));
      shoppingChoices.add("Exit");
      
      int choice = playerChoice(shoppingChoices);
      if (choice == shoppingChoices.size()) {
        return;
      }
      
      Weapon weaponToBuy = weaponShop.getWeapons().get(choice - 1);
      
      if (player.getMoney() >= weaponToBuy.getPrice()) {
        weaponShop.removeToInventory(weaponToBuy);
        player.addWeapon(weaponToBuy);
        player.updateMoney(-weaponToBuy.getPrice());
        System.out.println("Thank you for your purchase");
      } else {
        System.out.println("Sorry sir, but you do not have enough money.");
      }
    }
  }
  
  private static int playerChoice(ArrayList<String> choices) {
    Scanner sc = new Scanner(System.in);
    for (; ; ) {
      try {
        for (String element : choices) {
          System.out.println(choices.indexOf(element) + 1 + ". " + element);
        }
        int choice = sc.nextInt();
        if (choice > 0 && choice <= choices.size()) {
          return choice;
        } else {
          System.err.println("Invalid Input: Out of bound.");
        }
      } catch (NumberFormatException e) {
        System.err.println("Invalid Input: Not a number.");
      }
    }
  }
  /*
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
    Monster monster = new Monster(20);
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
  */
}
