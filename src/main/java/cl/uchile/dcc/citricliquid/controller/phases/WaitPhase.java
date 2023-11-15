package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;

/**
 * Class that represent the wait state when a player already attack
 */
public class WaitPhase extends Phase{

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "WaitPhase";
    }

    /**
     * Changes the phase to Player Decision
     */
    @Override
    public void toPlayerDecisionPhase(int atkF) throws ActionException {
        changePhase(new PlayerDecisionPhase(atkF));
    }



}
