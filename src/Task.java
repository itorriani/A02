/*
Author: Ivan T. 

Random Ideas:
- Need method to name task
- Need method to assign user to task
- Need method to assign value to task
*/

//imports
import java.Util.Scanner;


public class Task {


    //initialize variables

    private String taskName;
    
    private String userAssignment; 

    private int taskValue; 

    public Task(String taskName, String userAssignment, int taskValue)
    {
        /*
        Method Description: constructor
        */
        this.taskName = taskName;
        this.userAssignment = userAssignment; 
        this.taskValue = taskValue;
    }

    
    public void setTaskName()
    {
        /*
        Method Description: assign a task object's taskName
        */
       Scanner input = new Scanner(System.in); // set up scanner object to get console info

       System.out.println("Enter Task Name: ") // prompt user to enter task name 

       String newTaskName = input.nextLine();  //read task name from console

       this.taskName = newTaskName; //assign taskName

    }

    public void setUserAssignment()
    {
        /*
        Method Description: assign a task user
        */

       Scanner input = new Scanner(System.in); // set up scanner object to get console info

       System.out.println("Enter User Assignment: ") // prompt user to enter user assignment 

       String newUserAssignment = input.nextLine();  //read user name from console

       this.userAssignment = newUserAssignment; //assign taskName

    }

    public void setTaskValue()
    {
        /*
        Method Description: assign a task object's taskName
        */

        Scanner input = new Scanner(System.in); // set up scanner object to get console info

        System.out.println("Enter Task Value"); // prompt user to enter user value

        int newTaskValue = input.nextInt(); // read from console

        this.taskValue = newTaskValue(); // assign task


    }

    public 

    // Getters . setters
    public String getTaskName() {
        return taskName;
    }

    public String getUserAssignment() {
        return userAssignment;
    }

    public int getTaskValue() {
        return taskValue;
    }

    public String setTaskName(String newTaskName) {
        this.taskName = newTaskName;
    }

    public String getUserAssignment(String newUserAssignment) {
        this.userAssignment = newUserAssignment;
    }

    public int getTaskValue(int newTaskValue) {
        this.taskValue = newTaskValue;
    }
    


}