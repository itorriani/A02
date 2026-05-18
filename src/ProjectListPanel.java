import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * A panel that displays all projects stored in the ProjectRepository (Blackboard).
 * Implements ProjectObserver so it automatically updates whenever a new project
 * is added — no manual refresh needed.
 *
 * @author Matthew Wiecking
 * @version 1.0
 */
public class ProjectListPanel extends JPanel implements ProjectObserver {

    private final DefaultTableModel tableModel;

    /**
     * Constructs the panel, builds the table, and registers as an observer
     * with the shared ProjectRepository.
     */
    public ProjectListPanel() {
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("Project List"));

        String[] columns = {"ID", "Name", "Description", "Type", "Auth"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        JTable table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setMaxWidth(80);

        add(new JScrollPane(table), BorderLayout.CENTER);

        ProjectRepository.getInstance().addObserver(this);

        // Populate any projects already in the repository at construction time
        for (Project p : ProjectRepository.getInstance().getProjects()) {
            addRow(p);
        }
    }

    /**
     * Called by ProjectRepository whenever a new project is added.
     * Appends a row to the table on the Swing event thread.
     *
     * @param project the newly added project
     */
    @Override
    public void onProjectAdded(Project project) {
        SwingUtilities.invokeLater(() -> addRow(project));
    }

    private void addRow(Project project) {
        tableModel.addRow(new Object[]{
            project.getId(),
            project.getName(),
            project.getDescription(),
            project.getProjType(),
            project.getAuthType()
        });
    }
}
