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
 * The Dolphin class represents a dolphin, which is a type of water animal.
 * It extends the WaterAnimal class.
 */
public class Dolphin extends WaterAnimal {



    /**
     * Enum representing the type of water the dolphin lives in.
     */
    public enum WaterType {Sea, Sweet}

    private WaterType waterType;

    /**
     * Constructs a Dolphin with specified attributes.
     *
     * @param name             The name of the dolphin.
     * @param gender           The gender of the dolphin.
     * @param weight           The weight of the dolphin.
     * @param speed            The speed of the dolphin.
     * @param point            The location of the dolphin.
     * @param numberOfMedals   The number of medals the dolphin has won.
     * @param medals           The medals the dolphin has won.
     * @param individual_sound The individual sound of the dolphin.
     * @param diveDept         The dive depth of the dolphin.
     * @param waterType        The type of water the dolphin lives in.
     */
    public Dolphin(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound,int maxEnergy ,double diveDept, WaterType waterType) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "Click-click",maxEnergy, diveDept,"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dolphin1.png",null,null,null);
        this.waterType = waterType;
        this.animalType = "Dolphin";
    }

    /**
     * Default constructor for Dolphin with default values.
     */
    public Dolphin() {
        super();
        super.setName("Dolphin");
        super.setIndividual_sound("Click-click");
        this.animalType = "Dolphin";
    }
    public Dolphin(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }

    /**
     * Returns a string representation of the dolphin.
     *
     * @return A string describing the dolphin.
     */
    @Override
    public String toString() {
        return animalType + " the WaterType is: " + waterType + "\n" + super.toString();
    }

    /**
     * Compares this dolphin to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dolphin) {
            Dolphin otherAnimal = (Dolphin) obj;
            return super.equals(otherAnimal) && Objects.equals(waterType, otherAnimal.waterType);
        }
        return false;
    }
}
