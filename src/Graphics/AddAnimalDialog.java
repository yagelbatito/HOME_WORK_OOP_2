/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

import animals.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.table.DefaultTableModel;
/**
 * The `AddAnimalDialog` class is a dialog for adding a new animal to the system.
 * It provides a user interface for selecting animal type, entering attributes, and confirming the addition.
 */
public class AddAnimalDialog extends JDialog {
    private JComboBox<String> typeComboBox;
    private JComboBox<String> specificTypeComboBox;
    private JPanel specificTypePanel;
    private JTextField nameField;
    private JComboBox<String> pathComboBox;
    private JTextField speedField;
    private JTextField currentEnergyField;
    private JTextField totalEnergyField;
    private String competitionType;
    private DefaultTableModel tableModel;
    private PathManager pathManager;
    private Animal addedAnimal;
    private BufferedImage img;
    private int width;
    private int height;
    /**
     * Constructs an `AddAnimalDialog` object.
     *
     * @param parent         The parent frame of this dialog.
     * @param competitionType The type of competition.
     * @param tableModel     The table model for the animals.
     * @param pathManager    The path manager for handling paths.
     */
    public AddAnimalDialog(JFrame parent, String competitionType, DefaultTableModel tableModel, PathManager pathManager) {
        super(parent, "Add Animal", true);
        this.competitionType = competitionType;
        this.tableModel = tableModel;
        this.pathManager = pathManager;
        CompetitionFrame frame = (CompetitionFrame) parent;
        this.img = frame.getImg();
        this.width = img.getWidth();
        this.height = img.getHeight();

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Add label for animal type selection

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Choose animal type:"), gbc);
        // Add animal type combo box

        gbc.gridy++;
        typeComboBox = new JComboBox<>(new String[]{"Terrestrial", "Air", "Water"});
        typeComboBox.addActionListener(e -> updateSpecificTypeComboBox());
        add(typeComboBox, gbc);
        // Panel for specific type selection

        specificTypePanel = new JPanel();
        specificTypePanel.setLayout(new GridBagLayout());
        gbc.gridy++;
        add(specificTypePanel, gbc);
        // Add label and field for animal name

        gbc.gridy++;
        add(new JLabel("Enter the name of the animal:"), gbc);

        gbc.gridy++;
        nameField = new JTextField(20);
        add(nameField, gbc);
        // Add label and combo box for path selection

        gbc.gridy++;
        add(new JLabel("Select path:"), gbc);

        gbc.gridy++;
        pathComboBox = new JComboBox<>();
        add(pathComboBox, gbc);
        // Add labels and fields for speed, current energy, and total energy

        gbc.gridy++;
        add(new JLabel("Enter speed:"), gbc);

        gbc.gridy++;
        speedField = new JTextField(20);
        add(speedField, gbc);

        gbc.gridy++;
        add(new JLabel("Enter current energy:"), gbc);

        gbc.gridy++;
        currentEnergyField = new JTextField(20);
        add(currentEnergyField, gbc);

        gbc.gridy++;
        add(new JLabel("Enter total energy:"), gbc);

        gbc.gridy++;
        totalEnergyField = new JTextField(20);
        add(totalEnergyField, gbc);

        updateSpecificTypeComboBox(); // Initial update for specific type combo box
        // Add button to add animal

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            // Get user inputs

            String selectedType = (String) typeComboBox.getSelectedItem();
            String name = nameField.getText();
            String specificType = (String) specificTypeComboBox.getSelectedItem();
            String path = (String) pathComboBox.getSelectedItem();
            int speed = 0;
            int currentEnergy = 0;
            int totalEnergy = 0;


            try {
                speed = Integer.parseInt(speedField.getText());
                currentEnergy = Integer.parseInt(currentEnergyField.getText());
                totalEnergy = Integer.parseInt(totalEnergyField.getText());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid integer for speed, current energy, and total energy.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // exit the method if input is invalid
            }


            if (competitionType.equals(selectedType)) {
                if (path == null || path.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "No path selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Determine path index
                int pathIndex = getPathIndex(path);

                Animal animal = createAnimal(specificType, name, speed, currentEnergy, totalEnergy, pathIndex);
                if (animal != null) {
                    addedAnimal = animal;
                    new Timer(1, e1 -> dispose()).start();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid animal type.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Animal type does not match competition type.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        add(addButton, gbc);

        setPreferredSize(new Dimension(400, 700));
        pack();
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    /**
     * Retrieves the index of the path from the given path string.
     *
     * @param path The path string (e.g., "Path 1").
     * @return The path index as an integer.
     */
    private int getPathIndex(String path) {
        try {
            return Integer.parseInt(path.replaceAll("\\D+", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Creates an `Animal` object based on the provided attributes.
     *
     * @param specificType  The specific type of animal (e.g., "Dog", "Pigeon").
     * @param name          The name of the animal.
     * @param speed         The speed of the animal.
     * @param currentEnergy The current energy of the animal.
     * @param totalEnergy   The total energy of the animal.
     * @param pathIndex     The path index for the animal.
     * @return The created `Animal` object or `null` if the type is invalid.
     */
    private Animal createAnimal(String specificType, String name, int speed, int currentEnergy, int totalEnergy, int pathIndex) {
        Animal animal = null;
        String imagePath = "";
        int x = 0;
        int y = 0;

        switch (specificType) {
            case "Dog":
            case "Cat":
            case "Snake":
                x = 0;
                y = 0;
                break;
            case "Pigeon":
            case "Eagle":
                x = 0;
                y = calculateYAirPosition(pathIndex);
                break;
            case "Dolphin":
            case "Whale":
                x = width / 14;
                y = calculateYWaterPosition(pathIndex);
                break;
            case "Alligator":
                if (competitionType.equals("Terrestrial")) {
                    x = 0;
                    y = 0;
                } else if (competitionType.equals("Water")) {
                    x = width / 14;
                    y = calculateYWaterPosition(pathIndex);
                }
                break;
            default:
                return null;
        }

        switch (specificType) {
            case "Alligator":
                imagePath = "src/graphics2/alligator3.png";
                animal = new Alligator(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;
            case "Dog":
                imagePath = "src/graphics2/dog1.png";
                animal = new Dog(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;
            case "Cat":
                imagePath = "src/graphics2/cat1.png";
                animal = new Cat(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;
            case "Pigeon":
                imagePath = "src/graphics2/pigeon.png";
                animal = new Pigeon(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;
            case "Dolphin":
                imagePath = "src/graphics2/dolphin1.png";
                animal = new Dolphin(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;
            case "Snake":
                imagePath = "src/graphics2/snake1.png";
                animal = new Snake(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;
            case "Eagle":
                imagePath = "src/graphics2/eagle1.png";
                animal = new Eagle(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;
            case "Whale":
                imagePath = "src/graphics2/whale.png";
                animal = new Whale(name, speed, currentEnergy, totalEnergy, imagePath, x, y);
                break;


            default:
                return null;
        }

        return animal;
    }
    /**
     * Updates the `specificTypeComboBox` based on the selected animal type.
     * It also updates the `pathComboBox` with available paths for the selected animal type.
     */

    private void updateSpecificTypeComboBox() {
        specificTypePanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String selectedType = (String) typeComboBox.getSelectedItem();
        if (selectedType != null) {
            String[] specificTypes = {};

            switch (selectedType) {
                case "Terrestrial":
                    specificTypes = new String[]{"Dog", "Cat", "Snake","Alligator"};
                    break;
                case "Air":
                    specificTypes = new String[]{"Eagle", "Pigeon"};
                    break;
                case "Water":
                    specificTypes = new String[]{"Dolphin", "Whale","Alligator"};
                    break;
            }

            specificTypeComboBox = new JComboBox<>(specificTypes);
            gbc.gridx = 0;
            gbc.gridy = 0;
            specificTypePanel.add(specificTypeComboBox, gbc);

            updatePathComboBox(selectedType);
        }

        specificTypePanel.revalidate();
        specificTypePanel.repaint();
        pack();
    }
    /**
     * Updates the `pathComboBox` with available paths based on the selected animal type.
     *
     * @param animalType The type of the animal (e.g., "Terrestrial", "Air", "Water").
     */
    private void updatePathComboBox(String animalType) {
        pathComboBox.removeAllItems();
        String[] paths = {};
        switch (animalType) {
            case "Terrestrial":
                paths = new String[]{"0.0"};
                break;
            case "Water":
                paths = new String[]{"Path 1", "Path 2", "Path 3", "Path 4"};
                break;
            case "Air":
                paths = new String[]{"Path 1", "Path 2", "Path 3", "Path 4", "Path 5"};
                break;
        }
        for (String path : paths) {
            pathComboBox.addItem(path);
        }
    }
    /**
     * Calculates the Y-coordinate position for an air animal based on the selected path.
     *
     * @param path The path index (1 to 5) for the air animal.
     * @return The Y-coordinate position for the animal.
     */
    private int calculateYAirPosition(int path) {
        if (path == 1) {
            return 0;
        }
        if (path == 2) {
            return height / 8 + height / 10;
        }
        if (path == 3) {
            return height / 3 + height / 10;
        }
        if (path == 4) {
            return height / 2 + height / 7;
        }
        if (path == 5) {
            return height / 2 + height / 3;
        }
        return 0;
    }

    /**
     * Calculates the Y-coordinate position for a water animal based on the selected path.
     *
     * @param path The path index (1 to 4) for the water animal.
     * @return The Y-coordinate position for the animal.
     */

    private int calculateYWaterPosition(int path) {
        if (path == 1) {
            return height / 8;
        } else if (path == 2) {
            return height / 3;
        } else if (path == 3) {
            return height / 3 + height / 5;
        } else if (path == 4) {
            return height / 3 + height / 3 + height / 13;
        }
        return 0;
    }



    public Animal getAddedAnimal() {
        return addedAnimal;
    }
}
