package system;

/**
 * HAI KARMI חי כרמי 207265687
 * yagel batito 318271863 יגל בטיטו
 */


import Olympics.Medal;
import animals.*;
import mobility.Point;

import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * The system.Sys class is a system that allows users to create and manage different types of animals,
 * including terrestrial animals, air animals, and water animals. Users can enter details for each animal,
 * such as name, gender, weight, speed, and specific attributes for each animal type.
 * The system provides functionality to view information about the animals and hear the sound each animal makes.
 */

public class Sys {
    // Constants for animal types
    static final int DOG = 1;
    static final int CAT = 2;
    static final int SNAKE = 3;
    static final int EAGLE = 1;
    static final int PIGEON = 2;
    static final int ALLIGATOR = 1;
    static final int WHALE = 2;
    static final int DOLPHIN = 3;
    static final int TERRESTRIAL_ANIMALS = 1;
    static final int AIR_ANIMALS = 2;
    static final int WATER_ANIMALS = 3;
    static final int INFORMATION = 1;
    static final int MAKE_SOUND = 2;
    static final int EXIT = 3;

    /**
     * The main method is the entry point of the program.
     * It interacts with the user to create and manage different types of animals.
     *
     * @param args command line arguments
     */

    public static void main(String[] args) {

        String name;
        Animal.Gender gender;
        double weight;
        double speed;
        Medal[] medals; // Initialize to empty array
        Point point;
        String individualSound = "";
        int num_animals = -1;
        int noLeg;
        double wingspan;
        double diveDept;
        int maxEnergy = 0;
        Snake.Poisonous poisonous;


        Scanner scanner = new Scanner(System.in);


        // Get the number of animals from the user
        do {


            System.out.print("Enter please how many animals do you want? \n");
            try {
                num_animals = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number >0");
                scanner.next();

            }

            if (num_animals <= 0) {
                System.out.println("You must enter a number greater than 0.");
            }
        } while (num_animals <= 0);


        Animal[] animals = new Animal[num_animals];

        // Get the details for each animal
        for (int i = 0; i < num_animals; i++) {
            System.out.print("FOR THE " + (i + 1) + ": ANIMAL CHOICE THE TYPE \n");
            int choice_type_TerrestrialAnimals_or_AirAnimal_or_WaterAnimal = -1;
            do {
                System.out.print("1. Terrestrial Animals \n" +
                        "2. Air Animal \n" +
                        "3. Water Animal \n");
                try {


                    choice_type_TerrestrialAnimals_or_AirAnimal_or_WaterAnimal = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number between 1 and 3");
                    scanner.next();

                }
            } while (choice_type_TerrestrialAnimals_or_AirAnimal_or_WaterAnimal > 3 || choice_type_TerrestrialAnimals_or_AirAnimal_or_WaterAnimal < 1);


            switch (choice_type_TerrestrialAnimals_or_AirAnimal_or_WaterAnimal) {
                case TERRESTRIAL_ANIMALS:

                    int choice_Terrestrial_type = -1;
                    System.out.print("Enter the type of animal:\n");
                    do {
                        System.out.print("1. Dog \n" + "2. Cat \n" + "3. Snake \n");
                        try {
                            choice_Terrestrial_type = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a number between 1 and 3");
                            scanner.next();
                        }
                    } while (choice_Terrestrial_type > 3 || choice_Terrestrial_type < 1);


                    switch (choice_Terrestrial_type) {
                        case DOG://dog case
                            System.out.print("Enter the breed of the dog:\n");
                            String breed = scanner.next();
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);
                            point = enter_point(scanner);
                            noLeg = enter_noLeg(scanner);

                            Dog dog = new Dog(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, noLeg, breed);
                            animals[i] = dog;
                            break;
                        case CAT://cat case
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);
                            point = enter_point(scanner);
                            noLeg = enter_noLeg(scanner);
                            boolean Castrated;
                            String temp;
                            System.out.print("Enter if the cat Castrated ? (yes/no):\n");
                            scanner.nextLine();
                            temp = scanner.nextLine();
                            temp = temp.toLowerCase();
                            if (temp.equals("yes") || temp.equals("y")) {
                                Castrated = true;
                                Cat cat = new Cat(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, noLeg, Castrated,"\"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dog2N.png\"",null,null,null);
                                animals[i] = cat;
                                break;
                            }
                            Cat cat = new Cat(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, noLeg, false,"\"/Users/haikarmi/Desktop/HOW_OOP/src/graphics2/dog2N.png\"",null,null,null);
                            animals[i] = cat;
                            break;
                        case SNAKE://snake case
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);
                            point = enter_point(scanner);
                            poisonous = enter_poisonous(scanner);
                            noLeg = enter_noLeg(scanner);
                            System.out.print("Enter the length of the snake:\n");
                            scanner.nextLine();
                            double length = scanner.nextDouble();
                            Snake snake = new Snake(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, noLeg, length, poisonous);
                            animals[i] = snake;
                            break;
                    }
                    break;//break the TerrestrialAnimal options

