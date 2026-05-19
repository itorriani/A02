/**
 * Represents a user story with a subject line, description, attachments, position, value, and assigned user.
 *
 * @author Ivan Torriani
 * @version 1.0
 */

import java.util.LinkedList;

public class Stories {

    private String subjectLine;
    private String description;
    private LinkedList<String> attatchments = new LinkedList<>();
    private boolean position;
    private int value;
    private String assignedUser;

    /**
     * Constructs a Story with all fields.
     *
     * @param subjectLine  the subject line
     * @param description  the description
     * @param attatchments list of attachments
     * @param position     the position flag
     */
    public Stories(String subjectLine, String description, LinkedList<String> attatchments, boolean position) {
        this.subjectLine = subjectLine;
        this.description = description;
        this.attatchments = attatchments;
        this.position = position;
        this.value = 0;
        this.assignedUser = "";
    }

    /**
     * Constructs a Story with value and assigned user.
     *
     * @param subjectLine  the subject line
     * @param description  the description
     * @param value        the story point value
     * @param assignedUser the user assigned to this story
     */
    public Stories(String subjectLine, String description, int value, String assignedUser) {
        this.subjectLine = subjectLine;
        this.description = description;
        this.value = value;
        this.assignedUser = assignedUser;
        this.attatchments = new LinkedList<>();
        this.position = false;
    }

    /**
     * Sets the subject line of this story.
     *
     * @param newSubjectLine the new subject line
     */
    public void setSubjectLine(String newSubjectLine) {
        this.subjectLine = newSubjectLine;
    }

    /**
     * Sets the description of this story.
     *
     * @param newDescription the new description
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    /**
     * Sets the position flag of this story.
     *
     * @param newPosition the new position value
     */
    public void setPosition(boolean newPosition) {
        this.position = newPosition;
    }

    /**
     * Sets the attachments list for this story.
     *
     * @param newAttatchments the new list of attachments
     */
    public void setAttatchments(LinkedList<String> newAttatchments) {
        this.attatchments = newAttatchments;
    }

    /**
     * Sets the story point value.
     *
     * @param value the new value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Sets the user assigned to this story.
     *
     * @param assignedUser the username to assign
     */
    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    /**
     * Returns the subject line of this story.
     *
     * @return the subject line
     */
    public String getSubjectLine() {
        return subjectLine;
    }

    /**
     * Returns the description of this story.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the list of attachments.
     *
     * @return the attachments list
     */
    public LinkedList<String> getAttatchments() {
        return attatchments;
    }

    /**
     * Returns the position flag.
     *
     * @return the position value
     */
    public boolean getPosition() {
        return position;
    }

    /**
     * Returns the story point value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the user assigned to this story.
     *
     * @return the assigned user
     */
    public String getAssignedUser() {
        return assignedUser;
    }
}
