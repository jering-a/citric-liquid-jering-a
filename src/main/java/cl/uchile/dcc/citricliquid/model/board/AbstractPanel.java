package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a panel in the board of the game.
 */
public abstract class AbstractPanel implements IPanels{
  private final Set<IPanels> nextPanels = new HashSet<>();

  /**
   * Creates a new panel.
   */
  public AbstractPanel() {
  }

  /**
   * Returns a copy of this panel's next ones.
   */
  public Set<IPanels> getNextPanels() {
    return Set.copyOf(nextPanels);
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  public void addNextPanel(final IPanels panel) {
    nextPanels.add(panel);
  }

  /**
   * Activate the Panel's effect.
   *
   * @param player the player who activates the effect.
   */
  public abstract void activate(final @NotNull Player player);

}
