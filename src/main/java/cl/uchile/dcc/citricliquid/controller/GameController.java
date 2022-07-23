package cl.uchile.dcc.citricliquid.controller;

import cl.uchile.dcc.citricliquid.controller.handler.HomeObserver;
import cl.uchile.dcc.citricliquid.controller.handler.NormaObserver;
import cl.uchile.dcc.citricliquid.controller.handler.PanelsObserver;
import cl.uchile.dcc.citricliquid.controller.handler.PlayersObserver;
import cl.uchile.dcc.citricliquid.controller.phases.IPhase;
import cl.uchile.dcc.citricliquid.controller.phases.StartTurnPhase;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.TransitionException;
import cl.uchile.dcc.citricliquid.model.IFighter;
import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.IPanels;
import cl.uchile.dcc.citricliquid.model.board.panels.*;
import cl.uchile.dcc.citricliquid.model.enemies.BossUnit;
import cl.uchile.dcc.citricliquid.model.enemies.WildUnit;
import cl.uchile.dcc.citricliquid.model.enemies.bosses.FlyingCastle;
import cl.uchile.dcc.citricliquid.model.enemies.bosses.ShifuRobot;
import cl.uchile.dcc.citricliquid.model.enemies.bosses.StoreManager;
import cl.uchile.dcc.citricliquid.model.enemies.wilds.Chicken;
import cl.uchile.dcc.citricliquid.model.enemies.wilds.RoboBall;
import cl.uchile.dcc.citricliquid.model.enemies.wilds.Seagull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * This class represents a Controller in the game 99.7% Citric Liquid.
 * that is the logical connection between the view and the model, the controller is expected to be able to
 * execute all the operations a player might want, deliver the necessary messages to each object of the model
 * and that saves the most important information of the state of the game at each moment.
 */
public class GameController {
    IPhase phase;
    int chapter;
    private int turn;
    private Random random = new Random();
    private IPanels actualPanel;
    private final List<IPanels> panels;
    private final List<Player> players;
    private Player owner;
    private Player winner = null;
    private final NormaObserver NormaNotification = new NormaObserver(this);
    private final PlayersObserver PlayersNotification=  new PlayersObserver(this);
    private final PanelsObserver PanelsNotification=  new PanelsObserver(this);
    private final HomeObserver HomeNotification=  new HomeObserver(this);
    private int steps;

    /**
     * Creates a new Game Controller
     */
    public GameController() {
        players = new ArrayList<>();
        panels = new ArrayList();
        chapter = 1;
        turn = 1;
        setPhase(new StartTurnPhase());
    }

    /** Generates a player for the game*/
    public Player generatePlayer(String name, int hp, int atk, int def, int evd) {
        return new Player(name, hp, atk, def, evd);
    }

    /**
     * Adds a player to the players list
     *
     * @param aPlayer the player to add
     */
    public void addPlayer(Player aPlayer) {
        players.add(aPlayer);
    }

    /**
     * Method that return the list of players
     * @return copy of players
     */
    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    /**
     * Generates the Boss for the game
     * @return The Boss for all BossPanels
     */
    public BossUnit createRandomBoss() {
        int boss = random.nextInt(3);
        if (boss == 0) return new FlyingCastle();
        else if (boss == 1) return new ShifuRobot();
        else return new StoreManager();
    }

    /**
     * Generates a random wild unit
     * @return The Wild Unit
     */
    public WildUnit createRandomWild() {
        int wild = random.nextInt(3);
        if (wild == 0) return new Chicken();
        else if (wild == 1) return new RoboBall();
        else return new Seagull();
    }

    /**
     * Set a Boss for the boss panel
     */
    public void setBossToPanels(BossUnit boss, BossPanel bossPanel){
        bossPanel.setBoss(boss);
    }

    /**
     * Add a NeutralPanel to the list of Panels
     * @param id the id of the new Panel
     * @return new Neutral Panel
     */
    public NeutralPanel addNeutralPanel(int id) {
        NeutralPanel NP = new NeutralPanel(id);
        addPanel(NP);
        return NP;
    }

    /**
     * Add a BonusPanel to the list of Panels
     * @param id the id of the new Panel
     * @return new Bonus Panel
     */
    public BonusPanel addBonusPanel(int id) {
        BonusPanel BP = new BonusPanel(id);
        addPanel(BP);
        return BP;
    }

    /**
     * Add a BossPanel to the list of Panels
     * @param id the id of the new Panel
     * @return new Boss Panel
     */
    public BossPanel addBossPanel(int id) {
        BossPanel BP = new BossPanel(id);
        addPanel(BP);
        return BP;
    }

    /**
     * Add a DrawPanel to the list of Panels
     * @param id the id of the new Panel
     * @return new Draw Panel
     */
    public DrawPanel addDrawPanel(int id) {
        DrawPanel DP = new DrawPanel(id);
        addPanel(DP);
        return DP;
    }

