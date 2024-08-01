
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

import animals.Animal;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * The `CompetitionFrame` class represents the main frame of the competition application.
 * It manages the display of animals, the background image, and provides menu options.
 */
public class CompetitionFrame extends JFrame {
    private BufferedImage img;
    private JPanel panel;
    private List<Animal> animals;
    private final int preferedWidth = 1024;
    private final int preferedHeight = 768;
    private CompetitationPanel competitationPanel;
    private int check;
    /**
     * Constructs a `CompetitionFrame` object and initializes the frame.
     * Loads the background image and sets up the main panel and menu bar.
     */
    public CompetitionFrame() {
        super("Competition");
        // Load background image

        try {
            img = ImageIO.read(new File("src/graphics2/competitionBackground.png"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Cannot load image");
            System.exit(1);
        }

        animals = new ArrayList<>();
        competitationPanel = new CompetitationPanel(this);
        // Initialize the panel for drawing animals and background

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
                Graphics2D g2d = (Graphics2D) g;
                double scaleX = getWidth() / (double) preferedWidth;
                double scaleY = getHeight() / (double) preferedHeight;
                g2d.scale(scaleX, scaleY);
                // Draw each animal on the panel

                for (Animal animal : animals) {
                    animal.drawObject(g);
                }
            }
        };

        setLayout(new BorderLayout());
        // Create menu bar with file and help options

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(CompetitionFrame.this, "Do you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        fileMenu.add(exitMenuItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpMenuItem = new JMenuItem("Help");
        helpMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(CompetitionFrame.this, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        helpMenu.add(helpMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        // Add panels to the frame

        add(panel, BorderLayout.CENTER);
        add(competitationPanel, BorderLayout.SOUTH);
        // Set default close operation and frame size

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 750);
        setVisible(true);
    }
    /**
     * Gets the panel used for drawing animals and the background image.
     *
     * @return The drawing panel.
     */
    public JPanel getPanel() {
        return panel;
    }
    /**
     * Adds an animal to the panel and requests a repaint to update the display.
     *
     * @param animal The animal to add to the panel.
     */

    public void addAnimalToPanel(Animal animal) {
        animals.add(animal);
        panel.repaint();
    }
    /**
     * Removes an animal from the panel and requests a repaint to update the display.
     *
     * @param animal The animal to remove from the panel.
     */

    public void removeAnimalFromPanel(Animal animal) {
        animals.remove(animal);
        panel.repaint(); // Update the display after removing the animal
    }
    /**
     * Gets the background image used for the competition frame.
     *
     * @return The background image.
     */
    public BufferedImage getImg() {
        return img;
    }
    /**
     * Main method to launch the `CompetitionFrame` application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new CompetitionFrame();
    }
}
// shinu