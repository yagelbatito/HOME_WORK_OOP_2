
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package animals;

import Olympics.Medal;
import mobility.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * The Pigeon class represents a pigeon, which is a type of air animal.
 * It extends the AirAnimal class.
 */
public class Pigeon extends AirAnimal {
    private String family;
    private String path;




    /**
     * Constructs a Pigeon with specified attributes.
     *
     * @param name             The name of the pigeon.
     * @param gender           The gender of the pigeon.
     * @param weight           The weight of the pigeon.
     * @param speed            The speed of the pigeon.
     * @param point            The location of the pigeon.
     * @param numberOfMedals   The number of medals the pigeon has won.
     * @param medals           The medals the pigeon has won.
     * @param individual_sound The individual sound of the pigeon.
     * @param wingspan         The wingspan of the pigeon.
     * @param family           The family of the pigeon.
     */
    public Pigeon(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound, int maxEnergy, double wingspan, String family) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "Arr-rar-rar-rar-raah", maxEnergy, wingspan,"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/pigeon.png",null,null,null);
        this.family = family;
        this.animalType = "Pigeon";
    }

    /**
     * Default constructor for Pigeon with default values.
     */
    public Pigeon() {
//        try {
//            img1 = ImageIO.read(new File("/Users/haikarmi/Desktop/dnfus/WhatsApp Image 2024-07-23 at 14.53.49.jpeg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        super();
        super.setName("Pigeon");
        super.setIndividual_sound("Arr-rar-rar-rar-raah");
        this.family = "Pigeon classic";
        this.animalType = "Pigeon";
    }
    public Pigeon(String img) {
        super.setName("Pigeon");
        super.setIndividual_sound("Arr-rar-rar-rar-raah");
        this.family = "Pigeon classic";
        this.animalType = "Pigeon";
        this.path = img;
    }
    public Pigeon(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }



        /**
         * Returns a string representation of the pigeon.
         *
         * @return A string describing the pigeon.
         */
    @Override
    public String toString() {
        return animalType + " the family is: " + family + "\n" + super.toString();
    }

    /**
     * Compares this pigeon to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pigeon) {
            Pigeon otherAnimal = (Pigeon) obj;
            return super.equals(otherAnimal) && Objects.equals(family, otherAnimal.family);
        }
        return false;
    }

//    @Override
//    public void loadImages(String nm) {
//
//    }
//
//
//
//    @Override
//    public String getAnimaleName() {
//        return "";
//    }




}
