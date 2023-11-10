package org.example.RPGUI.game;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GameInputs {
    @Setter private String playerName;
    @Setter private PlayerCast playerCast;

    public GameInputs() {
        this.playerName = "";
        this.playerCast = null;
    }

}
