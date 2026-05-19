/**
 * Panel that displays the product backlog — a list of user stories.
 * Shown on the bottom half of the main dashboard.
 * Stories can be added via a dialog that prompts for description, value, and assigned user.
 *
 * @author Ivan Torriani
 * @version 1.0
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BacklogPanel extends JPanel {


    /**
     * Constructs the BacklogPanel with a table and an "Add Story" button.
     */
    public BacklogPanel() 
    {
        JFrame backlogFrame = new JFrame("Backlog Panel"); // create a backlog frame panel

        //Create the fields

        JLabel label1 = new JLabel("Name: ");
        JTextField field1 = new JTextField();

        JLabel label2 = new JLabel("Description:  ");
        JTextField field2 = new JTextField();

        JLabel label3 = new JLabel("Value: ");
        JTextField field3 = new JTextField();


        JLabel label4 = new JLabel("User Assignment: ");
        JTextField field4 = new JTextField();
    }

      