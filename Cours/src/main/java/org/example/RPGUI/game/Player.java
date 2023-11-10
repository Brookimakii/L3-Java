package org.example.RPGUI.game;

import lombok.Getter;

@Getter
public class Player {

    private final String name;

    private final PlayerCast cast;

    public Player(String n, PlayerCast c) {
        this.name = n;
        this.cast = c;
    }
    
    
}
