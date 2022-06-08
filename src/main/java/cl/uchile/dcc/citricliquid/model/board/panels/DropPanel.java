package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a Drop Panel in the game 99.7% Citric Liquid.
 */
public class DropPanel extends AbstractPanel {

    /**
     * Creates a new Drop panel.
     */
    public DropPanel() {
    }

    /**
     * Reduces the player's star count by the D6 roll multiplied by the player's norma level.
     *
     * @param player the player who activates the effect.
     */
    @Override
    public void activate(@NotNull Player player) {
        player.reduceStarsBy(player.roll() * player.getNormaLevel());
    }
}
