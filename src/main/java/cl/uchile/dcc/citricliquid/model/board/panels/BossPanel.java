package cl.uchile.dcc.citricliquid.model.board.panels;

import cl.uchile.dcc.citricliquid.model.Player;
import cl.uchile.dcc.citricliquid.model.board.AbstractPanel;
import cl.uchile.dcc.citricliquid.model.enemies.BossUnit;
import org.jetbrains.annotations.NotNull;

/**
 * This class represents a Boss Panel in the game 99.7% Citric Liquid.
 */
public class BossPanel extends AbstractPanel {
    private BossUnit boss;

    /**
     * Creates a new Boss panel.
     */
    public BossPanel(int id) {
        super(id);
    }

    /**
     * sets this Panel's Boss.
     */
    public void setBoss(BossUnit boss) {
        this.boss = boss;
    }

    /**
     * Try to start a boss battle.
     *
     * @param player the player who activates the effect.
     */
    @Override
    public void activate(@NotNull Player player) {
        System.out.println("Start Boss Battle");
    }

    /**
     * Returns this Panel's Boss.
     */
    public BossUnit getBoss() {
        return boss;
    }

}