    /**
     * Add a DropPanel to the list of Panels
     * @param id the id of the new Panel
     * @return new Drop Panel
     */
    public DropPanel addDropPanel(int id) {
        DropPanel DP = new DropPanel(id);
        addPanel(DP);
        return DP;
    }

    /**
     * Add a EncounterPanel to the list of Panels
     * @param id the id of the new Panel
     * @return new Encounter Panel
     */
    public EncounterPanel addEncounterPanel(int id) {
        EncounterPanel EP = new EncounterPanel(id);
        addPanel(EP);
        return EP;
    }

    /**
     * Add a HomePanel to the list of Panels
     * @param id the id of the new Panel
     * @return new Home Panel
     */
    public HomePanel addHomePanel(int id) {
        HomePanel HP = new HomePanel(id);
        addPanel(HP);
        return HP;
    }

    /**
     * Adds panel to list
     * @param panel
     */
    public void addPanel(IPanels panel) {
        panels.add(panel);
    }

    /**
     * Return a Set with all the next panels
     * @param panel the panel
     * @return Set with the next panels
     */
    public Set<IPanels> getNextPanels(IPanels panel) {
        return panel.getNextPanels();
    }

    /**
     * Set a Panel next to the actual
     */
    public void setNextPanel(IPanels panel, IPanels nextPanel) {
        panel.addNextPanel(nextPanel);
    }

    /**
     * Returns a list with all the panels created in the controller
     * @return copy of board
     */
    public List<IPanels> getPanels() {
        return List.copyOf(panels);
    }

    /**
     * Returns the player owner of the turn
     * @return player owner of the turn
     */
    public Player getOwner() {
        owner = players.get((turn - 1) % players.size());
        return owner;
    }

    /**
     * Sets the player owner of the turn
     */
    public void setOwner(Player pl) {
        owner = pl;
    }


    /**
     * Returns the actual Phase.
     */
    public String getPhase(){
        return phase.toString();
    }

    /**
     * Returns the actual Chapter.
     */
    public int getChapter() {
        return chapter;
    }

    /**
     * Returns the winner of the game
     */
    @Nullable
    public Player getWinner() {
        return winner;
    }

    /**
     * set a phase to the controller and set the controller to that phase
     * @param phase
     *      phase to set
     */
    public void setPhase(IPhase phase) {
        this.phase = phase;
        phase.setController(this);
    }

    /**
     * Set the player's Home Panel
     * @param player
     *      the player
     * @param home
     *      player's Home Panel
     */
    public void setHomePanel(Player player, HomePanel home) {
        player.setHomePanel(home);
        player.setActualPanel(home);
        home.addPlayer(player);
    }

    /**
     * Set the player in the new panel
     * Remove the player from the panel where it was
     * Add it to the new panel
     * @param player the player
     * @param panel  the new panel
     */
    public void setPlayerPanel(Player player, IPanels panel) {
        player.getPanel().removePlayer(player);
        panel.addPlayer(player);
        player.setActualPanel(panel);
    }

    /**
     * Set the permission for the player to move
     */
    public void setMoving(boolean newValue){
        getOwner().setMoving(newValue);
    }

    /**
     * Method that takes the decision when the player is under attack
     * @param atkF the attack's damage
     */
    public void playerDecide(int atkF) throws ActionException {
        int decision = random.nextInt(2);
        if (decision == 0){
            phase.defend(atkF);
        }
        else{
            phase.dodge(atkF);
        }
    }

    /**
     * The fighter decides to Defend the attack
     * @param fighter the attack's target
     * @param atkF the attack's damage
     */
    public void fighterDefend(IFighter fighter, int atkF) {
         int dmg= atkF - fighter.roll() + fighter.getDef();
         fighter.setCurrentHp(fighter.getCurrentHp() - (Math.max(dmg, 1)));

    }

    /**
     * The fighter decides to Dofge the attack
     * @param fighter the attack's target
     * @param atkF the attack's damage
     */
    public void fighterDodge(IFighter fighter, int atkF) {
        int evdF = fighter.roll() + fighter.getEvd();
        if(evdF < atkF){
            fighter.setCurrentHp(fighter.getCurrentHp() - atkF);
        }
    }


    /**
     * Make a fighter attacks another fighter
     * @param attacker
     *      fighter that attacks
     * @param victim
     *      fighter tha is attacked
     */
    public void attack(IFighter attacker, IFighter victim) throws ActionException {
        int atkF = attacker.getAtk() + attacker.roll();
        attacker.attack(victim, atkF);
    }

