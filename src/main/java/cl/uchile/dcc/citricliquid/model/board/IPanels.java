package cl.uchile.dcc.citricliquid.model.board;

import java.util.Set;

/**
 * This interface represents a panel in the board of the game.
 */
public interface IPanels {

    /**
     * Returns a copy of this panel's next ones.
     */
    Set<IPanels> getNextPanels();

    /**
     * Adds a new adjacent panel to this one.
     *
     * @param Panel the panel to be added.
     */
    void addNextPanel(final IPanels Panel);
}
