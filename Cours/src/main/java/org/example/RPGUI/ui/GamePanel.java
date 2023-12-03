package org.example.RPGUI.ui;


import lombok.Getter;
import org.example.RPGUI.game.Game;

import javax.swing.*;
import java.awt.*;
import org.example.RPGUI.listener.KeysListener;

public class GamePanel extends JPanel {
  private CardLayout cardLayout;
  private JPanel cardPanel;
  @Getter private String currentPanelName;
  
  
  @Getter private final MapPanel mapPanel;
  @Getter private final StatusPanel statusPanel;
  @Getter private final ShopPanel shopPanel;
  
  
  public GamePanel(Game game) {
    this.setFocusable(true);
    
    this.setLayout(new BorderLayout());
    this.setBackground(Color.BLACK);
    
    // Add MapPanel to GamePanel
    cardLayout = new CardLayout();
    cardPanel = new JPanel(cardLayout);
    
    this.mapPanel = new MapPanel(game);
    this.statusPanel = new StatusPanel(game);
    this.shopPanel = new ShopPanel(game, this);
    
    cardPanel.add(mapPanel, "Map");
    cardPanel.add(statusPanel, "Status");
    cardPanel.add(shopPanel, "Shop");
    
    showPanel("Map");
    
    this.addKeyListener(new KeysListener(this));
    
    
    this.add(cardPanel, BorderLayout.NORTH);
    
    //TODO: Add Button presses Listener to listen to...
    // UP       → Go up if possible
    // DOWN     → Go down if possible
    // LEFT     → Go left if possible
    // RIGHT    → Go right if possible
    // ENTER    → Open Menu...
    //  1_Shop
    //  2_Status Window + Inventory
    
    
    //TODO: Add PlayerInfoPanel & Inventory to GamePanel. Theses Panel should do...
    // showing Player Stats
    // changing current weapon
    
    //TODO: Add Shop Panel
    //TODO: Add Battle Panel
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(800, 500);
  }
  
  public void showPanel(String panelName){
    cardLayout.show(cardPanel, panelName);
    currentPanelName = panelName;
    System.out.println(panelName);
  }
}
