/**
 * GUI for creating and managing Stories (user stories).
 * A story has a subject line, description, attachments, and position.
 *
 * @author Ivan Torriani
 * @version 1.0
 */

//imports
import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;


public class Stories extends JFrame {


    //initialize variables

    private String subjectLine; 
    
    private String description; 

    private LinkedList<String> attatchments = new LinkedList<>();  

    private boolean position; 


    private JTextField subjectLineField;
    
    private JTextArea descriptionArea;

    private JTextField attatchmentField;

    private DefaultListModel<String> attatchmentListModel;

    private JList<String> attatchmentList;

    private JCheckBox positionCheckBox;

    private JTextArea outputArea;


    public Stories(String subjectLine, String description, LinkedList<String> attatchments, boolean position)
    {
        this.subjectLine = subjectLine;
        this.description = description; 
        this.attatchments = attatchments;
        this.position = position;
    }


    public Stories()
    {
        setTitle("Stories GUI");

        setSize(500, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);


        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout(10, 10));


        JPanel inputPanel = new JPanel();

        inputPanel.setLayout(new GridLayout(0, 1, 5, 5));


        JLabel subjectLabel = new JLabel("Enter Subject Line: ");

        subjectLineField = new JTextField();


        JLabel descriptionLabel = new JLabel("Enter Description: ");

        descriptionArea = new JTextArea(5, 20);

        JScrollPane descriptionScrollPane = new JScrollPane(descriptionArea);


        JLabel attatchmentLabel = new JLabel("Please enter string attatchment:");

        attatchmentField = new JTextField();

        JButton addAttatchmentButton = new JButton("Add Attatchment");


        attatchmentListModel = new DefaultListModel<>();

        attatchmentList = new JList<>(attatchmentListModel);

        JScrollPane attatchmentScrollPane = new JScrollPane(attatchmentList);


        JButton removeAttatchmentButton = new JButton("Remove Selected Attatchment");


        positionCheckBox = new JCheckBox("Enter Position");


        JButton createButton = new JButton("Create Story");


        outputArea = new JTextArea(8, 20);

        outputArea.setEditable(false);

        JScrollPane outputScrollPane = new JScrollPane(outputArea);


        addAttatchmentButton.addActionListener(e -> {
            String toAdd = attatchmentField.getText();

            if (!toAdd.equals("")) {
                attatchmentListModel.addElement(toAdd);
                attatchmentField.setText("");
            }
        });


        removeAttatchmentButton.addActionListener(e -> {
            int selectedIndex = attatchmentList.getSelectedIndex();

            if (selectedIndex != -1) {
                attatchmentListModel.remove(selectedIndex);
            }
        });


        createButton.addActionListener(e -> {
            String newSubjectLine = subjectLineField.getText();

            String newDescription = descriptionArea.getText();

            boolean newPosition = positionCheckBox.isSelected();

            LinkedList<String> newAttatchments = new LinkedList<>();


            for (int i = 0; i < attatchmentListModel.size(); i++) {
                newAttatchments.add(attatchmentListModel.getElementAt(i));
            }


            setSubjectLine(newSubjectLine);

            setDescription(newDescription);

            setAttatchments(newAttatchments);

            setPosition(newPosition);


            outputArea.setText(
                "Subject Line: " + getSubjectLine() +
                "\nDescription: " + getDescription() +
                "\nAttatchments: " + getAttatchments() +
                "\nPosition: " + getPosition()
            );
        });


        inputPanel.add(subjectLabel);

        inputPanel.add(subjectLineField);

        inputPanel.add(descriptionLabel);

        inputPanel.add(descriptionScrollPane);

        inputPanel.add(attatchmentLabel);

        inputPanel.add(attatchmentField);

        inputPanel.add(addAttatchmentButton);

        inputPanel.add(attatchmentScrollPane);

        inputPanel.add(removeAttatchmentButton);

        inputPanel.add(positionCheckBox);

        inputPanel.add(createButton);

        inputPanel.add(new JLabel("Output:"));

        inputPanel.add(outputScrollPane);


        mainPanel.add(inputPanel, BorderLayout.CENTER);


        add(mainPanel);
    }

    
    public void setSubjectLine(String newSubjectLine)
    {
        /*
        Description: Get user input to set subect line. Refer to tasks 
        class for line by line comments
        */

       this.subjectLine = newSubjectLine;

    }

    public void setDescription(String newDescription)
    {
        /*
        Description: Get user input to set the description. Refer to tasks 
        class for line by line comments
        */

       this.description = newDescription;

    }

    public void setPosition(boolean newPosition)
    {

        this.position = newPosition;


    }

    public void setAttatchments(LinkedList<String> newAttatchments)
    {

        /*
        Description: Get user input to add attatchments. For now, 
        attatchments are just user inputted strings 
        (will add logic for other types later)
        */

        this.attatchments = newAttatchments; //assign the copied list


    }



    // Getters
    public String getSubjectLine() {
        return subjectLine;
    }

    public String getDescription() {
        return description;
    }

    public LinkedList<String> getAttatchments() {
        return attatchments;
    }

    public boolean getPosition() {
        return position;
    }

    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Stories gui = new Stories();

            gui.setVisible(true);
        });
    }
}