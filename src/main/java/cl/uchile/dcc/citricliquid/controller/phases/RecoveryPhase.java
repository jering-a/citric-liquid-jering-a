package cl.uchile.dcc.citricliquid.controller.phases;

/**
 * Class that represent the recovery phase
 */
public class RecoveryPhase extends Phase{
    private int payment=6;

    /**
     * Return the name of the actual Phase
     */
    @Override
    public String toString() {
        return "RecoveryPhase";
    }

    /**
     * reduce the payment needed to leave
     */
    public void reducePayment(){
        this.payment = Math.max(0, payment - 1);
    }

    /**
     * Try to scape form the recovery phase
     */
    public void tryToScape(){
        int n =getFighter().roll();
        if(n>=payment){
            toStartTurnPhase();
        }
        else{
            reducePayment();
        }
    }

    /**
     * Changes the phase to Start Turn
     */
    @Override
    public void toStartTurnPhase() {
        changePhase(new StartTurnPhase());
    }

}
