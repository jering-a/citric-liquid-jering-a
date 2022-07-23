package cl.uchile.dcc.citricliquid.controller.phases;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;

/**
 * Class that represent the start turn phase
 */
public class StartTurnPhase extends Phase{

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "StartTurnPhase";
    }

    /**
     * Gives to the player the stars for the beginning of the new chapter
     */
    @Override
    public void turnStars(){
        getFighter().increaseStarsBy((int) Math.floor(controller.getChapter()/5)+1);
    }

    /**
     * the player starts to move
     */
    @Override
    public void StartMoving() throws ActionException {
        turnStars();
        toMovingPhase();
        controller.move();
    }

    /**
     * Changes the phase to moving
     */
    @Override
    public void toMovingPhase(){
        changePhase(new MovingPhase());
    }

}
