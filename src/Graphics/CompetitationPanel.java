/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */


package Graphics;

import animals.Animal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


/**
 * The `CompetitationPanel` class represents a panel in the competition interface.
 * It provides controls for managing competitions, adding and removing animals, feeding animals, and displaying animal information.
 */
public class CompetitationPanel extends JPanel {
    private JButton addCompetition;
    private JButton addAnimal;
    private JButton clear;
    private JButton eat;
    private JButton info;
    private JButton exit;
    private JButton removeAnimal;
    private String selectedCompetitionType;
    private DefaultTableModel tableModel;
    private JTable table;
    private Animal animal;
    private Map<String, String> animalImagePaths;
    private List<Animal> animals;
    private JPanel panel;
    private BufferedImage img;
    private CompetitionFrame competitionFrame;
    /**
     * Constructs a `CompetitationPanel` object.
     *
     * @param competitionFrame The parent competition frame that manages this panel.
     */
    public CompetitationPanel(CompetitionFrame competitionFrame) {
        this.competitionFrame = competitionFrame;
        setLayout(new BorderLayout());
        animals = new ArrayList<>();

        JPanel buttonPanel = new JPanel();
        // Initialize and add 'Add Competition' button

        addCompetition = new JButton("Add Competition");
        addCompetition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(CompetitationPanel.this);
                AddCompetitionDialog dialog = new AddCompetitionDialog(parent);
                dialog.setVisible(true);
                selectedCompetitionType = dialog.getSelectedCompetitionType();
            }
        });
        // Initialize and add 'Add Animal' button

        addAnimal = new JButton("Add Animal");
        addAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedCompetitionType != null) {
                    JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(CompetitationPanel.this);
                    AddAnimalDialog dialog = new AddAnimalDialog(parent, selectedCompetitionType, tableModel, new PathManager());
                    dialog.setVisible(true);

                    Animal newAnimal = dialog.getAddedAnimal();
                    if (newAnimal != null) {
                        animals.add(newAnimal);
                        competitionFrame.addAnimalToPanel(newAnimal); // Add the animal to the main panel
                        tableModel.addRow(new Object[]{
                                newAnimal.getName(),
                                selectedCompetitionType,  // Adjusted to show competition type
                                newAnimal.getClass().getSimpleName(), // Ensure this matches table column headers
                                newAnimal.getSpeed(),
                                newAnimal.getCurrentEnergy(),
                                newAnimal.getMaxEnergy(),
                                newAnimal.getPoint(),  // Assuming 'Point' needs a specific format
                                newAnimal.getEnergyConsumption() // Adjusted to show energy consumption if needed
                        });
                        updateTableVisibility();
                        repaint(); // Repaint the panel to update the display
                    }
                } else {
                    JOptionPane.showMessageDialog(CompetitationPanel.this, "Please add a competition first.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        // Initialize and add 'Clear' button

        clear = new JButton("clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animals.isEmpty()) {
                    String[] animalNames = animals.stream().map(Animal::getName).toArray(String[]::new);
                    String animalToRemove = (String) JOptionPane.showInputDialog(
                            SwingUtilities.getWindowAncestor(CompetitationPanel.this),
                            "Select animal to remove:",
                            "Remove Animal",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            animalNames,
                            animalNames[0]
                    );

                    if (animalToRemove != null) {
                        Animal animal = animals.stream()
                                .filter(a -> a.getName().equals(animalToRemove))
                                .findFirst()
                                .orElse(null);

                        if (animal != null) {
                            animals.remove(animal);
                            tableModel.removeRow(tableModel.getRowCount() - 1);
                            updateTableVisibility();
                            competitionFrame.removeAnimalFromPanel(animal); // Remove the animal from the main panel
                            repaint(); // Repaint the panel to update the display
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(CompetitationPanel.this, "No animals on the screen to remove.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Initialize and add 'Eat' button

        eat = new JButton("Eat");
        eat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animals.isEmpty()) {
                    JOptionPane.showMessageDialog(CompetitationPanel.this, "No animals to feed.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String[] animalNames = animals.stream().map(Animal::getName).toArray(String[]::new);
                String selectedAnimalName = (String) JOptionPane.showInputDialog(
                        SwingUtilities.getWindowAncestor(CompetitationPanel.this),
                        "Select animal to feed:",
                        "Feed Animal",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        animalNames,
                        animalNames[0]
                );

                if (selectedAnimalName != null) {
                    Animal selectedAnimal = animals.stream()
                            .filter(a -> a.getName().equals(selectedAnimalName))
                            .findFirst()
                            .orElse(null);

                    if (selectedAnimal != null) {
                        String input = (String) JOptionPane.showInputDialog(
                                SwingUtilities.getWindowAncestor(CompetitationPanel.this),
                                "Enter energy amount:",
                                "Energy Input",
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                null,
                                ""
                        );
                        if (input != null && !input.isEmpty()) {
                            try {
                                int energyAmount = Integer.parseInt(input);
                                if (energyAmount > 0) {
                                    selectedAnimal.eat(energyAmount);
                                    JOptionPane.showMessageDialog(CompetitationPanel.this, "Energy updated. Current energy: " + selectedAnimal.getCurrentEnergy() + "/" + selectedAnimal.getMaxEnergy());
                                    competitionFrame.getPanel().repaint(); // Repaint the main panel to update the display
                                } else {
                                    JOptionPane.showMessageDialog(CompetitationPanel.this, "Please enter a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(CompetitationPanel.this, "Invalid input. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
            }
        });
        // Initialize and add 'Info' button

        info = new JButton("Info");
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tableModel.getRowCount() > 0) {
                    JFrame infoFrame = new JFrame("Animals Information");
                    infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    infoFrame.setSize(800, 400);
                    infoFrame.add(new JScrollPane(table));
                    infoFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "No data to display.", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        // Initialize and add 'Exit' button

        exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });

        // Add buttons to the button panel

        buttonPanel.add(addCompetition);
        buttonPanel.add(addAnimal);
        buttonPanel.add(clear);
        buttonPanel.add(eat);
        buttonPanel.add(info);
        buttonPanel.add(exit);

        add(buttonPanel, BorderLayout.NORTH);
        // Initialize and set up the table for displaying animal information

        String[] columnNames = {"Animal", "Category", "Type", "Speed", "Energy", "Max Energy", "Distance", "Energy Consumption"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        JScrollPane tableScrollPane = new JScrollPane(table);
        add(tableScrollPane, BorderLayout.CENTER);
        tableScrollPane.setVisible(false);

        // Initialize and add custom panel for drawing animals
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (img != null) {
                    g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                }
                for (Animal animal : animals) {
                    animal.drawObject(g);
                }
            }
        };
        add(panel, BorderLayout.SOUTH);
    }

    /**
     * Updates the visibility of the animal table based on its row count.
     */
    private void updateTableVisibility() {
        if (tableModel.getRowCount() > 0) {
            table.getParent().getParent().setVisible(true);
        } else {
            table.getParent().getParent().setVisible(false);
        }
    }
    /**
     * Gets the list of animals currently managed by this panel.
     *
     * @return A list of `Animal` objects.
     */
    public List<Animal> getAnimals() {
        return animals;
    }
}
