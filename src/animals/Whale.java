
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package animals;

import Olympics.Medal;
import mobility.Point;

import java.awt.*;
import java.util.Objects;

/**
 * The Whale class represents a type of water animal, specifically a whale.
 * It extends the WaterAnimal class.
 */
public class Whale extends WaterAnimal {
    private String foodType;

    /**
     * Constructs a whale with specified attributes.
     *
     * @param name             The name of the whale.
     * @param gender           The gender of the whale.
     * @param weight           The weight of the whale.
     * @param speed            The speed of the whale.
     * @param point            The location of the whale.
     * @param numberOfMedals   The number of medals the whale has won.
     * @param medals           The medals the whale has won.
     * @param individual_sound The individual sound of the whale.
     * @param diveDept         The diving depth capability of the whale.
     * @param foodType         The type of food the whale consumes.
     */
    public Whale(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound,int maxEnergy, double diveDept, String foodType) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "Splash", maxEnergy,diveDept,"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/whale.png",null,null,null);
        this.foodType = foodType;
        this.animalType = "Whale"; // Initialization of animalType
    }

    /**
     * Default constructor for Whale with default values.
     */
    public Whale() {
        super();
        super.setName("Whale");
        this.animalType = "Whale"; // Initialization of animalType
    }
    public Whale(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }


    /**
     * Returns a string representation of the whale.
     *
     * @return A string describing the whale.
     */
    @Override
    public String toString() {
        return animalType + ", the foodType is: " + foodType + "\n" + super.toString();
    }

    /**
     * Compares this whale to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Whale) {
            Whale otherAnimal = (Whale) obj;
            return super.equals(otherAnimal) && Objects.equals(foodType, otherAnimal.foodType);
        }
        return false;
    }


}
