package src;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private int id;
    private String name;
    private String description;
    private String projType;
    private String authType;
    private List<Stories> userStories;
    private List<Tasks> userTasks;
    private List<Sprints> userSprints;

    public Project(int id, String name, String description, String projType, String authType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.projType = projType;
        this.authType = authType;
        this.userStories = new ArrayList<Stories>();
        this.userTasks = new ArrayList<Tasks>();
        this.userSprints = new ArrayList<Sprints>();
    }

    public void addUserStory(Stories s) {
        this.userStories.add(s);
    }

    public void addUserTask(Tasks t) {
        this.userTasks.add(t);
    }

    public void addUserSprint(Sprints sp) {
        this.userSprints.add(sp);
    }

    public List<Stories> getStory() {
        return this.userStories;
    }

    public List<Tasks> getTask() {
        return this.userTasks;
    }

    public List<Sprints> getSprint() {
        return this.userSprints;
    }

}