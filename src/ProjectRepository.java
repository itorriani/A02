package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Blackboard-style shared data repository for projects.
 * Implemented as a singleton so all parts of the application share one instance.
 * Observers registered here are notified automatically whenever a project is added.
 *
 * @author Matthew Wiecking
 * @version 1.0
 */
public class ProjectRepository {

    private static ProjectRepository instance;

    private final List<Project> projects = new ArrayList<>();
    private final List<ProjectObserver> observers = new ArrayList<>();

    private ProjectRepository() {}

    /**
     * Returns the single shared instance of this repository.
     *
     * @return the ProjectRepository singleton
     */
    public static ProjectRepository getInstance() {
        if (instance == null) {
            instance = new ProjectRepository();
        }
        return instance;
    }

    /**
     * Adds a project to the repository and notifies all registered observers.
     *
     * @param project the project to add
     */
    public void addProject(Project project) {
        projects.add(project);
        notifyObservers(project);
    }

    /**
     * Returns an unmodifiable view of all stored projects.
     *
     * @return read-only list of projects
     */
    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    /**
     * Registers an observer to be notified on project additions.
     *
     * @param observer the observer to add
     */
    public void addObserver(ProjectObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes a previously registered observer.
     *
     * @param observer the observer to remove
     */
    public void removeObserver(ProjectObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Project project) {
        for (ProjectObserver observer : observers) {
            observer.onProjectAdded(project);
        }
    }
}
