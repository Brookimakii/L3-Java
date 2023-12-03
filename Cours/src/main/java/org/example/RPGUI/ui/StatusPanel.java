package org.example.RPGUI.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import org.example.RPGUI.game.Game;
import org.example.RPGUI.game.Player;

import javax.swing.table.DefaultTableModel;
import java.awt.GridBagConstraints;


public class StatusPanel extends JPanel {
  private JLabel nameLabel;
  private JLabel classLabel;
  private JLabel specieLabel;
  private JLabel hpLabel;
  private JLabel mpLabel;
  private JLabel moneyLabel;
  
  
  private JTable statsTable;
  private JScrollPane statsScrollPane;
  
  
  private JButton[] equipmentButtons;
  
  private Player player;
  
  public StatusPanel(Game game) {
    this.player = game.getPlayer();
    initComponents();
    buildUI();
    updatePlayerInfo();
    updatePlayerStats();
  }
  
  private void initComponents() {
    nameLabel = new JLabel("Name: ");
    classLabel = new JLabel("Class: ");
    specieLabel = new JLabel("Specie: ");
    hpLabel = new JLabel("HP: ");
    mpLabel = new JLabel("MP: ");
    moneyLabel = new JLabel("Money: ");
    
    String[] columnNames = {"Stat", "Value"};
    Object[][] data = {
        {"Strength", player.getStrength()}, {"Dexterity", player.getDexterity()},
        {"Constitution", player.getConstitution()}, {"Intelligence", player.getIntelligence()},
        // Add other stats as needed
    };
    statsTable = new JTable(data, columnNames);
    statsScrollPane = new JScrollPane(statsTable);
    
    equipmentButtons = new JButton[player.getEquipmentSlots().size()];
    int index = 0;
    for (String slot : player.getEquipmentSlots().keySet()) {
      equipmentButtons[index] = new JButton(slot);
      int finalIndex = index;
      equipmentButtons[index].addActionListener(e -> equipItem(finalIndex, slot));
      index++;
    }
  }
  
  private void buildUI() {
    setLayout(new BorderLayout());
    
    JPanel playerInfoPanel = new JPanel(new GridLayout(3, 2));
    playerInfoPanel.add(nameLabel);
    playerInfoPanel.add(hpLabel);
    playerInfoPanel.add(classLabel);
    playerInfoPanel.add(mpLabel);
    playerInfoPanel.add(specieLabel);
    playerInfoPanel.add(moneyLabel);
    
    JPanel statsPanel = new JPanel(new BorderLayout());
    statsPanel.setBorder(BorderFactory.createTitledBorder("Player Stats"));
    statsPanel.add(statsScrollPane, BorderLayout.CENTER);
    
    JPanel equipmentPanel = new JPanel();
    equipmentPanel.setLayout(new BoxLayout(equipmentPanel, BoxLayout.Y_AXIS)); // Set layout to BoxLayout with Y_AXIS alignment
    equipmentPanel.setBorder(BorderFactory.createTitledBorder("Equipment Slots"));
    for (JButton button : equipmentButtons) {
      equipmentPanel.add(button);
    }
    
    // Add components to StatusPanel
    add(playerInfoPanel, BorderLayout.NORTH);
    add(statsPanel, BorderLayout.CENTER);
    add(equipmentPanel, BorderLayout.EAST);
  }
  
  public void updatePlayerInfo() {
    nameLabel.setText("Name: " + player.getName());
    classLabel.setText("Class: " + player.getCharacterClass());
    specieLabel.setText("Specie: " + player.getCharacterSpecie());
    hpLabel.setText("HP: " + player.getCurHealth() + "/" + player.getMaxHealth());
    mpLabel.setText("MP: " + player.getCurMana() + "/" + player.getMaxMana());
    moneyLabel.setText("Money: " + player.getMoney() + " po.");
  }
  
  public void updatePlayerStats() {
    // Update the JTextArea with the player's stats
    String[][] newData = {
        {"Strength", String.valueOf(player.getStrength())},
        {"Dexterity", String.valueOf(player.getDexterity())},
        {"Constitution", String.valueOf(player.getConstitution())},
        {"Intelligence", String.valueOf(player.getIntelligence())},
        // Add other stats as needed
    };
    statsTable.setModel(new DefaultTableModel(newData, new String[] {"Stat", "Value"}));
  }
  
  public void updateEquipment() {
    int index = 0;
    for (Map.Entry<String, String> entry : player.getEquipmentSlots().entrySet()) {
      String slotName = entry.getKey();
      String itemName = entry.getValue();
      equipmentButtons[index].setText(
          slotName + ": " + (itemName != null && !itemName.isEmpty() ? itemName : "Empty"));
      index++;
    }
  }
  
  private void equipItem(int buttonIndex, String slot) {
    // TODO: Should filter inventory for only item available of that slot.
    String selectedItem =
        (String) JOptionPane.showInputDialog(this, "Select an item to equip in " + slot + ":",
            "Equip Item", JOptionPane.QUESTION_MESSAGE, null, player.getInventory().toArray(), null
        );
    
    if (selectedItem != null) {
      player.equipItem(slot, selectedItem);
      updateEquipment();
    }
  }
}
