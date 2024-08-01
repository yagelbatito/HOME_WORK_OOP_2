
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package animals;

/**
 * The IReptile interface represents a reptile with a speed attribute and a method to increase speed.
 */
public interface IReptile {
    /**
     * The maximum speed a reptile can achieve.
     */
    static final int MAX_SPEED = 5;

    /**
     * The current speed of the reptile.
     */
    int speed = 0;

    /**
     * Increases the speed of the reptile.
     *
     * @param speed The amount to increase the speed by.
     * @return The new speed of the reptile.
     */
    default int speedUP(int speed) { //todo:bbb
        speed += speed;
        return speed;
    }
}
