/*

*/

//imports
import java.util.LinkedList;
import java.util.Scanner;


public class Login {


    //initialize variables

    private String user; 
    
    private String pass; 




    public Stories(); // empty constructor

    
    public void setUser()
    {
        /*
        Description: Get user input to set subect line. Refer to tasks 
        class for line by line comments
        */

       Scanner input = new Scanner(System.in);

       System.out.println("Enter the Username: ");

       String newUser = input.nextLine();

       this.user = newUser;

    }

    public void setPass()
    {
        /*
        Description: Get user input to set the description. Refer to tasks 
        class for line by line comments
        */

       Scanner input = new Scanner(System.in);

       System.out.println("Enter Password: ");

       String newPass = input.nextLine();

       this.pass = newPass;

    }

    public boolean checkValidity(String validUser, String validPass)
    {

        /*
        Description: Check if the user and password is correct
        based on some future knowledgeo f what the user/password is
        */


        if (!(user.equals(validUser) || !(pass.equals(validPass)) return false )); 

    }


}