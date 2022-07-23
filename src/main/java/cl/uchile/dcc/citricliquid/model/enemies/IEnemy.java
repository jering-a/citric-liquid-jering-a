package cl.uchile.dcc.citricliquid.model.enemies;

import cl.uchile.dcc.citricliquid.model.IFighter;

/**
 * This interface represents a Enemy in the game 99.7% Citric Liquid.
 */
public interface IEnemy extends IFighter {

    /**
     * the fighter is under attack
     * @param atkF the dmg that the enemy attacks with
     */
    @Override
    void atacado(int atkF);
}
