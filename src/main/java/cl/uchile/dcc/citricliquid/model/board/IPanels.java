package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

/**
 * This interface represents a panel in the board of the game.
 */
public interface IPanels {

    /**
     * Returns the id of the panel
     */
    int getId();

    /**
     * Returns a copy of this panel's next ones.
     */
    Set<IPanels> getNextPanels();

    /**
     * Returns a copy of this panel's next ones.
     */
    List<Player> getPlayers();

    /**
     * Adds a new adjacent panel to this one.
     *
     * @param Panel the panel to be added.
     */
    void addNextPanel(final IPanels Panel);

    /**
     * Adds a new player in the panel
     * @param player
     */
    void addPlayer(Player player);

    /**
     * Remove the player from the panel
     * @param player
     */
    void removePlayer(Player player);

    /**
     * Activate the Panel's effect.
     *
     * @param player the player who activates the effect.
     */
    void activate(final @NotNull Player player);

    IPanels getLeft();

    IPanels getRight();

    IPanels getUp();

    IPanels getDown();

    void setLeft(IPanels left);

    void setRight(IPanels right);

    void setUp(IPanels up);

    void setDown(IPanels down);
}
