package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;

/**
 * Class that represent the recovery phase
 */
public class PlayerDecisionPhase extends Phase{
    private int atkF;

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "PlayerDecisionPhase";
    }

    /**
     * Creates a new Player Decision Phase
     *
     * @param atkF
     *      the attack's damage
     */
    public PlayerDecisionPhase(int atkF) {
        this.atkF=atkF;
    }

    /**
     * Method that takes the decision in the battle (defend or dodge)
     */
    @Override
    public void DecisionBattle() throws ActionException {
        controller.playerDecide(atkF);
    }

    /**
     * The player decided to defend
     */
    @Override
    public void defend(int atkFinal){
        controller.fighterDefend(player, atkFinal);
        if(player.isKO()){
            toRecoveryPhase();
        }
        else{
            toEndTurnPhase();
        }
    }

    /**
     * The player decided to dodge
     */
    @Override
    public void dodge(int atkFinal){
        controller.fighterDodge(player, atkFinal);
        if(player.isKO()){
            toRecoveryPhase();
        }
        else{
            toEndTurnPhase();
        }
    }

    /**
     * Changes the phase to End Turn
     */
    @Override
    public void toEndTurnPhase(){
        changePhase(new EndTurnPhase());
    }

    /**
     * Changes the phase to Recovery
     */
    @Override
    public void toRecoveryPhase(){
        changePhase(new RecoveryPhase());
    }

}
