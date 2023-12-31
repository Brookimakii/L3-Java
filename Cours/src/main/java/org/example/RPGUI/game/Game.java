package org.example.RPGUI.game;

import lombok.Getter;

@Getter
public class Game {

    private final GameMap map;

    private final Player player;

    public Game(GameInputs gameInputs) {
        this.player = new Player(gameInputs.getPlayerName(), gameInputs.getPlayerCast());
        this.map = new GameMap();
    }
    
}
