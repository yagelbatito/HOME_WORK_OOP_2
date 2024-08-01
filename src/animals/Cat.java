
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package animals;

import Olympics.Medal;
import mobility.Point;

import java.awt.*;

/**
 * The Cat class represents a cat, which is a type of terrestrial animal.
 * It extends the TerrestrialAnimals class.
 */
public class Cat extends TerrestrialAnimals {
    private boolean castrated;

    /**
     * Constructs a Cat with specified attributes.
     *
     * @param name             The name of the cat.
     * @param gender           The gender of the cat.
     * @param weight           The weight of the cat.
     * @param speed            The speed of the cat.
     * @param point            The location of the cat.
     * @param numberOfMedals   The number of medals the cat has won.
     * @param medals           The medals the cat has won.
     * @param individual_sound The individual sound of the cat.
     * @param noLegs           The number of legs the cat has (typically 4).
     * @param castrated        Whether the cat is castrated.
     */
    public Cat(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound,int maxEnergy, int noLegs, boolean castrated,String path1, String path2, String path3, String path4) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "Meow",maxEnergy, 4,"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/cat1.png",null,null,null);
        super.setIndividual_sound("Meow");
        this.castrated = castrated;
        this.animalType = "Cat";
    }
    public Cat(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }


    /**
     * Default constructor for Cat with default values.
     */
    public Cat() {
        super();
        super.setName("Cat");
        super.setIndividual_sound("Meow");
        this.castrated = true;
        this.animalType = "Cat";
    }


    /**
     * Returns a string representation of the cat.
     *
     * @return A string describing the cat.
     */
    @Override
    public String toString() {
        return animalType + "{" + "castrated=" + castrated + '}' + super.toString() + "\n";
    }

    /**
     * Compares this cat to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cat) {
            Cat otherAnimal = (Cat) obj;
            return super.equals(otherAnimal) && castrated == otherAnimal.castrated;
        }
        return false;
    }







}
