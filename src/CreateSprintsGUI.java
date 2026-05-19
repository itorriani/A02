import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GUI form for creating a new sprint.
 * Collects sprint name, description, type, and auth type from the user.
 * Lets the user pick stories from the current backlog to assign to the sprint.
 *
 * @author Ivan Torriani
 * @version 1.0
 */
public class CreateSprintsGUI extends JFrame {

    private JTextField nameField;
    private JTextArea descriptionArea;
    private JComboBox<String> sprintTypeCombo;
    private JComboBox<String> authTypeCombo;
    private JList<String> storiesList;
    private DefaultListModel<String> storiesListModel;
    private JTextArea outputArea;

    private static int nextId = 1;

    /**
     * Constructs and lays out the Create Sprint form.
     */
    public CreateSprintsGUI() {
        setTitle("Create New Sprint");
        setSize(500, 620);
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

        // Stories checklist — populated from the shared StoryRepository
        inputPanel.add(new JLabel("Assign Stories (hold Cmd/Ctrl to multi-select):"));
        storiesListModel = new DefaultListModel<>();
        for (Stories s : ProjectRepository.getInstance().getStories()) {
            storiesListModel.addElement(s.getSubjectLine());
        }
        storiesList = new JList<>(storiesListModel);
        storiesList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        storiesList.setVisibleRowCount(4);
        inputPanel.add(new JScrollPane(storiesList));

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
     * Validates input, creates a Sprints object with selected stories,
     * adds it to the repository, and displays a confirmation.
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

        int id = nextId++;
        Sprints sprint = new Sprints(id, name, description);

        // Add selected stories to the sprint
        List<Stories> allStories = ProjectRepository.getInstance().getStories();
        List<String> selectedNames = storiesList.getSelectedValuesList();
        for (Stories s : allStories) {
            if (selectedNames.contains(s.getSubjectLine())) {
                sprint.addUserStory(s);
            }
        }

        // Push to repository so the observer fires and the sprint list updates
        Project project = new Project(id, name, description, sprintType, authType);
        ProjectRepository.getInstance().addSprint(sprint);
        ProjectRepository.getInstance().addProject(project);

        outputArea.setText(
            "Sprint Created Successfully!\n" +
            "ID:          " + sprint.getId() + "\n" +
            "Name:        " + sprint.getName() + "\n" +
            "Description: " + sprint.getDescription() + "\n" +
            "Type:        " + sprintType + "\n" +
            "Auth:        " + authType + "\n" +
            "Stories:     " + sprint.getStory().size()
        );

        nameField.setText("");
        descriptionArea.setText("");
        storiesList.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CreateSprintsGUI gui = new CreateSprintsGUI();
            gui.setVisible(true);
        });
    }
}
