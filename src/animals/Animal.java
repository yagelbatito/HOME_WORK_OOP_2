/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */


package animals;

import Graphics.IClonable;
import Graphics.IDrawable;
import Graphics.IMoveable;
import Olympics.Medal;
import mobility.Mobile;
import mobility.Point;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.util.Arrays;

import mobility.ILocatable;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import Graphics.CompetitationPanel;


/**
 * The Animal class is an abstract class that extends the Mobile class.
 * It represents an animal with attributes such as name, gender, weight, speed,
 * medals, location (point), and individual sound.
 */
public abstract class Animal extends Mobile implements ILocatable, IMoveable, IDrawable, IClonable {
    public Animal(String name, int speed, int currentEnergy, int maxEnergy, String imagePath,int x,int y) {
    super(new Point(x, y));
    this.name = name;
    this.speed = speed;
    this.currentEnergy = currentEnergy;
    this.maxEnergy = maxEnergy;
    loadImages(imagePath);
}

    public Object getEnergyConsumption() {
        return currentEnergy;
    }


    /**
     * Enum representing the gender of the animal.
     */
    public enum Gender {Male, Female, Hermaphrodite}

    public enum Orientation {
        EAST,
        SOUTH,
        WEST,
        NORTH
    }

    private String name;
    private Gender gender;
    private double weight;
    private double speed;
    private Medal[] medals;
    private String individual_sound;
    protected String animalType = "un";
    private int id;
    private int maxEnergy;
    private int energyPerMeter;
    private CompetitationPanel pan;
    private int currentEnergy;
    protected Point location=super.getLocation();
    private BufferedImage img1; // East
    private BufferedImage img2; // South
    private BufferedImage img3; // West
    private BufferedImage img4; // North
    protected int size = 65;
    protected Orientation orientation;


    /**
     * Constructs an Animal with specified attributes.
     *
     * @param name             The name of the animal.
     * @param gender           The gender of the animal.
     * @param weight           The weight of the animal.
     * @param speed            The speed of the animal.
     * @param point            The location of the animal.
     * @param numberOfMedals   The number of medals.
     * @param medal            The medals the animal has won.
     * @param individual_sound The individual sound of the animal.
     * @param maxEnergy        The maximum energy of the animal.
     * @param imagePath1       Path to the image for East orientation.
     * @param imagePath2       Path to the image for South orientation.
     * @param imagePath3       Path to the image for West orientation.
     * @param imagePath4       Path to the image for North orientation.
     * @param orientation      The initial orientation of the animal.
     */
    public Animal(String name, Gender gender, double weight, double speed, Point point, int numberOfMedals, Medal[] medal, String individual_sound, int maxEnergy, String imagePath1, String imagePath2, String imagePath3, String imagePath4, Orientation orientation) {
        super(point);
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.speed = speed;
        this.medals = new Medal[numberOfMedals];
        for (int i = 0; i < numberOfMedals; i++) {
            this.medals[i] = medal[i];
        }
        this.individual_sound = individual_sound;
        this.maxEnergy = 200;
        this.currentEnergy = 100;
        this.location = point;
        loadImages(imagePath1, imagePath2, imagePath3, imagePath4);
        this.orientation = Orientation.EAST;
    }


    /**
     * Default constructor for Animal with default values.
     */
    public Animal() {
        this("animal", Gender.Male, 0.0, 0.0, new Point(0, 0), 0, new Medal[0], "default sound", 0, "/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/default-scaled.jpeg", null, null, null, Orientation.EAST);
    }
    public Animal(String path1, String path2, String path3, String path4) {
    }

    /**
     * Copy constructor for Animal.
     *
     * @param other Another Animal object to copy from.
     */

    /**
     * Prints the sound the animal makes.
     */
    public void makeSound() {
        System.out.println(this.animalType + " " + this.name + " said " + this.individual_sound);
    }

    /**
     * Returns a string representation of the animal.
     *
     * @return A string describing the animal.
     */
    @Override
    public String toString() {
        return "the name is: " + this.name + "\n" +
                "the sound is: " + this.individual_sound + "\n" +
                "the speed is: " + this.speed + "\n" +
                "the weight is: " + this.weight + "\n" +
                "the point is: " + super.getLocation() + "\n" +
                "the medal is:\n " + toStringMEDAL() + "\n";
    }

    /**
     * Returns a string representation of the medals.
     *
     * @return A string listing all the medals.
     */
    public String toStringMEDAL() {
        StringBuilder str = new StringBuilder();
        for (Medal medal : this.medals) {
            str.append(medal.toString());
        }
        return str.toString();
    }