                case AIR_ANIMALS:
                    int choice_AirAnimal_type = -1;
                    do {
                        System.out.print("Enter the type of animal:\n");
                        System.out.print("1. Eagle \n" + "2. Pigeon \n");
                        try {

                            choice_AirAnimal_type = scanner.nextInt();

                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a number between 1 and 2");
                            scanner.next();
                        }
                    } while (choice_AirAnimal_type > 2 || choice_AirAnimal_type < 1);

                    switch (choice_AirAnimal_type) {
                        case EAGLE://eagle case
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);
                            point = enter_point(scanner);
                            wingspan = enter_wingspan(scanner);
                            double altitudeOfFlight;
                            System.out.print("Enter the altitude Of Flight:\n");
                            scanner.nextLine();
                            altitudeOfFlight = scanner.nextDouble();
                            Eagle eagle = new Eagle(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, wingspan, altitudeOfFlight);
                            animals[i] = eagle;
                            break;
                        case PIGEON://pigeon case
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);
                            point = enter_point(scanner);
                            wingspan = enter_wingspan(scanner);
                            String family;
                            System.out.print("Enter the family name:\n");
                            scanner.nextLine();
                            family = scanner.nextLine();
                            Pigeon pigeon = new Pigeon(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, wingspan, family);
                            animals[i] = pigeon;
                            break;
                    }
                    break;//break the AirAnimal options
                case WATER_ANIMALS:
                    int choice_WaterAnimal_type = -1;
                    do {
                        System.out.print("Enter the type of animal:\n");
                        System.out.print("1. Alligator \n" + "2. Whale \n" + "3. Dolphin \n");
                        try {
                            choice_WaterAnimal_type = scanner.nextInt();

                        } catch (InputMismatchException e) {
                            System.out.println("Please enter a number between 1 and 3");
                            scanner.next();
                        }
                    } while (choice_WaterAnimal_type > 3 || choice_WaterAnimal_type < 1);

                    switch (choice_WaterAnimal_type) {
                        case ALLIGATOR:
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);

                            point = enter_point(scanner);
                            diveDept = enter_diveDept(scanner);
                            maxEnergy = enter_maxEnergy(scanner);

                            String AreaOfLiving;
                            System.out.print("Enter the Area of Living:\n");
                            scanner.nextLine();
                            AreaOfLiving = scanner.nextLine();
                            Alligator alligator = new Alligator(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, diveDept, AreaOfLiving);
                            alligator.makeSound();
                            animals[i] = alligator;
                            break;
                        case WHALE:
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);
                            point = enter_point(scanner);
                            diveDept = enter_diveDept(scanner);
                            String foodType;
                            System.out.print("Enter the foodType:\n");
                            scanner.nextLine();
                            foodType = scanner.nextLine();
                            Whale whale = new Whale(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, diveDept, foodType);
                            animals[i] = whale;
                            break;
                        case DOLPHIN:
                            name = enter_name(scanner);
                            gender = enter_gender(scanner);
                            medals = enter_Medal(scanner);
                            weight = enter_weight(scanner);
                            speed = enter_speed(scanner);

                            point = enter_point(scanner);
                            diveDept = enter_diveDept(scanner);
                            Dolphin.WaterType WaterType = null;
                            System.out.print("Enter the WaterType:(Sea/Sweet)\n");
                            scanner.nextLine();
                            String type = scanner.nextLine().toLowerCase();
                            if (type.equals("sea")) {
                                WaterType = Dolphin.WaterType.Sea;
                                Dolphin dolphin = new Dolphin(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy ,diveDept, WaterType);
                                animals[i] = dolphin;
                                break;
                            } else if (type.equals("sweet")) {
                                Dolphin dolphin = new Dolphin(name, gender, weight, speed, point, medals.length, medals, individualSound,maxEnergy, diveDept, WaterType);
                                animals[i] = dolphin;
                                break;
                            }
                    }
                    break;//break the WaterAnimal options
            }
        }

        // Menu for additional options
        int choice_menu;
        do {
            do {
                System.out.print("Choose the option you want to do\n" +
                        "1. Information about each stock\n" +
                        "2. Speech of each individual\n" +
                        "3. Exiting the system.:\n");
                choice_menu = scanner.nextInt();
            } while (choice_menu > 3 || choice_menu < 1);

            switch (choice_menu) {
                case INFORMATION:
                    for (int i = 0; i < animals.length; i++) {
                        System.out.print(animals[i].toString());
                    }
                    break;

                case MAKE_SOUND:
                    for (int i = 0; i < animals.length; i++) {
                        animals[i].makeSound();
                    }
                    break;

                case EXIT:
                    System.out.println("Exiting the system.");
                    break;
            }
        } while (choice_menu != EXIT);

        scanner.close();
    }

    // Method to build a Medal object
    private static Medal buildMedal(Scanner scanner) {
//        Scanner scanner = new Scanner(System.in);
        int year;
        String tournament;
        Medal.MedalType type;

        System.out.print("Enter the year:\n");
        year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the tournament:\n");
        tournament = scanner.nextLine();
        System.out.print("Enter the .MedalType: (bronze, silver, gold)\n");
        String medalType;
        do {
            medalType = scanner.next();
            scanner.nextLine();
            if (!Objects.equals(medalType, "bronze") && !Objects.equals(medalType, "silver") && !Objects.equals(medalType, "gold")) {
                System.out.print("Enter bronze, silver or gold\n");
            }
        } while (!medalType.equals("bronze") && !medalType.equals("silver") && !medalType.equals("gold"));
        type = Medal.MedalType.valueOf(medalType);
        Medal medal = new Medal(year, tournament, type);
        return medal;
    }

    /**
     * Prompts the user to enter a name.
     *
     * @return the name entered by the user
     */

    public static String enter_name(Scanner scanner) {
//        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of the animal:\n");
        String name = scanner.next();
        return name;

    }

    /**
     * Prompts the user to enter a gender.
     *
     * @return the gender entered by the user
     */

    public static Animal.Gender enter_gender(Scanner scanner) {
//        Scanner scanner = new Scanner(System.in);
        String tempGender;
        System.out.print("Enter the gender of the animal only (Male, Female, Hermaphrodite):\n");
        do {
            tempGender = scanner.next();
            scanner.nextLine();
            if (!Objects.equals(tempGender, "Male") && !Objects.equals(tempGender, "Female") && !Objects.equals(tempGender, "Hermaphrodite")) {
                System.out.print("Enter Male, Female or Hermaphrodite");
            }
        } while (!tempGender.equals("Male") && !tempGender.equals("Female") && !tempGender.equals("Hermaphrodite"));
        Animal.Gender gender = Animal.Gender.valueOf(tempGender);
        return gender;


    }

    /**
     * Prompts the user to enter weight.
     *
     * @return the weight entered by the user
     */

    public static double enter_weight(Scanner scanner) {
//        Scanner scanner = new Scanner(System.in);
        double weight = -1;
        do {
            System.out.print("Enter the weight of the animal:\n");
            try {
                weight = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid weight:\n");
                scanner.nextLine(); // לנקות את קלט הסורק
            }
        } while (weight < 0);
        return weight;
    }

    /**
     * Prompts the user to enter speed.
     *
     * @return the speed entered by the user
     */

    public static double enter_speed(Scanner scanner) {
//        Scanner scanner = new Scanner(System.in);
        double speed = -1;
        do {
            System.out.print("Enter the speed of the animal: speed > 0 and speed < 6 \n");
            try {
                speed = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid speed:\n");
                scanner.nextLine();
            }
        } while (speed < 0 || speed > 5);
        return speed;
    }

    /**
     * Prompts the user to enter medals.
     *
     * @return an array of medals entered by the user
     */

    public static Medal[] enter_Medal(Scanner scanner) {
        int nummedal = -1;
//        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of medals:\n");
        do {
            try {
                nummedal = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a valid number of medals:\n");
                scanner.nextLine();
            }
        } while (nummedal < 0);

        scanner.nextLine();
        Medal[] medals = new Medal[nummedal];

        for (int i = 0; i < medals.length; i++) {
            System.out.print("Enter the details for medal " + (i + 1) + ":\n");
            medals[i] = buildMedal(scanner);
        }
        return medals;
    }

    public static Point enter_point(Scanner scanner) {

        int x = -1;
        int y = -1;
//        Scanner scanner = new Scanner(System.in);
        do {

            System.out.print("Enter the x-coordinate of the point num>=0 :\n");
            try {

                x = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number >0");
                scanner.next();
            }
        } while (x < 0);
        do {


            System.out.print("Enter the y-coordinate of the point:\n");
            try {


                y = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number >0");
                scanner.next();
            }
        } while (y < 0);

        return new Point(x, y);
    }

    /**
     * Prompts the user to enter the number of legs.
     *
     * @return the number of legs entered by the user
     */
    public static int enter_noLeg(Scanner scanner) {
        int noLeg = -1;
//        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the num leg:\n");
        try {
            noLeg = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number >0");
            scanner.next();
        }
        return noLeg;

    }

    /**
     * Prompts the user to enter the wingspan.
     *
     * @return the wingspan entered by the user
     */

    public static double enter_wingspan(Scanner scanner) {
        double wingspan = -1;
//        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the wingspan of the animal:\n");
        try {
            wingspan = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number >0");
            scanner.next();
        }
        return wingspan;
    }

    public static double enter_diveDept(Scanner scanner) {
        double diveDept = -1;
//        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the diveDept of the animal:\n");
        try {
            diveDept = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number >0");
            scanner.next();
        }
        return diveDept;
    }
    public static int enter_maxEnergy(Scanner scanner) {
        int maxEnergy = 0;
//        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maxEnergy of the animal:\n");
        try {
            maxEnergy = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number >=0");
            scanner.next();
        }
        return maxEnergy;
    }


    /**
     * Prompts the user to enter the poisonous status.
     *
     * @return the poisonous status entered by the user
     */

    public static Snake.Poisonous enter_poisonous(Scanner scanner) {//todo: lsdar
        Snake.Poisonous poisonous = Snake.Poisonous.Low;
//        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter if poisonous poisonous animal (yes or no):\n");
        String temp = scanner.nextLine();
        temp = temp.toLowerCase();
        if (temp.equals("yes") || temp.equals("y")) {
            poisonous = Snake.Poisonous.Low;
        } else if (temp.equals("no") || temp.equals("n")) {
            poisonous = Snake.Poisonous.Low;
        }
        return poisonous;
    }

}