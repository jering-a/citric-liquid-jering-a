package cl.uchile.dcc.citricliquid.controller.phases.exceptions;

/**
 * Class that represent the Action Exception
 * this happens when a player try to do something in another phase
 * e.g. attacks in moving phase
 */
public class ActionException extends Exception{

    /**
     * Creates a new Action Exception
     */
    public ActionException(final String message){
        super(message);
    }
}
