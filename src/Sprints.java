package src;

import java.util.List;
import java.util.ArrayList;

public class Sprints {
    private int id;
    private String name;
    private String description;
    private List<Stories> userStories;
    private List<Tasks> userTasks;

    public Sprints(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userStories = new ArrayList<Stories>();
        this.userTasks = new ArrayList<Tasks>();
    }

    public void addUserStory(Stories s) {
        this.userStories.add(s);
    }

    public void addUserTask(Tasks t) {
        this.userTasks.add(t);
    }

    public List<Stories> getStory() {
        return this.userStories;
    }

    public List<Tasks> getTask() {
        return this.userTasks;
    }
}
