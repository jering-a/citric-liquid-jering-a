package cl.uchile.dcc.citricliquid.controller.phases;


import cl.uchile.dcc.citricliquid.controller.GameController;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.TransitionException;
import cl.uchile.dcc.citricliquid.model.IFighter;
import cl.uchile.dcc.citricliquid.model.Player;

/**
 * This abstarct class represents a Phase in the game 99.7% Citric Liquid.
 */
public abstract class Phase implements IPhase{
    protected IFighter target;
    protected Player player;
    protected GameController controller;

    /**
     * Returns the name of the actual Phase
     */
    public String toString(){
        return "Phase";
    }

    /**
     * Returns the fighter in the Phase
     */
    public Player getFighter() {
        return player;
    }

    /**
     * Sets a game controller to the phase
     */
    public void setController (GameController c){
        this.controller = c;
    }

    /**
     * Sets a fighter to the phase
     * @param fighter
     *      character to set
     */
    @Override
    public void setPlayer(Player fighter){
        this.player=fighter;
    }

    /**
     * Goes to a new phase and set the corresponding character to the the new phase,
     * and set the new phase to that character
     * @param phase
     *      new phase
     */
    @Override
    public void changePhase(IPhase phase){
        controller.setPhase(phase);
        player.setState(phase);
    }

    /**
     * The player attacks
     */
    @Override
    public void attack() throws ActionException {
        throw new ActionException("Can't attack on " + this.toString());
    }

    /**
     * Method that takes the decision in the battle (defend or dodge)
     */
    @Override
    public void DecisionBattle() throws ActionException{
        throw new ActionException("Can't attack on " + this.toString());
    }

    /**
     * The player decided to defend
     */
    @Override
    public void defend(int atkF) throws ActionException {
        throw new ActionException("Can't defend on " + this.toString());
    }

    /**
     * The player decided to dodge
     */
    @Override
    public void dodge(int atkF) throws ActionException {
        throw new ActionException("Can't dodge on " + this.toString());
    }

    /**
     * Gives to the player the stars for the beginning of the new chapter
     */
    @Override
    public void turnStars() throws ActionException {
        throw new ActionException("Can't get Stars from new chapter on " + this.toString());
    }

    /**
     * Decides that the goal for the new norma level is Wins
     */
    @Override
    public void winsGoal() throws ActionException {
        throw new ActionException("Can't choose norma goal on " + this.toString());
    }

    /**
     * Decides the goal for the new norma level
     */
    @Override
    public void decideGoal() throws ActionException{
        throw new ActionException("Can't choose norma goal on " + this.toString());
    }

    /**
     * Decides that the goal for the new norma level is Stars
     */
    @Override
    public void starsGoal() throws ActionException {
        throw new ActionException("Can't choose norma goal on " + this.toString());
    }

    /**
     * Ends the player's turn
     */
    @Override
    public void endTurn() throws ActionException {
        throw new ActionException("Can't end turn on " + this.toString());
    }

    /**
     * The player decides to stay at home
     */
    @Override
    public void HomeDecision() throws ActionException {
        throw new ActionException("Can't end turn on " + this.toString());
    }

    /**
     * Changes the phase to Start Turn
     */
    @Override
    public void toStartTurnPhase() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to End Turn phase");
    }

    /**
     * Changes the phase to Player Decision
     */
    @Override
    public void toPlayerDecisionPhase(int atkF) throws ActionException {}

    /**
     * Changes the phase to Wait
     */
    @Override
    public void toWaitPhase() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to Wait phase");
    }

    /**
     * Changes the phase to Recovery
     */
    @Override
    public void toRecoveryPhase() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to Recovery phase");
    }

    /**
     * Changes the phase to End Turn
     */
    @Override
    public void toEndTurnPhase() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to End Turn phase");
    }

    /**
     * Changes the phase to Start Turn
     */
    @Override
    public void toAttackPhase() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to Attack phase");
    }

    /**
     * Decides to go up
     */
    @Override
    public void up() throws TransitionException, ActionException {
        throw new ActionException("You can´t chooce Panel at :"+ toString());
    }

    /**
     * Decides to go down
     */
    @Override
    public void down() throws TransitionException, ActionException {
        throw new ActionException("You can´t chooce Panel at :"+ toString());
    }

    /**
     * Decides to go left
     */
    @Override
    public void left() throws TransitionException, ActionException {
        throw new ActionException("You can´t chooce Panel at :"+ toString());
    }

    /**
     * Decides to go right
     */
    @Override
    public void right() throws TransitionException, ActionException {
        throw new ActionException("You can´t chooce Panel at :"+ toString());
    }

    /**
     * The player starts to move
     */
    @Override
    public void StartMoving() throws ActionException{
        throw new ActionException("You can´t Start Moving :"+ toString());
    }

    /**
     * Changes the phase to Moving
     */
    @Override
    public void toMovingPhase() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to Moving phase");
    }

    /**
     * Changes the phase to Decision Panel
     */
    @Override
    public void toDecisionPanelPhase() throws TransitionException{
        throw new TransitionException("Can't change from " + this.toString() + " to DecisionPanelPhase ");
    }

    /**
     * Changes the phase to Decision Battle
     */
    @Override
    public void toDecisionBattlePhase(Player opponent) throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to DecisionBattlePhase ");
    }

    /**
     * Changes the phase to Home Panel Decision
     */
    @Override
    public void toHomePanelDecision() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to HomePanelDecision");
    }

    /**
     * Changes the phase to Norma Goal
     */
    @Override
    public void toNormaGoalPhase() throws TransitionException {
        throw new TransitionException("Can't change from " + this.toString() + " to NormaGoalPhase");
    }
}
