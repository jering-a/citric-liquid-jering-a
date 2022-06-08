package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a Home Panel in the game 99.7% Citric Liquid.
 */
public class HomePanel extends AbstractPanel {
    private final Player owner;

    /**
     * Creates a new Home panel.
     */
    public HomePanel(final Player owner) {
        this.owner=owner;
    }

    /**
     * Returns the panel's owner.
     */
    public Player getOwner() {
        return owner;
    }


    /**
     * Restores a player's HP in 1.
     *
     * @param player the player who activates the effect.
     */
    @Override
    public void activate(@NotNull Player player) {
        player.setCurrentHp(player.getCurrentHp() + 1);
        this.normaCheck(player);
    }

    /**
     * Check that the player meets the requirements.
     *
     * @param player the player who check.
     */
    public void normaCheck(Player player) {
        int norma = player.getNormaLevel();
        int stars= player.getStars();
        int wins= player.getWins();
        switch (norma) {
            case 1:
                if(stars==10){
                    player.normaClear();
                }
                else{
                    break;
                }
            case 2:
                if(stars==30 || wins==2){
                    player.normaClear();
                }
                else{
                    break;
                }
            case 3:
                if(stars==70 || wins==5){
                    player.normaClear();
                }
                else{
                    break;
                }
            case 4:
                if(stars==120 || wins==9){
                    player.normaClear();
                }
                else{
                    break;
                }
            case 5:
                if(stars==200 || wins==14){
                    player.normaClear();
                }
                else{
                    break;
                }
        }
    }
}
