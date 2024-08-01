
/**
 Yagel Batito 318271863
 Hai Karmi 207265687
 */

package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * The `AddCompetitionDialog` class represents a dialog window for selecting a competition type.
 * It allows users to choose the type of competition and confirm their selection.
 */
public class AddCompetitionDialog extends JDialog {
    private JComboBox<String> competitionTypeComboBox;
    private String selectedCompetitionType;

    /**
     * Constructs an `AddCompetitionDialog` object.
     *
     * @param parent The parent frame of this dialog.
     */

    public AddCompetitionDialog(JFrame parent) {
        super(parent, "Add Competition", true);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        // Add label for competition type selection

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("Choose competition type:"), gbc);
        // Add competition type combo box

        gbc.gridy++;
        competitionTypeComboBox = new JComboBox<>(new String[]{"Terrestrial", "Air", "Water"});
        add(competitionTypeComboBox, gbc);
        // Add button to confirm selection

        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            // Get selected competition type

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCompetitionType = (String) competitionTypeComboBox.getSelectedItem();
                setVisible(false);
            }
        });
        add(addButton, gbc);

        setPreferredSize(new Dimension(400, 200));
        pack();
        setLocationRelativeTo(parent);
    }
    /**
     * Gets the selected competition type from the dialog.
     *
     * @return The selected competition type as a string.
     */
    public String getSelectedCompetitionType() {
        return selectedCompetitionType;
    }
}
