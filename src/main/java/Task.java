import java.io.Serializable;

public class Task implements Serializable {
    private String description;
    private boolean isDone;

    /**
     * Creates task
     * @param description the description of task
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Mark the task as done
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Gives the string format of the object
     * @return [done] description
     */
    public String toString() {
        return "[" + (this.isDone ? "\u2713" : "\u2718") + "] " + this.description;
    }

    /**
     * Gives the string format to be saved
     * @return done|description
     */
    public String saveFormat() {
        return (this.isDone ? "1" : "0") + "|" + this.description;
    }

    /**
     * Check if description contains keyword
     * @param keyword keyword to be searched
     * @return true or false
     */
    public boolean containsKeyword(String keyword) {return this.description.contains(keyword); }
}