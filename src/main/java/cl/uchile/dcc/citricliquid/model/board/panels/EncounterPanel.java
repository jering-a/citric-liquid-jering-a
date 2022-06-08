package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import cl.uchile.dcc.citricliquid.model.enemies.WildUnit;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a Encounter Panel in the game 99.7% Citric Liquid.
 */
public class EncounterPanel extends AbstractPanel {

    private WildUnit wild;

    /**
     * Creates a new Encounter panel.
     */
    public EncounterPanel() {
    }

    /**
     * Sets the Wild Unit to fight.
     */
    public void setWildUnit(WildUnit wild){
        this.wild=wild;
    }

    /**
     * Try to start a wild battle.
     *
     * @param player the player who activates the effect.
     */
    @Override
    public void activate(@NotNull Player player) {
        System.out.println("Start Wild Battle");
    }
}
