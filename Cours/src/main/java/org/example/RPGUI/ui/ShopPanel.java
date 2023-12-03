package org.example.RPGUI.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import org.example.RPGUI.game.Game;
import org.example.RPGUI.game.Player;

public class ShopPanel extends JPanel {
  private Player player;
  private GamePanel gamePanel;
  
  private JLabel moneyLabel;
  private DefaultListModel<String> shopListModel;
  private JList<String> shopList;
  
  public ShopPanel(Game game, GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    this.player = game.getPlayer();
    initComponents();
    buildUI();
  }
  
  private void initComponents() {
    setLayout(new BorderLayout());
    
    moneyLabel = new JLabel("Money: " + player.getMoney() + " po");
    
    shopListModel = new DefaultListModel<>();
    // TODO: WEAPONS
    shopListModel.addElement("Sword - 10 po");
    shopListModel.addElement("Shield - 5 po");
    shopListModel.addElement("Fist - 0 po");
    
    shopList = new JList<>(shopListModel);
    shopList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
    JButton buyButton = new JButton("Buy");
    buyButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        buySelectedItem();
      }
    });
    
    JButton backButton = new JButton("Back");
    backButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Call a method to go back to the map
        returnToMap();
      }
    });
    
    JPanel buttonPanel = new JPanel(new GridLayout(1, 2)); // 1 row, 2 columns
    buttonPanel.add(buyButton);
    buttonPanel.add(backButton);
    
    add(moneyLabel, BorderLayout.NORTH);
    add(new JScrollPane(shopList), BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);
  }
  
  private void buildUI() {
    // Set UI properties, if needed
  }
  
  private void buySelectedItem() {
    int selectedIndex = shopList.getSelectedIndex();
    if (selectedIndex != -1) {
      String selectedItem = shopListModel.get(selectedIndex);
      // Extract item name and price from the selected item string
      String[] parts = selectedItem.split(" - ");
      if (parts.length == 2) {
        String itemName = parts[0];
        double itemPrice = Double.parseDouble(parts[1].replace(" po", ""));
        if (player.getMoney() >= itemPrice) {
          // Deduct money from the player
          player.updateMoney(-itemPrice);
          moneyLabel.setText("Money: " + player.getMoney() + " po");
          
          // Add the bought item to the player's inventory
          player.addToInventory(itemName);
          
          // Remove the item from the shop
          shopListModel.remove(selectedIndex);
          
          // Update the equipment section
          // You need to call the appropriate method to update the equipment section
          // This might involve updating the model or directly interacting with the UI
          // For example: equipmentPanel.updateEquipment();
        } else {
          JOptionPane.showMessageDialog(this, "Not enough money to buy this item.");
        }
      }
    }
  }
  private void returnToMap() {
      gamePanel.showPanel("Map");
  }
}
