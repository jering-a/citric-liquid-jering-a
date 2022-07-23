package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;

/**
 * Class that represent the End Turn phase
 */
public class EndTurnPhase extends Phase{

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "EndTurnPhase";
    }

    /**
     * Ends the player's turn
     */
    @Override
    public void endTurn(){
        controller.endTurn();
        toStartTurnPhase();
    }

    /**
     * Changes the phase to Moving
     */
    @Override
    public void toStartTurnPhase(){
        changePhase(new StartTurnPhase());
    }


}
