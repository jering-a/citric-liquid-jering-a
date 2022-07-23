package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;
import cl.uchile.dcc.citricliquid.model.Player;

/**
 * Class that represent the Attack phase
 */
public class AttackPhase extends Phase{

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "AttackPhase";
    }

    /**
     * The player attacks
     */
    @Override
    public void attack() throws ActionException {
        controller.attack(player, target);
        toWaitPhase();
    }

    /**
     * Changes the phase to Wait
     */
    @Override
    public void toWaitPhase(){
        changePhase(new WaitPhase());
    }
}
