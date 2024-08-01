
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
 * The Snake class represents a snake, which is a type of terrestrial animal.
 * It extends the TerrestrialAnimals class.
 */
public class Snake extends TerrestrialAnimals implements IReptile {
    private double length;
    private Poisonous poisonous;






    /**
     * Enum representing whether the snake is poisonous or not.
     */
    public enum Poisonous { Low, Medium, High }

    /**
     * Constructs a Snake with specified attributes.
     *
     * @param name             The name of the snake.
     * @param gender           The gender of the snake.
     * @param weight           The weight of the snake.
     * @param speed            The speed of the snake.
     * @param point            The location of the snake.
     * @param numberOfMedals   The number of medals the snake has won.
     * @param medals           The medals the snake has won.
     * @param individual_sound The individual sound of the snake.
     * @param noLegs           The number of legs of the snake.
     * @param length           The length of the snake.
     * @param poisonous        Whether the snake is poisonous or not.
     */
    public Snake(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound, int maxEnergy,int noLegs, double length, Poisonous poisonous) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "sssssssss",maxEnergy, noLegs,"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/snake1.png",null,null,null);
        this.length = length;
        this.animalType = "Snake";
        this.poisonous = poisonous;
    }

    /**
     * Default constructor for Snake with default values.
     */
    public Snake() {
        super();
        super.setName("Snake");
        super.setIndividual_sound("sssssssss");
        this.length = 0.5;
        this.animalType = "Snake";
    }
    public Snake(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }


    /**
     * Compares this snake to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Snake) {
            Snake otherAnimal = (Snake) obj;
            return super.equals(otherAnimal) &&
                    Objects.equals(length, otherAnimal.length) &&
                    poisonous == otherAnimal.poisonous;
        }
        return false;
    }

    /**
     * Returns a string representation of the snake.
     *
     * @return A string describing the snake.
     */
    @Override
    public String toString() {
        return animalType + " , the length is " + length + ", the snake is Poisonous: " + poisonous + "\n" + super.toString();
    }
}
