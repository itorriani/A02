/**
 * GUI for creating a new sprint. Gets names, descriptions, stories, and tasks.
 *
 * @author Ivan Torriani
 * @version 1.0
 */

import javax.swing.*;
import java.awt.*;

public class CreateSprintsGUI extends JFrame {

    private Project project;

    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel descriptionLabel;
    private JTextArea descriptionText;
    private DefaultListModel<String> storiesModel;
    private JList<String> storiesList;
    private DefaultListModel<String> tasksModel;
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
        setSize(500, 600);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(0, 1, 5, 5));

        nameLabel = new JLabel("Sprint Name:");
        inputPanel.add(nameLabel);
        nameField = new JTextField();
        inputPanel.add(nameField);

        descriptionLabel = new JLabel("Description:");
        inputPanel.add(descriptionLabel);
        descriptionText = new JTextArea(4, 20);
        inputPanel.add(new JScrollPane(descriptionText));

        saveButton = new JButton("Create Sprint");
        inputPanel.add(saveButton);

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

        tasksModel = new DefaultListModel<>();
        tasksList = new JList<>(tasksModel);
        addTaskButton = new JButton("Add Task");
        addTaskButton.addActionListener(e -> {
            String task = JOptionPane.showInputDialog("Enter task name:");
            if (task != null && !task.trim().isEmpty()) {
                tasksModel.addElement(task);
            }
        });
        inputPanel.add(new JLabel("Tasks:"));
        inputPanel.add(new JScrollPane(tasksList));
        inputPanel.add(addTaskButton);

        removeButton = new JButton("Remove Selected");
        removeButton.addActionListener(e -> {
            int storyIndex = storiesList.getSelectedIndex();
            if (storyIndex != -1) {
                storiesModel.remove(storyIndex);
            }
            int taskIndex = tasksList.getSelectedIndex();
            if (taskIndex != -1) {
                tasksModel.remove(taskIndex);
            }
        });
        inputPanel.add(removeButton);

        saveButton.addActionListener(e -> handleCreateProject());

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
        for (int i = 0; i < storiesModel.size(); i++) {
            Stories story = new Stories(storiesModel.getElementAt(i), "", null, false);
            sprint.addUserStory(story);
        }
        for (int i = 0; i < tasksModel.size(); i++) {
            Task task = new Task(tasksModel.getElementAt(i), "", 0);
            sprint.addUserTask(task);
        }
        project.addUserSprint(sprint);

        outputArea.setText(
                "Sprint Created Successfully!\n" +
                        "ID:          " + sprint.getId() + "\n" +
                        "Name:        " + sprint.getName() + "\n" +
                        "Description: " + sprint.getDescription() + "\n" +
                        "Stories:     " + storiesModel.size() + "\n" +
                        "Tasks:       " + tasksModel.size());

        nameField.setText("");
        descriptionText.setText("");
        storiesModel.clear();
        tasksModel.clear();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Project testProject = new Project(1, "Test Project", "A test", "scrum", "normal");
            CreateSprintsGUI gui = new CreateSprintsGUI(testProject);
            gui.setVisible(true);
        });
    }
}