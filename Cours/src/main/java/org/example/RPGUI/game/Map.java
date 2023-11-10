package org.example.RPGUI.game;

import lombok.Getter;

@Getter
public class Map {
    static final int[][] MAP_TEMPLATE_DEFAULT = {
            {2, 0, 1, 1},
            {1, 0, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 0, 0},
    };

    private final int[][] map;

    public Map() {
        this.map = MAP_TEMPLATE_DEFAULT;
    }
    
    
}
