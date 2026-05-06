/*
Author: Ivan T. 
*/

//imports
import java.util.LinkedList;
import java.util.Scanner;


public class Stories {


    //initialize variables

    private String subjectLine; 
    
    private String description; 

    private LinkedList<Project> attatchments = new LinkedList<>();  

    private boolean position; 


    public Stories(String subjectLine, String description, LinkedList<Project> attatchments, boolean position)
    {
        this.subjectLine = subjectLine;
        this.description = description; 
        this.attatchments = attatchments;
        this.position = position;
    }

    
    public void setSubjectLine()
    {
        /*
        Description: Get user input to set subect line. Refer to tasks 
        class for line by line comments
        */

       Scanner input = new Scanner(System.in);

       System.out.println("Enter Subject Line: ");

       String newSubjectLine = input.nextLine();

       this.subjectLine = newSubjectLine;

    }

    public void setDescription()
    {
        /*
        Description: Get user input to set the description. Refer to tasks 
        class for line by line comments
        */

       Scanner input = new Scanner(System.in);

       System.out.println("Enter Description: ");

       String newDescription = input.nextLine();

       this.description = newDescription;

    }

    public void setPosition()
    {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Position:");

        boolean newPosition = input.nextBoolean();

        this.position = newPosition;


    }

    public void setAttatchments()
    {

        /*
        Description: Get user input to add attatchments. For now, 
        attatchments are just user inputted strings 
        (will add logic for other types later)
        */

        String close = "close"; // create close string to close when needed

        

        LinkedList<Project> newAttatchments = new LinkedList<>(); // create an 
        //temporary array for new attatchments

        while (true) { 
                Scanner input = new Scanner(System.in); //input setp

                System.out.println("Please enter string attatchment. Enter close if you
                want to stop"); //prompt

                String toAdd = input.nextLine(); //read the input

                if (toAdd.equals("close")) { return; } //return if the user types in close

                newAttatchments.add(toAdd); // add element
        }

        this.attatchments = newAttatchments; //assign the copied list


    }



    // Getters
    public String getSubjectLine() {
        return subjectLine;
    }

    public String getDescription() {
        return description;
    }

    public LinkedList<Project> getAttatchments() {
        return attatchments;
    }

    public boolean getPosition() {
        return position;
    }

    


}