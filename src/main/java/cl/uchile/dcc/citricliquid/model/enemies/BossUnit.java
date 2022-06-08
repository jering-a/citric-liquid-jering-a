package cl.uchile.dcc.citricliquid.model.enemies;

import cl.uchile.dcc.citricliquid.model.Fighter;

/**
 * This class represents a Boss Unit in the game 99.7% Citric Liquid.
 */
public class BossUnit extends Fighter {

    /**
     * Creates a new Boss unit.
     *
     * @param hp
     *     the initial (and max) hit points of the Boss.
     * @param atk
     *     the base damage the Boss does.
     * @param def
     *     the base defense of the Boss.
     * @param evd
     *     the base evasion of the Boss.
     */
    public BossUnit(final int hp, final int atk, final int def, final int evd) {
        super(hp, atk, def, evd);
    }

}
