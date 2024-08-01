
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
 * The Eagle class represents an eagle, which is a type of air animal.
 * It extends the AirAnimal class.
 */
public class Eagle extends AirAnimal {
    private double altitudeOfFlight;
    static final int MAX_ALTITUDE = 1000;

    /**
     * Constructs an Eagle with specified attributes.
     *
     * @param name             The name of the eagle.
     * @param gender           The gender of the eagle.
     * @param weight           The weight of the eagle.
     * @param speed            The speed of the eagle.
     * @param point            The location of the eagle.
     * @param numberOfMedals   The number of medals the eagle has won.
     * @param medals           The medals the eagle has won.
     * @param individual_sound The individual sound of the eagle.
     * @param wingspan         The wingspan of the eagle.
     * @param altitudeOfFlight The altitude of flight of the eagle.
     */
    public Eagle(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medals, String individual_sound,int maxEnergy, double wingspan, double altitudeOfFlight) {
        super(name, gender, weight, speed, point, numberOfMedals, medals, "Clack-wack-chack",maxEnergy, wingspan,"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/eagle2.png",null,null,null);
        this.altitudeOfFlight = altitudeOfFlight;
        this.animalType = "Eagle";
    }

    /**
     * Default constructor for Eagle with default values.
     */
    public Eagle() {
        super();
        super.setName("Eagle");
        super.setIndividual_sound("Clack-wack-chack");
        this.altitudeOfFlight = super.getPoint().getY();
        this.animalType = "Eagle";
    }
    public Eagle(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
        super(name, speed, currentEnergy, maxEnergy, imagePath,x,y);
        super.loadImages(imagePath);
    }





    /**
     * Sets the altitude of flight for the eagle.
     *
     * @param altitudeOfFlight The altitude of flight to set.
     * @return true if the altitude was successfully set, false otherwise.
     */
    public boolean setAltitudeOfFlight(double altitudeOfFlight) {
        if (this.altitudeOfFlight < MAX_ALTITUDE) {
            this.altitudeOfFlight += altitudeOfFlight;
            if (this.altitudeOfFlight > MAX_ALTITUDE) {
                this.altitudeOfFlight = MAX_ALTITUDE;
            }
            super.getPoint().setY((int) this.altitudeOfFlight);
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the eagle.
     *
     * @return A string describing the eagle.
     */
    @Override
    public String toString() {
        return animalType + " the altitudeOfFlight is: " + altitudeOfFlight + "\n" + super.toString();
    }

    /**
     * Compares this eagle to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Eagle) {
            Eagle otherAnimal = (Eagle) obj;
            return super.equals(otherAnimal) && Objects.equals(altitudeOfFlight, otherAnimal.altitudeOfFlight);
        }
        return false;
    }
//
//    @Override
//    public void loadImages(String nm) {
//
//    }
//
//    @Override
//    public void drawObject(Graphics g) {
//
//    }




}
