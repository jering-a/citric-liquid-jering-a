package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a Draw Panel in the game 99.7% Citric Liquid.
 */
public class DrawPanel extends AbstractPanel {

    /**
     * Creates a new Draw panel.
     */
    public DrawPanel(int id) {
        super(id);
    }

    /**
     * Activate the Panel's effect.
     *
     * @param player the player who activates the effect.
     */
    @Override
    public void activate(@NotNull Player player) {
        System.out.println("Take a Card");
    }
}
