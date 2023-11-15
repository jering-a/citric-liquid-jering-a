package cl.uchile.dcc.citricliquid.controller.handler;

import cl.uchile.dcc.citricliquid.controller.GameController;

import java.beans.PropertyChangeEvent;

/**
 * Observer to check when the panel is a home panel to stay
 */
public class HomeObserver implements IHandler{
    private GameController controller;

    /**
     * Creates a Home observer
     */
    public HomeObserver(GameController controller){
        this.controller=controller;
    }

    /**
     * This method gets called when a bound property is changed.
     * @param evt A PropertyChangeEvent object describing the event source
     * and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        controller.onAHome((boolean) evt.getNewValue());
    }
}
