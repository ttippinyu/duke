import java.io.Serializable;

public class Task implements Serializable {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String toString() {
        return "[" + (this.isDone ? "\u2713" : "\u2718") + "] " + this.description;
    }

    public String saveFormat() {
        return (this.isDone ? "1" : "0") + "|" + this.description;
    }
}