# Project Management Tool - Sprint 2

## How to Run

```bash
javac src/*.java
java -cp src MainApp
```

---

## User Stories & Task Progress

### #125 Create Users
- [x] `User` data model with name, email, project list
- [x] `addProjectToUser`, `removeUserProject`, `getProjects` methods
- [ ] User is never created or shown in the running app (not wired into GUI)

### #124 Create Blackboard
- [x] `Blackboard` class with sections: New, In Progress, Ready for Test, Closed, Needs Info
- [x] `addNewTask` and `reorganizeTask` methods
- [ ] No GUI for the Blackboard — sections are not visible when running
- [ ] Not connected to `MainApp` (dead code)

### #123 Create Tasks
- [x] `Task` data model with name, user assignment, and value
- [x] Standalone `Task` GUI (can run via `java -cp src Task`)
- [x] Getters and setters
- [ ] Task GUI is not accessible from `MainApp`

### #86 Create Stories
- [x] `Stories` data model with subject line, description, attachments, position
- [x] Standalone `Stories` GUI (can run via `java -cp src Stories`)
- [x] Add/remove attachments functionality
- [ ] Stories GUI is not accessible from `MainApp`

### #43 ProjectRepository
- [x] Singleton `ProjectRepository` (Blackboard pattern)
- [x] Observer registration and notification (`addObserver`, `removeObserver`)
- [x] `addProject` notifies all observers
- [x] Fully wired into `MainApp` — projects appear in list automatically

### #120 Create Sprints
- [x] `Sprints` data model with id, name, description, stories, tasks
- [x] `CreateSprintsGUI` form with name, description, stories, tasks input
- [ ] `CreateSprintsGUI` is not accessible from `MainApp`
- [ ] Sprint list is not displayed anywhere in the running app

### #8 User Login
- [x] `Login` class with email/password validation logic
- [x] `LoginGUI` with username and password fields
- [ ] `LoginGUI` is not launched from `MainApp` — app starts without login
- [ ] After login, opens `Blackboard()` which has no visible GUI

### #23 Create Project
- [x] `Project` data model with id, name, description, type, auth type
- [x] `CreateProjectGUI` form fully functional
- [x] Created projects saved to `ProjectRepository`
- [x] `ProjectListPanel` displays all projects via Observer pattern
- [x] Accessible from `MainApp` via "+ New Project" button

---

## TODO (Submission)

- [ ] Push code to a **new** GitHub repository
- [ ] Submit to Canvas:
  - [ ] Link to new GitHub repository
  - [ ] Link to Taiga repository
  - [ ] Short note identifying your assigned story, what feature you implemented, and how it satisfies acceptance criteria

---

## Authors

| Author | Classes |
|--------|---------|
| Ivan Torriani | Task, Stories, Sprints, Project, Blackboard, CreateSprintsGUI |
| Anthony Soto | User, Login, LoginGUI |
| Matthew Wiecking | MainApp, CreateProjectGUI, ProjectListPanel, ProjectObserver, ProjectRepository |


## Ideas

- A backlog is created on the same main dashboard panel. This holds a collection of stories, who each have a) their assigned person b) their description c) their value. 
DONE

- Functionality to assign tasks to sprints. So in the add sprints, there should be an option to select which stories
DONE

- Need to address the sprint viewing options (DONE)

- Need to address the multiple projects. 

- This should be it I just need to address ProjectDetailFrame