/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package mobility;

/**
 * The ILocatable interface represents an object that has a location.
 * It provides methods to get and set the location of the object.
 */
public interface ILocatable {

    /**
     * Retrieves the current location of the object.
     *
     * @return The current location of the object as a Point.
     */
    Point getLocation();

    /**
     * Sets the location of the object to the specified Point.
     *
     * @param location The new location to set for the object.
     * @return true if the location was successfully set, false otherwise.
     */
    Boolean setLocation(Point location);
}
