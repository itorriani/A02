import javax.swing.*;
import java.awt.*;

/**
 * GUI form for creating a new sprint.
 * Collects sprint name, description, type, and auth type from the user,
 * then constructs a Sprints object and adds it to the ProjectRepository.
 *
 * @author Ivan Torriani
 * @version 1.0
 */
public class CreateSprintsGUI extends JFrame {

    private JTextField nameField;
    private JTextArea descriptionArea;
    private JComboBox<String> sprintTypeCombo;
    private JComboBox<String> authTypeCombo;
    private JTextArea outputArea;

    private static int nextId = 1;

    /**
     * Constructs and lays out the Create Sprint form.
     */
    public CreateSprintsGUI() {
        setTitle("Create New Sprint");
        setSize(500, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(0, 1, 5, 5));

        inputPanel.add(new JLabel("Sprint Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Description:"));
        descriptionArea = new JTextArea(4, 20);
        inputPanel.add(new JScrollPane(descriptionArea));

        inputPanel.add(new JLabel("Sprint Type:"));
        sprintTypeCombo = new JComboBox<>(new String[]{"Scrum", "Kanban", "Waterfall"});
        inputPanel.add(sprintTypeCombo);

        inputPanel.add(new JLabel("Auth Type:"));
        authTypeCombo = new JComboBox<>(new String[]{"Public", "Private", "Protected"});
        inputPanel.add(authTypeCombo);

        JButton createButton = new JButton("Create Sprint");
        inputPanel.add(createButton);

        inputPanel.add(new JLabel("Output:"));
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        inputPanel.add(new JScrollPane(outputArea));

        createButton.addActionListener(e -> handleCreateSprint());

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    /**
     * Validates input, creates a Sprints object, and displays a confirmation.
     * Clears the form on success.
     */
    private void handleCreateSprint() {
        String name = nameField.getText().trim();
        String description = descriptionArea.getText().trim();
        String sprintType = (String) sprintTypeCombo.getSelectedItem();
        String authType = (String) authTypeCombo.getSelectedItem();

        if (name.isEmpty()) {
            outputArea.setText("Error: Sprint name cannot be empty.");
            return;
        }

        Sprints sprint = new Sprints(nextId++, name, description);

        outputArea.setText(
            "Sprint Created Successfully!\n" +
            "ID:          " + sprint.getId() + "\n" +
            "Name:        " + sprint.getName() + "\n" +
            "Description: " + sprint.getDescription() + "\n" +
            "Type:        " + sprintType + "\n" +
            "Auth:        " + authType
        );

        nameField.setText("");
        descriptionArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CreateSprintsGUI gui = new CreateSprintsGUI();
            gui.setVisible(true);
        });
    }
}
