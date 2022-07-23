package cl.uchile.dcc.citricliquid.model.board;

import cl.uchile.dcc.citricliquid.model.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * Class that represents a panel in the board of the game.
 */
public abstract class AbstractPanel implements IPanels{
  private final Set<IPanels> nextPanels;
  private final List<Player> players;
  private int id;
  private IPanels left;
  private IPanels right;
  private IPanels up;
  private IPanels down;

  /**
   * Creates a new panel.
   */
  public AbstractPanel(int id) {
    nextPanels = new HashSet<>();
    players = new ArrayList<Player>();
    this.id=id;
  }

  /**
   * Returns the id of the panel
   */
  @Override
  public int getId() {
    return id;
  }

  /**
   * Returns a copy of this panel's next ones.
   */
  @Override
  public Set<IPanels> getNextPanels() {
    return Set.copyOf(nextPanels);
  }

  /**
   * Return the list of PLayers.
   */
  @Override
  public List<Player> getPlayers() {
    return players;
  }

  /**
   * Adds a new adjacent panel to this one.
   *
   * @param panel the panel to be added.
   */
  @Override
  public void addNextPanel(final IPanels panel) {
    nextPanels.add(panel);
  }

  /**
   * Adds a new player in the panel
   * @param player
   */
  @Override
  public void addPlayer(Player player) {
    players.add(player);
  }

  /**
   * Remove the player from the panel
   * @param player
   */
  @Override
  public void removePlayer(Player player) {
    players.remove(player);
  }

  /**
   * Activate the Panel's effect.
   *
   * @param player the player who activates the effect.
   */
  @Override
  public abstract void activate(final @NotNull Player player);

  @Override
  public IPanels getLeft() {
    return left;
  }

  @Override
  public IPanels getRight() {
    return right;
  }

  @Override
  public IPanels getUp() {
    return up;
  }

  @Override
  public IPanels getDown() {
    return down;
  }

  @Override
  public void setLeft(IPanels left) {
    this.left = left;
  }

  @Override
  public void setRight(IPanels right) {
    this.right = right;
  }

  @Override
  public void setUp(IPanels up) {
    this.up = up;
  }

  @Override
  public void setDown(IPanels down) {
    this.down = down;
  }


}