    /**
     * Change the state to choose the norma goal
     * Set a winner when someone has level 6 norma
     * @param norma new normaLevel for the player
     */
    public void NewNormaLevel(int norma) {
        if (norma==6){
            winner=getOwner();
        }
        else{
            try{
                phase.toNormaGoalPhase();}
            catch (TransitionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Method that decides the goal for the new norma level
     */
    public void playerDecideGoal() throws ActionException {
        int decision = random.nextInt(2);
        if (decision == 0){
            phase.starsGoal();
        }
        else{
            phase.winsGoal();
        }
    }

    /**
     * the movement of a player in their turn
     */
    public void move() {
        owner.addHomeListener(HomeNotification);
        owner.addPlayersListener(PlayersNotification);
        owner.addPanelsListener(PanelsNotification);
        steps= 10;
        if(!getOwner().isMoving()&&steps>0){
            try {
                phase.toDecisionPanelPhase();
            } catch (TransitionException e) {
                e.printStackTrace();
            }
        }
        else if(steps==0){
            try {
                phase.toEndTurnPhase();
            } catch (TransitionException e) {
                e.printStackTrace();
            }
        }
        else {
            while (steps>0 && getOwner().isMoving()){
                IPanels nextPanel= getOwner().getPanel().getNextPanels().iterator().next();
                setSteps(getSteps() - 1);
                setPlayerPanel(getOwner(),nextPanel);
            }
        }
    }

    /**
     * The player is on a panel in which there is another player
     * @param newValue
     */
    public void PlayerToFight(boolean newValue) {
        if (newValue) {
            setMoving(false);
            List<Player> opponents = new ArrayList<>();
            opponents.addAll(getOwner().getPanel().getPlayers());
            opponents.remove(getOwner());
            try {
                phase.toDecisionBattlePhase(opponents.get(0));
            } catch (TransitionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * The player is on a panel in which there is more than one next panels
     * @param newValue
     */
    public void PanelDecision(boolean newValue)  {
        if(newValue) {
            setMoving(false);
            try{
                phase.toDecisionPanelPhase();}
            catch (TransitionException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Activates the panels effect in the end of the turn
     * @param player the player who activates the panel's effect
     */
    public void activatePanel(Player player) {
        actualPanel.activate(player);
    }

    /**
     * Finishes the Turn
     */
    public void endTurn() {
        activatePanel(getOwner());
        if (turn % players.size() == 0) {
            chapter++;
        }
        owner.addNormaLevelListener(NormaNotification);
        turn= turn + 1;
    }

    /**
     * Set the player's remaining steps
     */
    public void setSteps(int steps) {
        this.steps = steps;
    }

    /**
     * Return the player's remaining steps
     */
    public int getSteps() {
        return steps;
    }

    /**
     * Move  to the left
     */
    public void left() throws TransitionException {
        setSteps(getSteps()-1);
        phase.toMovingPhase();
        setMoving(true);
        setPlayerPanel(getOwner(),getOwner().getPanel().getLeft());
        if(steps==0){
            noSteps();
        }
    }

    /**
     * Move to the right
     */
    public void right() throws TransitionException {
        setSteps(getSteps()-1);
        phase.toMovingPhase();
        setMoving(true);
        setPlayerPanel(getOwner(),getOwner().getPanel().getRight());
        if(steps==0){
            noSteps();
        }
    }

    /**
     * Move up
     */
    public void up() throws TransitionException {
        setSteps(getSteps()-1);
        phase.toMovingPhase();
        setMoving(true);
        setPlayerPanel(getOwner(),getOwner().getPanel().getUp());
        if(steps==0){
            noSteps();
        }
    }

    /**
     * Move down
     */
    public void down() throws TransitionException {
        setSteps(getSteps()-1);
        phase.toMovingPhase();
        setMoving(true);
        setPlayerPanel(getOwner(),getOwner().getPanel().getDown());
        if(steps==0){
            noSteps();
        }
    }

    /**
     *  Method that changes the phase to the End Turn when the player has no steps remaining
     */
    public void noSteps() throws TransitionException {
        phase.toEndTurnPhase();
    }

    /**
     *  Method that changes the phase when the player is in a home panel
     */
    public void onAHome(boolean newValue){
        if(newValue) {
            setMoving(false);
            try {
                phase.toHomePanelDecision();
            } catch (TransitionException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Try To End The Turn
     */
    public void tryToEndTurn() {
        try {
            phase.endTurn();
        } catch (ActionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Try To Go Left
     */
    public void tryToLeft(){
        try{
            phase.left();
        }catch (ActionException | TransitionException e){
            e.printStackTrace();
        }
    }

    /**
     * Try To Go Right
     */
    public void tryToGoRight(){
        try{
            phase.right();
        }catch (ActionException | TransitionException e){
            e.printStackTrace();
        }
    }

    /**
     * Try To Go Up
     */
    public void tryToGoUp(){
        try{
            phase.up();
        }catch (ActionException | TransitionException e){
            e.printStackTrace();
        }
    }

    /**
     * Try To Go Down
     */
    public void tryToGoDown(){
        try{
            phase.down();
        }catch (ActionException | TransitionException e){
            e.printStackTrace();
        }
    }
}
