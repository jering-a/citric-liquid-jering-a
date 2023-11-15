package cl.uchile.dcc.citricliquid.model.enemies;

import cl.uchile.dcc.citricliquid.model.Fighter;

/**
 * This class represents a Wild Unit in the game 99.7% Citric Liquid.
 */
public class WildUnit extends Fighter implements IEnemy {

    /**
     * Creates a new Wild unit.
     *
     * @param hp
     *     the initial (and max) hit points of the character.
     * @param atk
     *     the base damage the character does.
     * @param def
     *     the base defense of the character.
     * @param evd
     *     the base evasion of the character.
     */
    public WildUnit(final int hp, final int atk, final int def, final int evd) {
        super(hp, atk, def, evd);
    }

    /**
     * the fighter is under attack
     * @param atkF the dmg that the enemy attacks with
     */
    @Override
    public void atacado(int atkF) {
        /*nada por ahora, porque no lo controla el usuario*/
    }

}
