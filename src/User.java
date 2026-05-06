package src;
import java.util.*;

public class User {
    // User class to represent a user in the system
    private String name;
    private String email;
    private LinkedList<Project> projects = new LinkedList<>();    


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Method to add a project to the user's list of projects
    public void addProjectToUser(Project project) {
        System.out.println("Adding project: " + project.getProjectName() + " to user: " + this.name);
        projects.add(project);
    }

    // Method to get the list of projects associated with the user
    public LinkedList<Project> getProjects() {
        return projects;
    }

    // Method to remove a project from the user's list of projects
    public void removeUserProject(Project project) {
        System.out.println("Removing project: " + project.getProjectName() + " from user: " + this.name);
        projects.remove(project);
    }

    // Method to display user's projects
    public void displayUserProjects() {
        System.out.println("Projects for user: " + this.name);
        for (Project project : projects) {
            System.out.println("- " + project.getProjectName());
        }
    }


    // Override toString for better user representation
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "'}";
    }
}