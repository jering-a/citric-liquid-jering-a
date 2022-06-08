package cl.uchile.dcc.citricliquid.model;

import java.util.Random;

/**
 * This class represents a fighter in the game 99.7% Citric Liquid.
 */
public class Fighter implements IFighter{
    private final Random random;
    private final int maxHp;
    private final int atk;
    private final int def;
    private final int evd;
    private int stars;
    private int currentHp;

    /**
     * Creates a new fighter.
     *
     * @param hp
     *     the initial (and max) hit points of the fighter.
     * @param atk
     *     the base damage the fighter does.
     * @param def
     *     the base defense of the fighter.
     * @param evd
     *     the base evasion of the fighter.
     */
    public Fighter(int hp, int atk, int def, int evd) {
        this.maxHp = currentHp = hp;
        this.atk = atk;
        this.def = def;
        this.evd = evd;
        random = new Random();
    }

    /**
     * Increases this Fighter's star count by an amount.
     */
    @Override
    public void increaseStarsBy(int amount) {
        stars += Math.max(0, amount);
    }

    /**
     * Returns this Fighter's star count.
     */
    @Override
    public int getStars() {
        return stars;
    }

    /**
     * Set's the seed for this Fighter's random number generator.
     *
     * <p>The random number generator is used for taking non-deterministic decisions, this method is
     * declared to avoid non-deterministic behaviour while testing the code.
     */
    @Override
    public void setSeed(long seed) {
        random.setSeed(seed);
    }

    /**
     * Returns a uniformly distributed random value in [1, 6].
     */
    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }

    /**
     * Returns the fighter's max hit points.
     */
    @Override
    public int getMaxHp() {
        return maxHp;
    }

    /**
     * Returns the current fighter's attack points.
     */
    @Override
    public int getAtk() {
        return atk;
    }

    /**
     * Returns the current fighter's defense points.
     */
    @Override
    public int getDef() {
        return def;
    }

    /**
     * Returns the current fighter's evasion points.
     */
    @Override
    public int getEvd() {
        return evd;
    }

    /**
     * Returns the current hit points of the fighter.
     */
    @Override
    public int getCurrentHp() {
        return currentHp;
    }

    /**
     * Sets the current fighter's hit points.
     *
     * <p>The character's hit points have a constraint to always be between 0 and maxHP, both
     * inclusive.
     */
    @Override
    public void setCurrentHp(int newHp) {
        this.currentHp = Math.max(Math.min(newHp, maxHp), 0);
    }

    /**
     * Reduces this fighter's star count by a given amount.
     *
     * <p>The star count will must always be greater or equal to 0
     */
    @Override
    public void reduceStarsBy(int amount) {
        stars = Math.max(0, stars - amount);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fighter)) {
            return false;
        }
        final Fighter fighter = (Fighter) o;
        return getMaxHp() == fighter.getMaxHp()
                && getAtk() == fighter.getAtk()
                && getDef() == fighter.getDef()
                && getEvd() == fighter.getEvd()
                && getStars() == fighter.getStars()
                && getCurrentHp() == fighter.getCurrentHp();
    }
}
