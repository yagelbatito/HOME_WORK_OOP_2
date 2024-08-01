/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */


/**
 * The `Alligator` class represents a specific type of water animal, specifically an alligator.
 * It extends the `WaterAnimal` class and implements additional interfaces to define behaviors
 * specific to alligators, including terrestrial and marine characteristics.
 * <p>
 * This class includes attributes and methods to model the alligator's behavior,
 * such as its area of living, and its ability to walk and swim.
 * </p>
 */
package animals;

import Olympics.Medal;
import mobility.Point;

import java.awt.*;
import java.util.Objects;

public class Alligator extends WaterAnimal implements TerrestrialAnimalInterface, MarineAnimalInterface, IReptile {
    private String AreaOfLiving; // Area where the alligator lives
    private TerrestrialAnimals terrestrialDelegate;
    private WaterAnimal marineDelegate;

    /**
     * Constructs an `Alligator` object with specified attributes.
     *
     * @param name             The name of the alligator.
     * @param gender           The gender of the alligator (Male, Female, Unknown).
     * @param weight           The weight of the alligator in kilograms.
     * @param speed            The speed of the alligator in meters per second.
     * @param point            The current location of the alligator as a `Point` object.
     * @param numberOfMedals   The number of medals the alligator has won.
     * @param medals           The array of medals the alligator has won.
     * @param individual_sound The specific sound the alligator makes.
     * @param maxEnergy        The maximum energy level of the alligator.
     * @param diveDept         The diving depth capability of the alligator in meters.
     * @param areaOfLiving     The specific area where the alligator lives.
     */
    public Alligator(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound,int maxEnergy, double diveDept, String areaOfLiving) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "Roar",maxEnergy, diveDept,"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/alligator1.png",null,null,null);
        this.AreaOfLiving = areaOfLiving;
        this.animalType = "Alligator"; // Setting the animal type to "Alligator"
        this.terrestrialDelegate = new TerrestrialAnimals() {
            @Override
            public void walk() {
                System.out.println("Alligator is walking on land");
            }
        };
        this.marineDelegate = this;
    }

    /**
     * Default constructor for `Alligator` class.
     * Initializes an `Alligator` object with default values.
     */
    public Alligator() {
        super(); // Calls the default constructor of the superclass `WaterAnimal`
        super.setName("Alligator"); // Sets the name of the alligator
        super.setIndividual_sound("Roar"); // Sets the sound made by the alligator
        this.AreaOfLiving = "Unknown"; // Default area of living set to "Unknown"
        this.animalType = "Alligator"; // Setting the animal type to "Alligator"
        this.terrestrialDelegate = new TerrestrialAnimals() {
            @Override
            public void walk() {
                System.out.println("Alligator is walking on land");
            }
        };
        this.marineDelegate = this;

    }
    /**
     * Constructs an `Alligator` with basic attributes.
     *
     * @param name             The name of the alligator.
     * @param speed            The speed of the alligator in meters per second.
     * @param currentEnergy    The current energy of the alligator.
     * @param maxEnergy        The maximum energy of the alligator.
     * @param imagePath        The path to the image representing the alligator.
     * @param x                The x-coordinate of the alligator's location.
     * @param y                The y-coordinate of the alligator's location.
     */
    public Alligator(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }

    /**
     * Defines the walking behavior of the alligator.
     */

    @Override
    public void walk() {
        terrestrialDelegate.walk();
    }
    /**
     * Defines the swimming behavior of the alligator.
     */

    @Override
    public void swim() {
        marineDelegate.swim();
    }





    /**
     * Returns a string representation of the `Alligator` object.
     *
     * @return A string describing the `Alligator`, including its area of living and other attributes.
     */
    @Override
    public String toString() {
        return animalType + "\n" + "the Area Of Living is: " + AreaOfLiving + "\n" + super.toString();
    }
    public boolean equals(Object obj) {
        if (obj instanceof Alligator) {
            Alligator otherAnimal = (Alligator) obj;
            return super.equals(otherAnimal) && Objects.equals(AreaOfLiving, otherAnimal.AreaOfLiving);


        }
        return false;
    }




}
