public class Todo extends Task {
    /**
     * Creates to do task object
     * @param description
     */
    public Todo (String description) {
        super(description);
    }

    /**
     * Gives string format of task
     * @return string format of task
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Gives string format to be saved
     * @return string format to be saved
     */
    @Override
    public String saveFormat() {
        return "T|" + super.saveFormat();
    }
}