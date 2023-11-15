package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.controller.handler.NormaObserver;
import cl.uchile.dcc.citricliquid.controller.phases.IPhase;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;
import cl.uchile.dcc.citricliquid.model.board.IPanels;
import cl.uchile.dcc.citricliquid.model.board.panels.HomePanel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class represents a player in the game 99.7% Citric Liquid.
 */
public class Player extends Fighter{
  private final String name;
  private int normaLevel;
  private int wins;
  private String normaGoal;
  private HomePanel home;
  IPanels actualPanel;
  private boolean moving;
  private final PropertyChangeSupport normaNotification= new PropertyChangeSupport(this);
  private final PropertyChangeSupport HomeNotification= new PropertyChangeSupport(this);
  private final PropertyChangeSupport PlayerNotification= new PropertyChangeSupport(this);
  private final PropertyChangeSupport PanelNotification= new PropertyChangeSupport(this);

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
    normaGoal = "Stars";
    moving=false;
  }

  /**
   * go to decision phase (defend or dodge)
   * @param atkF the dmg that the enemy attacks
   */
  @Override
  public void atacado(int atkF) throws ActionException {
    state.toPlayerDecisionPhase(atkF);
  }

  /**
   * Increases this player's wind count by an amount.
   */
  public void increaseWinsBy(final int amount) {
    wins += Math.max(0, amount);
  }

  /**
   * Returns the player's home panel
   */
  public HomePanel getHomePanel() {
    return home;
  }

  /**
   * Returns this player's wins count.
   */
  public int getWins() {
    return wins;
  }

  /**
   * Returns true if the player is moving
   * else False
   */
  public boolean isMoving() {
    return moving;
  }

  /**
   * Returns the character's name.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the character's Norma Goal
   */
  public String getNormaGoal() {
    return normaGoal;
  }

  /**
   * Returns the current norma level.
   */
  public int getNormaLevel() {
    return normaLevel;
  }

  /**
   * Returns the current panel
   */
  public IPanels getPanel() {
    return actualPanel;
  }

  /**
   * Updates de panel where the player is
   * fire some changes if the panel is special one
   * @param newPanel new panel
   */
  public void setActualPanel(IPanels newPanel){
    actualPanel=newPanel;
    if(this.getHomePanel().getId()==newPanel.getId()) {
      HomeNotification.firePropertyChange("aHome", false,true);
    }

    else if(newPanel.getPlayers().size()>1) {
      PlayerNotification.firePropertyChange("aPlayer", false, true);
    }

    else if(newPanel.getNextPanels().size()>1) {
      PanelNotification.firePropertyChange("Panels",
              false, true);
    }
  }


  /**
   * Set the player's Home panel
   */
  public void setHomePanel(HomePanel home) {
    this.home = home;
    home.setOwner(this);
  }

  /**
   * Set true if the player is moving
   * else False
   */
  public void setMoving(boolean mov) {
    moving=mov;
  }

  /**
   * Set the player's norma goal
   */
  public void setNormaGoal(String normaGoal) {
    this.normaGoal = normaGoal;
  }

  /**
   * Set fighter's turn phase
   */
  public void setState(IPhase phase) {
    this.state= phase;
    state.setPlayer(this);
  }

  /**
   * Performs a norma clear action; the {@code norma} counter increases in 1.
   */
  public void normaClear() {
    normaLevel++;
    normaNotification.firePropertyChange("NewNormaLevel",normaLevel-1,normaLevel);
  }

  /**
   * Add a listener in the player's norma
   * @param Listener new Listener
   */
  public void addNormaLevelListener(PropertyChangeListener Listener){
    normaNotification.addPropertyChangeListener(Listener);
  }

  /**
   * Add a listener to home panel type in the route
   * @param Listener new Listener
   */
  public void addHomeListener(PropertyChangeListener Listener){
    HomeNotification.addPropertyChangeListener(Listener);
  }

  /**
   * Add a listener to players in the panel to fight
   * @param Listener new Listener
   */
  public void addPlayersListener(PropertyChangeListener Listener){
    PlayerNotification.addPropertyChangeListener(Listener);
  }

  /**
   * Add a listener in the panels to decide the road
   * @param Listener new Listener
   */
  public void addPanelsListener(PropertyChangeListener Listener){
    PanelNotification.addPropertyChangeListener(Listener);
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
