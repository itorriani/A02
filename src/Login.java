<<<<<<< HEAD
/**
 * Login class for user authentication.
 * Validates username and password credentials.
 *
 * @author Ivan Torriani
 * @version 1.0
 */

package src;
=======
//package src;
>>>>>>> e8c2a71c84ac7b637ebfdf97414c4a2531e4efdd

//imports
import java.util.LinkedList;
import java.util.Scanner;


public class Login {


    //initialize variables

    private String user; 
    
    private String pass; 




<<<<<<< HEAD
    public Login() {} // empty constructor
=======
    public Login() { // empty constructor

    }
    public void setUser(String newUser)
    {
        this.user = newUser;
    }

    public void setPass(String newPass)
    {
        this.pass = newPass;
    }

    public boolean checkValidity()
    {
        /*
        Description: Check if the user is a valid email or password is "password"
        Email: at least 3 letters before @, some text after @, followed by .net, .com, .org, or .edu
        Password: accept "password" universally for testing, or any password if email is valid
        */

        String emailRegex = "^[a-zA-Z]{3,}@.+\\.(net|com|org|edu)$";
        return (user != null && user.matches(emailRegex)) || "password".equals(pass);
    
        }
    }
>>>>>>> e8c2a71c84ac7b637ebfdf97414c4a2531e4efdd

    


<<<<<<< HEAD
        if (!user.equals(validUser) || !pass.equals(validPass)) return false;
        return true;

    }


}
=======
>>>>>>> e8c2a71c84ac7b637ebfdf97414c4a2531e4efdd
