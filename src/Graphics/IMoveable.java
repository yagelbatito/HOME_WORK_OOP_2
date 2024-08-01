/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

import mobility.Point;

/**
 * The `IMoveable` interface defines the contract for objects that can move within a
 * coordinate system. It provides methods to retrieve movement attributes and perform
 * movement operations.
 */
public interface IMoveable {

    /**
     * Retrieves the name of the animal.
     *
     * @return The name of the animal.
     */
    public String getAnimaleName();

    /**
     * Retrieves the speed at which the object moves.
     *
     * @return The speed of the object.
     */
    public double getSpeed();

    /**
     * Moves the object to a specified point.
     *
     * @param p The `Point` object representing the new location.
     * @return `true` if the move was successful, `false` otherwise.
     */
    public boolean move(Point p);
}
