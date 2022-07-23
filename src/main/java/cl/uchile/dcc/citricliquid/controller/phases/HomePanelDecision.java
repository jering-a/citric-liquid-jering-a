package cl.uchile.dcc.citricliquid.controller.phases;

/**
 * Class that represent the Home Panel phase
 * here the player decides to stay on the home or continues moving
 */
public class HomePanelDecision extends Phase{

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "HomePanelDecision";
    }

    /**
     * The player decides to stay at home
     */
    @Override
    public void HomeDecision() {
        controller.setSteps(0);
        toEndTurnPhase();
        controller.tryToEndTurn();
    }

    /**
     * Changes the phase to Moving
     */
    @Override
    public void toMovingPhase(){
        changePhase(new MovingPhase());
    }

    /**
     * Changes the phase to End Turn
     */
    @Override
    public void toEndTurnPhase() {
        changePhase(new EndTurnPhase());
    }

}
