package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.GameController;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;
import cl.uchile.dcc.citricliquid.controller.phases.exceptions.TransitionException;
import cl.uchile.dcc.citricliquid.model.Player;

/**
 * This interface class represents a Phase in the game 99.7% Citric Liquid.
 */
public interface IPhase {

    /**
     * Sets a fighter to the phase
     * @param fighter
     *      character to set
     */
    void setPlayer(Player fighter);

    /**
     * Goes to a new phase and set the corresponding character to the the new phase,
     * and set the new phase to that character
     * @param phase
     *      new phase
     */
    void changePhase(IPhase phase);

    /**
     * The player attacks
     */
    void attack() throws ActionException;

    /**
     * Method that takes the decision in the battle (defend or dodge)
     */
    void DecisionBattle() throws ActionException;

    /**
     * The player decided to defend
     */
    void defend(int atkf) throws ActionException;

    /**
     * The player decided to dodge
     */
    void dodge(int atkF) throws ActionException;

    /**
     * Gives to the player the stars for the beginning of the new chapter
     */
    void turnStars() throws ActionException;

    /**
     * Decides that the goal for the new norma level is Wins
     */
    void winsGoal() throws ActionException;

    /**
     * Decides the goal for the new norma level
     */
    void decideGoal() throws ActionException;

    /**
     * Decides that the goal for the new norma level is Stars
     */
    void starsGoal() throws ActionException;

    /**
     * Ends the player's turn
     */
    void endTurn() throws ActionException;

    /**
     * The player decides to stay at home
     */
    void HomeDecision() throws ActionException;

    /**
     * Changes the phase to Start Turn
     */
    void toStartTurnPhase() throws TransitionException;

    /**
     * Changes the phase to Player Decision
     */
    void toPlayerDecisionPhase(int atkF) throws ActionException;

    /**
     * Changes the phase to Wait
     */
    void toWaitPhase() throws TransitionException;

    /**
     * Changes the phase to Recovery
     */
    void toRecoveryPhase() throws TransitionException;

    /**
     * Changes the phase to Attack
     */
    void toAttackPhase() throws TransitionException;

    /**
     * Changes the phase to End Turn
     */
    void toEndTurnPhase() throws TransitionException;

    /**
     * Decides to go up
     */
    void up() throws TransitionException, ActionException;

    /**
     * Decides to go down
     */
    void down() throws TransitionException, ActionException;

    /**
     * Decides to go left
     */
    void left() throws TransitionException, ActionException;

    /**
     * Decides to go right
     */
    void right() throws TransitionException, ActionException;

    /**
     * The player starts to move
     */
    void StartMoving() throws ActionException;

    /**
     * Changes the phase to Moving
     */
    void toMovingPhase() throws TransitionException;

    /**
     * Sets a game controller to the phase
     */
    void setController(GameController gameController);

    /**
     * Changes the phase to Decision Panel
     */
    void toDecisionPanelPhase() throws TransitionException;

    /**
     * Changes the phase to Decision Battle
     */
    void toDecisionBattlePhase(Player opponent) throws TransitionException;

    /**
     * Changes the phase to Home Panel Decision
     */
    void toHomePanelDecision() throws TransitionException;

    /**
     * Changes the phase to Norma Goal
     */
    void toNormaGoalPhase() throws TransitionException;
}
