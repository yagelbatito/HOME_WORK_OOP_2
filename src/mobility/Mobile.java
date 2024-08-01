/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package mobility;

/**
 * The Mobile class represents a mobile object with location and distance capabilities.
 * It implements the ILocatable interface for location management.
 */
public abstract class Mobile implements ILocatable {
    private Point location;
    private double totalDistance;

    /**
     * Constructs a Mobile object with a specified initial location and total distance.
     *
     * @param location The initial location of the mobile object.
     */
    public Mobile(Point location) {
        this.location = location;
        this.totalDistance = 0;
    }

    /**
     * Default constructor for Mobile class.
     * Initializes the location to (0, 0) and total distance to 0.
     */
    public Mobile() {
        this(new Point(0, 0));
    }

    /**
     * Retrieves the current location of the mobile object.
     *
     * @return The current location of the mobile object as a Point.
     */
    @Override
    public Point getLocation() {
        return location;
    }

    /**
     * Sets the location of the mobile object to the specified Point.
     *
     * @param location The new location to set for the mobile object.
     * @return
     */
    @Override
    public Boolean setLocation(Point location) {
        this.location = location;
        return null;
    }

    /**
     * Adds the given distance to the total distance traveled by the mobile object.
     *
     * @param distance The distance to add to the total distance.
     */
    public void addTotalDistance(double distance) {
        this.totalDistance += distance;
    }

    /**
     * Calculates the distance between the current location of the mobile object
     * and the specified point using Euclidean distance formula.
     *
     * @param point The destination point to calculate the distance to.
     * @return The distance between the current location and the specified point.
     */
    public double calcDistance(Point point) {
        return Math.sqrt(Math.pow(point.getX() - this.location.getX(), 2) +
                Math.pow(point.getY() - this.location.getY(), 2));
    }

    /**
     * Moves the mobile object to the specified point and updates the total distance traveled.
     *
     * @param point The destination point to move the mobile object to.
     * @return true if the move was successful.
     */
    public boolean move(Point point) {
        if (point == null) {
            return false; // Assuming totalDistance remains unchanged if point is null
        }
        double distance = calcDistance(point);
        addTotalDistance(distance);
        setLocation(point); // Update the location to the new point
        return true;
    }

    /**
     * Checks equality of this Mobile object with another Mobile object based on location and total distance.
     *
     * @param obj The other Mobile object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mobile mobile = (Mobile) obj;
        return Double.compare(mobile.totalDistance, totalDistance) == 0 &&
                location.equals(mobile.location);
    }

    /**
     * Returns a string representation of the Mobile object, including its location and total distance.
     *
     * @return A string representation of the Mobile object.
     */
    @Override
    public String toString() {
        return "Location: " + location + ", Total Distance: " + totalDistance;
    }

    /**
     * Returns a hash code value for the Mobile object.
     *
     * @return A hash code value for the Mobile object.
     */
    @Override
    public int hashCode() {
        int result = location.hashCode();
        long temp = Double.doubleToLongBits(totalDistance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
