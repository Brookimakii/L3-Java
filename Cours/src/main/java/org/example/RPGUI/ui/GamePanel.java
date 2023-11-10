package org.example.RPGUI.ui;


import org.example.RPGUI.game.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final MapPanel mapPanel;


    public GamePanel(Game game) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);

        // Add MapPanel to GamePanel
        this.mapPanel = new MapPanel(game.getMap());
        this.add(mapPanel, BorderLayout.NORTH);

        //TODO: Add PlayerInfoPanel to GamePanel
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 500);
    }


}
