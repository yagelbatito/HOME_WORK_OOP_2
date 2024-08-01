/**
Yagel Batito 318271863
 Hai Karmi 207265687
 */




/**
 * The `AirAnimal` class represents animals that can fly.

 * It extends the `Animal` class and adds specific attributes
 * related to flying animals, such as wingspan.
 */
package animals;

import Olympics.Medal;
import mobility.Point;

public abstract class AirAnimal extends Animal {
    private double wingspan; // Wingspan of the air animal

    /**
     * Constructs an `AirAnimal` object with specified attributes.
     *
     * @param name           The name of the animal.
     * @param gender         The gender of the animal (Male, Female, Unknown).
     * @param weight         The weight of the animal in kilograms.
     * @param speed          The speed of the animal in meters per second.
     * @param point          The current location of the animal as a `Point` object.
     * @param numberOfMedals The number of medals the animal has won.
     * @param individual_sound The specific sound the animal makes.
     * @param wingspan       The wingspan of the animal in meters.
     */
    public AirAnimal(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound,int maxEnergy, double wingspan,String imagePath1,String imagePath2, String imagePath3, String imagePath4) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, individual_sound,maxEnergy,imagePath1,imagePath2,imagePath3,imagePath4,Orientation.EAST);
        this.wingspan = wingspan;
        this.animalType = "AirAnimal"; // Setting the animal type to "AirAnimal"
    }

    /**
     * Default constructor for `AirAnimal` class.
     * Initializes an `AirAnimal` object with default values.
     */
    public AirAnimal() {
        super(); // Calls the default constructor of the superclass `Animal`
        super.getPoint().setX(0); // Sets the X-coordinate of the animal's location to 0
        super.getPoint().setY(100); // Sets the Y-coordinate of the animal's location to 100
        wingspan = 0; // Default wingspan set to 0
        this.animalType = "AirAnimal"; // Setting the animal type to "AirAnimal"
    }
    public AirAnimal(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x, int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath, x, y);
        this.wingspan = 0;
        this.animalType = "AirAnimal";
    }


    /**
     * Checks equality between two `AirAnimal` objects based on wingspan and other attributes.
     *
     * @param obj The other `AirAnimal` object to compare with.
     * @return `true` if both `AirAnimal` objects are equal, `false` otherwise.
     */
    public boolean equals(Object obj) {
        if (obj instanceof AirAnimal) {
            AirAnimal otherAnimal = (AirAnimal) obj;
            return super.equals(otherAnimal) && wingspan == otherAnimal.wingspan;


        }
        return false;
    }

   
    /**
     * Constructs an `AirAnimal` object from an existing `Animal` object and wingspan.
     *
     * @param other    The existing `Animal` object to copy attributes from.
     * @param wingspan The wingspan of the new `AirAnimal`.
     */

    /**
     * Constructs a copy of an existing `AirAnimal` object.
     *
     * @param other The existing `AirAnimal` object to copy attributes from.
     */


    /**
     * Returns a string representation of the `AirAnimal` object.
     *
     * @return A string describing the `AirAnimal`, including its wingspan and other attributes.
     */
    public String toString() {
        return "AirAnimal " + "the wingspan:" + wingspan + "\n" + super.toString();
    }
}
