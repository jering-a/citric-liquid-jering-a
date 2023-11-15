package cl.uchile.dcc.citricliquid.controller.handler;

import cl.uchile.dcc.citricliquid.controller.GameController;

import java.beans.PropertyChangeEvent;

/**
 * Observer to check when the actual panel has 2 or more next panels
 */
public class PanelsObserver implements IHandler {
    private GameController controller;

    /**
     * Creates a norma observer
     */
    public PanelsObserver(final GameController controler){
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
        controller.PanelDecision((boolean) evt.getNewValue());
    }
}
