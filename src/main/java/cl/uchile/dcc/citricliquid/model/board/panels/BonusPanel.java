package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a Bonus Panel in the game 99.7% Citric Liquid.
 */
public class BonusPanel extends AbstractPanel {

    /**
     * Creates a new Bonus panel.
     */
    public BonusPanel(int id) {
        super(id);
    }

    /**
     * Increase the player's star count by the D6 roll multiplied by the minimum between the player's
     * norma level and three.
     */
    @Override
    public void activate(@NotNull Player player) {
        player.increaseStarsBy(player.roll() * Math.min(player.getNormaLevel(), 3));
    }

}
