/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package mobility;

/**
 * The Point class represents a point in a 2D coordinate system.
 */
public class Point {
    private int x;
    private int y;

    /**
     * Constructs a Point object with the specified x and y coordinates.
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor for creating a Point object from another Point object.
     *
     * @param other The Point object to copy.
     */
    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    /**
     * Default constructor for creating a Point object with coordinates (0, 0).
     */
    public Point() {
        this(0, 0);
    }

    /**
     * Retrieves the x-coordinate of the point.
     *
     * @return The x-coordinate of the point.
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x-coordinate of the point to the specified value.
     *
     * @param x The new value for the x-coordinate.
     * @return true if the x-coordinate was set successfully, false otherwise.
     */
    public boolean setX(int x) {
        if (x < 0) {
            return false;
        }
        this.x = x;
        return true;
    }

    /**
     * Retrieves the y-coordinate of the point.
     *
     * @return The y-coordinate of the point.
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y-coordinate of the point to the specified value.
     *
     * @param y The new value for the y-coordinate.
     * @return true if the y-coordinate was set successfully, false otherwise.
     */
    public boolean setY(int y) {
        if (y < 0) {
            return false;
        }
        this.y = y;
        return true;
    }

    /**
     * Checks equality of this Point object with another Point object based on x and y coordinates.
     *
     * @param obj The other object to compare.
     * @return true if the points are equal (have the same x and y coordinates), false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    /**
     * Returns a string representation of the Point object.
     *
     * @return A string representation of the Point object.
     */
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    /**
     * Returns the hash code of the Point object.
     *
     * @return The hash code of the Point object.
     */
    @Override
    public int hashCode() {
        int result = Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(y);
        return result;
    }
}
