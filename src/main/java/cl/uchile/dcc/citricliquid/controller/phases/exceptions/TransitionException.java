package cl.uchile.dcc.citricliquid.controller.phases.exceptions;

/**
 * Class that represent the Transition Exception
 * this happens when a player try to change phase to another that is not posible
 * e.g. go to start turn in attack phase
 */
public class TransitionException extends Exception {

    /**
     * Creates a new Transition Exception
     */
    public TransitionException(String message) {
        super(message);
    }
}
