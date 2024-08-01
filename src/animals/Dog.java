

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
 * The Dog class represents a dog, which is a type of terrestrial animal.
 * It extends the TerrestrialAnimals class.
 */
public class Dog extends TerrestrialAnimals {
    private String breed;

    /**
     * Constructs a Dog with specified attributes.
     *
     * @param name             The name of the dog.
     * @param gender           The gender of the dog.
     * @param weight           The weight of the dog.
     * @param speed            The speed of the dog.
     * @param point            The location of the dog.
     * @param numberOfMedals   The number of medals the dog has won.
     * @param medals           The medals the dog has won.
     * @param individual_sound The individual sound of the dog.
     * @param noLegs           The number of legs the dog has.
     * @param breed            The breed of the dog.
     */
    public Dog(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound, int maxEnergy, int noLegs, String breed) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "Woof Woof", maxEnergy, noLegs, "/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dog2.png", "/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dog2N.png", "/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dog2S.png", "/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dog2W.png");
        this.breed = breed;
        this.animalType = "Dog";
        super.loadImages("/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dog2N.png");

    }

    /**
     * Default constructor for Dog with default values.
     */
    public Dog() {
        super();
        this.breed = "German Shepherd";
        this.animalType = "Dog";
    }

    public Dog(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }


    /**
     * Returns a string representation of the dog.
     *
     * @return A string describing the dog.
     */
    @Override
    public String toString() {
        return animalType + "\n" + ", the breed is " + breed + "\n" + super.toString();
    }

    /**
     * Compares this dog to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dog) {
            Dog otherAnimal = (Dog) obj;
            return super.equals(otherAnimal) && Objects.equals(breed, otherAnimal.breed);
        }
        return false;
    }



}
