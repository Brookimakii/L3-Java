package org.example.RPGUI;

import org.example.RPGUI.game.Game;
import org.example.RPGUI.game.GameInputs;
import org.example.RPGUI.ui.DialogBoxStart;
import org.example.RPGUI.ui.GamePanel;

import javax.swing.*;

public class MainGUI {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setSize(800, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("My Game");
        window.setVisible(true);

        // display start menu where to define your character and set game inputs variables
        GameInputs gameInputs = new GameInputs();
        //new DialogBoxStart(gameInputs);
        System.out.println(gameInputs.getPlayerName());
        System.out.println(gameInputs.getPlayerCast());

        // create game
        Game game = new Game(gameInputs);
        // Create the main panel in which graphical components will be defined
        GamePanel gamePanel = new GamePanel(game);
        window.add(gamePanel);
        
        
        
        gamePanel.requestFocusInWindow();
        window.pack();
        window.setVisible(true);
        //window.validate();

    }
}
