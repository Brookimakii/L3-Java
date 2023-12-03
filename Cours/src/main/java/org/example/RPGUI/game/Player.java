package org.example.RPGUI.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import org.example.TextBasedRPG.model.weapons.Weapon;

@Getter
public class Player {
    private final PlayerCast cast;
    
    public Player(String n, PlayerCast c) {
        this.name = n;
        this.cast = c;
    }
    
    //Character Personal Infos
    private final String name;
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
    
    private final Map<String, String> equipmentSlots = new HashMap<>(Map.of(
        "Helmet","",
        "Chestplate","",
        "Weapon",""
    ));
    
    
    //Inventory
    private final List<String> inventory = new ArrayList<>();
    private double money;
    
    // Change Player Stats
    public void updateStr(int amount) {this.strength += amount;}
    public void updateDex(int amount) {this.dexterity += amount;}
    public void updateCon(int amount) {this.constitution += amount;}
    public void updateInt(int amount) {this.intelligence += amount;}
    
    
    
    
    public void updateMoney(double amount) {
        this.money += amount;
    }
    public void addToInventory(String w) {
        inventory.add(w);
    }
    public void playerSleep() {
        this.curHealth = this.maxHealth;
        this.curMana = this.maxMana;
    }
    
    public void equipItem(String slot, String itemName) {
        // Check if the slot is a valid equipment slot
        if (equipmentSlots.containsKey(slot)) {
            // If there's already an item in the slot, add it to the inventory
            String previousItem = equipmentSlots.get(slot);
            if (previousItem != null && !previousItem.isEmpty()) {
                // Assuming inventory is a list of items
                // You might need to adjust this based on your actual implementation
                inventory.add(previousItem);
            }
            
            // Equip the new item
            equipmentSlots.put(slot, itemName);
            
            // Remove the item from the inventory
            inventory.remove(itemName);
        }
    }
}
