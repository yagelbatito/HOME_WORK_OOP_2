
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * The `TerrestrialAnimals` class represents terrestrial animals, which are animals that live on land.
 * It is an abstract class that extends the `Animal` class and implements the `TerrestrialAnimalInterface`.
 * <p>
 * This class defines common attributes and behaviors for terrestrial animals, including the number of legs
 * and the ability to walk.
 * </p>
 */
public abstract class TerrestrialAnimals extends Animal implements TerrestrialAnimalInterface {
    private Integer noLegs = 4;


    /**
     * Constructs a `TerrestrialAnimals` object with specified attributes.
     *
     * @param name             The name of the terrestrial animal.
     * @param gender           The gender of the terrestrial animal.
     * @param weight           The weight of the terrestrial animal.
     * @param speed            The speed of the terrestrial animal.
     * @param point            The location of the terrestrial animal as a `Point` object.
     * @param numberOfMedals   The number of medals the terrestrial animal has won.
     * @param medals           The medals the terrestrial animal has won.
     * @param individual_sound The specific sound made by the terrestrial animal.
     * @param noLegs           The number of legs of the terrestrial animal.
     * @param maxEnergy        The maximum energy of the terrestrial animal.
     * @param imagePath1       Path to the image for orientation EAST.
     * @param imagePath2       Path to the image for orientation SOUTH.
     * @param imagePath3       Path to the image for orientation WEST.
     * @param imagePath4       Path to the image for orientation NORTH.
     */
    public TerrestrialAnimals(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound, int maxEnergy, int noLegs,String imagePath1,String imagePath2, String imagePath3, String imagePath4) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, individual_sound,maxEnergy,imagePath1,imagePath2,imagePath3,imagePath4,Orientation.EAST);
        this.noLegs = noLegs;
        this.animalType = "TerrestrialAnimals"; // Initialization of animalType
    }

    /**
     * Default constructor for TerrestrialAnimals with default values.
     */
    public TerrestrialAnimals() {
        super();
        this.noLegs = 4;
        this.animalType = "TerrestrialAnimals";
    }
    /**
     * Constructs a `TerrestrialAnimals` object with the given image paths.
     * <p>
     * This constructor is used when only image paths are provided.
     * </p>
     *
     * @param path1 Path to the image for orientation EAST.
     * @param path2 Path to the image for orientation SOUTH.
     * @param path3 Path to the image for orientation WEST.
     * @param path4 Path to the image for orientation NORTH.
     */
    public TerrestrialAnimals(String path1, String path2, String path3, String path4) {
        super(path1, path2, path3, path4);
        this.noLegs = 4;
        this.animalType = "TerrestrialAnimals";
    }
    public TerrestrialAnimals(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath, x, y);
    }
    @Override
    public void walk() {
        System.out.println("Walking on land");
    }



    /**
     * Returns a string representation of the terrestrial animal.
     *
     * @return A string describing the terrestrial animal.
     */
    @Override
    public String toString() {
        return "noLegs=" + noLegs + "\n" + super.toString();
    }

    /**
     * Compares this terrestrial animal to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TerrestrialAnimals) {
            TerrestrialAnimals otherAnimal = (TerrestrialAnimals) obj;
            return super.equals(otherAnimal) && noLegs.equals(otherAnimal.noLegs);
        }
        return false;
    }
}
