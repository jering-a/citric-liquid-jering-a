package cl.uchile.dcc.citricliquid.controller.handler;

import cl.uchile.dcc.citricliquid.controller.GameController;

import java.beans.PropertyChangeEvent;

/**
 * Observer to check when the panel has another player
 */
public class PlayersObserver implements IHandler {
    private final GameController controller;

    /**
     * Creates a norma observer
     */
    public PlayersObserver(GameController controler){
        this.controller=controler;
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.PlayerToFight((boolean) evt.getNewValue());
    }
}
