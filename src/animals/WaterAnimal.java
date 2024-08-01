
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package animals;

import Olympics.Medal;
import mobility.Point;

/**
 * The WaterAnimal class represents aquatic animals,
 * which are a type of animal that lives in water.
 * It extends the Animal class.
 */
public abstract class WaterAnimal extends Animal implements MarineAnimalInterface {
    private double diveDept;
    static final int MAX_DIVE = -800;

    /**
     * Constructs a water animal with specified attributes.
     *
     * @param name             The name of the water animal.
     * @param gender           The gender of the water animal.
     * @param weight           The weight of the water animal.
     * @param speed            The speed of the water animal.
     * @param point            The location of the water animal.
     * @param numberOfMedals   The number of medals the water animal has won.
     * @param medals           The medals the water animal has won.
     * @param individual_sound The individual sound of the water animal.
     * @param diveDept         The diving depth capability of the water animal.
     */
    public WaterAnimal(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound,int maxEnergy, double diveDept,String imagePath1,String imagePath2, String imagePath3, String imagePath4) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, individual_sound,maxEnergy,imagePath1,imagePath2,imagePath3,imagePath4,Orientation.EAST);
        this.diveDept = diveDept;
        this.animalType = "WaterAnimal"; // Initialization of animalType
    }
    public WaterAnimal(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        this.diveDept = 100;
        this.animalType = "WaterAnimal";
    }
    @Override
    public void swim() {
        System.out.println("Swimming in water");
    }


    /**
     * Default constructor for WaterAnimal with default values.
     */
    public WaterAnimal() {
        super();
        this.diveDept = 0;
        super.getPoint().setX(50);
        super.getPoint().setY(0);
        this.animalType = "WaterAnimal"; // Initialization of animalType
    }

    /**
     * Allows the water animal to dive to a certain depth.
     *
     * @param dive The depth to dive.
     * @return true if the dive is successful, false otherwise.
     */
    public boolean Dive(double dive) {
        if (diveDept < MAX_DIVE) {
            diveDept += dive;
            if (diveDept > MAX_DIVE) {
                diveDept = MAX_DIVE;
            }
            return true;
        }
        return false;
    }



    /**
     * Returns a string representation of the water animal.
     *
     * @return A string describing the water animal.
     */
    @Override
    public String toString() {
        return "WaterAnimal [diveDept=" + diveDept + "]\n" + super.toString();
    }

    /**
     * Compares this water animal to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WaterAnimal) {
            WaterAnimal otherAnimal = (WaterAnimal) obj;
            return super.equals(otherAnimal) && diveDept == otherAnimal.diveDept;
        }
        return false;
    }
}
