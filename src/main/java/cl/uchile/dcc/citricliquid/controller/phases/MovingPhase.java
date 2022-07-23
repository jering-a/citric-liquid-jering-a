package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.model.Player;

/**
 * Class that represent the Moving phase
 */
public class MovingPhase extends Phase{

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "MovingPhase";
    }

    /**
     * Changes the phase to Decision Panel
     */
    @Override
    public void toDecisionPanelPhase(){
        changePhase(new DecisionPanelPhase());
    }

    /**
     * Changes the phase to Decision Battle
     */
    @Override
    public void toDecisionBattlePhase(Player opponent){
        changePhase(new DecisionBattlePhase(opponent));
    }

    /**
     * Changes the phase to Home Panel Decision
     */
    @Override
    public void toHomePanelDecision(){
        changePhase(new HomePanelDecision());
    }

    /**
     * Changes the phase to End Turn
     */
    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurnPhase());
    }


}
