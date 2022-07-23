package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.TransitionException;

/**
 * Class that represent the Decision Panel phase
 */
public class DecisionPanelPhase extends Phase{

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "DecisionPanelPhase";
    }

    /**
     * Decides to go left
     */
    @Override
    public void left() throws TransitionException {
        controller.left();
    }

    /**
     * Decides to go right
     */
    @Override
    public void right() throws TransitionException {
        controller.right();
    }

    /**
     * Decides to go up
     */
    @Override
    public void up() throws TransitionException {
        controller.up();
    }

    /**
     * Decides to go down
     */
    @Override
    public void down() throws TransitionException {
        controller.down();
    }

    /**
     * Changes the phase to Moving
     */
    @Override
    public void toMovingPhase(){
        changePhase(new MovingPhase());
    }
}
