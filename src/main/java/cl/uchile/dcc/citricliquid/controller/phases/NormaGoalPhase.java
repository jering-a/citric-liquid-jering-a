package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;

/**
 * Class that represent the Norma Goal phase
 */
public class NormaGoalPhase extends Phase{


    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "WaitPhase";
    }

    /**
     * Decides the goal for the new norma level
     */
    @Override
    public void decideGoal() throws ActionException {
        controller.playerDecideGoal();
        toEndTurnPhase();
        controller.tryToEndTurn();
    }

    /**
     * Decides that the goal for the new norma level is Stars
     */
    public void starsGoal(){
        player.setNormaGoal("Stars");
    }

    /**
     * Decides that the goal for the new norma level is Wins
     */
    public void winsGoal(){
        player.setNormaGoal("Wins");
    }

    /**
     * Changes the phase to End Turn
     */
    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurnPhase());
    }
}