    /**
     * Compares this animal to another object for equality.
     *
     * @param obj The object to compare with.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            Animal otherAnimal = (Animal) obj;
            return name.equals(otherAnimal.name) &&
                    gender == otherAnimal.gender &&
                    weight == otherAnimal.weight &&
                    speed == otherAnimal.speed &&
                    super.getLocation().equals(otherAnimal.getLocation()) &&
                    Arrays.equals(medals, otherAnimal.medals);
        }
        return false;
    }

    /**
     * Gets the location of the animal.
     *
     * @return The point representing the animal's location.
     */
    public Point getPoint() {
        return super.getLocation();
    }

    /**
     * Sets the individual sound of the animal.
     *
     * @param individual_sound The sound to set.
     */
    public void setIndividual_sound(String individual_sound) {
        this.individual_sound = individual_sound;
    }

    /**
     * Sets the name of the animal.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the animal.
     *
     * @return The name of the animal.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the type of the animal.
     *
     * @return The type of the animal.
     */

    public String getAnimalType() {
        return this.animalType;
    }

    @Override
    public String getAnimaleName() {
        return this.animalType;
    }

    public double getSpeed() {
        return speed;
    }
    /**
     * Updates the energy of the animal by adding the specified amount.
     *
     * @param energyAmount The amount of energy to add.
     */
    public void eat(int energyAmount) {
        currentEnergy += energyAmount;
        if (currentEnergy > maxEnergy) {
            currentEnergy = maxEnergy;
        }
    }

    /**
     * Gets the current energy of the animal.
     *
     * @return The current energy level.
     */
    public int getCurrentEnergy() {
        return currentEnergy;
    }
    /**
     * Gets the maximum energy of the animal.
     *
     * @return The maximum energy level.
     */
    public int getMaxEnergy() {
        return maxEnergy;
    }
    /**
     * Draws the animal on the given graphics context.
     *
     * @param g The graphics context to draw on.
     */
    @Override
    public void drawObject(Graphics g) {
        BufferedImage img = null;
        img = img1;
        if (img != null && super.getLocation() != null) { // בדיקה אם getLocation לא מחזיר null
            g.drawImage(img, super.getLocation().getX(), super.getLocation().getY() - size / 10, size , size, pan);
        }
    }
    /**
     * Moves the animal based on its orientation and speed.
     */

    public void move() {
        int x = location.getX();
        int y = location.getY();
        if (orientation == Orientation.EAST) {
            x += speed;
        } else if (orientation == Orientation.SOUTH) {
            y += speed;
        } else if (orientation == Orientation.WEST) {
            x -= speed;
        } else if (orientation == Orientation.NORTH) {
            y -= speed;
        }

        // Handle energy depletion
        if (currentEnergy <= 0) {
            stopMovement();
        }
    }
    /**
     * Stops the animal's movement.
     */
    private void stopMovement() {
        // Stop animal's movement
    }
    /**
     * Loads images for different orientations of the animal.
     *
     * @param imagePath1 Path to the image for East orientation.
     * @param imagePath2 Path to the image for South orientation.
     * @param imagePath3 Path to the image for West orientation.
     * @param imagePath4 Path to the image for North orientation.
     */
    public void loadImages(String imagePath1, String imagePath2, String imagePath3, String imagePath4) {
        try {
            img1 = ImageIO.read(new File(imagePath1));
            img2 = ImageIO.read(new File(imagePath2));
            img3 = ImageIO.read(new File(imagePath3));
            img4 = ImageIO.read(new File(imagePath4));
        } catch (IOException e) {
            System.out.println("Cannot load image");
        }
    }
    /**
     * Checks for collision with the edges of the boundary and updates the orientation if needed.
     */
    public void checkEdgeCollision() {
        if (orientation == Orientation.EAST && location.getX() > 500) {
            orientation = Orientation.NORTH;
            // Update image if necessary
        } else if (orientation == Orientation.SOUTH && location.getY() > 500) {
            orientation = Orientation.WEST;
            // Update image if necessary
        }
    }
    /**
     * Sets the {@link CompetitationPanel} for the animal.
     *
     * @param pan1 The CompetitationPanel to set.
     */
    public void set_CompetitationPanel(CompetitationPanel pan1) {
        pan = pan1;
    }
    /**
     * Gets the {@link CompetitationPanel} for the animal.
     *
     * @return The CompetitationPanel.
     */
    public CompetitationPanel get_CompetitationPanel() {
        return pan;
    }
    /**
     * Loads a single image for the animal.
     *
     * @param img Path to the image.
     */
    public void loadImages(String img) {
        try { img1 = ImageIO.read(new File(img)); }
        catch (IOException e) { System.out.println("Cannot load image"); }
        System.out.print("hidbciwhjkbfwijebf");

    }




}

