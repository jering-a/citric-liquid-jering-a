package cl.uchile.dcc.citricliquid.model;

import cl.uchile.dcc.citricliquid.controller.phases.exceptions.ActionException;

/**
 * This interface represents a fighter in the game 99.7% Citric Liquid.
 */
public interface IFighter {

    /**
     * Returns if it is alive or not
     */
    boolean isKO();

    /**
     * Increases this fighter's star count by an amount.
     */
    void increaseStarsBy(final int amount);

    /**
     * Returns this fighter's star count.
     */
    int getStars();

    /**
     * Set's the seed for this fighter's random number generator.
     *
     * <p>The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    void setSeed(final long seed);

    /**
     * Returns a uniformly distributed random value in [1, 6].
     */
    int roll();

    /**
     * Returns the fighter's max hit points.
     */
    int getMaxHp();

    /**
     * Returns the current fighter's attack points.
     */
    int getAtk();

    /**
     * Returns the current fighter's defense points.
     */
    int getDef();

    /**
     * Returns the current fighter's evasion points.
     */
    int getEvd();

    /**
     * Returns the current hit points of the fighter.
     */
    int getCurrentHp();

    /**
     * Sets the current fighter's hit points.
     *
     * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
     * inclusive.
     */
    void setCurrentHp(final int newHp);

    /**
     * Reduces this fighter's star count by a given amount.
     *
     * <p>The star count will must always be greater or equal to 0
     */
    void reduceStarsBy(final int amount);


    /**
     * Attacks a character
     * @param fighter
     *  fighter to attach
     */
    void attack(IFighter fighter, int atk) throws ActionException;

    /**
     * the fighter is under attack
     * @param atkF the dmg that the enemy attacks with
     */
    void atacado(int atkF) throws ActionException;
}
