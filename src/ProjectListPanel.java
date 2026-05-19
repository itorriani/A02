import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * A panel that displays all sprints stored in the ProjectRepository.
 * Implements ProjectObserver so it automatically updates whenever a new sprint
 * is added. Double-clicking a row opens a detail frame showing its stories.
 *
 * @author Matthew Wiecking
 * @version 1.0
 */
public class ProjectListPanel extends JPanel implements ProjectObserver {

    private final DefaultTableModel tableModel;
    private final JTable table;

    /**
     * Constructs the panel, builds the table, and registers as an observer
     * with the shared ProjectRepository.
     */
    public ProjectListPanel() {
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createTitledBorder("Sprint List"));

        String[] columns = {"ID", "Name", "Description", "Type", "Auth"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setMaxWidth(80);

        // Double-click a row to open the sprint detail frame
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //tracking double click
                if (e.getClickCount() == 2) {

                    //get row
                    int row = table.getSelectedRow();
                    
                    //get the sprint id
                    int sprintId = (int) tableModel.getValueAt(row, 0);

                    //get the sprint instance
                    Sprints sprint = ProjectRepository.getInstance().getSprintById(sprintId);
                    if (sprint != null) {
                        openSprintDetail(sprint);
                    }
                }
            }
        });

        add(new JScrollPane(table), BorderLayout.CENTER);

        ProjectRepository.getInstance().addObserver(this);

        for (Project p : ProjectRepository.getInstance().getProjects()) {
            addRow(p);
        }
    }

    /**
     * Opens a detail frame showing all stories assigned to the given sprint.
     */
    private void openSprintDetail(Sprints sprint) {
        JFrame detail = new JFrame("Sprint: " + sprint.getName());
        detail.setSize(450, 350);
        detail.setLocationRelativeTo(this);
        detail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Stories in \"" + sprint.getName() + "\":"), BorderLayout.NORTH);

        String[] columns = {"Name", "Description", "Value", "Assigned To"};
        DefaultTableModel storyModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        for (Stories s : sprint.getStory()) {
            storyModel.addRow(new Object[]{
                s.getSubjectLine(),
                s.getDescription(),
                s.getValue(),
                s.getAssignedUser()
            });
        }

        JTable storyTable = new JTable(storyModel);
        storyTable.setFillsViewportHeight(true);
        panel.add(new JScrollPane(storyTable), BorderLayout.CENTER);

        detail.add(panel);
        detail.setVisible(true);
    }

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
