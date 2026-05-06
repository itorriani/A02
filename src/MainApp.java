package src;

import javax.swing.*;
import java.awt.*;

/**
 * Main application window for the project management tool.
 * Hosts a "New Project" button and the live project list panel.
 * The list updates automatically via the Observer pattern when a project is created.
 *
 * @author Matthew Wiecking
 * @version 1.0
 */
public class MainApp extends JFrame {

    /**
     * Builds the main window with a toolbar and the live project list.
     */
    public MainApp() {
        setTitle("Project Management");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton newProjectBtn = new JButton("+ New Project");
        newProjectBtn.addActionListener(e -> {
            CreateProjectGUI form = new CreateProjectGUI();
            form.setVisible(true);
        });
        toolbar.add(newProjectBtn);

        root.add(toolbar, BorderLayout.NORTH);
        root.add(new ProjectListPanel(), BorderLayout.CENTER);

        add(root);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApp app = new MainApp();
            app.setVisible(true);
        });
    }
}
