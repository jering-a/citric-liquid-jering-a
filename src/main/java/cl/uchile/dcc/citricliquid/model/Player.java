package cl.uchile.dcc.citricliquid.model;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends Fighter{
  private final String name;
  private int normaLevel;
  private int wins;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name.
   * @param hp
   *     the initial (and max) hit points of the character.
   * @param atk
   *     the base damage the character does.
   * @param def
   *     the base defense of the character.
   * @param evd
   *     the base evasion of the character.
   */
  public Player(final String name, final int hp, final int atk, final int def,
                final int evd) {
    super(hp, atk, def, evd);
    this.name = name;
    normaLevel = 1;
  }

  /**
   * Increases this player's wind count by an amount.
   */
  public void increaseWinsBy(final int amount) {
    wins += Math.max(0, amount);
  }

  /**
   * Returns this player's wins count.
   */
  public int getWins() {
    return wins;
  }

  /**
   * Returns the character's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the current norma level.
   */
  public int getNormaLevel() {
    return normaLevel;
  }

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  public void normaClear() {
    normaLevel++;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Player)) {
      return false;
    }
    final Player player = (Player) o;
    return getMaxHp() == player.getMaxHp()
           && getAtk() == player.getAtk()
           && getDef() == player.getDef()
           && getEvd() == player.getEvd()
           && getNormaLevel() == player.getNormaLevel()
           && getStars() == player.getStars()
           && getWins() == player.getWins()
           && getCurrentHp() == player.getCurrentHp()
           && getName().equals(player.getName());
  }

  /**
   * Returns a copy of this character.
   */
  public Player copy() {
    return new Player(name, getMaxHp(), getAtk(), getDef(), getEvd());
  }
}
