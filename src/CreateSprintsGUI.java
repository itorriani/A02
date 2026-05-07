import javax.swing.*;
import java.awt.*;

/**
 * GUI for creating a new sprint. Gets names, descriptions, stories, and tasks.
 */

public class CreateSprintsGUI extends JFrame {

    private Project project;

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel descriptionLabel;
    private JTextField descriptionField;
    private JTextArea descriptionText;
    private DefaultListModel<String> storiesModel;
    private JList<String> storiesList;
    private JList<String> tasksList;
    private JButton addStoryButton;
    private JButton addTaskButton;
    private JButton saveButton;
    private JButton removeButton;
    private JTextArea outputArea;

    private static int nextId = 1;

    public CreateSprintsGUI(Project project) {
        this.project = project;
        setTitle("Create New Sprint");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(0, 1, 5, 5));

        inputPanel.add(new JLabel("Sprint Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Description:"));
        descriptionText = new JTextArea(4, 20);
        inputPanel.add(new JScrollPane(descriptionText));

        JButton createButton = new JButton("Create Sprint");
        inputPanel.add(createButton);

        inputPanel.add(new JLabel("Output:"));
        outputArea = new JTextArea(5, 20);
        outputArea.setEditable(false);
        inputPanel.add(new JScrollPane(outputArea));

        storiesModel = new DefaultListModel<>();
        storiesList = new JList<>(storiesModel);
        addStoryButton = new JButton("Add Story");
        addStoryButton.addActionListener(e -> {
            String story = JOptionPane.showInputDialog("Enter story name:");
            if (story != null && !story.trim().isEmpty()) {
                storiesModel.addElement(story);
            }
        });

        inputPanel.add(new JLabel("Stories:"));
        inputPanel.add(new JScrollPane(storiesList));
        inputPanel.add(addStoryButton);

        createButton.addActionListener(e -> handleCreateProject());

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    private void handleCreateProject() {
        String name = nameField.getText().trim();
        String description = descriptionText.getText().trim();

        if (name.isEmpty()) {
            outputArea.setText("Error: Sprint name cannot be empty.");
            return;
        }

        Sprints sprint = new Sprints(nextId++, name, description);
        project.addUserSprint(sprint);

        outputArea.setText(
                "Sprint Created Successfully!\n" +
                        "ID:          " + sprint.getId() + "\n" +
                        "Name:        " + sprint.getName() + "\n" +
                        "Description: " + sprint.getDescription());

        nameField.setText("");
        descriptionText.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Project testProject = new Project(1, "Test Project", "A test", "scrum", "normal");
            CreateSprintsGUI gui = new CreateSprintsGUI(testProject);
            gui.setVisible(true);
        });
    }
}