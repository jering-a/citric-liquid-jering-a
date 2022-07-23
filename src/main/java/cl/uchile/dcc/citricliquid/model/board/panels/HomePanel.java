package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * This class represents a Home Panel in the game 99.7% Citric Liquid.
 */
public class HomePanel extends AbstractPanel {
    private Player owner;

    /**
     * Creates a new Home panel.
     */
    public HomePanel(int id) {
        super(id);
        owner= new Player("const",1,1,1,1);
    }

    /**
     * Returns the panel's owner.
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * Returns the panel's owner.
     */
    public void setOwner(Player player) {
        owner = player;
    }


    /**
     * Restores a player's HP in 1.
     *
     * @param player the player who activates the effect.
     */
    @Override
    public void activate(@NotNull Player player) {
        player.setCurrentHp(player.getCurrentHp() + 1);
        normaCheck(player);
    }

    /**
     * Check that the player meets the requirements.
     *
     * @param player the player to check.
     */
    public void normaCheck(Player player) {
        String goal = player.getNormaGoal();
        if(goal.equals("Stars")){
            starsCheck(player);
        }
        else{
            winsCheck(player);
        }
    }

    /**
     * Check that the player meets the wins requirements.
     *
     * @param player the player to check.
     */
    private void winsCheck(Player player) {
        int wins = player.getWins();
        int norma = player.getNormaLevel();
        List<Integer> necessaryWins= List.of(0,2, 5, 9, 14);
        if(wins >= necessaryWins.get(norma - 1)){
            player.normaClear();
        }
    }

    /**
     * Check that the player meets the stars requirements.
     *
     * @param player the player to check.
     */
    private void starsCheck(Player player) {
        int stars= player.getStars();
        int norma = player.getNormaLevel();
        List<Integer> necessaryStars= List.of(10,30, 70, 120, 200);
        if(stars >= necessaryStars.get(norma - 1)){
            player.normaClear();
        }

    }
}
