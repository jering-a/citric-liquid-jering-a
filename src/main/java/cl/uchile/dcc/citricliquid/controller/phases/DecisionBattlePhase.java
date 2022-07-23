package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.model.Player;

/**
 * Class that represent the Decision Battle phase
 */
public class DecisionBattlePhase extends Phase{

    /**
     * Creates a new Decsion BATTLE Phase
     *
     * @param opponent
     *      the target in the battle
     */
    public DecisionBattlePhase(Player opponent){
            this.target=opponent;
    }

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "DecisionBattlePhase";
    }

    /**
     * Decides to fight
     */
    public void fight(){
        controller.setSteps(0);
        toAttackPhase();
    }

    /**
     * Changes the phase to Attack
     */
    @Override
    public void toAttackPhase(){
        changePhase(new AttackPhase());
    }

    /**
     * Changes the phase to Moving
     */
    @Override
    public void toMovingPhase(){
        changePhase(new MovingPhase());
    }
}
